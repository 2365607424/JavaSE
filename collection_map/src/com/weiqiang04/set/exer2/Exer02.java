package com.weiqiang04.set.exer2;

import java.util.HashSet;
import java.util.Iterator;

public class Exer02 {

    public static void main(String[] args) {

        HashSet set = new HashSet();

        while (set.size()<10){
            int random = (int)(Math.random()*(20-1+1)+1);
            set.add(random);
        }


        Iterator iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }


    }

}
