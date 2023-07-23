package com.weiqiang03.more;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;


public class GenericTest1 {
    @Test
    public void test1(){

        List<?> list = null;
        List<Object> list1 = null;
        List<String> list2 = null;

        list = list1;
        list = list2;

        method(list1);
        method(list2);

    }

    public void method(List<?> list){

    }
    @Test
    public void test2(){

        List<?> list = null;
        List<String> list2 = new ArrayList<>();

        list2.add("AA");

        list = list2;

        //读取数据(以集合为例说明)
        Object o = list.get(0);
        System.out.println(o);
        method(list2);

        //写入数据(以集合为例说明)
        //写入数据,操作失败
//        list.add("AA");
        //特例：可以将null写入集合中。
        list.add(null);
    }
}
