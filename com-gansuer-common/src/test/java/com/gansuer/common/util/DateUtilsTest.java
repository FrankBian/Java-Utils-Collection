package com.gansuer.common.util;

import org.junit.Assert;
import org.junit.Test;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Frank on 3/11/16.
 */
public class DateUtilsTest {

    @Test
    public void testGetDateFormat() throws Exception {
        DateFormat dateFormat = DateUtils.getDateFormat();
        Assert.assertNotNull(dateFormat);
    }

    @Test
    public void testGetLongDate() throws Exception {

    }

    @Test
    public void testGetDateFromLong() throws Exception {

    }

    @Test
    public void testGetWeekendFromDate() throws Exception {
        Date date = new Date();
        date = DateUtils.getWeekendFromDate(date);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        Assert.assertEquals(7,calendar.get(Calendar.MONTH) +1); // 2016.7.3
        Assert.assertEquals(3,calendar.get(Calendar.DAY_OF_MONTH));
        Assert.assertEquals(2016,calendar.get(Calendar.YEAR));
        //LocalDate localDate = LocalDate.now();
        //int len = DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue();
        //System.out.println(len);
        //localDate = localDate.plusDays(len);
        //System.out.println(localDate);
    }

    @Test
    public void testFormatTime() throws Exception {

    }

    @Test
    public void testGetFromLong() throws Exception {

    }

    @Test
    public void testDefaultTime() throws Exception {

    }

    @Test
    public void testFromatDates() throws Exception {

    }

    @Test
    public void testGetDateTime() throws Exception {

    }

    @Test
    public void testGetCurrentDate() throws Exception {

    }

    @Test
    public void testGetAddDays() throws Exception {

    }

    @Test
    public void testGetAddDays1() throws Exception {

    }

    @Test
    public void testGetAddDays2() throws Exception {

    }

    @Test
    public void testGetAddMins() throws Exception {

    }

    @Test
    public void testGetDaysMin() throws Exception {

    }

    @Test
    public void testChangeEndTime() throws Exception {

    }

    @Test
    public void testGetDaysSecond() throws Exception {

    }

    @Test
    public void testGetTimeSpanSeconds() throws Exception {

    }

    @Test
    public void testAddHours() throws Exception {

    }

    @Test
    public void testInitKeyTime() throws Exception {

    }

    @Test
    public void testGetTimeSpanMinutes() throws Exception {

    }

    @Test
    public void testGetTimeSpanMinutes1() throws Exception {

    }

    @Test
    public void testTimeCompare() throws Exception {

    }

    @Test
    public void testTimeCompareStr() throws Exception {

    }

    @Test
    public void testCreateDates() throws Exception {

    }

    @Test
    public void testTimeCompare1() throws Exception {

    }

    @Test
    public void testGetBetweentHours() throws Exception {

    }

    @Test
    public void testTimeCompareDate() throws Exception {

    }

    @Test
    public void testTimeCompare2() throws Exception {

    }

    @Test
    public void testTimeCompareBefore() throws Exception {

    }

    @Test
    public void testString2Date() throws Exception {

    }

    @Test
    public void testGetString2Date() throws Exception {

    }

    @Test
    public void testDate2String() throws Exception {

    }

    @Test
    public void testGetWeekBeginDate() throws Exception {

    }

    @Test
    public void testGetWeekBeginDate1() throws Exception {

    }

    @Test
    public void testGetWeekEndDate() throws Exception {

    }

    @Test
    public void testGetWeekEndDate1() throws Exception {

    }

    @Test
    public void testGetPreWeekBeginDate() throws Exception {

    }

    @Test
    public void testGetPreWeekEndDate() throws Exception {

    }

    @Test
    public void testGetMonthBeginDate() throws Exception {

    }

    @Test
    public void testGetMonthEndDate() throws Exception {

    }

    @Test
    public void testGetPreMonthBeginDate() throws Exception {

    }

    @Test
    public void testGetPreMonthEndDate() throws Exception {

    }

    @Test
    public void testConvertStrToDate() throws Exception {

    }

    @Test
    public void testDateToKey() throws Exception {

    }

    @Test
    public void testGetDayOfWeek() throws Exception {

    }

    @Test
    public void testGet_week() throws Exception {

    }

    @Test
    public void testGetTimespan() throws Exception {

    }

    @Test
    public void testGetDays() throws Exception {

    }
}