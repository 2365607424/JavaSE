package com.weiqiang06.collections;

import java.util.ArrayList;
import java.util.Collections;

public class PokerTest {

    public static void main(String[] args) {


        //1.创建一副扑克牌
        String[] num = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        String[] color = {"方片♦","梅花♣","红桃♥","黑桃♠"};
        ArrayList poker = new ArrayList();

        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < num.length; j++) {
                poker.add(color[i]+" "+num[j]);
            }
        }

        poker.add("大王");
        poker.add("小王");

        //洗牌
        Collections.shuffle(poker);

        //创建3个人和一个底牌
        ArrayList cwq = new ArrayList();
        ArrayList lqf = new ArrayList();
        ArrayList lzz = new ArrayList();
        ArrayList lastCards = new ArrayList();

        //发牌
        for (int i = 0; i < poker.size(); i++) {

            if (i >= poker.size()-3){
                lastCards.add(poker.get(i));
            }else if (i % 3 == 0){
                cwq.add(poker.get(i));
            }else if (i % 3 == 1){
                lqf.add(poker.get(i));
            }else if (i % 3 == 2){
                lzz.add(poker.get(i));
            }

        }

        //显示
        System.out.println("陈伟强：");
        System.out.println(cwq);
        System.out.println("刘庆峰：");
        System.out.println(lqf);
        System.out.println("赖泽智：");
        System.out.println(lzz);
        System.out.println("底牌：");
        System.out.println(lastCards);



    }

}
