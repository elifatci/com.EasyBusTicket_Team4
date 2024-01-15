package tests.US02_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US02_TC02 {
    @Test
    public void test01(){
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        //3.These Items should be displayed;
        // Phone Number,
        SoftAssert softAssert = new SoftAssert();
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        softAssert.assertTrue(visitorHomepage.TelNo.isDisplayed());
        // e-mail address,
        softAssert.assertTrue(visitorHomepage.mail.isDisplayed());
        // social media icons
        softAssert.assertTrue(visitorHomepage.twitterIkonu.isDisplayed());
        softAssert.assertTrue(visitorHomepage.instagramIkonu.isDisplayed());
        softAssert.assertTrue(visitorHomepage.youtubeIkonu.isDisplayed());
        softAssert.assertTrue(visitorHomepage.facebookIkonu.isDisplayed());
         //logo,
        softAssert.assertTrue(visitorHomepage.logoEasyBuyTickets.isDisplayed());
        // Home,
        softAssert.assertTrue(visitorHomepage.buttonHome.isDisplayed());
        // About,
        softAssert.assertTrue(visitorHomepage.buttonAbout.isDisplayed());
        // FAQs,
        softAssert.assertTrue(visitorHomepage.buttonFAQs.isDisplayed());
        // Blog,
        softAssert.assertTrue(visitorHomepage.buttonBlog.isDisplayed());
        // Contact
        softAssert.assertTrue(visitorHomepage.buttonContact.isDisplayed());
        // Buy TICKET button
        softAssert.assertTrue(visitorHomepage.buttonBuyTickets.isDisplayed());
        // 4.Close the browser
        Driver.closeDriver();
    }
}
