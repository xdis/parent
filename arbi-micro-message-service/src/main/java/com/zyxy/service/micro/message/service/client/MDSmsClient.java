package com.zyxy.service.micro.message.service.client;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.zyxy.common.vo.BuzzResultVO;


/**
 * 联系人：13141382518
 * 联系电话：010-56733999-3726
 * 账户密码：SDK-BBX-010-23070 / 2e4aa6Cd
 * 接口url：http://sdk.entinfo.cn:8061/webservice.asmx
 * 后台查询url：
 * @author hesen
 * 
 */
@Component
public class MDSmsClient {
	
    private static final Logger logger = LoggerFactory.getLogger(MDSmsClient.class);
    
	/*
	 * webservice服务器定义
	 */
	@Value("${provider.102.serverUrl}")
	private String serviceURL;
	@Value("${provider.102.sn}")
	private String sn;// 序列号
	@Value("${provider.102.password}")
	protected String password;
	private String pwd;// 密码
	
	/*
	 * 方法名称：getMD5 
	 * 功    能：字符串MD5加密 
	 * 参    数：待转换字符串 
	 * 返 回 值：加密之后字符串
	 */
	private String getMD5(String sourceStr) throws UnsupportedEncodingException {
		String resultStr = "";
		try {
			byte[] temp = sourceStr.getBytes();
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			md5.update(temp);
			// resultStr = new String(md5.digest());
			byte[] b = md5.digest();
			for (int i = 0; i < b.length; i++) {
				char[] digit = { '0', '1', '2', '3', '4', '5', '6', '7', '8',
						'9', 'A', 'B', 'C', 'D', 'E', 'F' };
				char[] ob = new char[2];
				ob[0] = digit[(b[i] >>> 4) & 0X0F];
				ob[1] = digit[b[i] & 0X0F];
				resultStr += new String(ob);
			}
			return resultStr;
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/*
	 * 方法名称：mdsmssend
	 * 功    能：发送短信 
	 * 参    数：mobile,content,ext,stime,rrid,msgfmt(手机号，内容，扩展码，定时时间，唯一标识，内容编码)
	 * 返 回 值：唯一标识，如果不填写rrid将返回系统生成的
	 */
	public BuzzResultVO<String> mdsmssend(String mobile, String content, String ext, String stime,
			String rrid,String msgfmt) {
        BuzzResultVO<String> ret = new BuzzResultVO<String>();
	    if (this.pwd == null) {
	        try {
                this.pwd = this.getMD5(this.sn + this.password);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                return ret.setOk(false).setMessage("渠道参数错误");
            }
	    }
		String result = "";
		String soapAction = "http://entinfo.cn/mdsmssend";
		String xml = "<?xml version=\"1.0\" encoding=\"utf-8\"?>";
		xml += "<soap:Envelope xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">";
		xml += "<soap:Body>";
		xml += "<mdsmssend  xmlns=\"http://entinfo.cn/\">";
		xml += "<sn>" + sn + "</sn>";
		xml += "<pwd>" + pwd + "</pwd>";
		xml += "<mobile>" + mobile + "</mobile>";
		xml += "<content>" + content + "</content>";
		xml += "<ext>" + ext + "</ext>";
		xml += "<stime>" + stime + "</stime>";
		xml += "<rrid>" + rrid + "</rrid>";
		xml += "<msgfmt>" + msgfmt + "</msgfmt>";
		xml += "</mdsmssend>";
		xml += "</soap:Body>";
		xml += "</soap:Envelope>";

		URL url;
		try {
			url = new URL(serviceURL);

			URLConnection connection = url.openConnection();
			HttpURLConnection httpconn = (HttpURLConnection) connection;
			ByteArrayOutputStream bout = new ByteArrayOutputStream();
			bout.write(xml.getBytes());
			byte[] b = bout.toByteArray();
			httpconn.setRequestProperty("Content-Length", String
					.valueOf(b.length));
			httpconn.setRequestProperty("Content-Type",
					"text/xml; charset=gb2312");
			httpconn.setRequestProperty("SOAPAction", soapAction);
			httpconn.setRequestMethod("POST");
			httpconn.setDoInput(true);
			httpconn.setDoOutput(true);

			OutputStream out = httpconn.getOutputStream();
			out.write(b);
			out.close();

			InputStreamReader isr = new InputStreamReader(httpconn
					.getInputStream());
			BufferedReader in = new BufferedReader(isr);
			String inputLine;
			while (null != (inputLine = in.readLine())) {
				Pattern pattern = Pattern.compile("<mdsmssendResult>(.*)</mdsmssendResult>");
				Matcher matcher = pattern.matcher(inputLine);
				while (matcher.find()) {
					result = matcher.group(1);
				}
			}
			if (!result.matches("[0-9a-zA-Z]{4,}")) {
			    logger.error("漫道短息发送失败-[{}]:{}", mobile, content);
			    return ret.setOk(false).setMessage("短信发送失败");
			}
			return ret.setOk(true).setAttach(result);
		} catch (Exception e) {
			e.printStackTrace();
			return ret.setOk(false).setMessage("调用渠道接口发送短信失败");
		}
	}

}
