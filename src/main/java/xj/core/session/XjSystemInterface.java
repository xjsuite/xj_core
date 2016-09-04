/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.core.session;

import java.beans.PropertyVetoException;
import javax.sql.DataSource;

/**
 *
 * @author Hendranto.Nugroho
 */
public interface XjSystemInterface {
    
    // system parameter
    public abstract String getSystemParameter(String key);
    
    // database connection - multiple database connection
    public abstract String getDbJndi(int index);
 
}
