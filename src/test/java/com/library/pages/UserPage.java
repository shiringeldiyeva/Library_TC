package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserPage {
    public UserPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@class='portlet-title']/span")
    public WebElement addUserButton;

    @FindBy(name = "full_name")
    public WebElement fullNameField;

    @FindBy(name = "password")
    public WebElement passwordField;

    @FindBy(name = "email")
    public WebElement emailField;

    @FindBy(id = "user_group_id")
    public WebElement userGroupField;

    @FindBy(id = "status")
    public WebElement statusField;

    @FindBy(name = "start_date")
    public WebElement startDateField;

    @FindBy(name = "end_date")
    public WebElement endDateField;

    @FindBy(id = "address")
    public WebElement addressField;

    @FindBy(xpath = "//*[text()='Save changes']")
    public WebElement saveChangesButton;

    @FindBy(xpath = "//*[@id='tbl_users']/tbody/tr[1]/td[4]")
    public WebElement emailInfo;

    @FindBy(xpath = "//*[text()='Close']")
    public WebElement closeButton;

    @FindBy(xpath = "//*[@class='modal fade show']")
    public WebElement addUserForm;

    @FindBy(xpath = "(//*[text()=' Edit User'])[1]")
    public WebElement editUserButton;

    @FindBy(id = "user_groups")
    public WebElement userGroups;

}
