package com.weiqiang03.list;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListTest {

    @Test
    public void test1(){
        List list = new ArrayList();

        list.add("aa");
        list.add("bb");
        list.add(123);
        list.add(new Person("tom",12));

        System.out.println(list.toString());

        list.add(2,"cc");

        System.out.println(list);

        List list1 = Arrays.asList(1,2,3);

        list.addAll(1,list1);
//        list.add(1,list1);//将list1整体作为一个元素，插入索引1的位置

        System.out.println(list);

    }
    @Test
    public void test2(){
        List list = new ArrayList();

        list.add("aa");
        list.add("bb");
        list.add(123);
        list.add(2);
        list.add(new Person("tom",12));

        //删除索引2的元素
//        list.remove(2);
//        System.out.println(list);
//        System.out.println(list.get(2));

        //删除集合内的数据2
        list.remove(Integer.valueOf(2));
        System.out.println(list);

    }

}
