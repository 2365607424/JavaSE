package com.weiqiang03.list.exer1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ListTest {
    public static void main(String[] args) {

        System.out.println("请输入学生的信息：");

        ArrayList list = new ArrayList();

        Scanner scanner = new Scanner(System.in);


        while (true){

            System.out.println("1.继续录入，0.结束录入");
            int i = scanner.nextInt();

            if (i == 0){
                break;
            }

            System.out.print("请输入学生姓名：");
            String name = scanner.next();
            System.out.print("请输入学生年龄：");
            int age = scanner.nextInt();

            Student student = new Student(name, age);

            list.add(student);

        }

        System.out.println("遍历学生信息：");

        for (Object s : list) {
            System.out.println(s);
        }

        scanner.close();

    }
}
