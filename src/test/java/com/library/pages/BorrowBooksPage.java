package com.library.pages;

import com.library.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class BorrowBooksPage {
    public BorrowBooksPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "tr>th")
    public List<WebElement> borrowBooksColumn;
}
