package tests.US01_Suleyman;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US01_TC02 extends TestBaseRapor {


    @Test
    public void test01() {
        extentTest=extentReports.createTest("US01_TC02","When I enter the homepage as a visitor, I should be able to view the elements in the " +
                "header and use the active elements.");
        // 1. Goes to the homepage.
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        extentTest.info("Goes to the homepage.");
        // 2.Accepts cookies.
        if (visitorHomepage.ButonCookieAccept.isDisplayed() && visitorHomepage.ButonCookieAccept.isEnabled())
        {visitorHomepage.ButonCookieAccept.click();}
        extentTest.info("Accepts cookies");
        // 3.Verifies that it is on the homepage.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")), "Ana sayfada değisiliniz");
        extentTest.pass("Verifies that it is on the homepage.");
        // 4.Verifies that Every journey is displayed on the homepage.
        softAssert.assertTrue(visitorHomepage.textEvery.isDisplayed());
        extentTest.pass("Verifies that Every journey is displayed on the homepage");
        softAssert.assertAll();
        // 5.Close the browser
        Driver.closeDriver();
        extentTest.info("Close the browser");
    }
}
