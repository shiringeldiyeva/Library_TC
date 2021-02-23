package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(id="inputEmail")
    public WebElement username;

    @FindBy(id="inputPassword")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement singInButton;

    public HomePage login (String user,String pass){
        username.sendKeys(user);
        password.sendKeys(pass);
        singInButton.click();
        return new HomePage();
    }

}
