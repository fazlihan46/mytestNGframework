package com.techproed.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.techproed.pages.GlbHomePage;
import com.techproed.pages.GlbSignUpPage;
import com.techproed.utilities.ConfigReader;
import com.techproed.utilities.Driver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ExtentReports1 {
    //ExtentReports ==> Raporlamaya baslamak icin buna ihtiyacimiz var.Raporu kapatmak icin flash() methodu kullaniyoruz.
    // ExtentHtmlReporter  ==> Raporlari yapilandirma(configration) yaridmci olur... HTML raporlarini creat eder.
    //ExtentTest Aciklama(LOGS) eklemek icin, test adimlarini belirlemek icn kullanilir.
    public ExtentReports extentReports;
    public ExtentHtmlReporter extentHtmlReporter;
    public ExtentTest extentTest;

@BeforeTest
    public void setup(){
//Reporteri baslatalim ve konumunu ayarlayalim.
    //klasor:reports , dosya adi: extentreport.html
extentHtmlReporter=new ExtentHtmlReporter("./reports/extentreport.html");
//extentHtmlReporter ile bazi configration lar yapalim
extentHtmlReporter.config().setReportName("GLB trader Report");
extentHtmlReporter.config().setTheme(Theme.STANDARD);
extentHtmlReporter.config().setDocumentTitle("GLB sign up Report");
extentHtmlReporter.config().setEncoding("UTF-8");

//ExtentsReports'u create edelim
    extentReports=new ExtentReports();
    extentReports.attachReporter(extentHtmlReporter);

    //daha fazla aciklama ekleyebiliriz.
    extentReports.setSystemInfo("Automation Engineer:","FAZLI KUZHAN");
    extentReports.setSystemInfo("Browser","Chrome");




}
@AfterTest
public void endReport(){
    extentReports.flush();
}
@Test
    public void glbSignUp() throws InterruptedException {
    GlbSignUpPage glbSignUpPage=new GlbSignUpPage();
    GlbHomePage glbHomePage=new GlbHomePage();

    extentTest=extentReports.createTest("GLB Sign Up Test");

    //Driver.getDriver().get(ConfigReader.getProperty("glb_signup_url"));
    extentTest.info("Url' e git");
    Driver.getDriver().get(ConfigReader.getProperty("glb_url"));
    extentTest.info("join now linkine tikla");
    glbHomePage.joinNowLink.click();
    extentTest.info("email gonder");
    glbSignUpPage.email.sendKeys(ConfigReader.getProperty("test_email"));
    extentTest.info("userName gonder");
    glbSignUpPage.name.sendKeys(ConfigReader.getProperty("test_username"));
    extentTest.info("phone nosu gonder");
    glbSignUpPage.phone.sendKeys(ConfigReader.getProperty("test_phone"));
    extentTest.info("pasword yaz");
    glbSignUpPage.password.sendKeys(ConfigReader.getProperty("test_password"));
    extentTest.info("tekrar password gonder");
    glbSignUpPage.repassword.sendKeys(ConfigReader.getProperty("test_password"));
    extentTest.info("sign up buttona tikla");
    glbSignUpPage.signupButton.click();

    Thread.sleep(3000);
    System.out.println("SUCCES MESAJ :"+ glbSignUpPage.successMesaj.getText());
    Assert.assertFalse(glbSignUpPage.successMesaj.getText().equals("Succes!"));

extentTest.pass("PASSED: Test basariyla tamamlandi");
Driver.closeDriver();
extentTest.pass("Driver basariyla kapatildi");
}


}
