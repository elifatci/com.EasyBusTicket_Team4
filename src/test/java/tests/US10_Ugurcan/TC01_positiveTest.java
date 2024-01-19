package tests.US10_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01_positiveTest extends TestBaseRapor {

    @Test
    public void US_10_positiveTest() {
        extentTest = extentReports.createTest("Kullanici giris testi","Kullanici kayit olunan bilgileri ile giris yapabilmesi ");
        // 1. Kullanici "https://qa.easybusticket.com/" Adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("easyBusLogin"));
        extentTest.info("kullanici qa.easybusticket.com ana sayfaya gider");

        // 2. Anasayfada header bolumunde "Sign In" butonunun gorunurlugu dogrulanir
        VisitorHomepage page = new VisitorHomepage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.buttonLogin.isDisplayed(),"goruntulenemedi");
        extentTest.info("kullanici Sign In butonunun gorunurlugu dogrular");

        // 3. Anasayfada header bolumunde "Sign In" butonu tiklanir
        ReusableMethods.clickWithJS(page.buttonLogin);
        extentTest.info("kullanici Sign In butonunun tiklar");

        // 4. Kullanici sayfanın acildigini dogrular
        String expedtedUrl = "https://qa.easybusticket.com/login";
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuelUrl, expedtedUrl);
        extentTest.pass("Kullanici sayfanın acildigini dogrular");

        // 5. Kullanici acilan sayfada username textbox'in icine gecerli kullanici adini girer
        page.textBoxUsername.sendKeys("deneme");
        extentTest.pass("Kullanici username textbox'in icine gecerli kullanici adini girer");

        // 6. Kullanici acilan sayfada password textbox icine gecerli sifre girer
        page.textBoxPassword.sendKeys("Deneme01.");
        extentTest.pass("Kullanici password textbox icine gecerli sifre girer");

        // 7. Kullanici LogIn buttonuna tiklar
        page.buttonLogin.click();
        extentTest.info("Kullanici Kullanici LogIn buttonuna tiklar");

        // 8. Kullanici acilan sayfanin dashboard sayfasi oldugu dogrulanir
        String expedtedDasboard = "https://qa.easybusticket.com/user/dashboard";
        String actuelDasboard = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuelUrl, expedtedUrl);
        extentTest.pass("Kullanici acilan sayfanin dashboard sayfasi oldugu dogrulanir");


        ReusableMethods.wait(2);

        // 9. Kullanici profilinden cikis yapar
        UserDashboard userPage = new UserDashboard();

        userPage.profile.click();

        userPage.Logout.click();
        extentTest.info("Kullanici profilinden cikis yapar");


        Driver.closeDriver();
        extentTest.info("Sayfayi kapatir");
    }
}