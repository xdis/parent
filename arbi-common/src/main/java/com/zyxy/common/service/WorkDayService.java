package com.zyxy.common.service;

import com.alibaba.fastjson.JSONObject;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.HttpUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Service
public class WorkDayService {

    protected Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 计算开始时间指定工作日后为那一天
     *
     * @param startDate 开始时间
     * @param workDay   工作日数
     * @param isMorrow  是否次日开始计算
     * @return
     */
    public Date after(Date startDate, Long workDay, boolean isMorrow) {
        if (isMorrow) {
            workDay++;
        }
        Date endTime = DateUtil.dateTimeAddByDays(startDate, workDay);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        String startDateStr;
        Map<String, Object> workDateResult;
        boolean flag = false;
        while (true) {
            Date date1 = DateUtil.dateTimeSubByDay(endTime, 1);
            startDateStr = simpleDateFormat.format(date1);
            workDateResult = callApi(startDateStr);
            if (!"1".equals(workDateResult.get("success"))) {
                logger.error(JSONObject.toJSONString(workDateResult));
                throw new RuntimeException("调用计算日期接口返回状态失败");
            }
            /*
             *         "date": "2015-09-03", 查询的日期
             *         "workmk": "2", 1:工作日 2:假日
             * */
            String workmk = (String) ((Map) workDateResult.get("result")).get("workmk");
            if ("1".equals(workmk)) {
                Date parse;
                simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    String date = (String) ((Map) workDateResult.get("result")).get("date");
                    parse = simpleDateFormat.parse(date);
                } catch (ParseException e) {
                    logger.error(JSONObject.toJSONString(workDateResult));
                    throw new RuntimeException("调用计算日期返回日期格式错误");
                }
                if (flag) {
                    return DateUtil.dateTimeAddByDays(parse, 1);
                } else {
                    return DateUtil.dateSub(endTime);
                }
            }
            try {
                endTime = DateUtil.dateTimeAddByDays(endTime, 1);
            } catch (Exception e) {
            }
            flag = true;
        }
    }

    /**
     * 计算开始时间指定工作日后为那一天
     *
     * @param startDate 开始时间
     * @param workDay   天数
     * @return
     */
    public Date after(Date startDate, Long workDay) {
        return after(startDate, workDay, true);
    }

    /**
     * 计算当前时间指定工作日后为那一天
     *
     * @param workDay 天数
     * @return
     */
    public Date after(Long workDay) {
        return after(new Date(), workDay, true);
    }

    /**
     * 计算当前时间指定工作日后为那一天
     *
     * @param workDay  天数
     * @param isMorrow 是否次日开始计算
     * @return
     */
    public Date after(Long workDay, boolean isMorrow) {
        return after(new Date(), workDay, isMorrow);
    }

    /**
     * workday.appkey=30254
     * workday.sign=dc807a6ce48585310f4e0f9529b1d314
     * workday.url=http://api.k780.com/?app=life.workday
     */
    @Value("${workday.appkey}")
    private String appkey;

    @Value("${workday.sign}")
    private String sign;

    @Value("${workday.url}")
    private String url;

    /**
     * 调用第三方服务计算
     *
     * @param dateStr
     * @return
     */
    private Map<String, Object> callApi(String dateStr) {
        Map<String, String> params = new HashMap<>();
        params.put("appkey", appkey);
        params.put("sign", sign);
        params.put("format", "json");
        params.put("date", dateStr);
        String result = HttpUtil.sendPost(url, params);
        /*
         *  {
         *      "success": "1",
         *      "result": 
         *      {
         *         "date": "2015-09-03", 查询的日期
         *         "workmk": "2", 1:工作日 2:假日
         *                 "worknm": "假日",
         *                 "week_1": "4", 星期样式1
         *                 "week_2": "星期四", 星期样式2
         *                 "week_3": "周四", 星期样式3
         *                 "week_4": "Wednesday", 星期样式4
         *                 "remark": "纪念日：世界反法西斯战争胜利70周年纪念日." 当天特殊备注
         *      }
         *  }
         * */
        return JSONObject.parseObject(result);
    }

}