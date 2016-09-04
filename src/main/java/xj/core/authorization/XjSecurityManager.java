/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.core.authorization;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.util.Log;
import org.stripesstuff.plugin.security.J2EESecurityManager;
import org.stripesstuff.plugin.security.SecurityHandler;
import xj.core.session.XjAuthenticationInterface;
import xj.core.session.XjSessionContext;

/**
 *
 * @author Hendranto Nugroho
 */
public class XjSecurityManager extends J2EESecurityManager implements SecurityHandler {

    private static final Log LOG = Log.getInstance(XjSecurityManager.class);

    @Override
    public Resolution handleAccessDenied(ActionBean bean, Method method) {
        XjSessionContext context = (XjSessionContext) bean.getContext();
        return context.handleAccessDenied();
    }

    @Override
    protected Boolean determineAccessOnElement(ActionBean bean, Method handler, AnnotatedElement element) {
        Boolean allowed = true;
        XjSessionContext context = (XjSessionContext) bean.getContext();
        
        LOG.debug("Determining if access is allowed for " + handler.getName() + " on " + bean.toString());

        if (element.isAnnotationPresent(XjDisabled.class)) {
            allowed = false;
        } else if (element.isAnnotationPresent(XjOpen.class)) {
            allowed = true;
        } else if (element.isAnnotationPresent(XjRestrictedRead.class)) {
            allowed = context.hasAccess(null, null, XjAuthenticationInterface.ACCESS_Read);
        } else if (element.isAnnotationPresent(XjRestrictedWrite.class)) {
            allowed = context.hasAccess(null, null, XjAuthenticationInterface.ACCESS_Write);
        } else if (element.isAnnotationPresent(XjSecured.class)) {
            allowed = context.isAuthenticated();
        } else if (element.isAnnotationPresent(XjAdministrator.class)) {
            allowed = context.isAdministratorGroup();
        } else if (element.isAnnotationPresent(XjDeveloper.class)) {
            allowed = context.isDeveloperGroup();
        }

        return allowed;
    }

}
