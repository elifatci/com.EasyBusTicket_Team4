package tests.US08_Samet;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US08_TC04 {
    @Test
    public void emailTetst() {
    // 1 "https://qa.easybusticket.com/contact" adresine gidin
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));
        VisitorHomepage homepage = new VisitorHomepage();
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
    //2 İletişim formundaki 'Name' alanına herhangi bir veri girmeyin.
    //3 Diğer alanlara uygun verileri girin (Email, Konu ve Mesaj).
            ReusableMethods.wait(2);
            homepage.buttonContact.click();
            homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
            homepage.PlaceholderSubject.sendKeys("Subject");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            String contactPageUrl = Driver.getDriver().getCurrentUrl();
            //4 İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            ReusableMethods.wait(2);
      //5 Mesajın iletilemediğini doğrulayın
            SoftAssert softAssert = new SoftAssert();
            String expectedMessage = "Your message has been sent. Thank you for contacting us.";
            softAssert.assertNotEquals(homepage.messageYourmessagehasbeensent, expectedMessage);
     //6 'Name' alanına uygun olmayan veriler girin Diğer alanlara uygun verileri girin.
     //7 İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
            Actions actions = new Actions(Driver.getDriver());
            ReusableMethods.wait(2);

            homepage.buttonContact.click();
            ReusableMethods.wait(2);
            homepage.PlaceholderName.sendKeys("     ");
            homepage.PlaceholderEmail.sendKeys(Keys.CLEAR);
            homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
            homepage.PlaceholderSubject.sendKeys("Konusuz");
            homepage.PlaceholderMessage.sendKeys("This is my wrong message");
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
    //8  Mesajın iletilemediğini doğrulayın
            softAssert.assertEquals(homepage.messageYourmessagehasbeensent.getText(), "The name field is required.");
     //9  Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
            softAssert.assertEquals(contactPageUrl, Driver.getDriver().getCurrentUrl());
     //10  Sayfaya geri dönüldükten sonra 'Name' alanı dışındaki diğer alanların önceki verilerle dolu olduğunu doğrula.
            ReusableMethods.wait(2);
            softAssert.assertEquals(homepage.PlaceholderEmail.getText(), "hjkh@kjhjkh.com");
            softAssert.assertEquals(homepage.PlaceholderSubject.getText(), "Konusuz");
            softAssert.assertEquals(homepage.PlaceholderMessage.getText(), "This is my wrong message");
     //11  İletişim formundaki 'Email' alanına herhangi bir veri girmeyin.
     //12  Diğer alanlara uygun verileri girin
     //13  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
           // ReusableMethods.wait(2);
           // homepage.PlaceholderName.sendKeys("ayse");
           // homepage.PlaceholderEmail.sendKeys(Keys.CLEAR);



    //14  Mesajın iletilemediğini doğrulayın

     //14  'Email' alanına uygun olmayan verileri girin.
     //15  Diğer alanlara uygun verileri girin (Name, Konu ve Mesaj).
     //16  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
     //17  Düğmeye tıklandığında 'Email' alanının altında 'Lütfen e-posta adresine bir "@" işareti ekleyin' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
     //18  'Email' alanına uygun olmayan verileri girin.
     //19  Diğer alanlara uygun verileri girin (Name, Konu ve Mesaj).
     //20  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
     //  Düğmeye tıklandığında 'Email' alanının altında 'Lütfen "@" işaretinden sonra gelen kısmı ekleyin' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
     //  'Email' alanına uygun olmayan verileri girin.
     //  Diğer alanlara uygun verileri girin (Name, Konu ve Mesaj).
     //  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
     //  Düğmeye tıklandığında 'Email' alanının altında 'Lütfen "@" işaretinden sonra gelen kısma "." şeklinde alan adı ekleyin' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
     //  'Subject' alanına herhangi bir veri girmeyin.
     //  Diğer alanlara uygun verileri girin (Name, Email ve Mesaj).
     //  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
     //  Düğmeye tıklandığında 'Subject' alanının altında 'Lütfen bu alanı doldurunuz' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
     //  'Subject' alanına uygun olmayan verileri girin.
     //  Diğer alanlara uygun verileri girin (Name, Email ve Mesaj).
     //  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
     //  Düğmeye tıklandığında, sayfanın sağ üst köşesinde "The subject field is required" (Konu alanı zorunludur) hatası görüntülendiğini doğrula.
     //  Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
     //  Sayfaya geri dönüldükten sonra 'Subject' alanı dışındaki diğer alanların önceki verilerle dolu olduğunu doğrula.
     //  İletişim formundaki 'Message' alanına herhangi bir veri girmeyin.
     //  Diğer alanlara uygun verileri girin (Name, Email ve Konu).
     //  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
     //  Düğmeye tıklandığında 'Message' alanının altında 'Lütfen bu alanı doldurunuz' mesajının görüntülendiğini ve düğmenin etkisiz olduğunu doğrula.
     //  'Message' alanına uygun olmayan verileri girin.
     //  İletişim formundaki 'Send Us Message' adlı düğmeye tıklayın.
     //  Düğmeye tıklandığında, sayfanın sağ üst köşesinde "The message field is required" (Mesaj alanı zorunludur) hatası görüntülendiğini doğrula.
     //  Hata mesajını aldıktan sonra sayfanın 'Contact' sayfasına geri döndüğünü doğrula.
     //  Sayfaya geri dönüldükten sonra 'Message' alanı dışındaki diğer alanların önceki verilerle dolu olduğunu doğrula.
     softAssert.assertAll();
        }
    }
}