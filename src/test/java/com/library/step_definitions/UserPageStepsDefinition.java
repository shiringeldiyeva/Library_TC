package com.library.step_definitions;

import com.github.javafaker.Faker;
import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.pages.UserPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import com.library.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.NoSuchElementException;

import java.util.Map;

public class UserPageStepsDefinition {
    LoginPage loginPage=new LoginPage();
    UserPage userPage;
    String emailInfo;
    @Given("logged in librarian on the users page")
    public void loggedInLibrarianOnTheUsersPage() {
        loginPage.username.sendKeys(ConfigurationReader.getProperty("librarianLogin"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        loginPage.singInButton.click();
        HomePage homePage=new HomePage();
        homePage.menuItems.get(1).click();
        userPage=new UserPage();
    }

    @When("user clicks on add user button")
    public void userClicksOnAddUserButton() {
        userPage.addUserButton.click();
    }

    @And("user fills fields with information below")
    public void userFillsFieldsWithInformationBelow(Map<String,String>information) {
        userPage.fullNameField.sendKeys(new Faker().harryPotter().character());
        userPage.passwordField.sendKeys(information.get("Password"));
        userPage.emailField.sendKeys(emailInfo=new Faker().internet().emailAddress());
        userPage.userGroupField.sendKeys(information.get("UserGroup"));
        userPage.statusField.sendKeys(information.get("Status"));
        userPage.startDateField.sendKeys(information.get("StartDate"));
        userPage.endDateField.sendKeys(information.get("EndDate"));
        userPage.endDateField.sendKeys(information.get("Address"));
    }

    @And("user clicks on save changes button")
    public void userClicksOnSaveChangesButton() {
        userPage.saveChangesButton.click();
    }
    @Then("new user should be created")
    public void newUserShouldBeCreated() throws InterruptedException {
        BrowserUtils.sleep(2);
        Assert.assertEquals(emailInfo, userPage.emailInfo.getText());
    }

    @And("user clicks on close button")
    public void userClicksOnCloseButton() throws InterruptedException {
        BrowserUtils.sleep(1);
        userPage.closeButton.click();

    }

    @Then("add user window should be closed")
    public void addUserWindowShouldBeClosed() {
        try{
            assert userPage.addUserForm.isDisplayed();
        } catch (NoSuchElementException e){
            Assert.assertTrue(true);
        }
    }

    @When("user clicks on edit user button")
    public void userClicksOnEditUserButton() throws InterruptedException {
        userPage.editUserButton.click();
    }

    @Then("edit user window is displayed")
    public void editUserWindowIsDisplayed() throws InterruptedException {
        BrowserUtils.sleep(2);
       Assert.assertTrue(userPage.addUserForm.isDisplayed());
    }
}
