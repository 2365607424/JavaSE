package com.weiqiang05.map.exer02;

import java.util.*;

public class Exer02 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
         Map map = CityMap.model;

        //1.获取Map，并遍历map中的key
        Set keySet = map.keySet();
        Iterator iterator = keySet.iterator();
        while (iterator.hasNext()){
            System.out.print(iterator.next()+"\t\t");
        }
        String[] cities;
        System.out.println();
        while (true){
            System.out.println("请选择你所在的省份：");
            String city = scanner.next();

            cities = (String[]) map.get(city);
            if (cities == null || cities.length == 0){
                System.out.println("你输入的省份有误，请重新输入");
            }else {
                break;
            }

        }

        for (int i = 0; i < cities.length; i++) {
            System.out.print(cities[i] + "\t\t");
        }
        System.out.println();
        l:while (true){
            System.out.println("请选择你所在的城市：");
            String city =scanner.next();
            //方式1：
//            for (int i = 0; i < cities.length; i++) {
//                if (city.equals(cities[i])){
//                    System.out.println("信息登记完毕");
//                    break l;
//                }
//            }
//
//            System.out.println("输入的城市有误，请重新输入");

            //方式2：
            if (containsCity(cities,city)) {
                System.out.println("信息登记完毕");
                break ;
            }

            System.out.println("输入的城市有误，请重新输入");

        }



        scanner.close();
    }

    //第二种方式处理城市是否存在
    public static boolean containsCity(String[] cities,String city){
        for (int i = 0; i < cities.length; i++) {
            if (city.equals(cities[i])){
                return true;
            }
        }
        return false;
    }

}


class CityMap{

    public static Map model = new HashMap();

    static {
        model.put("北京", new String[] {"北京"});
        model.put("辽宁", new String[] {"沈阳","盘锦","铁岭","丹东","大连","锦州","营口"});
        model.put("吉林", new String[] {"长春","延边","吉林","白山","白城","四平","松原"});
        model.put("河北", new String[] {"承德","沧州","邯郸","邢台","唐山","保定","石家庄"});
        model.put("河南", new String[] {"郑州","许昌","开封","洛阳","商丘","南阳","新乡"});
        model.put("山东", new String[] {"济南","青岛","日照","临沂","泰安","聊城","德州"});
    }

}