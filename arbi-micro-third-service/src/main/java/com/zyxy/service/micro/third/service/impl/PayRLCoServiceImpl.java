package com.zyxy.service.micro.third.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.PayRLCo;
import com.zyxy.common.domain.PayRLCoExample;
import com.zyxy.common.mapper.PayRLCoMapper;
import com.zyxy.service.micro.third.service.PayRLCoService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class PayRLCoServiceImpl implements PayRLCoService {

	@Autowired
	private PayRLCoMapper mapper;
	
	@Override
	public int countByExample(PayRLCoExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PayRLCoExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PayRLCo record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(PayRLCo record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<PayRLCo> selectByExample(PayRLCoExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public PayRLCo selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(PayRLCo record,
			PayRLCoExample example) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByExample(PayRLCo record,
			PayRLCoExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(PayRLCo record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PayRLCo record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<PayRLCo> selectPagedByExample(Integer page, Integer pageSize,
			PayRLCoExample example) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (pageSize == null || pageSize < 1 || pageSize > 1000) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		return new PageInfo<>(this.selectByExample(example));
	}

	
}
