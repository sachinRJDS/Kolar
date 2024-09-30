package com.TYSS.Selenium.Practice;

public class aabbcccd {
    public static void main(String[] args) {
        String s="aabbbccaaaaabb";
        String[]str=s.split("");
        String ch=str[0];
        int count=1;
        String str1="";
        for(int i=1;i<str.length;i++){
            if(ch.equals(str[i])){
                count++;
            }
            if(!ch.equals(str[i])){
                str1+=ch+count;
                count=1;
                ch=str[i];
            }
        }
        str1+=ch+count;
        System.out.println(str1);

    }

}
