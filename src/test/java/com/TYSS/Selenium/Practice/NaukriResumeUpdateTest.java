package com.TYSS.Selenium.Practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.io.File;
import java.time.Duration;

public class NaukriResumeUpdateTest {

    @Test
    public void naukriResumeUpdateTest() throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.manage().window().maximize();

        driver.get("https://www.naukri.com/");

        //click on login btn in naukri home page
        driver.findElement(By.xpath("//a[@title='Jobseeker Login']")).click();

        //enter the UN and PWD
        driver.findElement(By.xpath("//form[@name='login-form']/div[2]/input")).sendKeys("sachinraj3665@gmail.com");
        driver.findElement(By.xpath("//form[@name='login-form']/div[3]/input")).sendKeys("sachin@123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();

        //click on more option
        driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__bars']")).click();

        //click om view and update the profile link
        driver.findElement(By.xpath("//a[text()='View & Update Profile']")).click();

        //get resume title
        String resumeTitle=driver.findElement(By.xpath("//div[@class='resume-name-inline']/div")).getText();

        if(resumeTitle.equalsIgnoreCase("Sachin.R_2.2_Update1.docx")) {
            File f = new File("./src/test/resources/Sachin.R_2.2_Update2.docx");
            String path = f.getAbsolutePath();
            driver.findElement(By.xpath("(//div[@class='uploadContainer'])[1]/input")).sendKeys(path);

        }else if(resumeTitle.equalsIgnoreCase("Sachin.R_2.2_Update2.docx")){

            File f = new File("./src/test/resources/Sachin.R_2.2_Update1.docx");
            String path = f.getAbsolutePath();
            driver.findElement(By.xpath("(//div[@class='uploadContainer'])[1]/input")).sendKeys(path);

        }

        Thread.sleep(2000);

        //click on more option
        driver.findElement(By.xpath("//div[@class='nI-gNb-drawer__bars']")).click();

        //click on logout
        driver.findElement((By.xpath("//a[@title='Logout']"))).click();

        driver.close();

        System.out.println("Resume has been Uploaded Successfully in Naukri.com");

    }
}
