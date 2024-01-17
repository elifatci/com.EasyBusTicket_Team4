package tests.US20_Nevfel;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US20_TC02 {
    @Test
    public void test02(){
        //1.Browser açar
        //2."https://qa.easybusticket.com/" anasayfasına gider
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));

        //3- Anasayfa görüntülendiğinde çerez izni uyarısını kabul eder.
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButonCookieAccept.click();

        //3.Anasayfadan sign in buton linkine tıklar.
        visitorHomepage.ButtonSignIn.click();

        //4.Login sayfasına geldiğini doğrular.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(visitorHomepage.SignUpYourAccountAndRegisterForm
                                             .isDisplayed(),"Signup your account and Register form yazısı görülmedi!");

        //5.Forgot Password linkine tıklar.
        visitorHomepage.TextForgetPassword.click();
        ReusableMethods.wait(2);

        //6.Forgot Password linkine tıkladığında Reset Password sayfasına ulaştığını  doğrular.
        String expectedResetUrl="https://qa.easybusticket.com/password/reset";
        String actualResetUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualResetUrl,expectedResetUrl,"Url'ler aynı değildir!");

        //7.Select One select butonuna  tıklanır ve Username'i  seçer.
        Select selectUsername=new Select(visitorHomepage.dropDownSelectOneResetPage);
        selectUsername.selectByValue("username");
        ReusableMethods.wait(2);

        //8.Username seçtiğinde  alttaki textbox da username  yazısının görüntülendiğini doğrular.
        softAssert.assertTrue(visitorHomepage.usernameYazisiResetPage
                  .isDisplayed(),"Username  yazısı görüntülenemedi!");

        //9.Username  textbox'ına kayıtlı username'i  girer.
        visitorHomepage.textBoxUsernameResetPage.sendKeys("nevfel");

        ReusableMethods.wait(2);
        //10.Send Password  Code butonuna  tıklar.
        visitorHomepage.buttonSendPasswordCodeResetPage.click();

        //11."Password reset email sent successfully" yazısı ile  kodun mail adresine gönderildiğini doğrular.
      ReusableMethods.waitForVisibility(visitorHomepage.alertPasswordResetSuccessfullyYazisi,4);
        softAssert.assertTrue(visitorHomepage.alertPasswordResetSuccessfullyYazisi
                  .isDisplayed(),"Password reset email sent successfully yazısı görüntülenemedi");
        ReusableMethods.wait(2);

        //12.Şifre gönderimi gerçekleştikten sonra Account Recovery sayfasını görüntüler.
        String expectedTitle="Easy Bus Ticket - Account Recovery";
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertEquals(actualTitle,expectedTitle,"Sayfa başlıkları aynı değildir!");

        //13.Account Recovery sayfasında Try to send again linkine tıklar.
        visitorHomepage.textTryToSendAgainAccountRecoveryPage.click();
        ReusableMethods.wait(2);

        //15. Reset Password sayfasına gelindiği doğrulanır
        String ExpectedResetUrl="https://qa.easybusticket.com/password/reset";
        String ActualResetUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualResetUrl,expectedResetUrl,"Url'ler aynı değildir!");
        ReusableMethods.wait(2);

        softAssert.assertAll();

        //16.Browser'ı kapatır.
        Driver.closeDriver();
    }
}
