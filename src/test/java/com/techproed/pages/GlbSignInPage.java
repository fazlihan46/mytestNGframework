package com.techproed.pages;

import com.techproed.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class GlbSignInPage {
    public GlbSignInPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }
    @FindBy(id = "email")
    public WebElement emailLogin;
    @FindBy(id = "password")
    public WebElement passwordLogin;
    @FindBy(xpath = "//button[@onclick='return Valid_login(document.login);']")
    public WebElement loginButton;
    @FindBy(xpath = "//strong")
    public WebElement mesaj;
}
