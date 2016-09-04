/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.core.session;

/**
 *
 * @author Hendranto.Nugroho
 */
public interface XjAuthorizationInterface {

    public abstract String getAuthRights();

    public abstract String getAuthAssets();

    public abstract String getAuthRoleId();

    public abstract String getAuthRolename();

    public abstract void setAuthRights(String[] rights);

    public abstract void setAuthAssets(String[] assets);

    public abstract void setAuthRoleId(int roleid);

    public abstract void setAuthRolename(String rolename);

    public abstract boolean hasAccess(String module, String actionBean, int readOrWrite);
}
