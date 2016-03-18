package com.gansuer.common.security;

public class DesSecurityComponent {

	private DesSecurity desSecurity;
	
	/**
	 * 非默认密钥解密
	 * @param data
	 * @return
	 */
	public byte[] decryptBytes(byte[] data){
		return this.desSecurity.decryptBytes(data);
	}
	
	/**
	 * 非默认密钥加密
	 * @param data
	 * @return
	 */
	public byte[] encryptBytes(byte[] data){
		return this.desSecurity.encryptBytes(data);
	}
	
	/**
	 * 默认密钥解密
	 * @param data
	 * @return
	 */
	public byte[] decryptBytesWithDefaultKey(byte[] data){
		return this.desSecurity.decryptDefaultBytes(data);
	}
	
	/**
	 * 默认密钥加密
	 * @param data
	 * @return
	 */
	public byte[] encryptBytesWithDefaultKey(byte[] data){
		return this.desSecurity.encryptBefaultBytes(data);
	}

	public DesSecurity getDesSecurity() {
		return desSecurity;
	}

	public void setDesSecurity(DesSecurity desSecurity) {
		this.desSecurity = desSecurity;
	}
	
}
