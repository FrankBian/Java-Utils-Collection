package com.gansuer.common.util;

import java.time.*;
import java.util.Date;

/**
 * TODO: Keeping completing
 * Created by Frank on 6/28/16.
 */
public class TimeUtils {

    /**
     * 获取指定日期所在的周的周日的日期
     *
     * @param date
     * @return
     */
    public static LocalDateTime getWeekendFromDate(Date date) {
        Instant instant = date.toInstant();
        LocalDateTime res = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        res = res.plusDays(DayOfWeek.SUNDAY.getValue() - res
                .getDayOfWeek().getValue());
        return res;
    }


}
