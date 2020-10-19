package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeTestColonlama extends TestBase {

    @Test
    public  void gecersizUsername(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage=new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
        fhcLoginPage.loginButton.click();
        //wait problemi varsa bunu kullanmaliyiz.
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement tryAgain = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[.='Try again please']")));
        Assert.assertTrue(tryAgain.isDisplayed());
        //Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));
        //Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }
    @Test
    public void gecersizPassword(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }
    @Test
    public  void gecersizUsernamePass(){
        driver.get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("invalid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains(ConfigReader.getProperty("login_error_mesaj")));

    }
    }
