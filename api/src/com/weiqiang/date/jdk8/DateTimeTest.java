package com.weiqiang.date.jdk8;

import org.junit.Test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

public class DateTimeTest {


    /**
     * JDK8的api：LocalDate\ LocalTime \ LocalDateTime
     */
    @Test
    public void test(){

        //now():获取当前日期和时间对应的实例
        LocalDate localDate = LocalDate.now();
        LocalTime localTime = LocalTime.now();
        LocalDateTime localDateTime = LocalDateTime.now();

        System.out.println(localDate);
        System.out.println(localTime);
        System.out.println(localDateTime);


        //of();获取指定的日期、时间对应的实例
        LocalDate localDate1 = LocalDate.of(2021, 5, 23);
        LocalDateTime localDateTime1 = LocalDateTime.of(2023, 5, 5, 6, 6, 6);
        System.out.println(localDate1);
        System.out.println(localDateTime1);

        //getxxx()
        LocalDateTime localDateTime2 = LocalDateTime.now();
        System.out.println(localDateTime2.getDayOfMonth());

        //体现不可变性
        //withXxx()
        LocalDateTime localDateTime3 = localDateTime2.withDayOfMonth(15);
        System.out.println(localDateTime3);
        System.out.println(localDateTime2);

        System.out.println("========================");
        //plusXxx()
        LocalDateTime localDateTime4 = localDateTime2.plusDays(5);
        System.out.println(localDateTime2);
        System.out.println(localDateTime4);
    }

    /**
     * JDK8的api：Instant
     */
    @Test
    public void test1(){
        //now()
        Instant instant = Instant.now();
        System.out.println(instant);

        OffsetDateTime instant1 = instant.atOffset(ZoneOffset.ofHours(8));
        System.out.println(instant1);

        Instant instant2 = Instant.ofEpochMilli(1651123151235L);
        System.out.println(instant2);//2022-04-28T05:19:11.235Z

        long milli = instant.toEpochMilli();
        System.out.println(milli);

        System.out.println(new Date().getTime());
    }
    /**
     * JDK8的api：DateTimeFormatter
     */
    @Test
    public void test2(){
        //自定义的格式。如：ofPattern(“yyyy-MM-dd hh:mm:ss”)
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        //格式化：日期和时间--->字符串
        LocalDateTime localDateTime = LocalDateTime.now();
        String strDateTime = dateTimeFormatter.format(localDateTime);
        System.out.println(strDateTime);//2023-05-11 21:43:57

        //解析：字符串 --->日期和时间
        TemporalAccessor temporalAccessor = dateTimeFormatter.parse("2023-05-11 21:43:57");
        LocalDateTime localDateTime1 = LocalDateTime.from(temporalAccessor);
        System.out.println(localDateTime1);//2023-05-11T21:43:57

    }


    @Test
    public void test3(){
        Calendar calendar = Calendar.getInstance();
        calendar.set(2002,8,19);
        Date time = calendar.getTime();
        System.out.println(time);
        calendar.add(Calendar.DAY_OF_YEAR,100);
        Date time1 = calendar.getTime();
        System.out.println(time1);

    }

    @Test
    public void test4(){

        LocalDateTime localDateTime = LocalDateTime.of(2002,8,19,0,0);
        System.out.println(localDateTime);

        LocalDateTime localDateTime1 = localDateTime.plusDays(100);
        System.out.println(localDateTime1);

    }

}
