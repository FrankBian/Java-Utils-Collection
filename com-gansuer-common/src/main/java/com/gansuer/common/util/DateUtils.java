package com.gansuer.common.util;

import org.apache.log4j.Logger;

import java.sql.Time;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

public class DateUtils {
    public static final Logger logger = Logger.getLogger(DateUtils.class);

    public static final String DefaultTime = "2000-01-01 00:00:00";
    private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";

    private static ThreadLocal threadLocal = new ThreadLocal() {
        protected synchronized Object initialValue() {
            return new SimpleDateFormat(DATE_FORMAT);
        }
    };

    public static DateFormat getDateFormat() {
        return (DateFormat) threadLocal.get();
    }

    public static long getLongDate(Date date) {
        return date.getTime() / 1000;
    }

    public static Date getDateFromLong(Long date) {
        return new Date(date * 1000);
    }

    /**
     * 根据输入的Date返回该周的周日Date
     *
     * @param date
     * @return
     */
    public static Date getWeekendFromDate(Date date) {

        Calendar datetest = Calendar.getInstance();
        datetest.setTime(date);
        int year = datetest.get(Calendar.YEAR);
        int month = datetest.get(Calendar.MONTH) + 1;
        int day = datetest.get(Calendar.DAY_OF_MONTH);

        if (month == 1 || month == 2) {
            year -= 1;
            month += 12;
        }

        /**
         * 计算星期可用 蔡勒（Zeller）公式（只适合于1582年10月15日之后的情形）：
         * W = Y + [Y/4] + [C/4] - 2C + [13(M+1)/5] + D - 1
         */
        int week = (day + 1 + 2 * month + 3 * (month + 1) / 5 + year + (year / 4) - year / 100 + year / 400) % 7;

        try {
            return DateUtils.getAddDays(date, 7 - week);
        } catch (Exception e) {
            return DateUtils.defaultTime();
        }
    }

    /**
     * 将指定日期时间格式化为时间格式
     *
     * @param date
     * @return Time
     * @author zhuang
     * @date 2014年9月5日
     */
    public static Time formatTime(Date date) {
        Time time = new Time(date.getTime());
        return time;
    }

    public static Date getFromLong(String senconds) {
        try {
            return new Date(Long.parseLong(senconds) * 1000);
        } catch (Exception e) {
            logger.error("format date error：", e);
        }
        return defaultTime();
    }

    /**
     * 默认日期
     *
     * @return
     */
    public static Date defaultTime() {
        Date d = new Date();
        try {
            d = getDateFormat().parse(DefaultTime);
        } catch (Exception e) {
            logger.error("获取默认日期出现异常：", e);
        }
        return d;
    }

    /**
     * 格式化日期格式
     *
     * @param t
     * @return
     */
    public static Date fromatDates(Date t) {
        try {
            String timeDate = getDateFormat().format(t);
            return DateUtils.getString2Date(timeDate);
        } catch (Exception e) {
            logger.error("格式化日期出现异常：", e);
            return t;
        }
    }

    /**
     * 获取日期
     *
     * @param date
     * @return 返回日期格式(yyyy-MM-dd HH:mm:ss)
     */
    public static String getDateTime(Date date) {
        if (date == null) {
            return null;
        }
        return getDateFormat().format(date);
    }

    /**
     * 获取当前日期
     *
     * @return
     */
    public static Date getCurrentDate() {
        Calendar calendar = Calendar.getInstance();
        return calendar.getTime();
    }

