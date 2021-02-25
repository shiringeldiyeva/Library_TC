package com.library.step_definitions;

import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.pages.UserPage;
import com.library.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class GroupCategoryStepDefinitions {
    HomePage homePage;
    UserPage userPage;
    @Given("the user \\(Librarian) on the homepage")
    public void theUserLibrarianOnTheHomepage() {
        LoginPage loginPage=new LoginPage();
        homePage=loginPage.login(ConfigurationReader.getProperty("librarianLogin"),
                ConfigurationReader.getProperty("librarianPassword"));
    }
    @When("the user click users module")
    public void theUserClickUsersModule() {
        homePage.menuItems.get(1).click();
        userPage = new UserPage();
    }

    @When("the user click User Group dropdown")
    public void theUserClickUserGroupDropdown() {
        userPage.userGroups.click();
    }

    @Then("the user should see the following options:")
    public void theUserShouldSeeTheFollowingOptions(List<String> users) {
        Select select = new Select(userPage.userGroups);
        List<WebElement> options = select.getOptions();
        for (int i=0; i<users.size(); i++) {
            Assert.assertEquals(users.get(i), options.get(i).getText());
        }
    }

}
