package com.weiqiang.test;

import java.util.Scanner;

public class UserTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        User[] users = new User[3];
        users[0] = new User("Tom","8888");
        users[1] = new User("songhk","123");
        users[2] = new User("cwq","cwq123");

        System.out.println("库中的用户有：");
        for (int i = 0;i<users.length;i++){
            System.out.println(users[i]);
        }

        System.out.println("请输入用户名:");
        String username = scanner.next();
        System.out.println("请输入密码:");
        String password = scanner.next();

        boolean isFlag = true;

        for (int i = 0;i<users.length;i++){
            if (users[i].getName().equals(username)){
                isFlag = false;
                if (users[i].getPassword().equals(password)){
                    System.out.println("登录成功，"+username);
                    break;
                }else {
                    System.out.println("密码有误");
                }
                break;
            }
        }

        if (isFlag){
            System.out.println("没有该用户");
        }

        scanner.close();
    }
}
