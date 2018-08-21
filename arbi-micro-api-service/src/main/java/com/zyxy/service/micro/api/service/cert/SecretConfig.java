package com.zyxy.service.micro.api.service.cert;

import java.io.Serializable;

/**
 * 证书路径配置信息
 * @author zhangzw
 *
 */
public class SecretConfig implements Serializable {
	private static final long serialVersionUID = 5824102417856321252L;
	private byte[] publicKeyStream; //公钥证书路径
	private byte[] privateKeyStream;//私钥证书路径
	private String keyStorePass;  //秘钥库密码
	private String keyPass;
	
	public SecretConfig(byte[] publicKeyStream, byte[] privateKeyStream, String keyStorePass, String keyPass) {
		this.publicKeyStream = publicKeyStream;
		this.privateKeyStream = privateKeyStream;
		this.keyStorePass = keyStorePass;
		this.setKeyPass(keyPass);
	}
	
	
	public byte[] getPublicKeyStream() {
		return publicKeyStream;
	}

	public void setPublicKeyStream(byte[] publicKeyStream) {
		this.publicKeyStream = publicKeyStream;
	}

	public byte[] getPrivateKeyStream() {
		return privateKeyStream;
	}

	public void setPrivateKeyStream(byte[] privateKeyStream) {
		this.privateKeyStream = privateKeyStream;
	}

	public String getKeyStorePass() {
		return keyStorePass;
	}


	public String getKeyPass() {
		return keyPass;
	}


	public void setKeyPass(String keyPass) {
		this.keyPass = keyPass;
	}
	
}
