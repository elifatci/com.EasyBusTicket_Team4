package tests.US09_Nevfel;

import com.github.javafaker.Faker;
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
import utilities.TestBaseRapor;

public class US09_TC01 extends TestBaseRapor {

    @Test
    public void test01(){
        //1.Browserı açar
        //2.Açılan browser'a "https://qa.easybusticket.com" adresini yazar .
        extentTest=extentReports.createTest("Smoke Test"," Ziyaretci olrak Sign up sayfasında kayıt mümkün olmalı ve \n sayfanın işlevleri düzgün çalışmalı");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("Kullanici anasayfaya gider.");

        //3- Anasayfa görüntülendiğinde çerez izni uyarısını kabul eder.
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButonCookieAccept.click();
        extentTest.info("Anasayfa'da cerez izni uyarısını kabul eder. ");

        //4.Anasayfadan signup buton linkine tıklar.
        visitorHomepage.ButtonSignUp.click();
        extentTest.info("Signup buton linkine tıklar.");

        //5. Sign up sayfaya eriştiğini  SignUp Your Account yazısı ve kayıt formu penceresi ile doğrular.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(visitorHomepage.SignUpYourAccountAndRegisterForm
                .isEnabled(),"SignUp Your Account yazısı ve kayıt formuna erişilemedi!");
        extentTest.pass("Sign up sayfaya eriştiğini  SignUp Your Account yazısı ve\n kayıt formu penceresi ile doğrular.");

        //6.First Name text box'ına  tıklar ve geçerli bir isim girer.
        //7.Last Name text box'ına tıklar ve geçerli bir soyisim girer.
        //8.Mobile butonuna tıklar  ve geçerli bir numara girer.
        //9.Username butonuna tıklar ve geçerli bir usename girer.
        //10.Email  butonuna tıklar ve geçerli bir email adresi girer.
        //11.Password  butonuna tıklar ve geçerli bir password girer.
        //12.ConfirmPassword  butonuna tıklar ve geçerli bir password girer.
        Actions actions=new Actions(Driver.getDriver());
        Faker faker=new Faker();

        String username= faker.name().lastName()+"of123";
        ReusableMethods.wait(2);

        actions.click(visitorHomepage.PlaceholderFirstName)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.country().name())
                .sendKeys(Keys.TAB)
                .sendKeys("222334455")
                .sendKeys(Keys.TAB)
                .sendKeys((username))
                .sendKeys(Keys.TAB)
                .sendKeys("denizzz10@proton.me")
                .sendKeys(Keys.TAB)
                .sendKeys("Testci1.")
                .sendKeys(Keys.TAB)
                .sendKeys("Testci1.")
                .sendKeys().perform();
        extentTest.info(" Kayıt Form penceresindeki Textbox'ları doldurur.");
        ReusableMethods.wait(4);

        //14.Accepting all check box'ını tıklar.
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.clickWithJS(visitorHomepage.CheckListAgree);
        ReusableMethods.wait(2);
        extentTest.info("Accepting all check box'ını tıklar.");

        //15.Signup butonuna tıklar.
        ReusableMethods.clickWithJS(visitorHomepage.ButtonSignUpSignUpPage);
        extentTest.info("Signup butonuna tıklar.");
        ReusableMethods.wait(2);

        //16.Üye olup "https://qa.easybusticket.com/user/dashboard"sayfasına gidildiğini  doğrular.
        String expectedUrl="https://qa.easybusticket.com/user/dashboard";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        ReusableMethods.wait(2);
        softAssert.assertEquals(actualUrl,expectedUrl,"Actual ve expected url'ler aynı değildir!");
        extentTest.pass("Üye olup \"https://qa.easybusticket.com/user/dashboard\"sayfasına gidildiğini  doğrular.");

        softAssert.assertAll();
        ReusableMethods.wait(2);
        //17.Browser'ı kapatır.
        Driver.closeDriver();
        extentTest.info("Browser'ı kapatır.");

    }

}
