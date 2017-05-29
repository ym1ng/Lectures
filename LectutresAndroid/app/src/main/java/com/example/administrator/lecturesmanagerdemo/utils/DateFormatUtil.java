package com.example.administrator.lecturesmanagerdemo.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/**
 * Created by Administrator on 2017/4/22.
 */

public class DateFormatUtil {
    /**
     * date类型进行格式化输出
     * @param date
     * @return
     */
    public static String dateFormat(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateString = formatter.format(date);
        return dateString;
    }

    /**
     * 将"2015-08-31 21:08:06"型字符串转化为Date
     * @param str
     * @return
     * @throws ParseException
     */
    public static Date StringToDate(String str) throws ParseException {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = (Date) formatter.parse(str);
        return date;
    }

    /**
     * 将CST时间类型字符串进行格式化输出
     * @param str
     * @return
     * @throws ParseException
     */
    public static String CSTFormat(String str) throws ParseException{
        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy", Locale.US);
        Date date = (Date) formatter.parse(str);
        return dateFormat(date);
    }


    /**
     * 将long类型转化为Date
     * @param str
     * @return
     * @throws ParseException
     */
    public static String LongToDate(long str) {
        Date dt=new Date(str);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sdf.setTimeZone(TimeZone.getTimeZone("GMT+8"));
        return sdf.format(dt);
    }
}
