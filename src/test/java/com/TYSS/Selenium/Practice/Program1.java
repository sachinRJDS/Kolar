package com.TYSS.Selenium.Practice;
import java.util.*;
public class Program1 {
        public static void main(String[] args) {

            String str="My name is Sachin";
            String[]split=str.split(" ");

            for(String s:split){
                StringBuilder builder=new StringBuilder(s);
                System.out.print(builder.reverse()+" ");
            }
        }
    }

