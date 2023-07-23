package com.woody.communication;


/**
 * 生产者(Productor)将产品交给店员(Clerk),而消费者(Customer)从店员初取走产品，店员一次只能持有固定数量的产品(比如：20)，如果
 * 生产者试图生产更多的产品，店员会叫生产者停一下，如果店中有空位放产品了再通知生产者继续生产；如果店中没有产品了，店员会告诉消费者
 * 等一下，如果店中有产品了再通知消费者来取走产品
 */

//店员
class Clerk{

    private int productNum = 0;//产品数量

    //增加产品数量的方法
    public synchronized void addProduct(){

        if (productNum >= 20){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            productNum++;
            System.out.println(Thread.currentThread().getName()+"生产了第"+productNum+"个产品！");
            notifyAll();
        }

    }

    //减少产品数量的方法
    public synchronized void minusProduct(){
        if (productNum <= 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println(Thread.currentThread().getName()+"消费了第"+productNum+"个产品！");
            productNum--;
            notifyAll();
        }
    }

}

//消费者
class Customer implements Runnable{

    private Clerk clerk;

    public Customer(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){
            System.out.println("消费者正在消费.....");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.minusProduct();

        }
    }
}

//生产者
class Productor implements Runnable{

    private Clerk clerk;

    public Productor(Clerk clerk){
        this.clerk = clerk;
    }

    @Override
    public void run() {
        while (true){

            System.out.println("生产者开始生产产品.....");

            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            clerk.addProduct();

        }
    }
}

public class ProductorCustomerTest {

    public static void main(String[] args) {

        Clerk clerk = new Clerk();
        Productor pro1 = new Productor(clerk);
        Customer cus1 = new Customer(clerk);

        Thread t1 = new Thread(pro1,"生产者1");
        Thread t2 = new Thread(cus1,"消费者1");
        Thread t3 = new Thread(cus1,"消费者2");

        t1.start();
        t2.start();
        t3.start();



    }

}
