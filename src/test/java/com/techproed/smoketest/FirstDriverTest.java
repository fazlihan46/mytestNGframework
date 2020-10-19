package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FirstDriverTest {
    @Test
    public void gecersizPassword(){
        //driver.....====>Driver.getDriver() kullanacagiz
        Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
        FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
        fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
        fhcLoginPage.password.sendKeys(ConfigReader.getProperty("invalid_password"));
        fhcLoginPage.loginButton.click();
        Assert.assertTrue(fhcLoginPage.error_mesaj.isDisplayed());
    }


}
