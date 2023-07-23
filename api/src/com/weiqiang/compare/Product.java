package com.weiqiang.compare;

/**
 * @author shkstart
 * @create 11:45
 */
public class Product implements Comparable{ //商品类

    private String name;//商品名称
    private double price;//价格

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Product() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

//    /**
//     * 当前的类需要实现Comparable中的抽象方法：compareTo(Object o)
//     * 在此方法中，指明如何判断当前类的对象的大小。比如：按照价格的高低进行大小的比较。
//     *
//     * 如果返回值是正数：当前对象大
//     * 如果返回值是负数：当前对象小
//     * 如果返回值是0：一样大
//     * @param o
//     * @return
//     */
//    @Override
//    public int compareTo(Object o) {
//        if (o == this){
//            return 0;
//        }
//
//        //判断是否是商品
//        if (o instanceof Product){
//            //强转为商品
//            Product p = (Product) o;
//
//            return Double.compare(this.price,p.price);
//        }
//
//        throw new RuntimeException("类型不匹配");
//
//
//    }


    /**
     * 比较的标准：先比价格，价格相同，进行名字的比较（从小到大）
     * @param o
     * @return
     */
    @Override
    public int compareTo(Object o) {
        if (o == this){
            return 0;
        }

        //判断是否是商品
        if (o instanceof Product){
            //强转为商品
            Product p = (Product) o;

            int value = Double.compare(this.price, p.price);

            if(value != 0){
                return -value;
            }

            return this.name.compareTo(p.name);
        }

        throw new RuntimeException("类型不匹配");


    }
}
