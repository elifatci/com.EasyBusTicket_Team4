package tests.US02_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US02_TC02 extends TestBaseRapor {
    @Test
    public void test01 (){
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        extentTest=extentReports.createTest("Smoke test","The items in header section should be displayed successfully");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("User goes to easyBus home page");
        //3.These Items should be displayed;
        // Phone Number,
        SoftAssert softAssert = new SoftAssert();
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        softAssert.assertTrue(visitorHomepage.TelNo.isDisplayed());
        extentTest.pass("User verifies that the phone number is visible");
        // e-mail address,
        softAssert.assertTrue(visitorHomepage.mail.isDisplayed());
        extentTest.pass("User verifies that the mail is visible");
        // social media icons
        softAssert.assertTrue(visitorHomepage.twitterIkonu.isDisplayed());
        softAssert.assertTrue(visitorHomepage.instagramIkonu.isDisplayed());
        softAssert.assertTrue(visitorHomepage.youtubeIkonu.isDisplayed());
        softAssert.assertTrue(visitorHomepage.facebookIkonu.isDisplayed());
        extentTest.pass("User verifies that the social media icons are visible");
         //logo,
        softAssert.assertTrue(visitorHomepage.logoEasyBuyTickets.isDisplayed());
        extentTest.pass("User verifies that the logo is visible");
        // Home,
        softAssert.assertTrue(visitorHomepage.buttonHome.isDisplayed());
        extentTest.pass("User verifies that the easyBus home link is visible");
        // About,
        softAssert.assertTrue(visitorHomepage.buttonAbout.isDisplayed());
        extentTest.pass("User verifies that the easyBus about link is visible");
        // FAQs,
        softAssert.assertTrue(visitorHomepage.buttonFAQs.isDisplayed());
        extentTest.pass("User verifies that the easyBus FAQs link is visible");
        // Blog,
        softAssert.assertTrue(visitorHomepage.buttonBlog.isDisplayed());
        extentTest.pass("User verifies that the easyBus Blog link is visible");
        // Contact
        softAssert.assertTrue(visitorHomepage.buttonContact.isDisplayed());
        extentTest.pass("User verifies that the easyBus Contact link is visible");
        // Buy TICKET button
        softAssert.assertTrue(visitorHomepage.buttonBuyTickets.isDisplayed());
        extentTest.pass("User verifies that the easyBus Buy Tickets link is visible");
        // 4.Close the browser
        Driver.closeDriver();
    }
}
