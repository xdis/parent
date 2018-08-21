package com.zyxy.common.util;

import java.math.BigDecimal;


/**
 * 数组工具类
 * 
 */
public class MoneyUtil {
	
	/**
	 * 分转元
	 * @param fen
	 * @return
	 */
	public static String fen2Yuan(Long fen) {
		BigDecimal ori = new BigDecimal(fen);
		// 保留2位小数并且四舍六入五成双
		ori = ori.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
		return String.valueOf(ori);
	}

    /**
	 * 分转元
	 * @param fen
	 * @return
	 */
	public static Long fen2Yuan(String fen) {
		BigDecimal ori = new BigDecimal(fen);
		// 保留2位小数并且四舍六入五成双
		ori = ori.divide(new BigDecimal(100), 2, BigDecimal.ROUND_HALF_EVEN);
		return ori.longValue();
	}
	
	/**
	 * 元转分
	 * @param fen
	 * @return
	 */
	public static Long yuan2Fen(Double yuan) {
		BigDecimal ori = new BigDecimal(yuan);
		// 元转分并且四舍六入五成双
		ori = ori.multiply(new BigDecimal(100));
		ori.setScale(0, BigDecimal.ROUND_HALF_EVEN);
		return ori.longValue();
	}
	
	/**
	 * 元转分
	 * @param fen
	 * @return
	 */
	public static Long yuan2Fen(String yuan) {
		BigDecimal ori = new BigDecimal(yuan);
		// 元转分并且四舍六入五成双
		ori = ori.multiply(new BigDecimal(100));
		ori.setScale(0, BigDecimal.ROUND_HALF_EVEN);
		return ori.longValue();
	}
	
	
}
