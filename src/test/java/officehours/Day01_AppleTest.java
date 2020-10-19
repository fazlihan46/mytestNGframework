package officehours;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Day01_AppleTest {
private WebDriver driver;

@BeforeTest
    public void setUp(){

    WebDriverManager.chromedriver().setup();//DRIVER OLUSTURMADAN ONCE SETUP OLUSTURMA
    driver=new ChromeDriver();//DRIVER OBJESI OLUSTURALIM
    driver.manage().window().maximize();// TUM EKRANI KAPLASIN
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //drivere bekleme suresi ekledik
    driver.get("https://www.apple.com/");
}
@Test(priority = 1)
public void ilkUrunTest(){

    WebElement ilkUrunBaslik=driver.findElement(By.xpath("(//h2[@class='headline'])[1]"));
    System.out.println(ilkUrunBaslik.getText());
    Assert.assertTrue(ilkUrunBaslik.isDisplayed());


}
////*[@class='headline'] sahip olan tum elementleri buluyoruz
@Test(priority = 2)
public void headLineTumElementlerTest() {

    List<WebElement> list = driver.findElements(By.xpath("//*[@class='headline']"));// class='headline' olan butun elementleri return ediyor
    for (WebElement elementler : list) {
        System.out.println("isim :" + elementler.getText());//tum iPhone lari yazdirdik
    }
}
@Test(priority = 3)
        public void urunBaslikTest(){
        //driver.get("https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");
    //navigate().to() ile de url ye gidebiliriz
driver.navigate().to("https://www.apple.com/shop/product/MXNK2LL/A/smart-keyboard-folio-for-ipad-pro-11%E2%80%91inch-2nd-generation-us-english");
WebElement baslik=driver.findElement(By.xpath("//h1[@class='materializer']"));
    System.out.println(baslik.getText());
    Assert.assertTrue(baslik.isDisplayed());
}
@Test(priority = 4)
public void sizeTest() {

    WebElement sizeDropDown = driver.findElement(By.id("dimensionMerchModel"));
    Select select = new Select(sizeDropDown);
    List<WebElement> list = select.getOptions();
//foreach ile dropdown lari aldik
    for (WebElement options : list) {
        System.out.println("size :" + options.getText());

    }
    Assert.assertTrue(sizeDropDown.isDisplayed());
}
@Test(priority = 5)
        public void dilLanguages(){
    WebElement dilDropdown = driver.findElement(By.id("dimensionLanguage"));
    Select select=new Select(dilDropdown);
    List<WebElement> list=select.getOptions();

    for (WebElement dilSecenekleri:list) {
        System.out.println("TUM DIL SECENEKLERI :"+dilSecenekleri.getText());

    }
    System.out.println(list.size()+ "tane dil secenegi var");
    Assert.assertTrue(dilDropdown.isDisplayed());

}
@AfterTest
    public void tearDown(){
   // driver.quit();
    System.out.println("TEST BITTI");


}

}
