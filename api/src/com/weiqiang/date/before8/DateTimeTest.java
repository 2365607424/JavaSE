package com.weiqiang.date.before8;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();//创建一个基于当前系统时间的Date的实例
        System.out.println(date.toString());

        long time = date.getTime();
        System.out.println(time);

        Date date1 = new Date(1683723567350L); //创建一个基于指定时间戳的Date的实例
        System.out.println(date1.toString());

        java.sql.Date date2 = new java.sql.Date(1683723567350L);
        System.out.println(date2.toString());

        System.out.println(date2.getTime());

        //用于日期时间的格式化和解析
        SimpleDateFormat sdf = new SimpleDateFormat();
        //格式化  日期----->字符串
        String strDate = sdf.format(date);
        System.out.println(strDate);

        //解析    字符串----->日期
        Date date3 = sdf.parse("23-5-10 下午10:16");
        System.out.println(date3);


        Calendar calendar = Calendar.getInstance();

        //get(int field)
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar.get(Calendar.DAY_OF_YEAR));

        //set(int field,xx)
        calendar.set(Calendar.DAY_OF_MONTH,9);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //add(int field,xx)
        calendar.add(Calendar.DAY_OF_MONTH,6);
        calendar.add(Calendar.DAY_OF_MONTH,-9);
        System.out.println(calendar.get(Calendar.DAY_OF_MONTH));

        //getTime():Calender -- > Date
        Date date4 = calendar.getTime();
        System.out.println(date4);

    }

    @Test
    public void test(){

    }
}
