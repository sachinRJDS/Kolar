package com.TYSS.Selenium.Practice;

import GenericUtility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.time.Duration;

public class Frames {

    @Test(dataProviderClass = data_Provider.class, dataProvider = "data")
    public void dataProvider_diffClass(String name, int age){
        System.out.println(name+":"+age);
    }


    @Test(enabled = false)
    public void Frames() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        Actions action = new Actions(driver);

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_4.html']")));
        driver.findElement(By.cssSelector("input[name=mytext4]")).sendKeys("Sachin");

        driver.close();
    }
}
