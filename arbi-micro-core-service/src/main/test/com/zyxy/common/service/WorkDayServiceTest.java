package com.zyxy.common.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import static org.mockito.Mockito.*;

public class WorkDayServiceTest {
    @Mock
    Logger logger;
    @Mock
    SimpleDateFormat simpleDateFormat;
    @InjectMocks
    private WorkDayService workDayService;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAfter() throws Exception {
        Date result = workDayService.after(new GregorianCalendar(2017, Calendar.DECEMBER, 13, 10, 55).getTime(), 1L, true);
        Assert.assertEquals(new GregorianCalendar(2017, Calendar.DECEMBER, 15, 0, 0).getTime(), result);

        result = workDayService.after(new GregorianCalendar(2017, Calendar.DECEMBER, 14, 10, 55).getTime(), 1L, true);
        Assert.assertEquals(new GregorianCalendar(2017, Calendar.DECEMBER, 16, 0, 0).getTime(), result);

        result = workDayService.after(new GregorianCalendar(2017, Calendar.DECEMBER, 15, 10, 55).getTime(), 1L, true);
        Assert.assertEquals(new GregorianCalendar(2017, Calendar.DECEMBER, 19, 0, 0).getTime(), result);
//
//        result = workDayService.after(new GregorianCalendar(2017, Calendar.JANUARY, 26, 10, 55).getTime(), 1, true);
//        Assert.assertEquals(new GregorianCalendar(2017, Calendar.JANUARY, 30, 0, 0).getTime(), result);
    }
}

//Generated with love by TestMe :) Please report issues and submit feature requests at: http://weirddev.com/forum#!/testme