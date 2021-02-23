package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(xpath = "//*[@id='menu_item']/li[1]/*/span[1]")
    public WebElement page;

    @FindBy(id = "navbarDropdown")
    public WebElement userButton;

    @FindBy(xpath = "//*[@class='dropdown-item']")
    public WebElement logOutButton;

    @FindBy(css = "#menu_item .nav-link .title")
    public List<WebElement> menuItems;


}
