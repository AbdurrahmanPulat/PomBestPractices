package POM;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {


    protected WebDriver driver;

    public LoginPage(WebDriver driver){
        this.driver= driver;
        PageFactory.initElements(driver,this);
        if (driver.getTitle().contentEquals("Your store, Login"))
            throw new IllegalStateException("Login Page was not launched");
    }

    @FindBy(xpath = "//input[@id='Email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement txtPassword;


    @FindBy(css = ".button-1")
    private WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    private WebElement lnkLogout;


    public void enterUsername(String username){
        txtEmail.clear();
        txtEmail.sendKeys(username);
    }


    public void enterPassword(String password){
        txtPassword.clear();
        txtPassword.sendKeys(password);
    }

    public void clickLogin(){
        btnLogin.click();
    }

    public void clickLogout(){
        lnkLogout.click();
    }



}
