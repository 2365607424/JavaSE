package com.woody.threadsafe;
/**
 * ClassName:WindowTest1
 * Description:
 *      使用继承Thread类的方式，实现售票。------>存在线程安全问题的
 *      使用同步方法解决上述卖票中的线程安全问题。
 */
class Window1 extends Thread{
    static int ticket = 100;
    static boolean isflag = true;
    @Override
    public void run() {
        while (isflag){

            show();

        }
    }

//    public synchronized void show(){ //此时同步监视器：this。此题目中的this：w1,w2,w3.扔然是线程不安全。
    public static synchronized void show(){ //此时同步监视器：当前类本身，即为Window1.class.是唯一的。
        if (ticket>0){

            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println(Thread.currentThread().getName()+"售票，票号为："+ (101-ticket));
            ticket--;

        }else {
            isflag = false;
        }
    }

}


public class WindowTest {
    public static void main(String[] args) {

        Window1 w1 = new Window1();
        Window1 w2 = new Window1();
        Window1 w3 = new Window1();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}
