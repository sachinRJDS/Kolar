package com.TYSS.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks {

    @Test
    public void brokenLinks() throws InterruptedException, IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.flipkart.com");

        List<WebElement> list = driver.findElements(By.xpath("//a"));
        ArrayList ele=new ArrayList();
        for(WebElement element : list) {
            String actualLink=element.getAttribute("href");
            URL url=new URL(actualLink);
            URLConnection conn = url.openConnection();
            HttpURLConnection httpConn = (HttpURLConnection) conn;
            conn.connect();
            if(httpConn.getResponseCode()>=400) {
                System.out.println(httpConn.getResponseCode()+":"+actualLink);
            }
        }
//        System.out.println(ele);
        driver.quit();

    }
}
