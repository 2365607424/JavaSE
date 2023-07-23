package com.weiqiang02.iterator;

import com.weiqiang01.collection.Person;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class iteratorTest {

    @Test
    public void test1(){
        Collection collection = new ArrayList();

        //add()
        collection.add("AA");
        collection.add("AA");
        Person p1 = new Person("tom",12);
        collection.add(p1);
        collection.add(128);//自动装箱
        collection.add(new String("陈伟强"));

        //获取迭代器对象
        Iterator iterator = collection.iterator();

//        //方式1:
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//        System.out.println(iterator.next());
//
//        System.out.println(iterator.next());//如果超出了集合中元素的个数，会报NoSuchElementException异常

//        //方式2:
//        for (int i = 0; i < collection.size(); i++) {
//            System.out.println(iterator.next());
//        }


        //方式3:推荐
        while (iterator.hasNext()){//判断是否还有元素可迭代
            System.out.println(iterator.next());
        }

    }


    @Test
    public void test2(){
        Collection collection = new ArrayList();

        //add()
        collection.add("AA");
        collection.add("AA");
        Person p1 = new Person("tom",12);
        collection.add(p1);
        collection.add(128);//自动装箱
        collection.add(new String("陈伟强"));

//        //方式1：错误的遍历
//        Iterator iterator = collection.iterator();
//
//        while (iterator.next() != null){ //调用一次iterator.next()指针就下移一次
//            System.out.println(iterator.next());
//        }

//        //方式2：错误的遍历
//        while (collection.iterator().hasNext()){ //不停创建新的迭代器对象，指针一直在第一个位置
//            System.out.println(collection.iterator().next());
//        }


        for (Object col : collection) {
            System.out.println(col);
        }

    }

}
