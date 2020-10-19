package com.techproed.tests;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import java.nio.file.Files;
import java.nio.file.Paths;


import java.nio.file.Paths;

public class FileDownload extends TestBase {
    //Tests packagenin altina bir class oluşturun : FileDownload
    //Iki tane metod oluşturun : isExist() ve downloadTest()


    @Test
    public void isExist(){

       String mevcutKlasor=System.getProperty("user.dir");
        System.out.println("MEVCUT KLASOR :"+mevcutKlasor);

        String userklasor=System.getProperty("user.home");
        System.out.println("USER KLASOR :"+userklasor);

String filePath=userklasor+"/Downloads/cyd.jpg";
//String filePath="C:\\Users\\Admin\\Downloads\\cyd.JPG" bu sekilde de yapilabilir.

      boolean isFileExixst= Files.exists(Paths.get(filePath));
      Assert.assertTrue(isFileExixst);//eger dosya varsa true ve pass yoksa false ve test fail olur

    }
    @Test
    public void downloadTest(){
        //downloadTest () metodunun icinde aşağıdaki testi yapın:
        //https://the-internet.herokuapp.com/download adresine gidin.
      driver.get("https://the-internet.herokuapp.com/download");
      //cyd.jpg dosyasını indir
        WebElement cyd=driver.findElement(By.linkText("cyd.JPG"));
        cyd.click();
        //Ardından dosyanın başarıyla indirilip indirilmediğini doğrulayın.
        String userKlasor=System.getProperty("user.home");
        String filePath=userKlasor+"/Downloads/cyd.jpg";
        boolean isDownload=Files.exists(Paths.get(filePath));
        Assert.assertTrue(isDownload);// Dosya yuklendiyse test "PASS" degilse "FAIL" olur.

    }
}
