package com.weiqiang01.use.exer01;

import org.junit.Test;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class EmployeeTest {
    /**
     * 使Employee 实现 Comparable 接口，并按 name 排序
     */
    @Test
    public void test1(){

        TreeSet<Employee> set = new TreeSet<>();

        Employee e1 = new Employee("cwq",22,new MyDate(2002,7,11));
        Employee e2 = new Employee("lzz",15,new MyDate(2009,8,15));
        Employee e3 = new Employee("lqf",26,new MyDate(1998,9,6));
        Employee e4 = new Employee("hqh",28,new MyDate(1996,2,25));
        Employee e5 = new Employee("sry",20,new MyDate(2004,4,21));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }

    }

    /**
     * 创建 TreeSet 时传入 Comparator对象，按生日日期的先后排序。
     */
    @Test
    public void test2(){

        Comparator<Employee> comparator = new Comparator<Employee>() {
            @Override
            public int compare(Employee o1, Employee o2) {

                //错误的写法
//                return o1.getBirthday().toString().compareTo(o2.getBirthday().toString());

                //正确的写法1
//                int yearDistince = o1.getBirthday().getYear() - o2.getBirthday().getYear();
//                if (yearDistince != 0){
//                    return yearDistince;
//                }
//                int monthDistince = o1.getBirthday().getMonth() - o2.getBirthday().getMonth();
//                if (monthDistince != 0){
//                    return monthDistince;
//                }
//
//                return o1.getBirthday().getDay() - o2.getBirthday().getDay();

                //正确的写法2
                //在MyDate中写Comparable
                return o1.getBirthday().compareTo(o2.getBirthday());
            }
        };

        TreeSet<Employee> set = new TreeSet<>(comparator);
        Employee e1 = new Employee("cwq",22,new MyDate(2002,7,11));
        Employee e2 = new Employee("lzz",15,new MyDate(2002,8,15));
        Employee e3 = new Employee("lqf",26,new MyDate(1998,9,6));
        Employee e4 = new Employee("hqh",28,new MyDate(1996,2,25));
        Employee e5 = new Employee("sry",20,new MyDate(2004,4,21));

        set.add(e1);
        set.add(e2);
        set.add(e3);
        set.add(e4);
        set.add(e5);

        Iterator<Employee> iterator = set.iterator();
        while (iterator.hasNext()){
            Employee next = iterator.next();
            System.out.println(next);
        }
    }

}
