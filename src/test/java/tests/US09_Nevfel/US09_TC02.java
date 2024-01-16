package tests.US09_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US09_TC02 {
@Test
    public void test01(){
    //1.Browserı açar
    //2.Açılan browser'a "https://qa.easybusticket.com" adresini yazar .
    Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
    //4- Anasayfa görüntülendiğinde çerez izni uyarısını kabul eder.
    VisitorHomepage visitorHomepage=new VisitorHomepage();
    visitorHomepage.ButonCookieAccept.click();
    //5.Anasayfadan signup buton linkine tıklar.
    visitorHomepage.ButtonSignUp.click();
    //5. Sign up sayfaya eriştiğini  SignUp Your Account yazısı ve kayıt formu penceresi ile doğrular.
    SoftAssert softAssert=new SoftAssert();
    //softAssert.assertTrue(visitorHomepage.signUpYourAccountAndRegisterForm
      //        .isEnabled(),"SignUp Your Account yazısı ve kayıt formuna erişilemedi!");
    softAssert.assertTrue(visitorHomepage.SignUpYourAccountAndRegisterForm
              .isEnabled(),"SignUp Your Account yazısı ve kayıt formuna erişilemedi!");
    //6.First Name text box'ına  tıklar ve geçerli bir isim girer.
    //7.Last Name text box'ına tıklar ve geçerli bir soyisim girer.
    //8.Mobile butonuna tıklar  ve geçerli bir numara girer.
    //9.Username butonuna tıklar ve geçerli bir usename girer.
    //10.Email  butonuna tıklar ve geçerli bir email adresi girer.
    //11.Password  butonuna tıklar ve geçerli bir password girer.
    //12.ConfirmPassword  butonuna tıklar ve geçerli bir password girer.
    Actions actions=new Actions(Driver.getDriver());
    ReusableMethods.wait(2);
    actions.click(visitorHomepage.PlaceholderFirstName)
            .sendKeys("nevfel")
            .sendKeys(Keys.TAB)
            .sendKeys("deniz")
            .sendKeys(Keys.TAB)
            .sendKeys(Keys.TAB)
            .sendKeys("2223334455")
            .sendKeys(Keys.TAB)
            .sendKeys("testcandir")
            .sendKeys(Keys.TAB)
            .sendKeys("testcandir@proton.me")
            .sendKeys(Keys.TAB)
            .sendKeys("Test2.")
            .sendKeys(Keys.TAB)
            .sendKeys("Test2.")
            .sendKeys().perform();
    ReusableMethods.wait(2);
    //13.Country butonuna  tıklar ve dropdown menuden  bir ülke seçer
    Select selectCountry =new Select(visitorHomepage.PlaceholderCountry);
    selectCountry.selectByValue("Canada");
    ReusableMethods.wait(2);
    //14.Accepting all check box'ını tıklar.
    JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
    ReusableMethods.clickWithJS(visitorHomepage.CheckListAgree);
    ReusableMethods.wait(2);
    //15.Signup butonuna tıklar.
    //JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
    ReusableMethods.clickWithJS(visitorHomepage.ButtonSignUpSignUpPage);
    //visitorHomepage.ButtonSignUpSignUpPage.click();
    ReusableMethods.wait(2);
    softAssert.assertTrue(visitorHomepage.nonSignUp.isDisplayed());
    ReusableMethods.wait(2);
    //17.Browser'ı kapatır.
    Driver.closeDriver();

}
}
