package com.techproed.tests;

import com.techproed.pages.FHCLoginPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderDemo {
//@Test(dataProvider ="getData") @DataProvider'a name verilmezse method ismi kullanilir.
@Test(dataProvider ="log in data")
    public void loginTest(String user,String pass){
    Driver.getDriver().get(ConfigReader.getProperty("fhc_login_url"));
    FHCLoginPage fhcLoginPage = new FHCLoginPage(Driver.getDriver());
    fhcLoginPage.username.sendKeys(user);
    fhcLoginPage.password.sendKeys(pass);
    fhcLoginPage.loginButton.click();

    Assert.assertTrue(fhcLoginPage.error_mesaj.getText().contains("Try again please"));

}
//bizim creat ettigimiz data provider methodu
@DataProvider(name = "log in data")
public Object[][] getData(){
    //{{user1,pass1},{user2,pass2},{user3,pass3}
Object[][] data=new Object[3][2];
//1.data'lar
    data[0][0]="user1";
    data[0][1]="pass1";
    //2.siradaki datalar
    data[1][0]="user2";
    data[1][1]="pass2";
//3.siradakiler
    data[2][0]="user3";
    data[2][1]="pass3";

    return data;
}


}
