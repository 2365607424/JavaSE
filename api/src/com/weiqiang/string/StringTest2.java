package com.weiqiang.string;

import java.util.Arrays;

public class StringTest2 {

    public String getMaxSameSubString(String str1){
        char[] chars = str1.toCharArray();
        Arrays.sort(chars);
        String s = new String(chars);
        return s;
    }

    public static void main(String[] args) {
        StringTest2 stringTest1 = new StringTest2();

        String str1 = "asgdyhelloajshd";

        String maxSameSubString = stringTest1.getMaxSameSubString(str1);

        System.out.println(maxSameSubString);
    }
}
