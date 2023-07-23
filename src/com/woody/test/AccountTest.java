package com.woody.test;


class Customer extends Thread{
    Account account;

    public Customer(Account acct){
        this.account = acct;
    }

    @Override
    public void run() {

            for (int i = 0; i < 3; i++) {

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                account.deposit(1000);

            }

    }
}

class Account{
    private double balance;//余额

    public synchronized void deposit(double amt){
        if (amt >0){
            balance += amt;
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "存钱1000元，余额为："+ balance);
    }

}


public class AccountTest {

    public static void main(String[] args) {
        Account acct = new Account();

        Customer customer1 = new Customer(acct);
        Customer customer2 = new Customer(acct);

        customer1.setName("客户1");
        customer2.setName("客户2");

        customer2.start();
        customer1.start();

    }

}
