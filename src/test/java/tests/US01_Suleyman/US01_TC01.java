package tests.US01_Suleyman;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US01_TC01 extends TestBaseRapor {

    @Test
    public void test01(){
        extentTest=extentReports.createTest("US01","I should be able to access the home page as a visitor.");
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        extentTest.info("Navigate to url");
        Driver.getDriver().get("https://qa.easybusticket.com/");
        VisitorHomepage homepage=new VisitorHomepage();
        // 3.Accept the cookie
        extentTest.info("Accept the cookie");
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        if (visitorHomepage.ButonCookieAccept.isDisplayed() && visitorHomepage.ButonCookieAccept.isEnabled())
        {visitorHomepage.ButonCookieAccept.click();}
        // 4.Confirms that it is on the homepage
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(homepage.logoEasyBuyTickets.isDisplayed(),"Görüntülenemedi");
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")),"Ana sayfada değisiliniz");
        softAssert.assertAll();
        // 5.Close the browser
        extentTest.info("Close the browser");
        Driver.closeDriver();

    }







}
