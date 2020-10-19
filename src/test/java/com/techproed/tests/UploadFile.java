package com.techproed.tests;

import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends TestBase {
//ts packagenin altina bir class oluşturun : UploadFile



 @Test
 //Bir metod oluşturun : uploadFileMethod
 public void    uploadFile(){
     //https://the-internet.herokuapp.com/upload internet adresine gidin.
     driver.get("https://the-internet.herokuapp.com/upload");
     //Yuklemek istediginiz dosyayi secin.
     WebElement chooseFileButton=driver.findElement(By.id("file-upload"));
     String filePath="C:\\Users\\Admin\\Downloads\\cyd.JPG";
     //SendKeys() kullanabilmek icin  choose file elementinin tag=input ve type="file" olamalidir ******
     chooseFileButton.sendKeys(filePath);
     //Upload butonuna basin.
     WebElement uploadButton=driver.findElement(By.id("file-submit"));
     uploadButton.click();

     //“File Uploaded!” textinin goruntulendigini dogrulayin.
     Assert.assertEquals(driver.findElement(By.xpath("//h3")).getText(),"File Uploaded!");
 }
}
