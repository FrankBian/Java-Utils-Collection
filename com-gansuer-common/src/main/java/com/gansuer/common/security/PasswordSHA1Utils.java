package com.gansuer.common.security;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordSHA1Utils {
	private static final Logger logger = Logger.getLogger(PasswordSHA1Utils.class);
	/**
	 * 使用SHA-1加密密码
	 * @author LJ
	 * @param password
	 * @return
	 */
	public static String generatePassword(String password) {
		if (StringUtils.isBlank(password)) {
			throw new IllegalArgumentException("请输入要加密的内容");
		}
		String encryptText = null;
		try {
			MessageDigest m = MessageDigest.getInstance("sha-1");
			m.update(password.getBytes("UTF8"));
			byte s[] = m.digest();
			return hex(s);
		} catch (NoSuchAlgorithmException e) {
			logger.error("no such algorithm.", e);
		} catch (UnsupportedEncodingException e) {
			logger.error("un support algorimthm.", e);
		}
		return encryptText;
	}

	/**
	 * 验证存储密码是否与输入加密的密码一致
	 * @param originalPassword
	 * @param storedPassword
	 * @return
	 */
	public static boolean validatePassword(String originalPassword, String storedPassword) {
		if (StringUtils.isBlank(originalPassword) || StringUtils.isBlank(storedPassword)) {
			return false;
		}
		String verifyPassword = generatePassword(originalPassword);
		logger.info("====storedPassword=" + storedPassword + ";verifyPassword" + verifyPassword);
		if (storedPassword.equals(verifyPassword)) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 返回十六进制字符串
	 * @param  str
	 * @return
	 */
	private static String hex(byte[] str) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < str.length; ++i) {
			sb.append(Integer.toHexString((str[i] & 0xFF) | 0x100).substring(1, 3));
		}
		return swapeToUpper(sb.toString());
	}

	/**
	 * 将加密结果返回为大写串，与old系统保持一致
	 * @param arr
	 * @return
	 */
	private static String swapeToUpper(String arr) {
		if (StringUtils.isBlank(arr)) {
			return arr;
		}

		char[] buffer = arr.toCharArray();
		for (int i = 0; i < buffer.length; i++){
			char tmp = buffer[i];
			if (Character.isLowerCase(tmp)){
				buffer[i] = Character.toUpperCase(tmp);
			}
		}
		return new String(buffer);
	}
}
