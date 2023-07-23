package com.woody.threadsafe;
/**
 * ClassName:WindowTest1
 * Description:
 *      使用继承Thread类的方式，实现售票。------>存在线程安全问题的
 *      使用同步代码块解决上述卖票中的线程安全问题。
 */
class Window extends Thread{
    static int ticket = 100;
    static Object object = new Object();
    @Override
    public void run() {
        while (true){

//            synchronized (this) { //this：此时表示w1,w2,w3,不能保证锁的唯一性。
//            synchronized (object) {//object：使用static修饰以后，就能保证其唯一性。
            synchronized (Window.class) {//结构：Class clz = Window.class 是唯一的
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
}


public class WindowTest1 {
    public static void main(String[] args) {

        Window w1 = new Window();
        Window w2 = new Window();
        Window w3 = new Window();

        w1.setName("窗口1");
        w2.setName("窗口2");
        w3.setName("窗口3");

        w1.start();
        w2.start();
        w3.start();

    }
}
