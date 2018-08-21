package com.zyxy.service.micro.third.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyxy.common.domain.PayRLItems;
import com.zyxy.common.domain.PayRLItemsExample;
import com.zyxy.common.mapper.PayRLItemsMapper;
import com.zyxy.common.vo.PayItemVO;
import com.zyxy.service.micro.third.service.PayRLItemsService;
/**
 * 
 * @author tanquan
 *
 */
@Service
public class PayRLItemsServiceImpl implements PayRLItemsService {

	@Autowired
	private PayRLItemsMapper mapper;
	
	@Override
	public int countByExample(PayRLItemsExample example) {
		return mapper.countByExample(example);
	}

	@Override
	public int deleteByExample(PayRLItemsExample example) {
		return mapper.deleteByExample(example);
	}

	@Override
	public int deleteByPrimaryKey(String id) {
		return mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(PayRLItems record) {
		return mapper.insert(record);
	}

	@Override
	public int insertSelective(PayRLItems record) {
		return mapper.insertSelective(record);
	}

	@Override
	public List<PayRLItems> selectByExample(PayRLItemsExample example) {
		return mapper.selectByExample(example);
	}

	@Override
	public PayRLItems selectByPrimaryKey(String id) {
		return mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByExampleSelective(PayRLItems record,
			PayRLItemsExample example) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByExample(PayRLItems record,
			PayRLItemsExample example) {
		return mapper.updateByExample(record, example);
	}

	@Override
	public int updateByPrimaryKeySelective(PayRLItems record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(PayRLItems record) {
		return mapper.updateByPrimaryKey(record);
	}
	
	@Override
	public PageInfo<PayRLItems> selectPagedByExample(Integer page, Integer pageSize,
			PayRLItemsExample example) {
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
    public List<PayItemVO> selectPayItemByUsages(Integer usages) {
        PayRLItemsExample ex = new PayRLItemsExample();
        ex.createCriteria().andUsagesEqualTo(usages);
        List<PayRLItems> list = this.selectByExample(ex);
        if (list == null || list.isEmpty()) {
            return new ArrayList<PayItemVO>();
        }
        List<PayItemVO> rtnList = new ArrayList<PayItemVO>();
        PayItemVO i = null;
        for (PayRLItems item : list) {
            i = new PayItemVO();
            i.setItemNo(item.getItemNo());
            i.setItemName(item.getItemName());
            rtnList.add(i);
        }
        return rtnList;
    }

	
}
