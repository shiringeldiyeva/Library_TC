package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LogOutStepsDefinition {
    HomePage homePage;
    LoginPage loginPage;
    @Given("logged in user")
    public void loggedInUser() {
        loginPage=new LoginPage();
        homePage=loginPage.login(ConfigurationReader.getProperty("studentLogin"),
                  ConfigurationReader.getProperty("studentPassword"));

    }

    @When("user clicks on userButton")
    public void userClicksOnUserButton() {
        homePage.userButton.click();
    }

    @And("user clicks on logOutButton")
    public void userClicksOnLogOutButton() {
        homePage.logOutButton.click();
    }

    @Then("user on the login page")
    public void userOnTheLoginPage() {
        Assert.assertTrue(loginPage.singInButton.isDisplayed());
    }
}
