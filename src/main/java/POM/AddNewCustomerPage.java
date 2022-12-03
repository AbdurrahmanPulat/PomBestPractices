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
