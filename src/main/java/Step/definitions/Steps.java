package Step.definitions;

import POM.AddNewCustomerPage;
import POM.LoginPage;


import io.cucumber.java.en.*;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;


public class Steps {

    WebDriver driver;
    LoginPage loginPage;

    AddNewCustomerPage acp;


    @Given("User opens URL {string}")
    public void user_opens_url(String url) {
        System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"/src/test/resources/BrowserDrivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        driver.get(url);

    }

    @When("User enters email as {string} and password as {string}")
    public void user_enters_email_as_and_password_as(String email, String password) {

        loginPage = new LoginPage(driver);
        loginPage.enterUsername(email);
        loginPage.enterPassword(password);

    }

    @When("User clicks on Login")
    public void user_clicks_on_login() {
        loginPage.clickLogin();

    }

    @Then("page title should be {string}")
    public void page_title_should_be(String title) {
        if (title.equalsIgnoreCase(driver.getTitle())){
            Assertions.assertTrue(true);
        }else {
            System.out.println("Actual title : "+driver.getTitle());
            driver.close();
            Assertions.assertTrue(false);
        }

    }

    @When("User clicks on logout link")
    public void user_clicks_on_logout_link() {

        loginPage.clickLogout();

    }

    @Then("User closes browser")
    public void user_closes_browser() {
        driver.quit();

    }



    ////



    @Then("User can view Dashboard")
    public void user_can_view_dashboard() {
        acp = new AddNewCustomerPage(driver);
        Assert.assertEquals("Dashboard / nopCommerce administration", acp.getTitlePage());

    }

    @When("Users clicks on customer menu")
    public void users_clicks_on_customer_menu() throws InterruptedException {
        acp.clickOnCustomerMenu();

    }

    @When("Users clicks on customer menu item")
    public void users_clicks_on_customer_menu_item() {
        acp.clickOnCustomersMenuItem();

    }

    @When("User clicks on Add New button")
    public void user_clicks_on_add_new_button() {
        acp.clickOnAddNew();

    }

    @Then("User can view and add customer page")
    public void user_can_view_and_add_customer_page() {
        Assert.assertEquals("Add a new customer / nopCommerce administration", acp.getTitlePage());

    }

    @When("User enters all the customer info")
    public void user_enters_all_the_customer_info() throws InterruptedException {
       acp.Form();
    }



    @Then("User can view confirmation message {string}")
    public void user_can_view_confirmation_message(String msg) {
        Assert.assertTrue(driver.getPageSource().contains(msg));

    }



}