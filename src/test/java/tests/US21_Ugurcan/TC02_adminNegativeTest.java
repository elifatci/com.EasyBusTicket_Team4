package tests.US21_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02_adminNegativeTest extends TestBaseRapor {

    @Test
    public void TC02_adminNegativeTest(){
        extentTest = extentReports.createTest("Admin yanlis giris testi","Admin yanlis bilgilerle giris testi");

        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.pass("Admin 'https://qa.easybusticket.com/admin' ana sayfasına gider");

        // 3. Admin sayfasinin acildigini goruntuleyin
        String expedtedUrl = "https://qa.easybusticket.com/admin" ;
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actuelUrl.contains(expedtedUrl));
        extentTest.pass("Admin sayfasinin acildigini goruntuleyin");

        // 4. Login penceresindeki password textBox bos birakilamaz oldugunu dogrulayın
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.clear();
        page.loginButonu.click();
        extentTest.pass("Login penceresindeki password textBox bos birakilamaz oldugunu dogrular");

        // 5. username kutusu bos birakildiginda The password field is required. yazisinin geldigini dogrulayin
        String expectedPassword = page.usernameKutusu.getText();
        String actualPassword = "The password field is required.";

        Assert.assertTrue(actualPassword.contains(expectedPassword));
        extentTest.pass("Bos birakildiginda The password field is required. yazisinin geldigini dogrular");

        ReusableMethods.wait(3);

        // 6. Login penceresindeki username textBox harf, rakam, ozel karakter girilebildigini dogrulayin
        page.usernameKutusu.clear();
        page.usernameKutusu.sendKeys("a1/.2b");

        Assert.assertTrue(page.usernameKutusu.isDisplayed());
        extentTest.pass("Login penceresindeki username textBox harf, rakam, ozel karakter girilebildigini dogrular");

        // 7. Login buttonuna basar
        page.loginButonu.click();
        extentTest.pass("Login buttonuna basar");


        ReusableMethods.wait(3);

        // 8. Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisinsaglar
        page.usernameKutusu.clear();
        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();
        extentTest.pass("Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisinsaglar");


        // 9. Dashboard sayfasinin gorunur oldugunu dogrulayin
        String expedtedDashboard = "https://qa.easybusticket.com/admin" ;
        String actuelDashboard = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actuelDashboard.contains(expedtedDashboard));
        extentTest.pass("Dashboard sayfasinin gorunur oldugunu dogrulayin");



        Driver.closeDriver();
        extentTest.pass("Sayfayi kapatir");
    }

}
