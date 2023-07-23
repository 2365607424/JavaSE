package com.weiqiang.string;

import com.sun.xml.internal.ws.developer.UsesJAXBContext;

public class StringTest {
    public int getSubStringCount(String str,String subStr){
        int count = 0;

        int index = str.indexOf(subStr);
        while (index >= 0){
            count++;

            index = str.indexOf(subStr,index + subStr.length());
        }

        return count;
    }

    public static void main(String[] args) {
        StringTest stringTest = new StringTest();
        String subStr = "ab";
        String str = "absdksajabasdjoabsdabsd";

        int subStringCount = stringTest.getSubStringCount(str, subStr);
        System.out.println(subStringCount);
    }

}
