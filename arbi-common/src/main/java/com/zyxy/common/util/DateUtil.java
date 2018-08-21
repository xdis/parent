package com.zyxy.common.util;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 日期 工具类
 * 
 * @author tanquan
 *
 */
public class DateUtil {
	private static final Logger logger = LoggerFactory.getLogger(DateUtil.class);
	/**
	 * 
	 * @param begin
	 *            :开始日期
	 * @param targetDate
	 *            :结束日期
	 * @return :返回相差天数
	 */
	public static long dateCompareByDay(String begin, String end) {
		begin = begin.replaceAll("[^0-9]", "");
		begin = begin.substring(0, 8);
		end = end.replaceAll("[^0-9]", "");
		end = end.substring(0, 8);
		long dis = -1;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMdd");
		Date nDate = null;
		Date tDate = null;
		try {
			nDate = df.parse(begin);
			tDate = df.parse(end);
			dis = (tDate.getTime() - nDate.getTime()) / 1000 / 60 / 60 / 24;
		} catch (ParseException e) {
			logger.error("dim dd error -begin:{} -end:{} - error message:", begin, end, e);
		}
		return dis;
	}
	
	/**
	 * 
	 * @param begin
	 *            :开始日期
	 * @param targetDate
	 *            :结束日期
	 * @return :返回相差天数
	 */
	public static long dateCompareByDay(Date begin, Date end) {
		long dis = -1;
		dis = (end.getTime() - begin.getTime()) / 1000 / 60 / 60 / 24;
		return dis;
	}

	/**
	 * 
	 * @param beginDate
	 *            :被比较日期
	 * @param endDate
	 *            :目标日期
	 * @return :返回目标日期与对象日期相差的天数
	 */
	public static long dateCompareByMiliSec(String beginDate, String endDate) {
		beginDate = beginDate.replaceAll("[^0-9]", "");
		endDate = endDate.replaceAll("[^0-9]", "");
		long dis = -1;
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date bDate = null;
		Date eDate = null;
		try {
			bDate = df.parse(beginDate);
			eDate = df.parse(endDate);
			dis = (eDate.getTime() - bDate.getTime());
		} catch (ParseException e) {
			logger.error("dim dd error -beginDate:{} -endDate:{} - error message:", beginDate, endDate, e);
		}
		return dis;
	}

	public static String getDate() {
		return getDate("yyyyMMddHHmmss");
	}

	/**
	 * 
	 * @param date_mode
	 *            :yyyyMMddHHmmss
	 * @return
	 */
	public static String getDate(String date_mode) {
		Date d = new Date();
		SimpleDateFormat date = new SimpleDateFormat(date_mode);
		date.setTimeZone(TimeZone.getTimeZone("Asia/Shanghai"));
		String datename = date.format(d).toString();
		return datename;
	}

	/**
	 * 
	 * @param dateTime
	 *            :被加时间
	 * @param days
	 *            :增加MiliSec
	 * @return 加后时间字符串
	 */
	public static String dateTimeAddByMiliSec(String dateTime, long sec) {
		return dateTimeAddByMiliSec(dateTime, sec, "yyyyMMddHHmmss");
	}

	/**
	 * 
	 * @param dateTime
	 *            :被加时间
	 * @param days
	 *            :增加MiliSec
	 * @param outPutMode
	 *            :输出格式
	 * @return 加后时间字符串
	 */
	public static String dateTimeAddByMiliSec(String dateTime, long sec, String outPutMode) {
		SimpleDateFormat df = new SimpleDateFormat(outPutMode);
		Date dealDate = new Date();
		try {
			dealDate = df.parse(dateTime);
		} catch (ParseException e) {
			logger.error("dim dm String error -dateTime:{} -sec:{} - error message:", dateTime, sec, e);
		}
		Date addedDate = new Date(dealDate.getTime() + sec);
		return df.format(addedDate);
	}

	/**
	 * @param dateTime :被减时间
	 * @param sec      :毫秒值
	 * @return 加后时间字符串
	 */
	public static Date dateTimeSubByMiliSec(Date dateTime, long sec) {
		return new Date(dateTime.getTime() - sec);
	}

