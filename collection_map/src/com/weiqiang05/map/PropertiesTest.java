package com.weiqiang05.map;

import org.junit.Test;

import java.io.*;
import java.util.Properties;

public class PropertiesTest {

    @Test
    public void test1() throws IOException {//注意：因为设计到流的操作，为了确保流能关闭，建议使用try-catch-finally

        //方式1：数据和代码耦合度高：如果修改的话，需要重写的编译代码、打包发布。繁琐
        //数据
//        String name = "Tom";
//        String password = "cwq123";

        //代码：用于操作name，password
        //......


        //方式2：将数据封装到具体的配置文件中，在程序中读取配置文件中的信息。实现了
        //数据和代码的解耦；由于我们没有修改代码，就省去了重新编译和打包的过程。
        File file = new File("info.properties");//注意：要提前创建好
//        System.out.println(file.getAbsolutePath());

        Properties properties = new Properties();
        FileInputStream fileInputStream = new FileInputStream(file);
        properties.load(fileInputStream);//加载流中的文件中的数据

        //读取数据
        String name = properties.getProperty("name");
        String password = properties.getProperty("password");

        System.out.println(name+":"+password);

        fileInputStream.close();
    }

}
