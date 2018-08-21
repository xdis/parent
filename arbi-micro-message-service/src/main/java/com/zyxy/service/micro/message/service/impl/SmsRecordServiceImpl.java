package com.zyxy.service.micro.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.SmsRecord;
import com.zyxy.common.domain.SmsRecordExample;
import com.zyxy.common.domain.SmsRecordWithBLOBs;
import com.zyxy.common.mapper.SmsRecordMapper;
import com.zyxy.service.micro.message.service.SmsRecordService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class SmsRecordServiceImpl implements SmsRecordService {

	@Autowired
	private SmsRecordMapper mapper;
	
	@Override
	public int countByExample(SmsRecordExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(SmsRecordExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<SmsRecord> selectByExample(SmsRecordExample example) {
		return mapper.selectByExample(example);
	}



	@Override
	public int updateByExample(SmsRecord record,
			SmsRecordExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(SmsRecordWithBLOBs record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(SmsRecord record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<SmsRecord> selectPagedByExample(Integer page, Integer pageSize,
			SmsRecordExample example) {
		if (page == null || page < 1) {
			page = 1;
		}
		if (pageSize == null || pageSize < 1 || pageSize > 1000) {
			pageSize = 10;
		}
		PageHelper.startPage(page, pageSize);
		return new PageInfo<>(this.selectByExample(example));
	}

    @Override
    public int insert(SmsRecordWithBLOBs record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(SmsRecordWithBLOBs record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<SmsRecordWithBLOBs> selectByExampleWithBLOBs(
            SmsRecordExample example) {
        return mapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public SmsRecordWithBLOBs selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(SmsRecordWithBLOBs record,
            SmsRecordExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExampleWithBLOBs(SmsRecordWithBLOBs record,
            SmsRecordExample example) {
        return mapper.updateByExampleWithBLOBs(record, example);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(SmsRecordWithBLOBs record) {
        return mapper.updateByPrimaryKeyWithBLOBs(record);
    }
	
}
