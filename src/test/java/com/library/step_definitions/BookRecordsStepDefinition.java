package com.library.step_definitions;

import com.library.pages.BooksPage;
import com.library.pages.HomePage;
import com.library.pages.LoginPage;
import com.library.pages.UserPage;
import com.library.utilities.ConfigurationReader;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BookRecordsStepDefinition {
    LoginPage loginPage = new LoginPage();
    HomePage homePage = new HomePage();
    BooksPage booksPage;

    @Given("logged in librarian")
    public void loggedInLibrarian() {
        loginPage.username.sendKeys(ConfigurationReader.getProperty("librarianLogin"));
        loginPage.password.sendKeys(ConfigurationReader.getProperty("librarianPassword"));
        loginPage.singInButton.click();
    }

    @When("user clicks on the books page")
    public void userClicksOnTheBooksPage() {
        homePage.menuItems.get(2).click();
        booksPage = new BooksPage();
    }

    @Then("user should be able to see show record is {int}")
    public void userShouldBeAbleToSeeShowRecordIs(int arg0) {
        Select select = new Select(booksPage.countButton);
        String count = select.getFirstSelectedOption().getText();
        Assert.assertEquals(arg0, Integer.parseInt(count));
    }

    @Then("below count options should be able")
    public void belowCountOptionsShouldBeAble(List<String> options) {
        Select select = new Select(booksPage.countButton);
        for (String option : options) {
            try {
                select.selectByValue(option);
            } catch (Exception e) {
                System.out.println("This option is not displayed: " + option);
            }
        }
    }
}
