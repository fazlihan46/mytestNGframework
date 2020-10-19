package com.techproed.smoketest;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.TestBase;
import org.testng.annotations.Test;
public class FHCLoginPositiveTest extends TestBase {
   @Test
   public void positiveTestLogin(){
      driver.get(ConfigReader.getProperty("fhc_login_url"));
      FHCLoginPage fhcLoginPage = new FHCLoginPage(driver);
      fhcLoginPage.username.sendKeys(ConfigReader.getProperty("valid_username"));
      fhcLoginPage.password.sendKeys(ConfigReader.getProperty("valid_password"));
      fhcLoginPage.loginButton.click();
   }
}

