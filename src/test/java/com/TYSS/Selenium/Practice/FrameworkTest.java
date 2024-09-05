package com.TYSS.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrameworkTest {

    @Test
    public void Framework() throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://lumafashion.co.nz/");
        Actions actions = new Actions(driver);
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("window.scrollTo(0,300)");


        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='main-nav']/li/a[normalize-space(text())='SHOP']"))).perform();
        actions.moveToElement(driver.findElement(By.xpath("//ul[@id='main-nav']/li/a[normalize-space(text())='SHOP']/following-sibling::ul/descendant::a[normalize-space(text())='TOPS']"))).perform();
        driver.findElement(By.xpath("//ul[@id='main-nav']/li/a[normalize-space(text())='SHOP']/following-sibling::ul/descendant::a[normalize-space(text())='TOPS']/following-sibling::ul/descendant::a[text()='T-Shirts']")).click();

        String expect=driver.findElement(By.xpath("//div[@id='main-collection-product-grid']/div[1]/descendant::a[2]")).getText();

        driver.findElement(By.xpath("//div[@id='main-collection-product-grid']/div[1]")).click();

        driver.findElement(By.cssSelector("#addToCart")).click();

        jsExecutor.executeScript("window.scrollTo(0,0)");

        driver.findElement(By.xpath("//*[name()='svg' and @class='testament--icon-theme-bag cart-links__link-cart--icon']")).click();

        String actual=driver.findElement(By.xpath("//p[@class='ajax-cart__title']/a")).getText();

        Assert.assertEquals(actual,expect,"Product not has been Added into a cart");

        driver.quit();
    }
}
