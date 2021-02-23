package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class ModulesStepsDefinitions {
    HomePage homePage;
    @Given("the student on the home page")
    public void theStudentOnTheHomePage() {
        LoginPage loginPage=new LoginPage();
        homePage=loginPage.login(ConfigurationReader.getProperty("studentLogin"),
                ConfigurationReader.getProperty("studentPassword"));

    }

    @Then("the user should see following modules")
    public void theUserShouldSeeFollowingModules(List<String> modules) {
        for (WebElement menuItem : homePage.menuItems) {
            Assert.assertTrue(modules.contains(menuItem.getText()));
        }
    }

    @Given("the librarian on the homepage")
    public void theLibrarianOnTheHomepage() {
        LoginPage loginPage=new LoginPage();
        homePage=loginPage.login(ConfigurationReader.getProperty("librarianLogin"),
                ConfigurationReader.getProperty("librarianPassword"));
    }
}
