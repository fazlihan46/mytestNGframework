package com.techproed.smoketest;

import com.techproed.pages.GlbSignInPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NegativeGlbSignIn {


    @Test
    public  void invalidTest(){
        Driver.getDriver().get(ConfigReader.getProperty("glb_trader_signin"));
        GlbSignInPage glbSignInPage=new GlbSignInPage();
        glbSignInPage.emailLogin.sendKeys(ConfigReader.getProperty("invalidemail"));
        glbSignInPage.passwordLogin.sendKeys(ConfigReader.getProperty("invalidpassword"));
        glbSignInPage.loginButton.click();
        Assert.assertTrue(glbSignInPage.mesaj.getText().equals("Sorry!"));
        Driver.closeDriver();

    }
}
