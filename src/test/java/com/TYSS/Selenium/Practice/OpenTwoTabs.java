package com.TYSS.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class OpenTwoTabs {
    @Test
    public void twoTabs() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.flipkart.com");

        //open new window & enter below url
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://www.google.com");

        Set<String> set=driver.getWindowHandles();
        System.out.println(set.size());
        for(String window:set){
            driver.switchTo().window(window);
            String title=driver.getTitle();
            if(title.contains("Online Shopping Site")){
                driver.findElement(By.cssSelector("input[name=q]")).sendKeys("i phone 14");
                Thread.sleep(3000);
            }
        }

        driver.quit();
    }
}
