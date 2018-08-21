package com.zyxy.service.micro.third.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.PayOrder;
import com.zyxy.common.domain.PayOrderExample;
import com.zyxy.common.mapper.PayOrderMapper;
import com.zyxy.service.micro.third.service.PayOrderService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class PayOrderServiceImpl implements PayOrderService {

	@Autowired
	private PayOrderMapper mapper;
	
	@Override
	public int countByExample(PayOrderExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PayOrderExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PayOrder record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(PayOrder record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<PayOrder> selectByExample(PayOrderExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public PayOrder selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(PayOrder record,
			PayOrderExample example) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByExample(PayOrder record,
			PayOrderExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(PayOrder record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PayOrder record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<PayOrder> selectPagedByExample(Integer page, Integer pageSize,
			PayOrderExample example) {
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
    public List<PayOrder> selectByExampleWithBLOBs(PayOrderExample example) {
        return mapper.selectByExampleWithBLOBs(example);
    }

    @Override
    public int updateByExampleWithBLOBs(PayOrder record, PayOrderExample example) {
        return mapper.updateByExampleWithBLOBs(record, example);
    }

    @Override
    public int updateByPrimaryKeyWithBLOBs(PayOrder record) {
        return mapper.updateByPrimaryKeyWithBLOBs(record);
    }
	
}
