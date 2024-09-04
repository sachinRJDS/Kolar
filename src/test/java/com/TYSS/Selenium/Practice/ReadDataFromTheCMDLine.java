package com.TYSS.Selenium.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class ReadDataFromTheCMDLine {

//    public static void main(String[] args) {
//        System.out.println(args.length);
//
//        for(String arg:args){
//            System.out.println(arg);
//        }
//    }

    @Test
    public void ReadDataFromTheCMDLine() {
        WebDriver driver;
        String browser=System.getProperty("browser");
        String url=System.getProperty("url");

        if(browser.equalsIgnoreCase("chrome")){
             driver=  new ChromeDriver();
        } else if (browser.equalsIgnoreCase("firefox")) {
            driver=new FirefoxDriver();
        }else{
            driver=new EdgeDriver();
        }

        System.out.println(System.getProperty("browser"));
        System.out.println(System.getProperty("url"));
        System.out.println(System.getProperty("username"));
        System.out.println(System.getProperty("password"));

        driver.get(url);
        driver.close();
    }


//    @Test
//    public void ReadDataFromTheCMDLine2() {
//        System.out.println("welcome to MVN");
//    }
}
