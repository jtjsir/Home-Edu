/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jing.edu.common.util;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.jing.edu.common.BaseLogger;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

/**
 * DES 密码的加解密
 *
 * @author jing
 */
public class PassUtil implements BaseLogger {

    private static final Logger logger = LogManager.getLogger(PassUtil.class);

    private final static Key passKey = getKey();

    /**
     * 采用固定的Key
     * @return 
     */
    private static Key getKey() {
        Key conKey = null;
        try {
            //create key
//            KeyGenerator keyGenerator = KeyGenerator.getInstance("DES");
//            keyGenerator.init(56);
//            SecretKey sk = keyGenerator.generateKey();
            byte[] data = {1,5,9,5,8,0,4,2} ;

            //transfer to Commonkey
            DESKeySpec spec = new DESKeySpec(data);
            SecretKeyFactory factory = SecretKeyFactory.getInstance("DES");
            conKey = factory.generateSecret(spec);
        } catch (Exception e) {
            logger.error(e.getMessage());
        }

        return conKey;
    }

    public static String encodePass(String pass) {
        byte[] result = null;
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.ENCRYPT_MODE, passKey);
            result = cipher.doFinal(pass.getBytes());
        } catch (Exception ex) {
            logger.error("Password " + "加密失败!");
        }
        //采用Base64处理
        return Base64.encode(result);
    }

    public static String decodePass(String pass) {
        byte[] origin = null;
        try {
            Cipher cipher = Cipher.getInstance("DES/ECB/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, passKey);
            origin = cipher.doFinal(Base64.decode(pass));
        } catch (Exception ex) {
            logger.error(ex.getMessage());
            logger.error("Password 解密失败!");
        }
        return new String(origin);
    }


    public static void main(String[] args) {
        System.out.println("加密前: " + "lisi");
        String s = PassUtil.encodePass("lisi");
        System.out.println("加密后: " + s);

        System.out.println("解密后: " + PassUtil.decodePass(s));
    }

	@Override
	public org.apache.logging.log4j.Logger getLogger() {
		// TODO Auto-generated method stub
		return logger;
	}
}
