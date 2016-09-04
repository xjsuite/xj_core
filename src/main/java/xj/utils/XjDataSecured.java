/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author anto89
 */
public class XjDataSecured {

    protected String hashed(String method, String input) {
        String result = null;

        if (null == input) {
            return null;
        }

        try {

            //Create MessageDigest object for MD5
            MessageDigest digest = MessageDigest.getInstance(method);

            //Update input string in message digest
            digest.update(input.getBytes(), 0, input.length());

            //Converts message digest value in base 16 (hex) 
            result = new BigInteger(1, digest.digest()).toString(16);

        } catch (NoSuchAlgorithmException e) {
            return null;
        }
        return result;
    }
    
    public static String md5(String input) {
        XjDataSecured encrypt = new XjDataSecured();
        return encrypt.hashed("MD5", input);
    }
    
    public static String sha1(String input) {
        XjDataSecured encrypt = new XjDataSecured();
        return encrypt.hashed("SHA-1", input);
    } 
    
    public static String sha256(String input) {
        XjDataSecured encrypt = new XjDataSecured();
        return encrypt.hashed("SHA-256", input);
    } 
    
    public static String md5sha256(String input) {
        XjDataSecured encrypt = new XjDataSecured();
        return encrypt.hashed("SHA-256", encrypt.hashed("MD5", input));
    }
}
