package com.TYSS.Selenium.Practice;

import GenericUtility.BaseTest;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class ScreenShot extends BaseTest {
    @Test
    public void testScreenShot() throws IOException {
//        WebDriver driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        TakesScreenshot ts = (TakesScreenshot) driver;
        File src=ts.getScreenshotAs(OutputType.FILE);
        File dest=new File("./src/test/resources/sample.png");

        FileUtils.copyFile(src,dest);


    }
}
