package com.zyxy.service.micro.file.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.SysFile;
import com.zyxy.common.domain.SysFileExample;
import com.zyxy.common.mapper.SysFileMapper;
import com.zyxy.service.micro.file.service.SysFileService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class SysFileServiceImpl implements SysFileService {

	@Autowired
	private SysFileMapper mapper;
	
	@Override
	public int countByExample(SysFileExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SysFileExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(SysFile record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(SysFile record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<SysFile> selectByExample(SysFileExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public SysFile selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(SysFile record,
			SysFileExample example) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByExample(SysFile record,
			SysFileExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SysFile record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SysFile record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<SysFile> selectPagedByExample(Integer page, Integer pageSize,
			SysFileExample example) {
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
