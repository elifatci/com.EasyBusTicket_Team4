package tests.US21_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class TC01_adminPositiveTest extends TestBaseRapor {

    @Test
    public void TC01_adminPositiveTest(){
        extentTest = extentReports.createTest("Admin giris testi","Admin dogru bilgilerle giris testi");
        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.pass("Admin 'https://qa.easybusticket.com/admin' ana sayfasına gider");


        // 3. Admin sayfasinin acildigini goruntuleyin
        String expedtedUrl = "https://qa.easybusticket.com/admin" ;
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actuelUrl.contains(expedtedUrl));
        extentTest.pass("Admin sayfasinin acildigini goruntuler");


        // 4. Yonetici giris sayfasindaki username textbox'in ve password textbox'in gorunur
        //    ve aktif oldugunu dogrulayın

        AdminDashboard page = new AdminDashboard();
        Assert.assertTrue(page.usernameKutusu.isDisplayed());
        Assert.assertTrue(page.passwordKutusu.isDisplayed());

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();
        extentTest.pass("Yonetici giris sayfasindaki username textbox'in ve password textbox'in gorunur ve aktif oldugunu dogrular");

        Driver.closeDriver();
        extentTest.pass("Sayfayi kapatir");

    }
}
