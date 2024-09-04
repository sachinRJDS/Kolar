package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    @FindBy(id="login2") WebElement loginBtn;
    public WebElement loginBtn(){
        return loginBtn;
    }

    @FindBy(id="loginusername") WebElement username;
    public WebElement username(){
        return username;
    }

    @FindBy(id="loginpassword") WebElement password;
    public WebElement password(){
        return password;
    }


    @FindBy(xpath = "//button[text()='Log in']") WebElement loginButton;
    public WebElement loginButton(){
        return loginButton;
    }

    @FindAll({@FindBy(id=""),@FindBy(id=" ")})
    WebElement abc; //it will work like a or || operator

    @FindBys({@FindBy(id=""),@FindBy(id=" ")})
    WebElement abc2; //it will work like a and && operator


    public LoginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    public void loginToApp(String username1, String password1){
        loginBtn().click();
        username().sendKeys(username1);
        password().sendKeys(password1);
        loginButton().click();
    }
}
