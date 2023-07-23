package com.weiqiang01.collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CollectionTest {

    @Test
    public void test(){
        Collection collection = new ArrayList();

        //add(Object obj)
        collection.add("aaa");
        collection.add(345);
        collection.add("陈伟强");
        collection.add(new Person("tom",23));

        System.out.println(collection);



        //addAll()
        Collection collection1 = new ArrayList();

        //add(Object obj)
        collection1.add("bbb");
        collection1.add(687);

        collection.addAll(collection1);


        System.out.println(collection);

    }

    /**
     * int size():获取当前集合中实际存储的元素个数
     * boolean isEmpty()：判断当前集合是否为空集合
     * boolean contains(Object obj)：判断当前集合中是否存在一个与obj对象equals返回true的元素
     * boolean containsAll(Collection coll)：判断coll集合中的元素是否在当前集合中都存在。即coll集合是否是当前集合的“子集”
     * boolean equals(Object obj)：判断当前集合与obj是否相等
     */
    @Test
    public void test1(){
        Collection collection = new ArrayList();

        //add()
        collection.add("AA");
        Person p1 = new Person("tom",12);
        collection.add(p1);
        collection.add(128);
        collection.add(new String("陈伟强"));
        //size()
        System.out.println(collection.size());

        //isEmpty()
        System.out.println(collection.isEmpty());

        //contains(Object obj)
        System.out.println(collection.contains("AA"));
        System.out.println(collection.contains(128));
        System.out.println(collection.contains(new Person("tom", 12)));

        //containsAll(Collection coll)
        Collection collection1 = new ArrayList();

        collection1.add("AA");
        collection.add(128);

        System.out.println(collection.containsAll(collection1));



        System.out.println(collection);

    }


    /**
     * void clear()：清空集合元素
     * boolean remove(Object obj) ：从当前集合中删除第一个找到的与obj对象equals返回true的元素。
     * boolean removeAll(Collection coll)：从当前集合中删除所有与coll集合中相同的元素。即this = this - this ∩ coll
     * boolean retainAll(Collection coll)：从当前集合中删除两个集合中不同的元素，使得当前集合仅保留与coll集合中的元素相同的元素，即当前集合中仅保留两个集合的交集，即this  = this ∩ coll；
     */
    @Test
    public void test2(){
        Collection collection = new ArrayList();

        //add()
        collection.add("AA");
        collection.add("AA");
        Person p1 = new Person("tom",12);
        collection.add(p1);
        collection.add(128);
        collection.add(new String("陈伟强"));

        System.out.println(collection);

//        collection.clear();//遍历，一个一个设为null
//        System.out.println(collection);
//        System.out.println(collection.size());//0

        //remove(Object obj)
        collection.remove(new Person("tom",12));
        collection.remove("AA");
        System.out.println(collection);

    }


    /**
     * Object[] toArray()：返回包含当前集合中所有元素的数组
     * hashCode()：获取集合对象的哈希值
     * iterator()：返回迭代器对象，用于集合遍历
     */
    @Test
    public void test3(){
        Collection collection = new ArrayList();

        //add()
        collection.add("AA");
        collection.add("AA");
        Person p1 = new Person("tom",12);
        collection.add(p1);
        collection.add(128);//自动装箱
        collection.add(new String("陈伟强"));

        //集合 --> 数组
        Object[] array = collection.toArray();
        System.out.println(Arrays.toString(array));

        //数组 ---> 集合
        List list = Arrays.asList(array);
        System.out.println(list);

        //hashCode()：获取集合对象的哈希值
        System.out.println(collection.hashCode());
    }

    @Test
    public void test4(){
        Integer[] arr = new Integer[]{1,2,3};
        List list = Arrays.asList(arr);
        System.out.println(list.size());
        System.out.println(list);

        int[] arr1 = new int[]{1,2,3};
        List list1 = Arrays.asList(arr1);
        System.out.println(list1.size());
        System.out.println(list1);

    }

}
