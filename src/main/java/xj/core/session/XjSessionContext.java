/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.core.session;

import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author Hendranto.Nugroho
 */
public class XjSessionContext extends ActionBeanContext implements XjSystemInterface, XjAuthenticationInterface, XjAuthorizationInterface {

    @Override
    public String getSystemParameter(String key) {
        return this.getServletContext().getInitParameter(key);
    }
    
    @Override
    public String getDbJndi(int index) {
        String jndi = (String)getRequest().getSession().getAttribute("jx.dbjndi-" + index);
        if (jndi == null) {
            String[] dbs = getSystemParameter("Xj-Dbs").split(",");
            if (dbs.length == 0) {
                throw new UnsupportedOperationException("No Configuration for JNDI on Web.XML");
            }
            
            if (dbs.length+1 < index) {
                throw new UnsupportedOperationException("JNDI Index [" + index + "] not exists.... ");
            }
            
            for (int i=1; i<=dbs.length; i++) {
                getRequest().getSession().setAttribute("jx.dbjndi-" + i, dbs[i-1]);
            }
            jndi = dbs[index-1];            
        }
        return jndi;
    }
    

    @Override
    public String getAuthUserId() {
        return "1";
    }

    @Override
    public String getAuthUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthName() {
        return "Hendranto Nugroho";
    }

    @Override
    public void setAuthUserId(int userid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthUsername(String username) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setSession(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Resolution handleAccessDenied() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAdministratorGroup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isDeveloperGroup() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAuthenticated() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getSession() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthRights() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthAssets() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthRoleId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getAuthRolename() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthRights(String[] rights) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthAssets(String[] assets) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthRoleId(int roleid) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAuthRolename(String rolename) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean hasAccess(String module, String actionBean, int readOrWrite) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    
}
