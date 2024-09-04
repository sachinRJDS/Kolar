package com.TYSS.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Set;

public class ChildWindowHandle {
    @Test
    public void childWindowHandle() {
        WebDriver driver = new ChromeDriver();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://secure.indeed.com");

        driver.findElement(By.cssSelector("#login-google-button")).click();

        JavascriptExecutor js=((JavascriptExecutor)driver);
        js.executeScript("arguments[0].click()",driver.findElement(By.cssSelector("#apple-signin-button")));

        Set<String> windows=driver.getWindowHandles();
        for(String windowHandle:windows){
            driver.switchTo().window(windowHandle);
            String title=driver.getTitle();
            wait.until(ExpectedConditions.titleIs(title));
            if(title.contains("Apple")){
                driver.close();
            }
        }
    }
}
