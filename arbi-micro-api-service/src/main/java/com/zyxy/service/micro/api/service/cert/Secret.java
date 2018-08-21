package com.zyxy.service.micro.api.service.cert;
import java.io.Serializable;
import java.security.PrivateKey;
import java.security.PublicKey;

/**
 * 处理证书加密类
 * @author tanquan
 *
 */
public class Secret  implements Serializable{
	private static final long serialVersionUID = 125765180783470291L;
	private SecretConfig csc;
	private PublicKey publicKey;
	private PrivateKey privateKey;
	
	public Secret(SecretConfig csc) {
		this.setCsc(csc);
		try{
			publicKey = SecretProcessor.getPublicKey(csc.getPublicKeyStream());
			privateKey = SecretProcessor.getPrivateKey(csc.getPrivateKeyStream(), csc.getKeyStorePass(), csc.getKeyPass());
		}catch(Exception e){
			System.out.println("=============================初始化获取证书信息失败==================================");
			e.printStackTrace();
		}
	}

	public String encrypt(String content) throws Exception{
		return SecretProcessor.encryptByPublickey(publicKey, content);
	}
	
	public String decrypt(String content) throws Exception{
		return SecretProcessor.decryptByPrivateKey(privateKey, content);
	}
	
	public String sign(String content) throws Exception{
		return SecretProcessor.sign(privateKey, content);
	}
	
	public boolean verify(String content, String sign) throws Exception{
		return SecretProcessor.verify(publicKey, sign, content);
	}

	public SecretConfig getCsc() {
		return csc;
	}

	public void setCsc(SecretConfig csc) {
		this.csc = csc;
	}
}
