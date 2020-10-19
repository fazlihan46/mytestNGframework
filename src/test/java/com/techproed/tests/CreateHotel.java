package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateHotel extends TestBase {
    //Bir method olusturun: createHotel
    //http://www.fhctrip.com/admin/HotelAdmin/Create adresine gidin.
    //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
    //Username : manager2
    //Password : Man1ager2!
    //Login butonuna basin.
    //Acilan sayfadaki butun textboxlara istediginiz verileri girin (en sondaki dropdowna dikkat edin).
    //Save butonuna basin.
    //“Hotel was inserted successfully” textinin goruntulendigini dogrulayin.
    //OK butonuna tiklayin.
    @Test
    public void createHotel(){
        driver.get("http://fhctrip-qa.com/admin/HotelAdmin/Create");
        WebElement userNameBox=driver.findElement(By.id("UserName"));
userNameBox.sendKeys("manager2");
        WebElement passwordBox=driver.findElement(By.id("Password"));
passwordBox.sendKeys("Man1ager2!");
        WebElement loginButton=driver.findElement(By.xpath("//button[@type='submit']"));
loginButton.click();


WebElement codeBox=driver.findElement(By.id("Code"));
codeBox.sendKeys("SUIT");
WebElement nameBox=driver.findElement(By.id("Name"));
nameBox.sendKeys("TORONTO HOTEL");
WebElement adressBox=driver.findElement(By.id("Address"));
adressBox.sendKeys("TORONTO/CANADA");
WebElement phoneBox=driver.findElement(By.id("Phone"));
phoneBox.sendKeys("6476853838");
WebElement emailBox=driver.findElement(By.id("Email"));
emailBox.sendKeys("fzlkzhn46@gmail.com");
WebElement idgroupDropDown=driver.findElement(By.id("IDGroup"));
        Select select=new Select(idgroupDropDown);
        select.selectByIndex(1);
WebElement saveButton=driver.findElement(By.id("btnSubmit"));
saveButton.click();
        WebDriverWait wait=new WebDriverWait(driver,20);
       boolean isTrue= wait.until(ExpectedConditions.textToBe(By.className("bootbox-body"),"Hotel was inserted successfully"));
        Assert.assertTrue(isTrue);
WebElement succesful=driver.findElement(By.className("bootbox-body"));
        Assert.assertTrue(succesful.isDisplayed());
        WebElement okButton=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        okButton.click();
    }
}
