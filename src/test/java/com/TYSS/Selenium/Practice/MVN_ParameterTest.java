package com.TYSS.Selenium.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class MVN_ParameterTest {

    @Test
    public void MVN_Parameter() throws InterruptedException, IOException {

        String path="./src/test/resources/commondata1.property";
        FileInputStream fid=new FileInputStream(path);
        Properties prop=new Properties();
        prop.load(fid);


        WebDriver driver;
        String browser=System.getProperty("browser",prop.getProperty("browser"));
        String url=System.getProperty("url",prop.getProperty("baseurl"));

        if(browser.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("chrome")) {
            driver=new ChromeDriver();
        }else{
            driver=new EdgeDriver();
        }
        driver.get(url);
        Thread.sleep(5000);
        driver.close();

    }
}
