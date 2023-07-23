package com.atguigu03.reflectapply;

public class TestEnum {
    public static void main(String[] args) {
        Week spring = Week.FRIDAY;
        System.out.println(spring);
        Week[] values = Week.values();
        for (int i = 0; i < values.length; i++) {
            //ordinal()、name()
            System.out.println((values[i].ordinal()+1) + "->" + values[i].name());
        }
    }
}
