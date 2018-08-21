package com.zyxy.common.util;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Random;

/**
 * 图片生成工具
 * @author tanquan
 *
 */
public final class ImageUtil {
	

	/**
	 * 生成随机验证码及图片
	 * @param width 宽度
	 * @param height 高度
	 * @param color 背景色
	 * @return 图片和字符串的数组
	 */
	public static Object[] createNumberImage(Integer width,Integer height,Color color, Integer size, Integer lines) {
		char[] chars = { 
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        return getImage(width, height, color, size, lines, chars);
	}

	/**
	 * 生成随机验证码及图片
	 * @param width 宽度
	 * @param height 高度
	 * @param color 背景色
	 * @return 图片和字符串的数组
	 */
	public static Object[] createImage(Integer width,Integer height,Color color, Integer size, Integer lines) {
		char[] chars = {
				'0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
				'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
        return getImage(width, height, color, size, lines, chars);
	}

    private static Object[] getImage(Integer width, Integer height, Color color, Integer size, Integer lines,
            char[] chars) {
        StringBuffer sb = new StringBuffer();
        int FONT_SIZE  = height - 4;
        // 1.创建空白图片
        BufferedImage image = new BufferedImage(
                width, height, BufferedImage.TYPE_INT_RGB);
        // 2.获取图片画笔
        Graphics graphic = image.getGraphics();
        // 3.设置画笔颜色
        graphic.setColor(color);
        // 4.绘制矩形背景
        graphic.fillRect(0, 0, width, height);
        // 5.画随机字符
        Random ran = new Random();
        for (int i = 0; i < size; i++) {
            // 取随机字符索引
            int n = ran.nextInt(chars.length);
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 设置字体大小
            graphic.setFont(new Font(
                null, Font.BOLD + Font.ITALIC, FONT_SIZE));
            // 画字符
            graphic.drawString(
                chars[n] + " ", i * width / size, height - 4 );
            // 记录字符
            sb.append(chars[n]);
        }
        // 6.画干扰线
        for (int i = 0; i < lines; i++) {
            // 设置随机颜色
            graphic.setColor(getRandomColor());
            // 随机画线
            graphic.drawLine(ran.nextInt(width), ran.nextInt(height),
                    ran.nextInt(width), ran.nextInt(height));
        }
        // 7.返回验证码和图片
        return new Object[]{sb.toString(), image};
    }

    /**
	 * 随机取色
	 */
	private static Color getRandomColor() {
		Random ran = new Random();
		Color color = new Color(ran.nextInt(256), 
				ran.nextInt(256), ran.nextInt(256));
		return color;
	}
	
	/**
	 * base64转图片
	 * @param imgStr
	 * @param path
	 */
	@SuppressWarnings("restriction")
	public static void saveBase64AsImg(String imgStr, String path) { 
		// 对字节数组字符串进行Base64解码并生成图片
		if (imgStr == null) { // 图像数据为空
			return ;
		}
		File saveFile = new File(path);
		if (!saveFile.getParentFile().exists()) {
			saveFile.getParentFile().mkdirs();
		}
		sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
		OutputStream out = null;
		try {
			// Base64解码
			byte[] b = decoder.decodeBuffer(imgStr);
			for (int i = 0; i < b.length; ++i) {
				if (b[i] < 0) {// 调整异常数据
					b[i] += 256;
				}
			}
			// 生成jpeg图片
			out = new FileOutputStream(path);
			out.write(b);
			out.flush();
			out.close();
		} catch (IOException e) {
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
	}
	
	/**
	 * base64转byte
	 * @param imgStr
	 * @param path
	 */
	@SuppressWarnings("restriction")
	public static byte[] convertBase64Byte(String imgBase64) { 
	    // 对字节数组字符串进行Base64解码并生成图片
	    if (imgBase64 == null) { // 图像数据为空
	        return null;
	    }
        sun.misc.BASE64Decoder decoder = new sun.misc.BASE64Decoder();
	    try {
            return decoder.decodeBuffer(imgBase64);
        } catch (IOException e) {
            e.printStackTrace();
        }
	    return null;
	}
	
	
	
	/**
	 * 图片转base64
	 * @param path
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String convertImg2Base64(String path) {
		InputStream in = null;
		byte[] data = null;
		// 读取图片字节数组
		try {
			in = new FileInputStream(path);
			data = new byte[in.available()];
			in.read(data);
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		// 对字节数组Base64编码
		sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
		return encoder.encode(data);// 返回Base64编码过的字节数组字符串
	}
	
	/**
	 * 图片转base64
	 * @param path
	 * @return
	 */
	@SuppressWarnings("restriction")
	public static String convertImg2Base64(byte[] bt) {
	    // 对字节数组Base64编码
	    sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
	    return encoder.encode(bt);// 返回Base64编码过的字节数组字符串
	}
      
	@SuppressWarnings("restriction")
	public static String getImgBase64FromNetworkUrl(String targetUrl) {
		ByteArrayOutputStream bos = null;
		BufferedInputStream bis = null;
		HttpURLConnection httpUrl = null;
		URL url = null;
		int BUFFER_SIZE = 1024;
		byte[] buf = new byte[BUFFER_SIZE];
		int size = 0;
		try {
			url = new URL(targetUrl);
			httpUrl = (HttpURLConnection) url.openConnection();
			httpUrl.connect();
			bis = new BufferedInputStream(httpUrl.getInputStream());
			bos = new ByteArrayOutputStream();
			while ((size = bis.read(buf)) != -1) {
				bos.write(buf, 0, size);
			}
			bos.flush();
			sun.misc.BASE64Encoder encoder = new sun.misc.BASE64Encoder();
			return encoder.encode(bos.toByteArray());
		} catch (IOException e) {
		} catch (ClassCastException e) {
		} finally {
			try {
				bos.close();
				bis.close();
				httpUrl.disconnect();
			} catch (IOException e) {
			} catch (NullPointerException e) {
			}
		}
		return null;
	}
	
	public static void main(String[] args) {
		System.out.println(ImageUtil.getImgBase64FromNetworkUrl("http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0"));
	}
}

