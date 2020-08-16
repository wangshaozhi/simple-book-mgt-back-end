package com.cqupt.bookserver.Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;

public class dateUtils {

    public static final SimpleDateFormat SHORT_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static Date getSystemTime() throws ParseException {
        return SHORT_DATE_FORMAT.parse(SHORT_DATE_FORMAT.format(System.currentTimeMillis()));
    }


    public static Date nextMonth() throws ParseException {
        Date date = new Date();
        //取到年份值
        int year = Integer.parseInt(new SimpleDateFormat("yyyy").format(date));
        //取到月份值
        int month = Integer.parseInt(new SimpleDateFormat("MM").format(date)) + 1;
        //取到天值
        int day = Integer.parseInt(new SimpleDateFormat("dd").format(date));
        //取到小时值
        int hour = Integer.parseInt(new SimpleDateFormat("HH").format(date));
        //取到分钟值
        int minute = Integer.parseInt(new SimpleDateFormat("mm").format(date));
        //取到秒值
        int second = Integer.parseInt(new SimpleDateFormat("ss").format(date));
        if (month == 0) {
            year -= 1;
            month = 12;
        } else if (day > 28) {
            if (month == 2) {
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    day = 29;
                } else {
                    day = 28;
                }
                ;
            } else if ((month == 4 || month == 6 || month == 9 || month == 11) && day == 31) {
                day = 30;
            }
        }
        String y = year + "";
        String m = "";
        String d = "";
        if (month < 10) {
            m = "0" + month;
        } else {
            m = month + "";
        }
        if (day < 10) {
            d = "0" + day;
        } else {
            d = day + "";
        }
        String hours = hour < 10 ? "0" + hour : "" + hour;
        String minutes = minute < 10 ? "0" + minute : "" + minute;
        String seconds = second < 10 ? "0" + second : "" + second;
        String result = y + "-" + m + "-" + d + " " + hours + ":" + minutes + ":" + seconds;
        return SHORT_DATE_FORMAT.parse(result);
    }
}

