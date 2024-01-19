package tests.US10_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC02_negativeTest extends TestBaseRapor {
    @Test
    public void TC02_negativeTest(){
        extentTest = extentReports.createTest("Kullanici hatali giris testi","Kullanici kayit olunan bilgileri ile hatali giris yapmasi ");
        // 1. Kullanici "https://www.easybusticket.com/login" Adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("easyBusLogin"));
        extentTest.info("kullanici qa.easybusticket.com ana sayfaya gider");

        // 2. Kullanici sayfanın acildigini dogrular
        String expedtedUrl = "https://qa.easybusticket.com/login" ;
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuelUrl,expedtedUrl);
        extentTest.pass("Kullanici sayfanın acildigini dogrular");

        // 3. Kullanici Username textbox ici bos birakilir
        VisitorHomepage page = new VisitorHomepage();

        page.textBoxUsername.sendKeys("");
        extentTest.pass("Kullanici Username textbox ici bos birakilir");

        // 4. Kullanici password textbox'in icine gecerli-gecersiz sifre girer
        page.textBoxPassword.sendKeys("12234");
        extentTest.info("Kullanici password textbox'in icine gecerli-gecersiz sifre girer");

        // 5. Kullanici LogIn buttonuna tiklar
        page.buttonLogin.click();
        extentTest.pass("Kullanici LogIn buttonuna tiklar");

        // 6. Kullanici Username textbox icine bosluklu karakteri girer
        page.textBoxUsername.click();
        page.textBoxUsername.sendKeys("1234 5678");
        extentTest.info("Kullanici Username textbox icine bosluklu karakteri girer");

        // 7. Kullanici password textbox'in icine gecerli-gecersiz sifre girer
        page.textBoxPassword.sendKeys("Deneme01.");
        extentTest.info("Kullanici password textbox'in icine gecerli-gecersiz sifre girer");

        // 8. Kullanici LogIn buttonuna tiklar
        page.buttonLogin.click();
        extentTest.pass("Kullanici LogIn buttonuna tiklar");


        Driver.closeDriver();
        extentTest.pass("Sayfayi kapatir");

    }
}
