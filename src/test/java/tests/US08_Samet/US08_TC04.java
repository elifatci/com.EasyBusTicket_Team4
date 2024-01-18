package tests.US08_Samet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US08_TC04 extends TestBaseRapor {
    @Test
    public void emailTetst() {
        extentTest = extentReports.createTest("emailTest","İletişim formundaki alanlara uygun olmayan veri girildiğinde mesaj gönderilmemeli, uygun hata mesajları görüntülenmelidir.");
        // 1 "https://qa.easybusticket.com/contact" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));
        VisitorHomepage homepage = new VisitorHomepage();
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            extentTest.info("https://qa.easybusticket.com/contact sayfasına gidilir");
            //2 İletişim formundaki 'Name' alanına herhangi bir veri girmeyin.
            //3 Diğer alanlara uygun verileri girin (Email, Konu ve Mesaj).
            ReusableMethods.wait(2);
            homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
            homepage.PlaceholderSubject.sendKeys("Subject");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            String contactPageUrl = Driver.getDriver().getCurrentUrl();
            extentTest.info("İletişim formundaki 'Name' alanına herhangi bir veri girmeyin, diğer alanlara uygun verileri girin");
            //4 İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            //5 Mesajın iletilemediğini doğrulayın
            ReusableMethods.wait(2);
            SoftAssert softAssert = new SoftAssert();
            String expectedMessage = "Your message has been sent. Thank you for contacting us.";
            softAssert.assertNotEquals(homepage.messageYourmessagehasbeensent, expectedMessage);
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğini doğrulayın");
            //6 'Name' alanına uygun olmayan veriler girin Diğer alanlara uygun verileri girin.
            ReusableMethods.wait(2);
            homepage.buttonContact.click();
            ReusableMethods.wait(2);
            homepage.PlaceholderName.sendKeys("     ");
            homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
            homepage.PlaceholderSubject.sendKeys("Konusuz");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            extentTest.info("İletişim formundaki 'Name' alanına uygun olmayan veri girin, diğer alanlara uygun verileri girin");
            //7 İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            //8  Mesajın iletilemediğini doğrulayın
            softAssert.assertEquals(homepage.messageYourmessagehasbeensent.getText(), "The name field is required.");
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğini doğrulayın");
            //9  Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
            softAssert.assertEquals(contactPageUrl, Driver.getDriver().getCurrentUrl());
            extentTest.info(" Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrulayın");
            //10  İletişim formundaki 'Email' alanına herhangi bir veri girmeyin, diğer alanlara uygun verileri girin
            ReusableMethods.wait(2);
            homepage.buttonContact.click();
            ReusableMethods.wait(2);
            homepage.PlaceholderName.sendKeys("aslı");
            homepage.PlaceholderSubject.sendKeys("Sağlık");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            extentTest.info("İletişim formundaki 'Email' alanına herhangi bir veri girmeyin, diğer alanlara uygun verileri girin");
            //11  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            //12  Mesajın iletilemediğini doğrulayın
            softAssert.assertNotEquals(homepage.messageYourmessagehasbeensent, expectedMessage);
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğini doğrulayın");
            //13  'Email' alanına uygun olmayan verileri girin, diğer alanlara uygun verileri girin
            ReusableMethods.wait(2);
            homepage.buttonContact.click();
            ReusableMethods.wait(2);
            homepage.PlaceholderName.sendKeys("Mahmut");
            homepage.PlaceholderEmail.sendKeys("gdfg dfg 45645 ");
            homepage.PlaceholderSubject.sendKeys("Konusuz");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            extentTest.info("İletişim formundaki 'Email' alanına uygun olmayan veri girin, diğer alanlara uygun verileri girin");
            //14  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            //15 Mesajın iletilemediğini doğrulayın
            softAssert.assertEquals(contactPageUrl, Driver.getDriver().getCurrentUrl());
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğini doğrulayın");
            //16  'Subject' alanına herhangi bir veri girmeyin, diğer alanlara uygun verileri girin
            ReusableMethods.wait(1);
            homepage.buttonContact.click();
            ReusableMethods.wait(1);
            homepage.PlaceholderName.sendKeys("Mahmut");
            homepage.PlaceholderEmail.sendKeys("gdfg@dgfd.com ");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            extentTest.info("İletişim formundaki 'Subject' alanına herhangi bir veri girmeyin, diğer alanlara uygun verileri girin");
            //17  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            //18 Mesajın iletilemediğini doğrulayın
            softAssert.assertEquals(contactPageUrl, Driver.getDriver().getCurrentUrl());
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğini doğrulayın");
            //19 'Subject' alanına uygun olmayan verileri girin, diğer alanlara uygun verileri girin
            ReusableMethods.wait(2);
            homepage.buttonContact.click();
            ReusableMethods.wait(2);
            homepage.PlaceholderName.sendKeys("Mahmut");
            homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
            homepage.PlaceholderSubject.sendKeys("       ");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            extentTest.info("İletişim formundaki 'Subject' alanına uygun olmayan veri girin, diğer alanlara uygun verileri girin");
            //20  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            //21  Mesajın iletilemediğini ve hata mesajının(The subject field is required.) görüntülendiğini doğrulayın
            softAssert.assertEquals(homepage.messageYourmessagehasbeensent.getText(), "The subject field is required.");
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğinive hata mesajının(The subject field is required.) görüntülendiğini doğrulayın");
            //22  Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
            softAssert.assertEquals(contactPageUrl, Driver.getDriver().getCurrentUrl());
            extentTest.info(" Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrulayın");
            //23  İletişim formundaki 'Message' alanına herhangi bir veri girmeyin, diğer alanlara uygun verileri girin
            ReusableMethods.wait(2);
            homepage.buttonContact.click();
            ReusableMethods.wait(2);
            homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
            homepage.PlaceholderSubject.sendKeys("Subject");
            homepage.PlaceholderName.sendKeys("Mahmut");
            extentTest.info("İletişim formundaki 'Message' alanına herhangi bir veri girmeyin, diğer alanlara uygun verileri girin");
            //24   İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            ReusableMethods.wait(2);
            //25  Mesajın iletilemediğini ve hata mesajının(The message field is required.) görüntülendiğini doğrulayın
            softAssert.assertEquals(homepage.messageYourmessagehasbeensent.getText(), "The message field is required.");
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğinive hata mesajının(The message field is required.) görüntülendiğini doğrulayın");
            //26  'Message' alanına uygun olmayan verileri girin, diğer alanlara uygun verileri girin
            ReusableMethods.wait(2);
            homepage.buttonContact.click();
            ReusableMethods.wait(2);
            homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
            homepage.PlaceholderSubject.sendKeys("Subject");
            homepage.PlaceholderName.sendKeys("Mahmut");
            homepage.PlaceholderMessage.sendKeys("  " );
             extentTest.info("İletişim formundaki 'Message' alanına uygun olmayan veri girin, diğer alanlara uygun verileri girin");
            //27 İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            ReusableMethods.wait(2);
            //28  Mesajın iletilemediğini ve hata mesajının(The message field is required.) görüntülendiğini doğrulayın
            softAssert.assertEquals(homepage.messageYourmessagehasbeensent.getText(), "The message field is required.");
            //29 Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
            softAssert.assertEquals(contactPageUrl, Driver.getDriver().getCurrentUrl());
            extentTest.pass("'Send Us Message' adlı düğmeye tıklayın, mesajın iletilemediğinive hata mesajının(The message field is required.) görüntülendiğini doğrulayın");
            softAssert.assertAll();
            //30 Sayfayı kapat
            Driver.getDriver().quit();
        }
    }
}