	/**
	 * @param dateTime :被减时间
	 * @param day      :天数
	 * @return 加后时间字符串
	 */
	public static Date dateTimeSubByDay(Date dateTime, long day) {
        return dateTimeSubByMiliSec(dateTime, day * (60 * 60 * 24 * 1000));
    }

	/**
	 * 
	 * @param dateTime
	 *            :被加时间
	 * @param days
	 *            :增加天数
	 * @param outPutMode
	 *            :输出格式
	 * @return 加后时间字符串
	 */
	public static String dateTimeAddByDays(String dateTime, long days, String outPutMode) {
		SimpleDateFormat df = new SimpleDateFormat(outPutMode);
		Date dealDate = new Date();
		try {
			dealDate = df.parse(dateTime);
		} catch (ParseException e) {
			logger.error("dim dd String error -dateTime:{} -days:{} - error message:", dateTime, days, e);
		}
		long s = days * 24 * 60 * 60 * 1000;
		Date addedDate = new Date(dealDate.getTime() + s);
		return df.format(addedDate);
	}

	/**
	 *
	 * @param dateTime
	 *            :被加时间
	 * @param days
	 *            :增加天数
	 * @return 加后时间字符串
	 */
	public static String dateTimeAddByDays(String dateTime, long days) {
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmss");
		Date dealDate = new Date();
		try {
			dealDate = df.parse(dateTime);
		} catch (ParseException e) {
			logger.error("dim dd String2 error -dateTime:{} -days:{} - error message:", dateTime, days, e);
		}
		long s = days * 24 * 60 * 60 * 1000;
		Date addedDate = new Date(dealDate.getTime() + s);
		return df.format(addedDate);
	}

	/**
	 *
	 * @param dateTime
	 *            :被加时间
	 * @param days
	 *            :增加天数
	 * @return 加后时间字符串
	 */
	public static Date dateTimeAddByDays(Date dateTime, long days) {
		long s = days * 24 * 60 * 60 * 1000;
		return new Date(dateTime.getTime() + s);
	}
	/**
	 * 将字符串日期增加日期后转换为日期格式 
	 * @param dateTime 字符串日期
	 * @param days 增加天数
	 * @return 加天数后日期格式天数
	 */
	public static Date dateTimeAddDaysReturnDate(String dateTime, int days){
		Date dealDate = DateUtil.formatDate(dateTime);
		long s = ((long)days) * 24 * 60 * 60 * 1000;
		return new Date(dealDate.getTime() + s);
	}
	

	/**
	 * 对系统当前日期进行累加
	 * 
	 * @param days
	 *            :增加天数
	 * @return 加后时间字符串
	 */
	public static String dateTimeAddByDays(long days, String outPutMode) {
		SimpleDateFormat df = new SimpleDateFormat(outPutMode);
		Date dealDate = new Date();
		long s = days * 24 * 60 * 60 * 1000;
		Date addedDate = new Date(dealDate.getTime() + s);
		return df.format(addedDate);
	}

	/**
	 * 格式化指定日期
	 * 
	 * @param d
	 * @param dateMode
	 * @return
	 */
	public static String formatDate(Date d, String dateMode) {
		if (d == null || dateMode == null || "".equals(dateMode.trim())) {
			return null;
		}
		SimpleDateFormat df = new SimpleDateFormat(dateMode);
		return df.format(d);
	}

	/**
	 * 格式化指定字符串日期
	 * 
	 * @param dateStr
	 * @param dateMode
	 * @return
	 */
	public static String formatDate(String dateStr, String dateMode) {
		if (dateStr == null || dateMode == null || "".equals(dateMode.trim())) {
			return null;
		}
		dateStr = dateStr.replaceAll("[^0-9]", "");
		dateStr = rightZero(dateStr, 17);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try {
			Date target = df.parse(dateStr);
			SimpleDateFormat df2 = new SimpleDateFormat(dateMode);
			return df2.format(target);
		} catch (ParseException e) {
			logger.error("formatting date error -dateStr:{} - error message:", dateStr, e);
		}
		return null;
	}

