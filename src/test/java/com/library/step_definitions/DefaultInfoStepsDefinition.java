package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DefaultInfoStepsDefinition {
    HomePage homePage;
    @Given("the user on the homepage")
    public void theUserOnTheHomepage() {
        LoginPage loginPage=new LoginPage();
        homePage=loginPage.login(ConfigurationReader.getProperty("studentLogin"),
                ConfigurationReader.getProperty("studentPassword"));
    }
    @Then("the user should see the following column names:")
    public void theUserShouldSeeTheFollowingColumnNames(List<String> columns) {
        List<WebElement>columnNames=homePage.columnNames;

        for (WebElement column:columnNames) {
            Assert.assertTrue(columns.contains(column.getText()));

        }
    }
}
