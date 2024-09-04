package com.TYSS.Selenium.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LunchingTheBrowser {

    @Test
    public void LunchingTheBrowser() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.facebook.com/");
        driver.close();
    }
}
