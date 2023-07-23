package com.weiqiang.string;

public class StringTest1 {

    public String getMaxSameSubString(String str1, String str2){
        if ( str1 !=null && str2 !=null){
            String strMax = (str1.length() > str2.length())?str1:str2;
            String strMin = (str1.length() > str2.length())?str2:str1;

            int len = strMin.length();

            for (int i = 0 ; i < len ; i++){
                for (int x = 0, y = len-i; y <= len;x++, y++){
                    if (strMax.contains(strMin.substring(x,y))){
                        return strMin.substring(x,y);
                    }
                }
            }

        }
        return null;
    }

    public static void main(String[] args) {
        StringTest1 stringTest1 = new StringTest1();

        String str1 = "asgdyhelloajshd";
        String str2 = "aassgasdasdadhellosasdshd";

        String maxSameSubString = stringTest1.getMaxSameSubString(str1, str2);

        System.out.println(maxSameSubString);
    }
}
