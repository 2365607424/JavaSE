package com.woody.runnable;

//1.创建一个实现Runnable接口的类
class EvenNumberPrint implements Runnable{
    //2.重写run()方法 ----> 将次线程要执行的操作，声明在此方法体中
    @Override
    public void run() {
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

public class EvenNumberTest {

    public static void main(String[] args) {
        //3.创建当前实现类的对象
        EvenNumberPrint p = new EvenNumberPrint();
        //4.将此对象作为参数传递到Thread类的构造器中，创建Thread类的实例
        Thread t = new Thread(p);
        //5.Thread类的实例调用start();1.启动线程 2.调用当前线程的run()
        t.start();

        Thread t1 = new Thread(p);
        t1.start();


        for (int i = 1; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() + ":" + i);
        }


//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 100; i++) {
//                    if (i % 2 == 0){
//                        System.out.println(Thread.currentThread().getName()+":"+i);
//                    }
//                }
//            }
//        }).start();
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for (int i = 1; i <= 100; i++) {
//                    if (i % 2 != 0){
//                        System.out.println(Thread.currentThread().getName()+":"+i);
//                    }
//                }
//            }
//        }).start();

    }

}
