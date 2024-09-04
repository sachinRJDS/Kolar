package com.TYSS.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.time.Duration;

public class HandlingMouseActions {
    WebDriver driver=new ChromeDriver();
    Actions action=new Actions(driver);

    @Test(enabled = false)
    public void mouseHover(){
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://myntra.com/");


        action.moveToElement(driver.findElement(By.xpath("//nav/descendant::a[text()='Men']"))).perform();
        driver.findElement(By.xpath("//a[text()='Topwear']/../following-sibling::li/descendant::a[text()='T-Shirts']")).click();
//        action.sendKeys(driver.findElement(By.cssSelector("input[class=desktop-searchBar]")),"shirts");
//        driver.close();
    }

    @Test(enabled = false)
    public void contextClick() throws AWTException {
        driver.manage().window().maximize();
        driver.get("https://www.actitime.com/free-online-trial");
//        action.scrollToElement(driver.findElement(By.xpath("//a[text()='Service Agreement']")));
        JavascriptExecutor js=(JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0,600)");
        action.contextClick(driver.findElement(By.xpath(" //a[text()='Service Agreement']"))).perform();
        Robot r=new Robot();
        r.keyPress(KeyEvent.VK_W);

    }

    @Test
    public void dragAndDrop(){
        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");
        WebElement src=driver.findElement(By.cssSelector("#box1"));
        WebElement dest=driver.findElement(By.cssSelector("#box104"));
        action.dragAndDrop(src,dest).perform();

    }
}
