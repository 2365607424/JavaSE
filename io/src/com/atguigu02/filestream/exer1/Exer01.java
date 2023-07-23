package com.atguigu02.filestream.exer1;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 实现图片加密操作。
 */
public class Exer01 {

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

            while ((len = fis.read(buffer)) != -1) {

                for(int i = 0;i < len;i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

                fos.write(buffer, 0, len);
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
            File file = new File("ASCII码表II_coey.jpg");
            File file1 = new File("ASCII码表II_coey1.jpg");

            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);


            byte[] buffer = new byte[1024];
            int len;

            while ((len = fis.read(buffer)) != -1){

                for(int i = 0;i < len;i++){
                    buffer[i] = (byte) (buffer[i] ^ 5);
                }

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
