package tests.US13_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US13_TC01 extends TestBaseRapor {

    @Test
    public void test01(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        extentTest=extentReports.createTest("Smoke test","Kayıtlı kullanıcı ad ve şifre ile giriş yaparak kullanıcı kontrol paneline erişilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("Kullanici easyBus ana sayfaya gider");
        //Click on 'SignIn' button
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButtonSignIn.click();
        extentTest.info("Kullanici signIn butonuna tiklar");
        // Enter correct username and password (Doğru username ve şifreyi girin)
        visitorHomepage.textBoxUsername.sendKeys("elifatci");
        extentTest.info("Kullanici username textboxina gecerli username girer");
        visitorHomepage.textBoxPassword.sendKeys("123Elif_");
        extentTest.info("Kullanici password textboxina gecerli password girer");
        // Click 'login' button (Giris yap butonuna tiklayin)
        visitorHomepage.buttonLogin.click();
        extentTest.info("Kullanici login butonuna tiklar");
        //Verify dashboard page is visible
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        extentTest.pass("Kullanici dashboard sayfasinin gorunur oldugunu dogrular");
        //Close the browser
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
