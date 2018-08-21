package com.zyxy.service.micro.third.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.RealNameAuthRecord;
import com.zyxy.common.domain.RealNameAuthRecordExample;
import com.zyxy.common.mapper.RealNameAuthRecordMapper;
import com.zyxy.service.micro.third.service.RealNameAuthRecordService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class RealNameAuthRecordServiceImpl implements RealNameAuthRecordService {

	@Autowired
	private RealNameAuthRecordMapper mapper;
	
	@Override
	public int countByExample(RealNameAuthRecordExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(RealNameAuthRecordExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(RealNameAuthRecord record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(RealNameAuthRecord record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<RealNameAuthRecord> selectByExample(RealNameAuthRecordExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public RealNameAuthRecord selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(RealNameAuthRecord record,
			RealNameAuthRecordExample example) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByExample(RealNameAuthRecord record,
			RealNameAuthRecordExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(RealNameAuthRecord record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(RealNameAuthRecord record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<RealNameAuthRecord> selectPagedByExample(Integer page, Integer pageSize,
			RealNameAuthRecordExample example) {
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
