/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xj.utils;

import java.util.Random;

/**
 *
 * @author anto89
 */
public class XjKeyGen {

    public static final String getKey(int n) {
        String key = "";
        Random ran = new Random();

        for (int i = 0; i < n; i++) {
            key += String.valueOf(ran.nextInt(10));
        }

        return key;
    }
}
