package tests.US03_Omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.*;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class US03_TC01 {
    @Test
    public void US03_TC1_AnasayfabodyTesti(){


        //1.Anasayfaya gidiliir.

        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        VisitorHomepage homepage=new VisitorHomepage();

        //2.Cookies kabul edilir.
        homepage.ButonCookieAccept.click();

        //3.anasayfada olduğumuz doğrulanır.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")),"ana sayfada değisliniz");

        //4-Siteye eriştiğimde sunulan olanaklar kısmını ve sunulan olanakları görüntüleyebilmeliyim
        softAssert.assertTrue(homepage.TextWifi.isDisplayed(),"wifi texti gözükmüyor");
        softAssert.assertTrue(homepage.TextPillow.isDisplayed(),"pillow texti gözükmüyor");
        softAssert.assertTrue(homepage.TextWater.isDisplayed(),"Water texti gözükmüyor");
        softAssert.assertTrue(homepage.TextTeaandcoffee.isDisplayed(),"teaandcoffe texti gözükmüyor");


        //5-Simple Steps, Get Your Bus Ticket ,Looking For a Bus?,Select Your Ticket,Pay Your Bill görünür olmalıdır.
        softAssert.assertTrue(homepage.TextLookingforbus.isDisplayed(),"lookingfor bus texti görünmüyor");
        softAssert.assertTrue(homepage.Textselectyourticket.isDisplayed(),"selectyourticket texti görünmüyor");
        softAssert.assertTrue(homepage.Textpayyourbill.isDisplayed(),"pay your bill texti görünmüyor");

        //6.Our Testimonials (yorumlar) kısmında son üç yorum tıklanabilir olamlıdır.
        softAssert.assertTrue(homepage.yorum1butonu.isEnabled(),"yorum1 butonu tıklanabilir değil");
        ReusableMethods.clickWithJS(homepage.yorum2butonu);
        ReusableMethods.wait(2);
        softAssert.assertTrue(homepage.yorum2butonu.isEnabled(),"yorum2 butonu tıklanabilir değil");
        ReusableMethods.clickWithJS(homepage.yorum3butonu);
        ReusableMethods.wait(2);
        softAssert.assertTrue(homepage.yorum3butonu.isEnabled(),"yorum3 butonu tıklanabilir değil");
        ReusableMethods.wait(2);

        //7.Recent Blog Post Eklenen son üç blog yazısı görünür olmalıdır.
        softAssert.assertTrue(homepage.Blogyazisi1.isDisplayed(),"blog yazısı1 görünmüyor");
        softAssert.assertTrue(homepage.Blogyazisi2.isDisplayed(),"blog yazısı2 görünmüyor");
        softAssert.assertTrue(homepage.Blogyazisi3.isDisplayed(),"blog yazısı3 görünmüyor");

        //8.Browser kapatılır.
        Driver.closeDriver();

    }


}
