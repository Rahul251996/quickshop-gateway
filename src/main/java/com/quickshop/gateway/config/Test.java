package com.quickshop.config;

import java.util.StringJoiner;

public class Test {

    public static void main(String[] args) {

        String s = "aaabbaacccc";

        //  Output = a3b2a2c4

        int count =1;
        StringJoiner output=new StringJoiner("");
        for(int i=1;i<s.length();i++)
        {
            char ch=s.charAt(i);
            if(s.charAt(i-1)==s.charAt(i)) {
                count++;
            }
         else {
                output.add(String.valueOf(s.charAt(i-1))).add(String.valueOf(count));
                count=1;
            }
        }
        output.add(String.valueOf(s.charAt(s.length() - 1))).add(String.valueOf(count));

        System.out.println(output.toString());
    }
}
