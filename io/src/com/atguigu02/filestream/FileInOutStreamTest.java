package com.atguigu02.filestream;

import org.junit.Test;

import java.io.*;

public class FileInOutStreamTest {

    @Test
    public void test() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("ASCII码表II.jpg");
            File file1 = new File("ASCII码表II_coey.jpg");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);


            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            System.out.println("复制成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    @Test
    public void test1() {

        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            File file = new File("hello.txt");
            File file1 = new File("hello_copy1.txt");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);


            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1){
                fos.write(buffer,0,len);
            }

            System.out.println("复制成功");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
