package com.zyxy.common.mapper;

import com.zyxy.service.micro.core.CoreApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * caseManagerMapper测试
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=CoreApplication.class)
public class CaseManagerMapperTests {

    @Autowired
    CaseManagerMapper caseManagerMapper;

    @Test
    public void testAllotManagerPeopleByCaseAndType() throws Exception {
        Assert.assertEquals(1, caseManagerMapper.allotManagerPeopleByCaseAndType("1", "2"));
    }

    @Test
    public void testQueryNowWorkPeopleIdByType() throws Exception {
        Assert.assertEquals("4", caseManagerMapper.queryNowWorkPeopleIdByType("1", "2"));
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme