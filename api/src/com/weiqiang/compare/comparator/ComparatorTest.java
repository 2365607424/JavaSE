package com.weiqiang.compare.comparator;

import com.weiqiang.compare.Product;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorTest {

    @Test
    public void test1(){
        Product[] arr = new Product[5];
        arr[0] = new Product("java",65);
        arr[1] = new Product("python",85);
        arr[2] = new Product("c#",99);
        arr[3] = new Product("c++",45);
        arr[4] = new Product("javaBean",95);

        //创建一个实现了Comparator接口的实现类的对象
        Comparator comparator = new Comparator() {

            //如果判断两个对象o1，o2的大小，其标准就是此方法的方法体要编写的逻辑。
            //排序：从 低到高
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Product && o2 instanceof Product){
                    Product p1 = (Product) o1;
                    Product p2 = (Product) o2;

                    return Double.compare(p1.getPrice(),p2.getPrice());

                }
                throw new RuntimeException("类型不匹配");
            }
        };
        //创建一个实现了Comparator接口的实现类的对象
        Comparator comparator1 = new Comparator() {

            //如果判断两个对象o1，o2的大小，其标准就是此方法的方法体要编写的逻辑。
            //排序：从 低到高
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Product && o2 instanceof Product){
                    Product p1 = (Product) o1;
                    Product p2 = (Product) o2;

                    return p1.getName().compareTo(p2.getName());

                }
                throw new RuntimeException("类型不匹配");
            }
        };

        Arrays.sort(arr,comparator1);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }

    }

}
