/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;

/**
 *
 * @author anto89
 */
public class XjFileProperties {
    
    final static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(XjFileProperties.class);
    
    public static Properties read(ServletContext context, String name) {
        InputStream inputStream;
        Properties prop = new Properties();
        
        inputStream = context.getResourceAsStream("/WEB-INF/" + name);
                
        if (inputStream == null) {
            return null;
        }
        
        try {
            prop.load(inputStream);
        } catch (IOException ex) {
            logger.error(ex);
        } 
                    
        try {
            inputStream.close();
        } catch (IOException ex) {
            logger.error(ex);
        }
        
        return prop;
    }
    
}
