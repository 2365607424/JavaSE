package com.weiqiang01.use.exer01;

public class MyDate implements Comparable<MyDate>{

    private Integer year;
    private Integer month;
    private Integer day;

    public MyDate() {
    }

    public MyDate(Integer year, Integer month, Integer day) {
        this.year = year;
        this.month = month;
        this.day = day;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public Integer getMonth() {
        return month;
    }

    public void setMonth(Integer month) {
        this.month = month;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    @Override
    public String toString() {
        return year + "年" + month + "月" + day + "日";
    }

    @Override
    public int compareTo(MyDate o) {
        int yearDistince = this.year - o.year;
        if (yearDistince != 0){
            return yearDistince;
        }
        int monthDistince = this.month - o.month;
        if (monthDistince != 0){
            return monthDistince;
        }

        return this.day - o.day;
    }
}