	/**
	 * 转换成指定格式的时间对象
	 * 
	 * @param obj
	 * @param pattern
	 * @return
	 */
	public static Date tranObj2Date(Object obj, String pattern) {
		if (obj == null) {
			return new Date();
		}
		if (pattern == null) {
			pattern = "yyyy-MM-dd";
		}
		if (obj instanceof String) {
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			try {
				return format.parse(obj.toString());
			} catch (ParseException e) {
				logger.error("transform object date error -obj:{} - error message:", obj, e);
				return null;
			}
		}
		if (obj instanceof Date) {
			return (Date) obj;
		}
		if (obj instanceof java.sql.Timestamp) {
			return (Date) obj;
		}
		if (obj instanceof java.sql.Time) {
			return (Date) obj;
		}
		return null;
	}

	/**
	 * 格式化指定字符串日期
	 * @param dateStr 
	 * @param dateMode
	 * @return
	 */
	public static Date formatDate(String dateStr) {
		if (dateStr == null) {
			return null;
		}
		dateStr = dateStr.replaceAll("[^0-9]", "");
		dateStr = rightZero(dateStr, 17);
		SimpleDateFormat df = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		try {
			return df.parse(dateStr);
		} catch (ParseException e) {
			logger.error("formatting date error -dateStr:{} - error message:", dateStr, e);
		}
		return null;
	}
	
	
	
	/**
	 * 字符串右补0
	 * 
	 * @param str
	 * @param length
	 *            包含 str 在内字符串总长度
	 * @return
	 */
	private static String rightZero(String str, int length) {
		if (str == null) {
			return null;
		}
		int zeroLength = length - str.length();
		if (zeroLength <= 0) {
			return str;
		}
		for (int i = 0; i < zeroLength; i++) {
			str += "0";
		}
		return str;
	}
	
	public static String test(String target) {
		String now = DateUtil.getDate("yyyyMMddHHmmssSSS");
		BigDecimal LL = new BigDecimal(now).subtract(new BigDecimal(target));
		return LL.toString();
		/*if (y > 0 && m >= 0 && d >=0 && h >= 0 && M >= 0 && s >= 0 && S >= 0) {
			return  y + "年前";
		}
		if (y <= 0 && m > 0 && d >=0 && h >= 0 && M >= 0 && s >= 0 && S >= 0) {
			return  m + "月前";
		}
		if (y == 1 && m < 0) {
			if (d > 0) {
				return  m + 12 + "月前";
			}
		}
		if (y <= 0 && m <= 0 && d > 0 && h >= 0 && M >= 0 && s >= 0 && S >= 0) {
			return  d + "天前";
		}
		if (y <= 0 && m <= 0 && d <= 0 && h > 0 && M >= 0 && s >= 0 && S >= 0) {
			return  h + "小时前";
		}
		if (y <= 0 && m <= 0 && d <= 0 && h <= 0 && M > 0 && s >= 0 && S >= 0) {
			return  M + "分钟前";
		}
		if (y <= 0 && m <= 0 && d <= 0 && h <= 0 && M <= 0 && s > 20 && S >= 0) {
			return  s + "秒前";
		}
		if (y <= 0 && m <= 0 && d <= 0 && h <= 0 && M <= 0 && s <= 20 && S >= 0) {
			return  "刚刚";
		}
		return "未知";*/
	}
	
	/**
	 * 
	 * @param begin
	 *            :开始日期
	 * @param targetDate
	 *            :结束日期
	 * @return :返回相差天数
	 */
	public static long dateCompare(Date begin, Date end) {
		long dis = -1;
		float cha = Math.abs(end.getTime() - begin.getTime());
		if(end.getTime() - begin.getTime() < 0 && cha >= 1){
			return -1;
		}else if(0 <= cha && cha < 1){
			return 0;
		}
		dis = (end.getTime() - begin.getTime()) / 1000 / 60 / 60 / 24;
		return dis;
	}

    public static Date dateSub(Date source) {
        long time = source.getTime();
        long date = time % (1000 * 60 * 60 * 24);
        long l = time - date - (1000 * 60 * 60 * 8);
        return new Date(l);
    }

    public static void main(String[] args) {
		System.err.println(DateUtil.dateCompareByDay("20170831", "20170831"));
	}
}
