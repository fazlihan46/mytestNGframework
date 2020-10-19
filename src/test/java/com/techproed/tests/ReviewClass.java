package com.techproed.tests;

import com.techproed.utilities.Driver;
import com.techproed.utilities.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class ReviewClass  {
    @Test
    public void airBien() {
//https://www.airbnb.co.in/ adresine git
        Driver.getDriver().get("https://www.airbnb.co.in/ adresine git");
//Sayfa basligini(title) al ve konsolda yazdir.
        String title=Driver.getDriver().getTitle();
        System.out.println("Page Title :"+title);
        //Sayfanin mevcut url’ ini (current url) al
        String currentUrl=Driver.getDriver().getCurrentUrl();
        System.out.println("Current url :"+currentUrl);
        //Sayfanin source(page source) ‘u al.
        String pageSourch=Driver.getDriver().getPageSource();
        System.out.println("Page Source :"+pageSourch);

    }
    @Test
    public void aBay(){
        //http://ebay.com adresine git
        Driver.getDriver().get("https://www.ebay.com/");
        //Search box’a “Selenium” yaz
        WebElement searchBox=Driver.getDriver().findElement(By.id("gh-ac"));
        searchBox.sendKeys("Selenium");
        //Search butonuna tikla
      WebElement searcButton= Driver.getDriver().findElement(By.id("gh-btn"));
      searcButton.click();
        //Selenium icin kac sonuc var kontrol et ve konsolda yazdir.
        WebElement results = Driver.getDriver().findElement(By.className("srp-controls__count-heading"));
        System.out.println(results.getText());
        //Sayfa basligini(title) al ve konsolda yazdir.
        String title =Driver.getDriver().getTitle();
        System.out.println("Page Title :"+title);
        //Sayfanin mevcut url’ini (current url) al
        String currentUrl=Driver.getDriver().getCurrentUrl();
        System.out.println("Current Pager :"+currentUrl);
        //Sayfanin source(page source) ‘u al.
        String pageSource=Driver.getDriver().getPageSource();
        System.out.println("page Source:"+pageSource);

    }
}
