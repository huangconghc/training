package jrx.data.report.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtil {

    public static final String DATE_FORMAT_YYYY = "yyyy";

    public static final String DATE_FORMAT_YYYYMM = "yyyyMM";

    public static final String DATE_FORMAT_YYYY_MM = "yyyy-MM";

    public static final String DATE_FORMAT_YYMMDD = "yyMMdd";

    public static final String DATE_FORMAT_YY_MM_DD = "yy-MM-dd";

    public static final String DATE_FORMAT_YYYYMMDD = "yyyyMMdd";

    public static final String DATE_FORMAT_YYYY_MM_DD = "yyyy-MM-dd";

    public static final String DATE_FORMAT_POINTYYYYMMDD = "yyyy.MM.dd";

    public static final String DATE_TIME_FORMAT_YYYY年MM月DD日 = "yyyy年MM月dd日";

    public static final String DATE_FORMAT_YYYYMMDDHHmm = "yyyyMMddHHmm";

    public static final String DATE_TIME_FORMAT_YYYYMMDD_HH_MI = "yyyyMMdd HH:mm";

    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI = "yyyy-MM-dd HH:mm";

    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISS = "yyyyMMddHHmmss";

    public static final String DATE_TIME_FORMAT_YYYY_MM_DD_HH_MI_SS = "yyyy-MM-dd HH:mm:ss";

    public static final String DATE_TIME_FORMAT_YYYYMMDDHHMISSSSS = "yyyyMMddHHmmssSSS";

    public static final String DATE_FORMAT_MMDDHHMI = "MM-dd HH:mm";


    /**
     * @param date
     * @Description获得年份
     * @MethodName getYear
     * @Return java.lang.Integer
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    public static Integer getYear(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.YEAR);
    }

    /**
     * @param date
     * @Description 获得月份
     * @MethodName getMonth
     * @Return java.lang.Integer
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    public static Integer getMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(Calendar.MONTH) + 1;
    }

    /**
     * @param format
     * @Description 指定格式时间
     * @MethodName getDateFormat
     * @Return java.lang.String
     * @Author xiaocongcong
     * @Date 2020/6/10
     */

    public static String getDateFormat(String format) {
        DateFormat df = new SimpleDateFormat(format);
        Calendar calendar = Calendar.getInstance();
        return df.format(calendar.getTime());
    }

}
