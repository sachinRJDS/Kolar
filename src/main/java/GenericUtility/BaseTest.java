package GenericUtility;

import POM.LoginPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

import java.io.IOException;
import java.sql.SQLOutput;
import java.time.Duration;

public class BaseTest {

   public WebDriver driver;
    CommonDataForProperty cLib=new CommonDataForProperty();


    @BeforeSuite
    public void beforeSuite(){
        System.out.println("BeforeSuite");
       System.out.println("Added");
    }
    @Parameters("browser")
    @BeforeTest(groups = "smoke")
    public void beforeTest(String browser) throws IOException {
//        String browser= cLib.readCommonData("browser");
        if(browser.equals("chrome")){
            driver = new ChromeDriver();
        }else if(browser.equals("firefox")){
            driver = new FirefoxDriver();
        }
    }

    @BeforeMethod(groups="smoke")
    public void beforeMethod() throws IOException {
        LoginPage loginLib=new LoginPage(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get(cLib.readCommonData("baseurl"));

        System.out.println(cLib.readCommonData("username"));
        System.out.println(cLib.readCommonData("password"));

        loginLib.loginToApp(cLib.readCommonData("username"),cLib.readCommonData("password"));
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AfterMethod");
    }
    @AfterTest(groups = "smoke")
    public void afterTest(){

        driver.close();

    }
    @AfterSuite
    public void afterSuite(){
        System.out.println("AfterSuite");
    }
}
