package com.TYSS.Selenium.Practice;

public class Program2 {
    public static void main(String[] args) {

        int[]arr={1,2,0,3,4,5,0,6,7};
        int count=0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                arr[count]=arr[i];
                count++;
            }
        }

        for(int i=count;i<arr.length;i++){
            arr[i]=0;
        }
        for(int a:arr){
            System.out.print(a+", ");
        }
    }
}