    /**
     * 把当前时间推迟或者增加几天
     *
     * @param days 要延迟或者提前的天数 例如1,2等
     * @return
     */
    public static Date getAddDays(int days) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.DAY_OF_YEAR, days);
        return calendar.getTime();
    }

    /**
     * 在str指定的日期，的基础上加几天
     *
     * @param str
     * @return
     * @throws Exception
     */
    public static Date getAddDays(String str, int days) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String str="20110823";
        Date dt = sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(dt);
        //rightNow.add(Calendar.YEAR,-1);//日期减1年
        //rightNow.add(Calendar.MONTH,3);//日期加3个月
        rightNow.add(Calendar.DAY_OF_YEAR, days);//日期加days
        //Date dt1=rightNow.getTime();
        //String reStr = sdf.format(dt1);
        //System.out.println(reStr);
        return rightNow.getTime();
    }

    public static Date getAddDays(Date date, int days) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        //String str="20110823";
        //Date dt=sdf.parse(str);
        Calendar rightNow = Calendar.getInstance();
        rightNow.setTime(date);
        //rightNow.add(Calendar.YEAR,-1);//日期减1年
        //rightNow.add(Calendar.MONTH,3);//日期加3个月
        rightNow.add(Calendar.DAY_OF_YEAR, days);//日期加days
        //Date dt1=rightNow.getTime();
        //String reStr = sdf.format(dt1);
        //System.out.println(reStr);
        return rightNow.getTime();
    }

    /**
     * 把当前时间向前或者向后推迟几分钟，支持负数
     *
     * @param min
     * @return
     */
    public static Date getAddMins(int min) {
        Calendar calendar = new GregorianCalendar();
        calendar.add(Calendar.MINUTE, min);
        return calendar.getTime();
    }

    /**
     * 获取当前时间的分钟值
     *
     * @param d
     * @return
     */
    public static long getDaysMin(Date d) {
        Calendar c1 = new GregorianCalendar();
        c1.setTime(d);
        long m = c1.get(Calendar.MINUTE);
        return m;
    }

    /**
     * 把当前时间推迟到59分，59秒
     *
     * @param d
     * @return
     */
    public static Date changeEndTime(Date d) {
        Calendar c1 = new GregorianCalendar();
        c1.setTime(d);
        c1.set(Calendar.MINUTE, 59);
        c1.set(Calendar.SECOND, 59);
        return c1.getTime();
    }

    /**
     * 获取时间的秒
     *
     * @param d
     * @return
     */
    public static long getDaysSecond(Date d) {
        Calendar c1 = new GregorianCalendar();
        c1.setTime(d);
        long m = c1.get(Calendar.SECOND);
        return m;
    }

    /**
     * 获取两个时间之间的差值，这里返回的是秒钟
     *
     * @param begindate
     * @param endTimes
     * @return
     */
    public static double getTimeSpanSeconds(Date begindate, Date endTimes) {
        double between = 0;
        try {
            long datebegin = begindate.getTime();
            long endTime = endTimes.getTime();
            between = (endTime - datebegin) / 1000.0;
        } catch (Exception e) {
            logger.error("获取时间差值异常：", e);
        }
        return between;
    }

    /**
     * 对时间操作，延迟或者推迟几个个小时
     *
     * @param hours 几个小时
     * @param d     要转化的时间
     * @return
     */
    public static Date addHours(int hours, Date d) {
        Calendar c1 = new GregorianCalendar();
        c1.setTime(d);
        c1.add(Calendar.HOUR, hours);
        return c1.getTime();
    }

    public static Date initKeyTime(Date d) {
        Calendar c1 = new GregorianCalendar();
        try {
            c1.setTime(d);
            if (DateUtils.getDaysMin(d) != 0 || DateUtils.getDaysSecond(d) != 0) {
                c1.set(Calendar.MINUTE, 00);
                c1.set(Calendar.SECOND, 00);
                c1.set(Calendar.MILLISECOND, 000);
            }
        } catch (Exception e) {
            logger.error("initKeyTime出现异常：", e);
            return d;
        }
        return c1.getTime();
    }

    /**
     * 获取两个时间之间的差值，这里返回的是分钟
     *
     * @param begindate
     * @param endTimes
     * @return
     */
    public static long getTimeSpanMinutes(Date begindate, Date endTimes) {
        long minute1 = 0;
        try {
            long datebegin = begindate.getTime();
            long endTime = endTimes.getTime();
            double between = (endTime - datebegin) / 1000.0;
            minute1 = (long) (between / 60.0);

        } catch (Exception e) {
            logger.error("获取时间差值出现异常：", e);
        }
        return minute1;
    }

    /**
     * 获取两个时间之间的差值，这里返回的是分钟
     *
     * @param begindate
     * @param endDate
     * @return
     */
    public static long getTimeSpanMinutes(Date begindate, String endDate) {
        long minute1 = 0;
        try {
            Date endTimes = getDateFormat().parse(endDate);
            long datebegin = begindate.getTime();
            long endTime = endTimes.getTime();
            double between = (endTime - datebegin) / 1000.0;
            minute1 = (long) (between / 60.0);

        } catch (Exception e) {
            logger.error("获取两个时间差值异常：", e);
        }
        return minute1;
    }

    /**
     * 比较两个日期字符串格式的大小 条件：t1 < t2 返回值：-1 条件：t1 = t2 返回值：0 条件：t1 > t2 返回值：1
     *
     * @param t1
     * @param t2
     * @return
     */
    public static int timeCompare(String t1, String t2) {
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(getDateFormat().parse(t1));
            c2.setTime(getDateFormat().parse(t2));
        } catch (Exception e) {
            logger.error("比较日期大小出现异常：", e);
        }
        int result = c1.compareTo(c2);
        return result;
    }

    /**
     * 比较两个日期字符串格式的大小 * 比较两个日期字符串格式的大小 条件：t1 < t2 返回值：-1 条件：t1 = t2 返回值：0 条件：t1
     * > t2 返回值：1
     *
     * @param t1
     * @param t2
     * @return
     */
    public static boolean timeCompareStr(String t1, String t2) {
        boolean flag = false;
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        try {
            c1.setTime(getDateFormat().parse(t1));
            c2.setTime(getDateFormat().parse(t2));
        } catch (Exception e) {
            logger.error("比较日期格式出现异常：", e);
        }
        int result = c1.compareTo(c2);
        if (result > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * @param yy
     * @param mm
     * @param dd
     * @param hh
     * @param min
     * @param ss
     * @return 根据年月日，小时生成一个新的Date对象
     */
    public static Date createDates(int yy, int mm, int dd, int hh, int min,
                                   int ss) {
        Calendar c1 = Calendar.getInstance();
        c1.set(Calendar.YEAR, yy);
        c1.set(Calendar.MONTH, mm);
        c1.set(Calendar.DAY_OF_MONTH, dd);
        c1.set(Calendar.HOUR_OF_DAY, hh);
        c1.set(Calendar.MINUTE, min);
        c1.set(Calendar.SECOND, ss);
        return c1.getTime();
    }

    /**
     * 两个日期格式进行比较 条件：d1 < d2 返回值：负数 条件：d1 = d2 返回值：0 条件：d1 > d2 返回值：正数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static long timeCompare(Date d1, Date d2) {
        long time = 0;
        try {
            time = d1.getTime() - d2.getTime();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return time;
    }

    /**
     * 获取两个时间的小时差
     *
     * @param begindate
     * @param endDate
     * @return
     */
    public static long getBetweentHours(Date begindate, Date endDate) {
        long datebegin = begindate.getTime();
        long endTime = endDate.getTime();
        long between = (endTime - datebegin) / 1000;
        long hours = between / 3600;
        return hours;
    }

    /**
     * 两个日期格式进行比较 条件：d1 < d2 返回值：负数 条件：d1 = d2 返回值：0 条件：d1 > d2 返回值：正数
     *
     * @param d1
     * @param d2
     * @return
     */
    public static boolean timeCompareDate(Date d1, String d2) {
        boolean flag = false;
        long time = 0;
        try {
            Date dd = getDateFormat().parse(d2);
            time = d1.getTime() - dd.getTime();
        } catch (Exception e) {
            logger.error("日期格式比较异常：", e);
        }
        if (time <= 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 判断第一个时间是否大于等于第二个时间
     *
     * @param d2
     * @param d1
     * @return
     */
    public static boolean timeCompare(String d2, Date d1) {
        boolean flag = false;
        long time = 0;
        try {
            Date dd = getDateFormat().parse(d2);
            time = d1.getTime() - dd.getTime();
        } catch (Exception e) {
            logger.error("判断第一个时间是否大于第二个时间异常：", e);
        }
        if (time >= 0) {
            // 原来是大于等于，后来因为数据库和内存中一分钟数据重叠导致拉斜线问题
            flag = true;

        }
        return flag;
    }

    /**
     * 判断第一个时间是否大于等于第二个时间
     *
     * @param d2
     * @param d1
     * @return
     */
    public static boolean timeCompareBefore(String d2, Date d1) {
        boolean flag = false;
        long time = 0;
        try {
            Date dd = getDateFormat().parse(d2);
            time = d1.getTime() - dd.getTime();
        } catch (Exception e) {
            logger.error("判断第一个时间是否大于等于第二个时间异常：", e);
        }
        // 原来是大于等于，后来因为数据库和内存中一分钟数据重叠导致拉斜线问题
        if (time > 0) {
            flag = true;
        }
        return flag;
    }

    /**
     * 将字符串日期yyyy-MM-dd HH:mm:ss转换为java.util.Date
     *
     * @param dateStr
     */
    public final static Date string2Date(String dateStr) {
        return getString2Date(dateStr);
    }

    /**
     * 将字符串日期yyyy-MM-dd HH:mm:ss转换为java.util.Date
     *
     * @param strDate
     * @return
     */
    public final static Date getString2Date(String strDate) {
        Date date = null;
        if (strDate != null && !"".equals(strDate)) {
            try {
                date = getDateFormat().parse(strDate);
            } catch (ParseException e) {
                date = defaultTime();
                logger.error("字符串日期转换为Date异常：", e);
            }
        }
        return date;
    }

    /**
     * @param date
     * @param strFormatString
     * @return
     * @author WJ
     */
    public static String Date2String(Date date, String strFormatString) {
        SimpleDateFormat sdf = new SimpleDateFormat(strFormatString);
        return sdf.format(date);
    }

    /**
     * @author WJ
     * @see 获取本周开始日期，星期一
     */
    public static Date getWeekBeginDate() {
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) {
            dayOfWeek = 1;
        }
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }

        cal.add(Calendar.DAY_OF_YEAR, -(dayOfWeek - 1));
        return cal.getTime();
    }

    /**
     * 获取指定日期所在周的开始日期
     *
     * @param date
     * @return
     */
    public static Date getWeekBeginDate(Date date) throws Exception {
        int dayOfWeek = getDayOfWeek(date);
        if (dayOfWeek == 1) {
            return date;
        }

        return getAddDays(date, 0 - (dayOfWeek - 1));
    }

    /**
     * @author WJ
     * @see 获取本周结束日期，星期日
     */
    public static Date getWeekEndDate() {
        Calendar cal = Calendar.getInstance();
        int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (dayOfWeek < 0) {
            dayOfWeek = 1;
        }
        if (dayOfWeek == 0) {
            dayOfWeek = 7;
        }
        cal.add(Calendar.DATE, 7 - dayOfWeek);
        return cal.getTime();
    }

    public static Date getWeekEndDate(Date date) throws Exception {
        Date beginDateOfWeek = getWeekBeginDate(date);
        return getAddDays(beginDateOfWeek, 6);
    }

    /**
     * @return
     * @author WJ
     * 获取上周开始日期
     */
    public static Date getPreWeekBeginDate() {
        Date date = DateUtils.getWeekBeginDate();
        return new Date(date.getTime() - 7 * 24 * 60 * 60 * 1000);
    }

    /**
     * @return
     * @author WJ
     * 获取上周结束日期
     */
    public static Date getPreWeekEndDate() {
        Date date = DateUtils.getWeekEndDate();
        return new Date(date.getTime() - 7 * 24 * 60 * 60 * 1000);
    }

    /**
     * @return
     * @author WJ
     * @see 获取本月第一天
     */
    public static Date GetMonthBeginDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMinimum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * @return
     * @author WJ
     * @see 获取本月最后一天
     */
    public static Date GetMonthEndDate() {
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, cal.getActualMaximum(Calendar.DAY_OF_MONTH));
        return cal.getTime();
    }

    /**
     * @return
     * @author WJ
     * @see 获取上一个月第一天
     */
    public static Date GetPreMonthBeginDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMinimum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * @return
     * @author WJ
     * @see 获取上一个月最后一天
     */
    public static Date GetPreMonthEndDate() {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.MONTH, -1);
        c.set(Calendar.DAY_OF_MONTH, c.getActualMaximum(Calendar.DAY_OF_MONTH));
        return c.getTime();
    }

    /**
     * 日期转换,将字符串转换成Date类型
     *
     * @param dateStr
     * @return
     */
    public static Date convertStrToDate(String dateStr, String formatStr) {

        try {
            return new SimpleDateFormat(formatStr).parse(dateStr);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return new Date();
    }

    public static String DateToKey(Date t) {
        StringBuilder bulider = new StringBuilder();
        try {
            Calendar c1 = Calendar.getInstance();
            c1.setTime(t);
            int years = c1.get(Calendar.YEAR);
            int months = c1.get(Calendar.MONTH) + 1;

            int days = c1.get(Calendar.DAY_OF_MONTH);
            int hours = c1.get(Calendar.HOUR_OF_DAY);
            bulider.append(years);
            bulider.append("_");
            if (months < 10) {
                bulider.append("0");
            }
            bulider.append(months);
            bulider.append("_");
            bulider.append(days);
            bulider.append("_");
            bulider.append(hours);
        } catch (Exception e) {
            logger.error("DateToKey异常：", e);
        }
        return bulider.toString();
    }

    /**
     * 返回指定日期的星期几 1...7（星期一...星期日）
     *
     * @param date
     * @return
     * @throws ParseException
     */
    public static int getDayOfWeek(Date date) throws ParseException {

        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1;
        if (w < 0) {
            w = 1;
        }

        if (w == 0) {
            w = 7;
        }

        return w;

//		return get_week(date);
    }

    /**
     * 输入日期，返回星期几
     * hxk
     */
    public static int get_week(Date date) throws ParseException {
        SimpleDateFormat dateFm = new SimpleDateFormat("EEEE", Locale.SIMPLIFIED_CHINESE);
        String str = dateFm.format(date);
        if (str.equals("星期一")) {
            return 1;
        } else if (str.equals("星期二")) {
            return 2;
        } else if (str.equals("星期三")) {
            return 3;
        } else if (str.equals("星期四")) {
            return 4;
        } else if (str.equals("星期五")) {
            return 5;
        } else if (str.equals("星期六")) {
            return 6;
        } else if (str.equals("星期日")) {
            return 7;
        } else {
            return -1;
        }
    }

    public static long getTimespan(long beginTime) {
        return System.currentTimeMillis() - beginTime;
    }

    /**
     * 日期相差天数
     *
     * @param date1
     * @param date2
     * @return
     */
    public static int getDays(Date date1, Date date2) {
        long ms = 24 * 60 * 60 * 1000;
        long t = date1.getTime() - date2.getTime();

        // 时间差小于一天
        if (Math.abs(t) < ms) {
            return 0;
        }

        long d = t / ms;
        long s = (t % ms > 0 ? 1 : 0) * (d / Math.abs(d));

        return (int) (d + s);
    }
}
