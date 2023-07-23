package com.weiqiang03.list.exer2;

import java.util.ArrayList;
import java.util.Collection;

public class ListTest {
    public static void main(String[] args) {

        ArrayList list = new ArrayList();

        for (int i = 0; i <30; i++) {
            list.add((char)(Math.random()*(122-97+1)+97)+"");
        }
        System.out.println(list);
        int a = listTest(list, "a");
        int b = listTest(list, "b");
        int c = listTest(list, "c");
        int x = listTest(list, "x");

        System.out.println("a:"+a);
        System.out.println("b:"+b);
        System.out.println("c:"+c);
        System.out.println("x:"+x);
    }

    public static int listTest(Collection list,String s){
        int count = 0;
        for (Object o : list) {
            if (s.equals(o)){
                count++;
            }
        }
        return count;
    }

}
