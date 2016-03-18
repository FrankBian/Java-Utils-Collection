package com.gansuer.common.security;

import org.apache.log4j.Logger;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.math.BigInteger;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;

/**
 * 密码Hash算法 PBKDF2 (Password-Based Key Derivation Function 2) is a key
 * derivation function that is part of RSA Laboratories' Public-Key Cryptography
 * Standards (PKCS) series, specifically PKCS #5 v2.0, also published as
 * Internet Engineering Task Force's RFC 2898. It replaces an earlier standard,
 * PBKDF1, which could only produce derived keys up to 160 bits long.
 */
public class PasswordHashUtils {
	private static final Logger logger = Logger.getLogger(PasswordHashUtils.class);
	
	/**
	 * 使用PBKDF2算法计算密码哈希算法
	 * @param password
	 * @return
	 */
	public static String generatePassword(String password) {
		try {
			int iterations = 1000;
			char[] chars = password.toCharArray();
			byte[] salt = getSalt().getBytes();

			PBEKeySpec spec = new PBEKeySpec(chars, salt, iterations, 64 * 8);
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			byte[] hash = skf.generateSecret(spec).getEncoded();
			return iterations + ":" + toHex(salt) + ":" + toHex(hash);
		} catch(NoSuchAlgorithmException e) {
			logger.error("no such algorithm.", e);
		} catch(InvalidKeySpecException e) {
			logger.error("invalid key spec.", e);
		}
		return "";
	}
	
	public static boolean validatePassword(String originalPassword, String storedPassword) {
		try {
			String[] parts = storedPassword.split(":");
	        int iterations = Integer.parseInt(parts[0]);
	        byte[] salt = fromHex(parts[1]);
	        byte[] hash = fromHex(parts[2]);
	         
	        PBEKeySpec spec = new PBEKeySpec(originalPassword.toCharArray(), salt, iterations, hash.length * 8);
	        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
	        byte[] testHash = skf.generateSecret(spec).getEncoded();
	         
	        int diff = hash.length ^ testHash.length;
	        for(int i = 0; i < hash.length && i < testHash.length; i++)
	        {
	            diff |= hash[i] ^ testHash[i];
	        }
	        return diff == 0;
		} catch(NoSuchAlgorithmException e) {
			logger.error("no such algorithm.", e);
		} catch(InvalidKeySpecException e) {
			logger.error("invalid key spec.", e);
		}
        return false;
    }
	
    private static byte[] fromHex(String hex) throws NoSuchAlgorithmException {
        byte[] bytes = new byte[hex.length() / 2];
        for(int i = 0; i<bytes.length ;i++) {
            bytes[i] = (byte) Integer.parseInt(hex.substring(2 * i, 2 * i + 2), 16);
        }
        return bytes;
    }

	private static String getSalt() throws NoSuchAlgorithmException {
		SecureRandom sr = SecureRandom.getInstance("SHA1PRNG");
		byte[] salt = new byte[16];
		sr.nextBytes(salt);
		return salt.toString(); //what's this?  Should be new String(salt)?
	}

	private static String toHex(byte[] array) throws NoSuchAlgorithmException {
		BigInteger bi = new BigInteger(1, array);
		String hex = bi.toString(16);
		int paddingLength = (array.length * 2) - hex.length();
		if (paddingLength > 0) {
			return String.format("%0" + paddingLength + "d", 0) + hex;
		} else {
			return hex;
		}
	}

}
