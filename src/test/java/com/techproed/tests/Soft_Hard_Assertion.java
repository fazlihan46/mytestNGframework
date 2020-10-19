package com.techproed.tests;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_Hard_Assertion {
//Class name : Soft_Hard_Assertion
//http://a.testaddressbook.com/sign_in adresine gidin.
//email textbox,password textbox, ve signin button elementlerini locate edin.
//Aşağıdaki username ve password girin ve signin buttonuna tıklayın.
//Username :  testtechproed@gmail.com
//Password :   Test1234!
//Daha sonra farklı iddialar(assertions) kullanarak sayfaya doğru giriş yaptığınızı doğrulayın.
//Daha sonra farklı iddialar(assertions) kullanarak testtechproed@gmail.com beklenen kullanıcı  kimliğinin(userID) doğrulayın
    WebDriver driver;
   @BeforeClass
    public void setUp(){
        WebDriverManager.chromedriver().setup();
         driver=new ChromeDriver();
        driver.get("http://a.testaddressbook.com/sign_in");
    }
  @Test(priority = 1)
    public void login(){
      WebElement emailBox=driver.findElement(By.id("session_email"));
      emailBox.sendKeys("testtechproed@gmail.com");

      WebElement passwordBox=driver.findElement(By.id("session_password"));
      passwordBox.sendKeys("Test1234!");

      WebElement signButton=driver.findElement(By.name("commit"));
      signButton.click();
  }

@Test(dependsOnMethods = "login")
    public void homePage(){
       WebElement welcomeMessage=driver.findElement(By.xpath("//h1[.='Welcome to Address Book']"));
    System.out.println(welcomeMessage.getText());
    Assert.assertTrue(welcomeMessage.isDisplayed());//HARD ASSERT fail olsaydi asagiya gitmeyecekti
    System.out.println("Hard assert fail olursa bu satir calismayacak");

    //SOFT ASSERT
    //1.adim create object
    SoftAssert softAssert=new SoftAssert();
    //2.adim assertion icin olusturulan objeyi kullan
    //softAssert.assertTrue(!welcomeMessage.isDisplayed());//FAIL
    softAssert.assertTrue(welcomeMessage.isDisplayed());//PASS
    //softAssert.assertEquals(3,5);// FAIL
    //3.adim assertAll()
    softAssert.assertAll();//bu satir cok *******onemli****** assertAll gercek assertion'u yapar ve en sonda kullaniriz assertAll yazolmazsa pass olur
    //fail olmasi gerektiginde de fail olur.
    WebElement userID=driver.findElement(By.className("navbar-text"));
    String actualID=userID.getText();
    String expectedID="testtechproed@gmail.";//com eksik oldugu icin fail oldu
    //Assert.assertEquals(actualID,expectedID);//Hard Assert

   // SOFT ASSERT
    softAssert.assertEquals(actualID,expectedID);
    softAssert.assertAll();


}
}
