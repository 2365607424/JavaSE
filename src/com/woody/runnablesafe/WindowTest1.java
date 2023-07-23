package com.woody.runnablesafe;


/**
 * ClassName:WindowTest
 * Description:
 *      使用实现Runnable接口的方式，实现售票。------>存在线程安全问题的
 *      使用同步方法解决上述卖票中的线程安全问题。
 */
class SaleTicket1 implements Runnable{
    private int ticket = 100;
    boolean isFlag = true;
    @Override
    public void run() {

        while (isFlag){

                show();

        }

    }

    public synchronized void show(){//此时的同步监视器是：this。此题目中即为saleTicket1，是唯一的。
        if (ticket>0){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"售票，票号为："+ (101-ticket));
            ticket--;

        }else {
            isFlag = false;
        }
    }

}


public class WindowTest1 {
    public static void main(String[] args) {

        SaleTicket1 saleTicket1 = new SaleTicket1();
        Thread thread1 = new Thread(saleTicket1);
        Thread thread2 = new Thread(saleTicket1);
        Thread thread3 = new Thread(saleTicket1);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
