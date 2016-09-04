/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.core.session;

import net.sourceforge.stripes.action.Resolution;

/**
 *
 * @author Hendranto.Nugroho
 */
public interface XjAuthenticationInterface {
    
    public static int ACCESS_Read = 1;
    public static int ACCESS_Write = 2;    

    public abstract String getAuthUserId();

    public abstract String getAuthUsername();

    public abstract String getAuthName();

    public abstract void setAuthUserId(int userid);

    public abstract void setAuthUsername(String username);

    public abstract void setAuthName(String name);

    public abstract void setSession(String name);

    public abstract Resolution handleAccessDenied();

    public abstract boolean isAdministratorGroup();

    public abstract boolean isDeveloperGroup();

    public abstract boolean isAuthenticated();
    
    public abstract String getSession();

}
