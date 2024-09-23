package com.TYSS.Selenium.Practice;

public class RhombusNumberpattern {

    public static void main(String[] args) {
        long n=9;
        for(long i=1,j=1;i<1000000000;i=(long)(i+ Math.pow(10, j++)))
        {
            System.out.println(" ".repeat((int) (n-j))+i*i);

        }
    }
}
