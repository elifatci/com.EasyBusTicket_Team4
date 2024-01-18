package tests.US20_Nevfel;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US20_TC01 extends TestBaseRapor {
    @Test
    public void test01(){
        //1.Browser açar
        //2."https://qa.easybusticket.com/" anasayfasına gider
        extentTest=extentReports.createTest("Smoke-E2E Test","Login sayfasında Şifremi unuttum linki ile\n şifre değiştirme için gerekli şifre kodunu alabilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("Anasayfaya gidilir.");

        //3- Anasayfa görüntülendiğinde çerez izni uyarısını kabul eder.
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButonCookieAccept.click();
        extentTest.info("Anasayfa'da cerez izni uyarısını kabul eder.");

        //4.Anasayfadan sign in buton linkine tıklar.
        visitorHomepage.ButtonSignIn.click();
        extentTest.info("Sign in buton linkine tıklar.");

        //5.Login sayfasına geldiğini doğrular.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(visitorHomepage.SignUpYourAccountAndRegisterForm
                                             .isDisplayed(),"Signup your account and Register form yazısı görülmedi!");
        extentTest.pass("Login sayfasına geldiğini doğrular.");

        //6.Forgot Password linkine tıklar.
        visitorHomepage.TextForgetPassword.click();
        extentTest.info("Forgot Password linkine tıklar.");
        ReusableMethods.wait(2);

        //7.Forgot Password linkine tıkladığında Reset Password sayfasına ulaştığını  doğrular.
        String expectedResetUrl="https://qa.easybusticket.com/password/reset";
        String actualResetUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualResetUrl,expectedResetUrl,"Url'ler aynı değildir!");
        extentTest.pass("Forgot Password linkine tıkladığında Reset Password sayfasına ulaştığını  doğrular.");

        //8.Select One select butonuna  tıklanır ve emaili seçer.
        Select selectEmail=new Select(visitorHomepage.dropDownSelectOneResetPage);
        selectEmail.selectByValue("email");
        extentTest.info("Select One select butonuna  tıklanır ve emaili seçer.");
        ReusableMethods.wait(2);

        //9.Emaili seçtiğinde  alttaki textbox da email yazısının görüntülendiğini doğrular.
        softAssert.assertTrue(visitorHomepage.emailAddressYazisiResetPage
                                             .isDisplayed(),"Email Address yazısı görüntülenemedi!");
        extentTest.pass("Emaili seçtiğinde  alttaki textbox da email yazısının görüntülendiğini doğrular.");

        //10.Email textbox'ına kayıtlı  Email adresini  girer.
        visitorHomepage.textBoxEmailAddressResetPage.sendKeys("y.nevfel10@tutanota.com");
        extentTest.info("Email textbox'ına kayıtlı  Email adresini  girer.");
        ReusableMethods.wait(2);

        //11.Send Password  Code butonuna  tıklar.
        visitorHomepage.buttonSendPasswordCodeResetPage.click();
        extentTest.info("Send Password  Code butonuna  tıklar.");

        //12."Password reset email sent successfully" yazısı ile  kodun mail adresine gönderildiğini doğrular.
        ReusableMethods.waitForVisibility(visitorHomepage.alertPasswordResetSuccessfullyYazisi,3);
        softAssert.assertTrue(visitorHomepage.alertPasswordResetSuccessfullyYazisi
                  .isDisplayed(),"Password reset email sent successfully yazisi görüntülenemedi!");
        extentTest.pass("Password reset email sent successfully\n yazısı ile  kodun mail adresine gönderildiğini doğrular.");
        ReusableMethods.wait(2);

        //13.Şifre gönderimi gerçekleştikten sonra Account Recovery sayfasını görüntüler.
        String expectedTitle="Easy Bus Ticket - Account Recovery";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Sayfa başlıkları aynı değildir!");
        extentTest.info("Şifre gönderimi gerçekleştikten sonra Account Recovery sayfasını görüntüler.");

        //14.Account Recovery sayfasında Try to send again linkine tıklar.
        visitorHomepage.textTryToSendAgainAccountRecoveryPage.click();
        extentTest.info("Account Recovery sayfasında Try to send again linkine tıklar.");
        ReusableMethods.wait(2);

        //15. Reset Password sayfasına gelindiği doğrular.
        String ExpectedResetUrl="https://qa.easybusticket.com/password/reset";
        String ActualResetUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualResetUrl,expectedResetUrl,"Url'ler aynı değildir!");
        extentTest.pass("Reset Password sayfasına gelindiği doğrular.");
        ReusableMethods.wait(2);

        softAssert.assertAll();

        //16.Browser'ı kapatır.
        Driver.closeDriver();
        extentTest.info("Browser'ı kapatır.");
    }
}
