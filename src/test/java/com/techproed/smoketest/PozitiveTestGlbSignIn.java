package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.annotations.Test;

public class PozitiveTestGlbSignIn {

    @Test
    public void validEmail(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_trader_signin"));
        GlbSignInPage glbSignInPage=new GlbSignInPage();
        glbSignInPage.emailLogin.sendKeys(ConfigReader.getProperty("test_email"));
        glbSignInPage.passwordLogin.sendKeys(ConfigReader.getProperty("test_password"));
        glbSignInPage.loginButton.click();

    }
}
