package com.woody.notesafe;


/**
 * ClassName:WindowTest
 * Description:
 *      使用实现Runnable接口的方式，实现售票
 */
class SaleTicket implements Runnable{
    private int ticket = 100;
    @Override
    public void run() {

        while (true){

            if (ticket>0){

                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println(Thread.currentThread().getName()+"售票，票号为："+ (101-ticket));
                ticket--;

            }else {
                break;
            }

        }

    }

}


public class WindowTest {
    public static void main(String[] args) {

        SaleTicket saleTicket = new SaleTicket();
        Thread thread1 = new Thread(saleTicket);
        Thread thread2 = new Thread(saleTicket);
        Thread thread3 = new Thread(saleTicket);

        thread1.setName("窗口1");
        thread2.setName("窗口2");
        thread3.setName("窗口3");

        thread1.start();
        thread2.start();
        thread3.start();

    }
}
