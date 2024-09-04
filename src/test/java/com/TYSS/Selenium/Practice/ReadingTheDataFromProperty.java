package com.TYSS.Selenium.Practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class ReadingTheDataFromProperty {

    @Test
    public void readingTheDataFromProperty() throws IOException {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String path="./src/test/resources/commondata1.property";
        FileInputStream fid=new FileInputStream(path);

        Properties prop=new Properties();
        prop.load(fid);
        System.out.println(prop.getProperty("browser"));
        System.out.println(prop.getProperty("baseurl"));
        System.out.println(prop.getProperty("username"));
        System.out.println(prop.getProperty("password"));

    }
}
