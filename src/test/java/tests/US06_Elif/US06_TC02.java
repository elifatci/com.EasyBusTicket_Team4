package tests.US06_Elif;

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

public class US06_TC02 extends TestBaseRapor {

    @Test
    public void test02(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/" (Url'e gidin)
        extentTest=extentReports.createTest("Smoke test","Sıkca sorulan sorular sayfasindaki soru ve cevaplar goruntulenmeli");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("Kullanici easyBus ana sayfaya gider");
        //Click on 'FAQs' link
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        visitorHomepage.ButonCookieAccept.click();
        extentTest.info("Kullanici cikan cookie'yi kabul eder");
        js.executeScript("arguments[0].click();",visitorHomepage.buttonFAQs);
        extentTest.info("Kullanici FAQs butonuna tiklar");
        //Click on 'What is EasyBusTicket, and what services does it provide?' textbox
        Actions actions=new Actions(Driver.getDriver());
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        js.executeScript("arguments[0].click();",visitorHomepage.textFirstQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'EasyBusTicket nedir ve hangi hizmetleri sağlar?'sorusuna tiklar");
        //Verify that the answer is visible
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(visitorHomepage.textFirstAnswer.isDisplayed(),"the answer is not visible");
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'How can I cancel a ticket, and is there a fee for cancellation?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textSecondQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'Bileti nasıl iptal edebilirim, iptal ücreti var mı?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textSecondAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'What are the in-bus services provided?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textThirdQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'Otobüs içi hizmetler nelerdir?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textThirdAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'How can I reach customer services?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textFourthQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'Müşteri hizmetlerine nasıl ulaşabilirim?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textFourthAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'Can I make changes to my tickets?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textFifthQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'Biletlerimde değişiklik yapabilir miyim?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textFifthAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'Where can I find information about departure times?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textSixthQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kalkış saatleri hakkında bilgiyi nereden bulabilirim?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textSixthAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'Is it possible to use the EasyBusTicket app?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textSeventhQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'EasyBusTicket uygulamasını kullanmak mümkün mü?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textSeventhAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'How can I purchase a ticket?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textEighthQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'Nasıl bilet satın alabilirim?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textEighthAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'How long does the refund process take?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textNinethQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Kullanici 'İade süreci ne kadar sürer?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textNinethAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'What is the Best Price Guarantee at EasyBusTicket?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textTenthQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("EasyBusTicket'ta En İyi Fiyat Garantisi Nedir?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textTenthAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'How do Cashback and special offers work?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textEleventhQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Cashback ve özel teklifler nasıl çalışır?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textEleventhAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'What payment methods are accepted?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textTwelvethQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Hangi ödeme yöntemleri kabul ediliyor?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textTwelvethAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        //Click on 'What is the baggage policy during travel?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textThirteenthQuestion);
        ReusableMethods.waitFor(2);
        extentTest.info("Seyahat sırasında bagaj politikası nedir?'sorusuna tiklar");
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textThirteenthAnswer.isDisplayed());
        extentTest.info("Cevabin gorunur oldugu dogrulanir");
        softAssert.assertAll();
        //Close the browser
        Driver.closeDriver();
    }
}
