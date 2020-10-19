package com.techproed.tests;

import com.techproed.utilities.TestBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.security.PublicKey;

public class HandlingAlerts extends TestBase {
    // https://the-internet.herokuapp.com/javascript_alerts adresine gidin.
    // Bir metod olusturun: acceptAlert
    //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    //Bir metod olusturun: dismissAlert
    //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.
    // Bir metod olusturun: sendKeysAlert
    //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna tıklayın ve result mesajının görüntülendiğini doğrulayın.


    @Test

    public void acceptAlert() {
        driver.get(" https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button1 = driver.findElement(By.xpath("//button[@onclick='jsAlert()']"));
        button1.click();
        System.out.println("Alert mesaji :" + driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultMessage.isDisplayed());

    }

    @Test

    public void dismissAlert() {
        driver.get(" https://the-internet.herokuapp.com/javascript_alerts");
        WebElement button2 = driver.findElement(By.xpath("//button[@onclick='jsConfirm()']"));
        button2.click();
        System.out.println("ALERT MESAJI :" + driver.switchTo().alert().getText());
        driver.switchTo().alert().dismiss();//cancel buttonuna basmak demektir.
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));
        String actualResult = resultMessage.getText();
        String expectedResult = "You clicked: Cancel";
        Assert.assertEquals(actualResult, expectedResult);

    }

    @Test

    public void sendKeysAlert() {
        driver.get(" https://the-internet.herokuapp.com/javascript_alerts");
        WebElement buton3 = driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));
        buton3.click();
        driver.switchTo().alert().sendKeys("Fazli Kuzhan");
        driver.switchTo().alert().accept();
        WebElement resultMessage = driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultMessage.isDisplayed());
    }

}