package com.TYSS.Selenium.Practice;

public class ReverseInSamePosition {
    public static void main(String[] args) {
        String s="i am sachin";
        String[]str=s.split(" ");
        for(String str1:str){
            int count=str1.length();
            for(int i=count-1;i>=0;i--){
                System.out.print(str1.charAt(i));
            }
            System.out.print(" ");
        }
    }
}
