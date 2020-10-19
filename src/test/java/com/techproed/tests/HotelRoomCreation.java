package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
public class HotelRoomCreation extends TestBase {
    @Test
    public void RoomCreateTest(){
        //http://www.fhctrip.com/admin/HotelRoomAdmin adresine gidin.
        driver.get("http://fhctrip-qa.com/admin/HotelRoomAdmin ");
        //Username textbox ve password textboxlarini locate edin ve asagidaki verileri girin.
        WebElement usernameBox = driver.findElement(By.id("UserName"));
        WebElement passwordBox = driver.findElement(By.id("Password"));
        WebElement loginButton = driver.findElement(By.xpath("//button[@type='submit']"));
        usernameBox.sendKeys("manager2");     //Username : manager2
        passwordBox.sendKeys("Man1ager2!");   //Password : Man1ager2!
        loginButton.click();
        //Add Hotel room butonuna tiklayin
        WebElement addHotelRoomButton = driver.findElement(By.className("hidden-480"));
        addHotelRoomButton.click();
        //Acilan sayfadaki butun textboxlara istediginiz verileri girin
        WebElement idHotel = driver.findElement(By.id("IDHotel"));
        Select select = new Select(idHotel);
        select.selectByIndex(9);
        driver.findElement(By.id("Code")).sendKeys("King");
        driver.findElement(By.id("Name")).sendKeys("112");
        driver.findElement(By.id("Location")).sendKeys("City center");
        driver.findElement(By.xpath("//textarea[@dir='ltr']")).sendKeys("Deniz manzarali");
        //price
        WebElement kaynak=driver.findElement(By.xpath("//li[@data-id='500']"));
        WebElement hedef=driver.findElement(By.id("Price"));
        actions.dragAndDrop(kaynak,hedef).perform();

WebElement roomType=driver.findElement(By.id("IDGroupRoomType"));
Select option=new Select(roomType);
option.selectByIndex(5);

driver.findElement(By.id("MaxAdultCount")).sendKeys("2");
driver.findElement(By.id("MaxChildCount")).sendKeys("2");
driver.findElement(By.id("btnSubmit")).click();//save buttonuna basalim

        //explictly wait
        WebDriverWait wait=new WebDriverWait(driver,20);
        boolean isTrue=     wait.until(ExpectedConditions.textToBe(By.xpath("//div[@class='bootbox-body']"),"HotelRoom was inserted successfully"));
        Assert.assertTrue(isTrue);
WebElement okButton=driver.findElement(By.xpath("//button[@data-bb-handler='ok']"));
okButton.click();
actions.sendKeys(Keys.HOME).perform();
WebElement hotelRooms=wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//a[@href='/admin/HotelRoomAdmin']"))));
hotelRooms.click();


WebElement listOfHotel=driver.findElement(By.xpath("//span[.='List Of Hotelrooms']"));
Assert.assertTrue(listOfHotel.isDisplayed());
        //Save butonuna basin.
        //“HotelRoom was inserted successfully” textinin goruntulendigini dogrulayin.
        //OK butonuna tiklayin.
        //Hotel rooms linkine tiklayin.
        //"LIST OF HOTELROOMS" textinin goruntulendigini(isDisplayed) dogrulayin.
    }
}
