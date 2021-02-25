package com.library.step_definitions;

import com.library.pages.BooksPage;
import com.library.pages.BorrowBooksPage;
import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BorrowBooksStepDefinition {
    HomePage homePage;
    BorrowBooksPage borrowBooksPage;
    @Given("the user goes on the homepage")
    public void theUserGoesOnTheHomepage() {
        LoginPage loginPage=new LoginPage();
        homePage=loginPage.login(ConfigurationReader.getProperty("studentLogin"),
                ConfigurationReader.getProperty("studentPassword"));
    }

    @When("the user click Borrowing Books module")
    public void theUserClickBorrowingBooksModule() {
        homePage.menuItems.get(1).click();
        borrowBooksPage=new BorrowBooksPage();

    }
    @Then("the user should see the following column names")
    public void theUserShouldSeeTheFollowingColumnNames(List<String> columnNames) {
        List<WebElement>borrowBooksColumn=borrowBooksPage.borrowBooksColumn;
        for (WebElement borrowBooks:borrowBooksColumn) {
            Assert.assertTrue(columnNames.contains(borrowBooks.getText()));
        }
    }
}
