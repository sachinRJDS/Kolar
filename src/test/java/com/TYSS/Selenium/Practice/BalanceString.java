package com.TYSS.Selenium.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Stack;

public class BalanceString {

    @Test
    public void BalanceString(){
        String bal="{}[(])]";
        System.out.println(test(bal));
    }

    public static boolean test(String s){
        Stack<Character> stack = new Stack();
        for(char ch : s.toCharArray()){
            if(ch=='{' || ch=='[' || ch=='('){
                stack.push(ch);
            }

            if(stack.isEmpty()){
                return false;
            }

            switch (ch){
                case '}':
                    if(stack.isEmpty() || stack.pop()!='{') {
                        return false;
                    }
                    break;
                case ']':
                    if(stack.pop()!='[') {
                        return false;
                    }
                    break;
                case ')':
                    if(stack.pop()!='(') {
                        return false;
                    }
                    break;
            }

        }
        return stack.isEmpty();
    }


}
