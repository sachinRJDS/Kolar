package com.TYSS.Selenium.Practice;

import org.json.simple.JSONObject;

import java.util.HashMap;
import java.util.Scanner;

public class ReadDatatFromJSON {

    public static void main(String[] args) {

        Scanner s=new Scanner(System.in);
        System.out.println("Enter the vlaue");
        String value=s.nextLine();
        StringBuilder builder=new StringBuilder(value);
        String expected= String.valueOf(builder.reverse());
        HashMap<Character,Integer>hash=new HashMap<>();
        for(int i=0;i<expected.length();i++){
            char ch=expected.charAt(i);
            if(hash.containsKey(ch)){
                hash.put(ch,hash.get(ch)+1);
            }else{
                hash.put(ch,1);
            }
        }
        System.out.println(hash);
    }
}
