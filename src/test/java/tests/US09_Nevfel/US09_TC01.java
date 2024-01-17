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

public class US09_TC01 {

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
          //      .isEnabled(),"SignUp Your Account yazısı ve kayıt formuna erişilemedi!");
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
        Faker faker=new Faker();

        String password=faker.internet()
               .password(7,9,true,true,true);
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
                .sendKeys("lefven.1@gmail.com")
                .sendKeys(Keys.TAB)
                .sendKeys("Testci1.")
                .sendKeys(Keys.TAB)
                .sendKeys("Testci1.")
                .sendKeys().perform();
        ReusableMethods.wait(4);
        //14.Accepting all check box'ını tıklar.
        JavascriptExecutor jse= (JavascriptExecutor) Driver.getDriver();
        ReusableMethods.clickWithJS(visitorHomepage.CheckListAgree);
        ReusableMethods.wait(2);
        //15.Signup butonuna tıklar.
        visitorHomepage.ButtonSignUpSignUpPage.click();
        ReusableMethods.wait(2);
        //16.Üye olup "https://qa.easybusticket.com/user/dashboard"sayfasına gidildiğini  doğrular.
        String expectedUrl="https://qa.easybusticket.com/user/dashboard";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        ReusableMethods.wait(2);
        softAssert.assertEquals(actualUrl,expectedUrl,"Actual ve expected url'ler aynı değildir!");
        softAssert.assertAll();
        ReusableMethods.wait(2);
        //17.Browser'ı kapatır.
        Driver.closeDriver();

    }

}
