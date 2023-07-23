package com.weiqiang.stringbufferbuilder;

public class StringBufferBuilderTest {

    public static void main(String[] args) {

        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("abc").append("123").append("def"); //方法链的调用
//        stringBuilder.reverse();
        stringBuilder.insert(2,1);
        System.out.println(stringBuilder);

        long timeMillis = System.currentTimeMillis();
    }

}
