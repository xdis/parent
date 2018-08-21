package com.zyxy.common.util;

import com.zyxy.common.dto.BasePageDTO;
import com.zyxy.common.dto.PartyCaseListDTO;
import org.junit.Assert;
import org.junit.Test;

/**
 * Convert工具类
 */
public class ConvertUtilTest {

    @Test
    public void testConvert() throws Exception {
        PartyCaseListDTO partyCaseListForm = new PartyCaseListDTO();
        partyCaseListForm.setPageNum(1);
        partyCaseListForm.setCurrentRole("1");

        BasePageDTO result = ConvertUtil.convert(partyCaseListForm, BasePageDTO.class);
        Assert.assertEquals(result.getPageNum(), partyCaseListForm.getPageNum());
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme