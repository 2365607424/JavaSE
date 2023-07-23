package com.weiqiang04.set.exer1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Exer01 {

    public static void main(String[] args) {

        List list = new ArrayList();

        list.add(45);
        list.add(45);
        list.add(45);
        list.add(33);
        list.add(33);
        list.add(33);
        list.add(99);
        list.add(99);
        list.add(99);

        List duplicateList = duplicateList(list);
        System.out.println(duplicateList);

    }

    public static List duplicateList(List list){
        HashSet set = new HashSet(list);
        List list1 = new ArrayList(set);
        return list1;
    }

}
