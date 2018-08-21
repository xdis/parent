package com.zyxy.service.micro.message.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.MailRecord;
import com.zyxy.common.domain.MailRecordExample;
import com.zyxy.common.domain.MailRecordWithBLOBs;
import com.zyxy.common.mapper.MailRecordMapper;
import com.zyxy.service.micro.message.service.MailRecordService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class MailRecordServiceImpl implements MailRecordService {

	@Autowired
	private MailRecordMapper mapper;
	
	@Override
	public int countByExample(MailRecordExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(MailRecordExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}


	@Override
	public List<MailRecord> selectByExample(MailRecordExample example) {
		return mapper.selectByExample(example);
	}



	@Override
	public int updateByExample(MailRecord record,
			MailRecordExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(MailRecordWithBLOBs record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(MailRecord record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<MailRecord> selectPagedByExample(Integer page, Integer pageSize,
			MailRecordExample example) {
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
    public int insert(MailRecordWithBLOBs record) {
        return mapper.insert(record);
    }

    @Override
    public int insertSelective(MailRecordWithBLOBs record) {
        return mapper.insertSelective(record);
    }

    @Override
    public List<MailRecordWithBLOBs> selectByExampleWithBLOBs(
            MailRecordExample example) {
        return mapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public MailRecordWithBLOBs selectByPrimaryKey(String id) {
        return mapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByExampleSelective(MailRecordWithBLOBs record,
            MailRecordExample example) {
        return mapper.updateByExampleSelective(record, example);
    }

    @Override
    public int updateByExampleWithBLOBs(MailRecordWithBLOBs record,
            MailRecordExample example) {
        return mapper.updateByExampleWithBLOBs(record, example);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(MailRecordWithBLOBs record) {
        return mapper.updateByPrimaryKeyWithBLOBs(record);
    }
	
}
