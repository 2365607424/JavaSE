package com.woody.communication;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 案例1：使用两个线程打印 1-100.线程1，线程2 交替打印
 */
class PrintNumber implements Runnable{

    private int number = 1;

    private ReentrantLock lock = new ReentrantLock();

    @Override
    public void run() {

        while (true){

            synchronized (this){

                this.notify();

                if (number <= 100){

                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    System.out.println(Thread.currentThread().getName()+":"+number);
                    number++;

                    try {
                        this.wait();//线程一旦执行此方法，就进入等待状态。同时，会释放对同步监视器的调用
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }else {
                    break;
                }
            }
        }
    }
}


public class PrintNumberTest {
    public static void main(String[] args) {

        PrintNumber printNumber = new PrintNumber();
        Thread t1 = new Thread(printNumber);
        Thread t2 = new Thread(printNumber);

        t1.setName("线程1");
        t2.setName("线程2");

        t1.start();
        t2.start();

    }
}
