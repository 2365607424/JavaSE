package com.weiqiang05.map.exer01;

import java.util.*;

public class Exer01 {

    public static void main(String[] args) {

        HashMap hashMap = new HashMap();

        ArrayList list = new ArrayList();

        String singer = "周杰伦";
        list.add("夜曲");
        list.add("青花瓷");
        list.add("晴天");
        list.add("稻香");
        hashMap.put(singer,list);

        ArrayList list1 = new ArrayList();

        String singer1 = "林俊杰";
        list1.add("江南");
        list1.add("曹操");
        list1.add("小酒窝");
        list1.add("可惜没如果");
        hashMap.put(singer1,list1);

        Set entrySet = hashMap.entrySet();

        Iterator iterator = entrySet.iterator();
        while (iterator.hasNext()){
            Map.Entry entry = (Map.Entry) iterator.next();
            System.out.println("歌手"+entry.getKey());
            System.out.println("歌曲"+entry.getValue());
        }

    }

}
