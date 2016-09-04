/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.utils;

/**
 *
 * @author anto89
 */
public class XjModelName {
    public static String get(String tableName) {
        
        String modelName = "";
        String ch;
        boolean start = true;
        for (int i=0; i<tableName.length(); i++) {
            ch = String.valueOf(tableName.charAt(i));
            if (ch.equals("_")) {
                start = true;
                continue;
            }
            if (start) {
                ch = ch.toUpperCase();
                start = false;
            }
            modelName += ch;
        }
        
        return modelName;
        
    }
}
