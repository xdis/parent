package com.zyxy.service.micro.api.service.cert;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.Security;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Calendar;

import javax.security.auth.x500.X500Principal;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMWriter;
import org.bouncycastle.x509.X509V3CertificateGenerator;

/**
 * 证书工具类
 * 
 * @author sonta
 *
 */
@SuppressWarnings("deprecation")
public class CertUtil {

	// 密钥算法
	private static String KEY_ALG = "RSA";

	static {
		// 系统添加BC加密算法 以后系统中调用的算法都是BC的算法
		Security.addProvider(new BouncyCastleProvider());
	}
	
	/**
	 * 生成证书并添加到证书库
	 * @param validity 证书有效期
	 * @param alias 证书别名
	 * @param dname
	 * @param storePass 证书库密码
	 * @param keyPass 获取证书私钥密码
	 * @param issuer 颁布者
	 * @return
	 */
	public static byte[] createKeyStore(int validity, String alias, String dname, String storePass,
			String keyPass, String issuer) {
		ByteArrayOutputStream out = null;
		try {
			// 创建KeyStore
			KeyStore store = KeyStore.getInstance("PKCS12",new BouncyCastleProvider());
			store.load(null, null);
			/* RSA算法产生公钥和私钥 */
			KeyPairGenerator kpg = KeyPairGenerator.getInstance(KEY_ALG,new BouncyCastleProvider());
			kpg.initialize(1024);
			KeyPair keyPair = kpg.generateKeyPair();
			// 组装证书
			String subject = dname;
			X509V3CertificateGenerator certGen = new X509V3CertificateGenerator();
			certGen.setSerialNumber(BigInteger.valueOf(System.currentTimeMillis()));
			certGen.setIssuerDN(new X500Principal(issuer));
			Calendar start = Calendar.getInstance();
			certGen.setNotBefore(start.getTime());
			Calendar end = Calendar.getInstance();
			end.add(Calendar.DATE, validity);
			certGen.setNotAfter(end.getTime());
			certGen.setSubjectDN(new X500Principal(subject));
			certGen.setPublicKey(keyPair.getPublic());
			certGen.setSignatureAlgorithm("SHA1WithRSAEncryption"); // SHA256WithRSAEncryption
			X509Certificate cert = certGen.generateX509Certificate(keyPair.getPrivate());
			store.setKeyEntry(alias, keyPair.getPrivate(),keyPass.toCharArray(), new Certificate[] { cert });
			out = new ByteArrayOutputStream();
			store.store(out, storePass.toCharArray());
			byte[] ret = out.toByteArray();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
	/**
	 * 获取证书库内证书
	 * @param alias 证书别名
	 * @param storePass 访问证书库所需的密码
	 * @param in 证书库文件流字节码
	 * @return
	 */
	public static byte[] exportCer(String alias, String storePass, byte[] in) {
		ByteArrayOutputStream out = null;
		try {
			char[] password = storePass.toCharArray();
			KeyStore from = KeyStore.getInstance("PKCS12", new BouncyCastleProvider());
			from.load(new ByteArrayInputStream(in), password);
			out = new ByteArrayOutputStream();
			PEMWriter pemWrt = new PEMWriter(new OutputStreamWriter(out));
			pemWrt.writeObject(from.getCertificateChain(alias)[0]);
			pemWrt.close();
			byte[] ret = out.toByteArray();
			return ret;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (out != null) {
				try {
					out.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return null;
	}
	
}
