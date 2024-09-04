package com.TYSS.Selenium.Practice;

import GenericUtility.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.time.Duration;

public class Frames extends BaseTest {

    @Test
    public void Frames() {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");

        driver.switchTo().frame(driver.findElement(By.xpath("//frame[@src='frame_4.html']")));
        driver.findElement(By.cssSelector("input[name=mytext4]")).sendKeys("Sachin");

        driver.close();
    }
}
