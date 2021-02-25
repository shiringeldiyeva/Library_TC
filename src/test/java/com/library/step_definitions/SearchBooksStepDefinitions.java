package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utilities.BrowserUtils;
import com.library.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SearchBooksStepDefinitions {
    HomePage homePage;
    boolean selectable = true;
    @Given("the user is on the homepage")
    public void theUserOnTheHomepage() {
        LoginPage loginPage=new LoginPage();
        homePage=loginPage.login(ConfigurationReader.getProperty("studentLogin"),
                ConfigurationReader.getProperty("studentPassword"));
    }
    @When("the user changes the category")
    public void theUserChangeTheCategory() {
        System.out.println("test");
        Select select = new Select(homePage.booksCategories);
        List<WebElement> options = select.getOptions();
        for (int i = 1; i < options.size(); i++) {
            try {
                select.selectByValue("" + i);

                selectable = true;
            } catch (Exception e) {
                selectable = false;
            }
        }
    }

    @Then("the user sees the result of chosen category")
    public void theUserSeesTheResultOfChosenCategory() {
        Assert.assertTrue(selectable);
    }
}
