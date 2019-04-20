package com.example.wedding.util;

import java.util.Calendar;
import java.util.Date;

/**
 * @author

 */
public class ToolUtil {
    /**
     * 计算两个日期间天数
     *
     * @param nowDate    当前日期
     * @param futureDate 未来日期
     * @return
     */
    public static int differentDays(Date nowDate, Date futureDate) {
        Calendar calendar1 = Calendar.getInstance();
        calendar1.setTime(nowDate);

        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(futureDate);
        int day1 = calendar1.get(Calendar.DAY_OF_YEAR);
        int day2 = calendar2.get(Calendar.DAY_OF_YEAR);

        int year1 = calendar1.get(Calendar.YEAR);
        int year2 = calendar2.get(Calendar.YEAR);
        if (year1 != year2) {//同一年
            int timeDistance = 0;
            for (int i = year1; i < year2; i++) {
                if (i % 4 == 0 && i % 100 != 0 || i % 400 == 0) {//闰年    
                    timeDistance += 366;
                } else {//不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2 - day1);
        } else {//不同年
            return day2 - day1;
        }
    }
}
