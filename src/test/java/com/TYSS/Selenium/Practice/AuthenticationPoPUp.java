package com.TYSS.Selenium.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class AuthenticationPoPUp {

    @Test
    public void testAuthenticationPopUp() {
        WebDriver driver=new ChromeDriver();
        driver.get("https://admin:admin@the-internet.herokuapp.com/basic_auth/");
        driver.close();
    }
}
