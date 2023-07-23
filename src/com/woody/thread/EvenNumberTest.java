package com.woody.thread;



// 1.创建一个继承Thread类的子类
class PrintNumber extends Thread{

    public PrintNumber(){

    }

    public PrintNumber(String name){
        super(name);
    }

    // 2.重写run()方法 ----> 将次线程要执行的操作，声明在此方法体中
    public void run(){

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+ Thread.currentThread().getPriority()+":"+i);
            }

            if (i % 20 == 0){
                Thread.yield();
            }
        }

    }

}

public class EvenNumberTest {

    public static void main(String[] args) {
        // 3.创建当前Thread的子类的对象
        PrintNumber p = new PrintNumber("");
        p.setPriority(Thread.MIN_PRIORITY);
        // 4.通过对象调用start();
        p.start();


        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);


        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName()+":"+ Thread.currentThread().getPriority()+":"+i);
            if (i == 20){
//                try {
//                    p.join();
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
            }
        }

//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 1; i <= 100; i++) {
//                    if (i % 2 == 0){
//                        System.out.println(Thread.currentThread().getName()+":"+i);
//                    }
//                }
//            }
//        }.start();
//
//        new Thread(){
//            @Override
//            public void run() {
//                for (int i = 1; i <= 100; i++) {
//                    if (i % 2 != 0){
//                        System.out.println(Thread.currentThread().getName()+":"+i);
//                    }
//                }
//            }
//        }.start();

    }

}
