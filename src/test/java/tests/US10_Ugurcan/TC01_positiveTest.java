package tests.US10_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01_positiveTest {

    @Test
    public void US_10_positiveTest() {

        // 1. Kullanici "https://qa.easybusticket.com/" Adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("easyBusLogin"));

        // 2. Anasayfada header bolumunde "Sign In" butonunun gorunurlugu dogrulanir
        VisitorHomepage page = new VisitorHomepage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(page.buttonLogin.isDisplayed(),"goruntulenemedi");

        // 3. Anasayfada header bolumunde "Sign In" butonu tiklanir
        ReusableMethods.clickWithJS(page.buttonLogin);

        // 4. Kullanici sayfanın acildigini dogrular
        String expedtedUrl = "https://qa.easybusticket.com/login";
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuelUrl, expedtedUrl);

        // 5. Kullanici acilan sayfada username textbox'in icine gecerli kullanici adini girer
        page.textBoxUsername.sendKeys("deneme");

        // 6. Kullanici acilan sayfada password textbox icine gecerli sifre girer
        page.textBoxPassword.sendKeys("Deneme01.");

        // 7. Kullanici LogIn buttonuna tiklar
        page.buttonLogin.click();

        // 8. Kullanici acilan sayfanin dashboard sayfasi oldugu dogrulanir
        String expedtedDasboard = "https://qa.easybusticket.com/user/dashboard";
        String actuelDasboard = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuelUrl, expedtedUrl);

        ReusableMethods.wait(2);

        // 9. Kullanici profilinden cikis yapar
        UserDashboard userPage = new UserDashboard();

        userPage.profile.click();

        userPage.Logout.click();


        Driver.closeDriver();
    }
}