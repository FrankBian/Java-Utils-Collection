package com.gansuer.common.security;

import org.apache.commons.codec.binary.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

public class AES {
    //默认偏移量
    private static byte[] _vector = { 0x41, 0x72, 0x65, 0x79, 0x6F, 0x75, 0x6E,
            0x79, 0x53, 0x6E, 0x6F, 0x77, 0x6D, 0x61, 0x6E, 0x3F};  
    //默认加密key
    private static String _key="mobile987DEF@joyschool.cn";
    public static String Encrypt(String encryptString, String encryptKey, byte[] vector) throws Exception {
        if (encryptString == null||encryptString.equals("")) {
            System.out.print("encryptString == null");
            return null;
        }        
        if (encryptKey==null||encryptKey.equals("")) {
        	encryptKey=_key;
        }
        if(encryptKey.length()>32)
        {
             encryptKey = encryptKey.substring(0, 32);
        }
        if(encryptKey.length()<32)
        {
            encryptKey = PadRight(encryptKey,32,'0');
        }
        if(vector==null||vector.length<=0)
        {
        	vector=_vector;
        }
        byte[] raw = encryptKey.getBytes("utf-8");
        SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
        IvParameterSpec ivSpec = new IvParameterSpec(vector);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, skeySpec,ivSpec);
        byte[] encrypted = cipher.doFinal(encryptString.getBytes("utf-8"));
        return Base64.encodeBase64String(encrypted);
    }
    public static String Decrypt(String decryptString, String decryptKey, byte[] vector) throws Exception {
        try {
            // 
            if (decryptString == null || decryptString.equals("")) {
                System.out.print("decryptString == null");
                return null;
            }
            // 
            if (decryptKey == null || decryptKey.equals("")) {
            	decryptKey=AES._key;
                return null;
            }
            if(decryptKey.length()>32)
            {
                decryptKey = decryptKey.substring(0, 32);
            }
            if(decryptKey.length()<32)
            {
                decryptKey = PadRight(decryptKey,32,'0');
            }
            if(vector==null||vector.length<=0)
            {
            	vector=_vector;
            }
            byte[] raw = decryptKey.getBytes("utf-8");
            SecretKeySpec skeySpec = new SecretKeySpec(raw, "AES");
            IvParameterSpec ivSpec = new IvParameterSpec(vector);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec,ivSpec);
            byte[] encrypted1 = Base64.decodeBase64(decryptString);
            try {
                byte[] original = cipher.doFinal(encrypted1);
                String originalString = new String(original);
                return originalString;
            } catch (Exception e) {
                System.out.println(e.toString());
                return null;
            }
        } catch (Exception ex) {
            System.out.println(ex.toString());
            return null;
        }
    } 
    public static String PadRight(String str, int totalWidth, char paddingChar)
    {
        if(str.length()>=totalWidth)
        {
            return str;
        }
        else
        {
            StringBuilder builder=new StringBuilder(str);
            int count=totalWidth-str.length();
            for (int i = 0; i < count; i++) {
                builder.append(paddingChar);
            }
            return builder.toString();
        }
    }
}
