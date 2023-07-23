package com.woody.singleton;



class Bank{
    private Bank(){}

    private static volatile Bank instance = null;

//    //实现线程安全的方式1
//    public static synchronized Bank getInstance(){ //同步监视器，默认为Bank.class
//        if (instance ==null){
//
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//
//            instance = new Bank();
//        }
//        return instance;
//    }

//    //实现线程安全的方式2
//    public static Bank getInstance(){ //同步监视器，默认为Bank.class
//        synchronized (Bank.class) {
//            if (instance ==null){
//
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//
//                instance = new Bank();
//            }
//            return instance;
//        }
//    }

    //实现线程安全的方式3:相对于方式1和方式2来讲，效率更高。为了避免出现指令重排，需要将instance声明为volatile
    public static Bank getInstance(){ //同步监视器，默认为Bank.class
        if (instance ==null) {
            synchronized (Bank.class) {
                if (instance ==null){

                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    instance = new Bank();
                }
            }
        }
        return instance;
    }
}

public class BankTest {

    static Bank b1 = null;
    static Bank b2 = null;

    public static void main(String[] args) {

        Thread t1 = new Thread(){
            @Override
            public void run() {
                b1 = Bank.getInstance();
            }
        };

        Thread t2 = new Thread(){
            @Override
            public void run() {
                b2 = Bank.getInstance();
            }
        };

        t1.start();
        t2.start();

        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(b1);
        System.out.println(b2);
        System.out.println(b2 == b1);
    }
}
