package tests.US03_Omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
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
        Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")));

        //4-Siteye eriştiğimde sunulan olanaklar kısmını ve sunulan olanakları görüntüleyebilmeliyim
        Assert.assertTrue(homepage.TextWifi.isDisplayed());
        Assert.assertTrue(homepage.TextPillow.isDisplayed());
        Assert.assertTrue(homepage.TextWater.isDisplayed());
        Assert.assertTrue(homepage.TextTeaandcoffee.isDisplayed());


        //5-Simple Steps, Get Your Bus Ticket ,Looking For a Bus?,Select Your Ticket,Pay Your Bill görünür olmalıdır.
        Assert.assertTrue(homepage.TextLookingforbus.isDisplayed());
        Assert.assertTrue(homepage.Textselectyourticket.isDisplayed());
        Assert.assertTrue(homepage.Textpayyourbill.isDisplayed());

        //6.Our Testimonials (yorumlar) kısmında son üç yorum tıklanabilir olamlıdır.
        Assert.assertTrue(homepage.yorum1butonu.isEnabled());
        ReusableMethods.clickWithJS(homepage.yorum2butonu);
        ReusableMethods.wait(2);
        Assert.assertTrue(homepage.yorum2butonu.isEnabled());
        ReusableMethods.clickWithJS(homepage.yorum3butonu);
        ReusableMethods.wait(2);
        Assert.assertTrue(homepage.yorum3butonu.isEnabled());
        ReusableMethods.wait(2);

        //7.Recent Blog Post Eklenen son üç blog yazısı görünür olmalıdır.
        Assert.assertTrue(homepage.Blogyazisi1.isDisplayed());
        Assert.assertTrue(homepage.Blogyazisi2.isDisplayed());
        Assert.assertTrue(homepage.Blogyazisi3.isDisplayed());

        //8.Browser kapatılır.
        Driver.closeDriver();

    }


}
