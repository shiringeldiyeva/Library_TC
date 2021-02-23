package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class LoginStepDefinitions {
    LoginPage loginPage;
    @Given("the user login as a {string}")
    public void the_user_login_as_a(String role) {

        loginPage=new LoginPage();
        if (role.equals("student")){
            loginPage.username.sendKeys(ConfigurationReader.getProperty("studentLogin"));
            loginPage.password.sendKeys(ConfigurationReader.getProperty("studentPassword"));
            loginPage.singInButton.click();
        }else if (role.equals("librarian")){
            loginPage.username.sendKeys(ConfigurationReader.getProperty("librarianLogin"));
            loginPage.password.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
            loginPage.singInButton.click();
        }
    }

    @Then("the user on  {string}")
    public void the_user_on(String page) {
        HomePage homePage = new HomePage();
        Assert.assertEquals(page, homePage.page.getText());
        Driver.closeDriver();
    }

}
