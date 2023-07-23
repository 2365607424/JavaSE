package com.weiqiang05.map;

import org.junit.Test;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeMap;

public class TreeMapTest {

    @Test
    public void test1() {

        TreeMap treeMap = new TreeMap();

        treeMap.put("CC", 89);
        treeMap.put("BB", 78);
        treeMap.put("JJ", 65);
        treeMap.put("MM", 78);

        Set entrySet = treeMap.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }

    }

    @Test
    public void test2(){

        TreeMap treeMap = new TreeMap();

        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",43);
        User u3 = new User("Rose",13);
        User u4 = new User("Jack",23);
        User u5 = new User("Tony",33);

        treeMap.put(u1,78);
        treeMap.put(u2,76);
        treeMap.put(u3,88);
        treeMap.put(u4,45);
        treeMap.put(u5,99);

//        Set entrySet = treeMap.entrySet();
//        for (Object entry : entrySet) {
//            System.out.println(entry);
//        }

        System.out.println(treeMap.containsKey(new User("Maria", 23)));


    }


    @Test
    public void test3(){

        Comparator comparator = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {

                if (o1 instanceof User && o2 instanceof User){
                    User u1 = (User) o1;
                    User u2 = (User) o2;

                    int value = u1.getName().compareTo(u2.getName());
                    if (value != 0){
                        return value;
                    }
                    return u1.getAge() - u2.getAge();

                }
                throw new RuntimeException("类型不匹配");

            }
        };
        TreeMap treeMap = new TreeMap(comparator);

        User u1 = new User("Tom",23);
        User u2 = new User("Jerry",43);
        User u3 = new User("Rose",13);
        User u4 = new User("Jack",23);
        User u5 = new User("Tony",33);

        treeMap.put(u1,78);
        treeMap.put(u2,76);
        treeMap.put(u3,88);
        treeMap.put(u4,45);
        treeMap.put(u5,99);

        Set entrySet = treeMap.entrySet();
        for (Object entry : entrySet) {
            System.out.println(entry);
        }



    }




}
