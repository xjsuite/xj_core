/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.core.controllers;

import com.samaxes.stripes.xss.SafeHtmlUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ErrorResolution;
import net.sourceforge.stripes.action.Resolution;
import org.javalite.activejdbc.Base;
import xj.core.session.XjSessionContext;
import xj.utils.XjPages;

/**
 *
 * @author Hendranto.Nugroho
 */
public class CoreActionBean implements ActionBean {
    
    

    protected XjSessionContext context;
    // output to views
    protected List<Map<String, Object>> puts = new ArrayList<>();
    protected Map<String, Object> put = new HashMap<>();
    protected Map<String, Object> messages = new HashMap<>();

    // input from views
    protected Map<String, Object> post = new HashMap<>();
    protected Map<String, Object> search = new HashMap<>();
    protected Map<String, Object> flag = new HashMap<>();

    // Page
    protected XjPages pages = new XjPages();
    protected int page;

    // active or inactive fields
    protected Map<String, Object> flags = new HashMap<>();
    
    //setting
    protected Map<String, Object> settings = new HashMap<>();

    // parameter
    protected int id;
    protected int id1;
    protected int id2;
    protected int id3;

    protected String ids;
    protected String id1s;
    protected String id2s;
    protected String id3s;

    @Override
    public void setContext(ActionBeanContext abc) {
        context = (XjSessionContext) abc;
    }

    @Override
    public XjSessionContext getContext() {
        return context;
    }

    public List<Map<String, Object>> getPuts() {
        return puts;
    }

    public void setPuts(List<Map<String, Object>> puts) {
        this.puts = puts;
    }

    public Map<String, Object> getPut() {
        return put;
    }

    public void setPut(Map<String, Object> put) {
        this.put = put;
    }

    public Map<String, Object> getMessages() {
        return messages;
    }

    public void setMessages(Map<String, Object> messages) {
        this.messages = messages;
    }

    public Map<String, Object> getPost() {
        return post;
    }

    public void setPost(Map<String, Object> post) {
        this.post = post;
    }

    public Map<String, Object> getSearch() {
        return search;
    }

    public void setSearch(Map<String, Object> search) {
        this.search = search;
    }

    public Map<String, Object> getFlag() {
        return flag;
    }

    public void setFlag(Map<String, Object> flag) {
        this.flag = flag;
    }

    public List<XjPages.DetailPage> getPages() {
        return pages.getPages();
    }

    public void setPage(int page) {
        pages.setPage(page);
    }

    public int getPage() {
        return pages.getPage();
    }
    
    public int getPreviousPage() {
        return pages.getPreviousPage();
    }
    
    public int getNextPage() {
        return pages.getNextPage();
    }

    protected void calculatePages(long count) {
        pages.calculatePages(count);
    }

    protected int getOffsetPage() {
        return pages.getOffset();
    }

    public int getLimitPage() {
        return pages.getLimit();
    }

    public Map<String, Object> getFlags() {
        return flags;
    }

    public void setFlags(Map<String, Object> flags) {
        this.flags = flags;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId1() {
        return id1;
    }

    public void setId1(int id1) {
        this.id1 = id1;
    }

    public int getId2() {
        return id2;
    }

    public void setId2(int id2) {
        this.id2 = id2;
    }

    public int getId3() {
        return id3;
    }

    public void setId3(int id3) {
        this.id3 = id3;
    }

    public String getIds() {
        return ids;
    }

    public void setIds(String ids) {
        this.ids = ids;
    }

    public String getId1s() {
        return id1s;
    }

    public void setId1s(String id1s) {
        this.id1s = SafeHtmlUtil.sanitize(id1s);
    }

    public String getId2s() {
        return id2s;
    }

    public void setId2s(String id2s) {
        this.id2s = SafeHtmlUtil.sanitize(id2s);
    }

    public String getId3s() {
        return id3s;
    }

    public void setId3s(String id3s) {
        this.id3s = SafeHtmlUtil.sanitize(id3s);
    }

    public Map<String, Object> getSettings() {
        return settings;
    }

    public void setSettings(Map<String, Object> settings) {
        this.settings = settings;
    }
    

    @DefaultHandler
    public Resolution blockedAccess() {
        return new ErrorResolution(401);
    }

    public void open() {
        if (context == null) {
            try {
                // change this to the notification that the session is timeout
                this.context.getRequest().getRequestDispatcher("front.action").forward(this.context.getRequest(), this.context.getResponse());
            } catch (ServletException | IOException ex) {
                Logger.getLogger(CoreActionBean.class.getName()).log(Level.SEVERE, null, ex);
            }
            return;
        }

        String jndi = context.getDbJndi(1);
        Base.open(jndi);
    }

    public void close() {
        if (Base.hasConnection()) {
            Base.close();
        }
        
    }
    
    public boolean sanitize(Map<String, Object> inputs) {
        String result;
        boolean found = false;
        for (Map.Entry entry:inputs.entrySet()) {
            result = SafeHtmlUtil.sanitize(entry.getKey().toString());
            if (!result.equals(entry.getKey())) {
                entry.setValue(result);
                found = true;
            }
        }
        return !found;
    }


}
