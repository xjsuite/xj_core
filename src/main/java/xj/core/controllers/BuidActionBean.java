/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.core.controllers;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.Properties;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.StreamingResolution;
import net.sourceforge.stripes.action.UrlBinding;
import org.apache.log4j.Logger;
import org.javalite.activejdbc.DB;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import xj.helpers.XjClientHttp;
import xj.helpers.XjClientRest;
import xj.utils.XjFileProperties;
import xj.utils.XjModelName;

/**
 *
 * @author anto89
 */
@UrlBinding("/build.action")
public class BuidActionBean extends CoreActionBean {

    final static Logger logger = Logger.getLogger(BuidActionBean.class);

    protected Resolution serverView(String server, String action) {
        
        String url = server + action;
        
        XjClientHttp http = new XjClientHttp();
        http.setHeaders(new String[]{"server"}).setHeadersValue(new String[]{server});
        http.setRestUrl(url);        
        
        String result = http.send();
        if (result == null) {
            return new RedirectResolution("/build.action");
        }

        return new StreamingResolution("text/html", result);
    }

    @DefaultHandler
    public Resolution build() {  

        Properties setup = XjFileProperties.read(this.context.getServletContext(), "build.properties");
        if (setup == null) {
            return new ForwardResolution(context.getSystemParameter("Xj-Home"));
        }
        String server = setup.getProperty("url");
        
        
        // request auth address
        XjClientRest url = new XjClientRest().setRestUrl(server + "/xjrest/url/login");
        JSONObject json = url.send();
        
        if (json == null) {
            return new ForwardResolution(context.getSystemParameter("Home"));
        }
        
        return serverView(server, json.get("url").toString());
    }


    public Resolution tableupload() {
        JSONArray result = new JSONArray();

        if (post.isEmpty()) {
            return new ErrorResolution(404);
        }

        if (post.get("jndi") == null) {
            return new ErrorResolution(404);
        }

        DB db = new DB("server");

        try {
            db.open(post.get("jndi").toString());
            Connection conn = db.getConnection();
            DatabaseMetaData md = conn.getMetaData();
            try (ResultSet rs = md.getTables(null, null, "%", null)) {
                while (rs.next()) {
                    JSONObject mapItem = new JSONObject();
                    String tablename = rs.getString(3);
                    mapItem.put("tablename", tablename);
                    mapItem.put("modelname", XjModelName.get(tablename));

                    try (ResultSet pk = md.getPrimaryKeys(null, null, tablename)) {
                        if (pk.next()) {
                            mapItem.put("keyname", pk.getString("COLUMN_NAME"));
                        }
                    }
                    result.add(mapItem);

                }
            }
        } catch (Exception e) {
            logger.error(e.getMessage());
        } finally {
            db.close();
        }

        db.close();

        // upload process
        String server = "http://localhost:8084/xj_service";
        XjClientRest upload = new XjClientRest();
        upload.setRestUrl(server + "/xjrest/dev/table_upload");
        upload.setHeaders(new String[]{"key"});
        upload.setHeadersValue(new String[]{post.get("key").toString()});
        upload.setParams(new String[]{"tables"});
        upload.setParamsValue(new String[]{result.toJSONString()});

        // post back ta project.tables.action
        server = "http://localhost:8084/xj_service"; //setup.getProperty("url");
        String myurl = context.getRequest().getRequestURL().toString() + "?build=";

        XjClientHttp rest = new XjClientHttp();
        rest.setRestUrl(server + "/project.tables.action");

        rest.setHeaders(new String[]{"key"});
        rest.setHeadersValue(new String[]{post.get("key").toString()});
        String res = rest.send();

        if (res == null) {
            return new ForwardResolution(context.getSystemParameter("Xj-Home"));
        }

        return new StreamingResolution("text/html", res);
    }
}
