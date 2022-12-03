# PomBestPractices

<a href="https://selenium.dev"><img src="https://selenium.dev/images/selenium_logo_square_green.png" width="180" alt="Selenium"/></a>
    

# About The Project
This project tests https://admin-demo.nopcommerce.com using the selenium and cucumber frameworks.
## Video


https://user-images.githubusercontent.com/57863133/205453183-f8a460de-94eb-47e5-8776-53f08d8e2271.mp4



## Project Report




# How the Project Works
 To run the project, java must be installed on your computer. In addition, one of the ide like Eclipse or Intellij Idea must be installed.
 Then you can install and run the project on your computer by typing "git clone https://github.com/AbdurrahmanPulat/PomBestPractices.git" in the terminal.
  * [About The Project](#About-The-Project)
  * [Video](#Video)
  * [How the Project Works](#How-The-Project-Works)
  * [Steps The Circus Movie](#Steps-The-Circus-Movie)
  * [Steps The Jazz Singer Movie](#Steps-The-Jazz-Singer-Movie)
  * [Imdb_Steps Class](#Imdb_Steps-Class)
  * [TheCircus_Steps Class](#TheCirsus_Steps-Class)
  * [TheJazzSinger_Steps Class](#TheJazzSinger_Steps-Class)
  * [TestRunner Class](#TestRunner-Class)
  

## Project Details
Successfully login to the nopcommerce site, then go to the customer page from the menu and fill in the new customer information and add a new customer.Finally, it is checked that the new customer has been successfully added.

## Steps Login


  Scenario: Login with valid credentials

    Given User opens URL "http://admin-demo.nopcommerce.com/login"
    When User enters email as "admin@yourstore.com" and password as "admin"
    And User clicks on Login
    Then page title should be "Dashboard / nopCommerce administration"
    When User clicks on logout link
    Then page title should be "your store. Login"
    And User closes browser


 ## Steps Customers
 
  Scenario: Add a new customer
    And User opens URL "http://admin-demo.nopcommerce.com/login"
    When User enters email as "admin@yourstore.com" and password as "admin"
    And User clicks on Login
    Then User can view Dashboard
    When Users clicks on customer menu
    When Users clicks on customer menu item
    And User clicks on Add New button
    Then User can view and add customer page
    When User enters all the customer info
    Then User can view confirmation message "The new customer has been added successfully."
    And User closes browser



## Login Class

```java
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

```

## AddNewCustomer Class
```java
package POM;

import net.bytebuddy.utility.RandomString;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddNewCustomerPage  {

    public WebDriver driver;


    public AddNewCustomerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@href='#']//p[contains(text(), 'Customers')]")
    private WebElement customerLnkMenu;

    @FindBy(xpath = "//a[@id='nopSideBarPusher']")
    private WebElement menu;

    @FindBy(css = ".nav-link[href='/Admin/Customer/List']")
    private WebElement lnkCustomersItem;

    @FindBy(xpath = "//a[@class='btn btn-primary'] ")
    private WebElement bttnAddNew;


    @FindBy(xpath = "//input[@id='Email']")
    private WebElement txtEmail;

    @FindBy(xpath = "//input[@id='Password']")
    private WebElement txtPassword;


    @FindBy(xpath = "//input[@id='FirstName']")
    private WebElement txtFirstName;

    @FindBy(xpath = "//input[@id='LastName']")
    private WebElement txtLastName;

    @FindBy(xpath = "//input[@id='Gender_Male']\n")
    private WebElement optMale;

    @FindBy(xpath = "//input[@id='Gender_Female']\n")
    private WebElement optFeMale;

    @FindBy(xpath = "//input[@id='Email']\n")
    private WebElement month;

    @FindBy(xpath = "//input[@id='Email']\n")
    private WebElement day;


    @FindBy(xpath = "//input[@id='DateOfBirth']")
    private WebElement txtDob;

    @FindBy(xpath = "//input[@id='Company']")
    private WebElement txtCompany;

    @FindBy(xpath = "//Select[@id='VendorId']")
    private WebElement drpMgrOfVendor;

    @FindBy(css = "#IsTaxExempt")
    private WebElement ısTaxExampt;

    @FindBy(css = ".k-readonly")
    private WebElement txtNewsLetter;

    @FindBy(xpath = "//li[.='Administrators']")
    private WebElement roleAdministrators;


    @FindBy(xpath = "//span[.='Registered']")
    private WebElement txtCostRoles;


    @FindBy(xpath = "//li[.='Guests']\n")
    private WebElement roleGuest;


    @FindBy(xpath = "//li[.='Forum Moderators']\n")
    private WebElement roleModerators;

    @FindBy(xpath = "//li[.='Vendors']")
    private WebElement roleVendors;


    @FindBy(xpath = "//li[@class='k-item k-state-selected']")
    private WebElement roleRegistered;

    @FindBy(xpath = "//textarea[@id='AdminComment']")
    private WebElement adminComment;


    @FindBy(css = "[name='save'] > .far")
    private WebElement btnSave;

    //methodds



    public String getTitlePage() {
        return driver.getTitle();
    }

    public void clickOnCustomerMenu() {

        customerLnkMenu.click();

    }

    public void clickOnAddNew() {
        bttnAddNew.click();
    }

    public void clickOnCustomersMenuItem() {
        lnkCustomersItem.click();
    }


    public void Form(){

        String generatedstring = RandomStringUtils.randomAlphabetic(8);
        String email = generatedstring+"@gmail.com";

        Actions actions = new Actions(driver);
        actions.click(txtEmail)
                .sendKeys(email)
                .sendKeys(Keys.TAB)
                .sendKeys("1234test")
                .sendKeys(Keys.TAB)
                .sendKeys("apo")
                .sendKeys(Keys.TAB)
                .sendKeys("polat")
                .sendKeys(Keys.TAB)
                .click(optMale)
                .sendKeys(Keys.TAB)
                .sendKeys("01/06/1997")
                .sendKeys(Keys.TAB)
                .sendKeys("D-COMPANY")
                .sendKeys(Keys.TAB)
                .click(ısTaxExampt)
                .sendKeys("nothing")
                .sendKeys(Keys.TAB)
                .sendKeys("Administrators")
                .sendKeys(Keys.TAB)
                .sendKeys("Vendor1")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("I'm the best")
                .click(btnSave)
                .perform();


    }



}

```

