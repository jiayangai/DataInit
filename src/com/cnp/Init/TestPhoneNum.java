package com.cnp.Init;


import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestPhoneNum{

        
        public static void main(String args[]) {
            
            Scanner sc = new Scanner(System.in);
for(;;){
           System.out.println("请输入：");

            String str =sc.nextLine();
            String pattern = "(13\\d|14[57]|15[^4,\\D]|17[678]|18\\d)\\d{8}|170[059]\\d{7}";

            Pattern r = Pattern.compile(pattern);
            Matcher m = r.matcher(str);
            System.out.println(m.matches());
        }

        }
}
