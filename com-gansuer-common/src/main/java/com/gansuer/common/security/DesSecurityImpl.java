package com.gansuer.common.security;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;
import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class DesSecurityImpl extends DesSecurity {
//	private final static Logger logger = Logger.getLogger(DesSecurityImpl.class);
	
	private final static String TRANSFORMATION = "DES/CBC/PKCS5Padding";
	
	private Cipher encryptDefaultCipher;
	
	private Cipher encryptCipher;
	
	private Cipher decryptDefaultCipher;
	
	private Cipher decryptCipher;
	
	public DesSecurityImpl(String defaultKey, String getMessionKey){
		try {
			this.decryptDefaultCipher = init(Cipher.DECRYPT_MODE, defaultKey);
			this.decryptCipher = init(Cipher.DECRYPT_MODE, getMessionKey);
			this.encryptDefaultCipher = init(Cipher.ENCRYPT_MODE, defaultKey);
			this.encryptCipher = init(Cipher.ENCRYPT_MODE, getMessionKey);
		} catch (InvalidKeyException e) {
//			logger.error("InvalidKeyException:", e);
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
//			logger.error("NoSuchAlgorithmException:", e);
			e.printStackTrace();
		} catch (NoSuchPaddingException e) {
//			logger.error("NoSuchPaddingException", e);
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
//			logger.error("UnsupportedEncodingException", e);
			e.printStackTrace();
		} catch (InvalidAlgorithmParameterException e) {
//			logger.error("InvalidAlgorithmParameterException:", e);
			e.printStackTrace();
		} catch (InvalidKeySpecException e) {
//			logger.error("InvalidKeySpecException:", e);
			e.printStackTrace();
		}
		
	}
	
	private Cipher init(int mode, String key) throws NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, UnsupportedEncodingException, InvalidAlgorithmParameterException, InvalidKeySpecException {
		SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
		Cipher cipher= Cipher.getInstance(TRANSFORMATION);
		DESKeySpec desKeySpec = new DESKeySpec(key.getBytes("UTF-8"));
		SecretKey secretKey = keyFactory.generateSecret(desKeySpec);
		IvParameterSpec iv = new IvParameterSpec(key.getBytes("UTF-8"));
		//cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
		cipher.init(mode, secretKey,iv);
		return cipher;
	}

	public byte[] encryptBytes(byte[] buffer) {
		byte[] byteFina = null;
		try {
			synchronized (encryptCipher) {
				byteFina = this.encryptCipher.doFinal(buffer);
			}
		} catch (Exception e) {
//			logger.error("encryptBytes异常：", e);
			e.printStackTrace();
		}
		return byteFina;
	}

	public byte[] decryptBytes(byte[] buffer) {
		byte[] byteFina = null;
		try {
			synchronized (decryptCipher) {
				byteFina = this.decryptCipher.doFinal(buffer);
			}
		} catch (Exception e) {
//			logger.error("decryptBytes异常：", e);
			e.printStackTrace();
		}
		return byteFina; 
		
	}

	public byte[] encryptBefaultBytes(byte[] buffer) {
		byte[] byteFina = null;
		try {
			synchronized (encryptDefaultCipher) {
				byteFina = this.encryptDefaultCipher.doFinal(buffer);
			}
		} catch (Exception e) {
//			logger.error("decryptBytes异常：", e);
			e.printStackTrace();
		}
		return byteFina; 
	}

	public byte[] decryptDefaultBytes(byte[] buffer) {
		byte[] byteFina = null;
		try {
			synchronized (decryptDefaultCipher) {				
				byteFina = this.decryptDefaultCipher.doFinal(buffer);
			}
		} catch (Exception e) {
//			logger.error("decryptBytes异常：", e);
			e.printStackTrace();
		}
		return byteFina; 
	}

}