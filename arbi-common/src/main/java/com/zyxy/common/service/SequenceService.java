package com.zyxy.common.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.zyxy.common.domain.CaseNoRecord;
import com.zyxy.common.domain.CaseNoSeq;
import com.zyxy.common.mapper.CaseNoRecordMapper;
import com.zyxy.common.mapper.CaseNoSeqMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.zyxy.common.domain.SysSequence;
import com.zyxy.common.exception.BuzzException;
import com.zyxy.common.mapper.SysSequenceMapper;
import com.zyxy.common.util.DateUtil;
import com.zyxy.common.util.StringUtil;

@Service
public class SequenceService {
	
    protected Logger logger = LoggerFactory.getLogger(this.getClass());
    
    @Autowired
    private SysSequenceMapper mapper;
    
    /**
     * 业务-机器代码
     */
    @Value("${system.bizMachine.no:6000}")
    private String mNo = "6700";

	// 当前系统时间下一分钟的时间戳
    private static long NEXT_MINUTE_TIMESTAMP = 0L;
    // 当前系统时间字符串缓存（yyyyMMddHHmm精确到分钟）
    private static String CURRENT_MINUTE_STR = null;
    // 计数器最大值
    private final static int SEQ_MAX = 99999999;
    // 计数器最大值的长度
    private final static int SEQ_LENGTH = String.valueOf(SEQ_MAX).length();
    // 通用流水号计数器
    private static int CURRENT_SEQ = new Random().nextInt(SEQ_MAX/2);
    
    /**
     * 获取时间yyyyMMddHHmmss字符串
     * @return
     */
    private String getTimeStr() {
        if (System.currentTimeMillis() >= NEXT_MINUTE_TIMESTAMP) {
            // 生成新的时间字符串及下一分钟的时间戳缓存
            String timeTemp = DateUtil.getDate("yyyyMMddHHmm");
            Date currMin = DateUtil.formatDate(timeTemp);
            CURRENT_MINUTE_STR = timeTemp;
            NEXT_MINUTE_TIMESTAMP = currMin.getTime() + 60000;
        }
        return CURRENT_MINUTE_STR;
    }
    /**
     * 获取通用流水号的序列
     * @return
     */
    private synchronized int nextSeq() {
        if (++CURRENT_SEQ > SEQ_MAX) {
            CURRENT_SEQ = new Random().nextInt(SEQ_MAX);
        }
        return CURRENT_SEQ;
    }
    
    /**
	 * 获取通用流水号
	 * 
	 * @return
	 */
	public String getCommonID() {
		StringBuffer seqSb = new StringBuffer(32);
		seqSb.append(getTimeStr()); // 时间前缀
		seqSb.append(mNo); // 机器编号
        String seqStr = String.valueOf(this.nextSeq());
        seqStr = StringUtil.leftZero(seqStr, SEQ_LENGTH);
        seqSb.append(seqStr);
        return seqSb.toString();
	}

    @Autowired
    public CaseNoSeqMapper caseNoSeqMapper;

    @Autowired
    public CaseNoRecordMapper caseNoRecordMapper;
    /**
     * 获取案号
     *
     * @return
     */
    @Transactional(isolation = Isolation.READ_COMMITTED)
    public String getCaseNo(String caseId) {
        String caseSeqId = getCommonID();
        caseNoSeqMapper.generaCaseNo(caseSeqId);
        CaseNoRecord caseNoRecord = new CaseNoRecord();
        caseNoRecord.setId(getCommonID());
        caseNoRecord.setCaseId(caseId);
        caseNoRecord.setCaseSeqId(caseSeqId);
        caseNoRecordMapper.insertSelective(caseNoRecord);
//        查询出年份，序号 珠仲网字（xxx）第xxx号
        CaseNoSeq caseNoSeq = caseNoSeqMapper.selectByPrimaryKey(caseSeqId);
        return "珠仲网字（" + caseNoSeq.getYear() + "）第" + caseNoSeq.getNo() + "号";
    }

	/**
	 * 获取瑞联支付8位序列号
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
    public String getRLPaySeq() {
        // 获取db序号
        String seqId = "RL_PAY_SEQ";
        int up = mapper.increaseByPrimaryKey(seqId);
        if (up != 1) {
            logger.error("生成瑞联支付8位序列号失败");
            throw new BuzzException("生成瑞联支付8位序列号失败");
        }
        SysSequence seq = mapper.selectByPrimaryKey(seqId);
        String seqStr = StringUtil.leftZero(String.valueOf(seq.getScurrent()), 8);
        return seqStr;
    }
	
	/**
	 * 获取证书序列号
	 * @return
	 */
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public String getCertSeq() {
	    // 获取db序号
	    String seqId = "CERT_SEQ";
	    int up = mapper.increaseByPrimaryKey(seqId);
	    if (up != 1) {
	        logger.error("获取证书序列号失败");
	        throw new BuzzException("获取证书序列号失败");
	    }
	    SysSequence seq = mapper.selectByPrimaryKey(seqId);
	    String seqStr = StringUtil.leftZero(String.valueOf(seq.getScurrent()), 8);
	    return seqStr;
	}
	
	public static void main(String[] args) {
		SequenceService imp = new SequenceService();
		List<String> a = new ArrayList<>();
		Long t = System.currentTimeMillis();
		for(int i = 0; i < 1000000; i++)
			a.add(imp.getCommonID());
		System.out.println(a.size());
		System.out.println(System.currentTimeMillis() - t);
		System.out.println(a.get(1));
		
	}
}