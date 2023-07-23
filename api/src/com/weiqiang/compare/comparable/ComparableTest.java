package com.weiqiang.compare.comparable;

import com.weiqiang.compare.Product;
import org.junit.Test;

import java.util.Arrays;

public class ComparableTest {

    @Test
    public void test(){
        String[] name = new String[]{"Cwq","Lqf","Lyn","Lzz","Scs","Ass"};

        Arrays.sort(name);

        for (int i = 0; i < name.length; i++) {
            System.out.println(name[i]);
        }

    }
    @Test
    public void test1(){

        Product[] arr = new Product[5];
        arr[0] = new Product("java",65);
        arr[1] = new Product("python",85);
        arr[2] = new Product("c#",99);
            arr[3] = new Product("c++",45);
        arr[4] = new Product("javaBean",95);

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
