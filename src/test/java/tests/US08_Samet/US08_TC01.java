package tests.US08_Samet;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US08_TC01 extends TestBaseRapor {
    @Test
    public void contactTest() {
        extentTest=extentReports.createTest("Contact Testi","İletişim sayfası çalışır durumda olmalı");
        // Navigate to 'https://qa.easybusticket.com/' which is the homapage of the site
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        VisitorHomepage homepage = new VisitorHomepage();
        extentTest.info("https://qa.easybusticket.com/ sayfasına gidilir");
        // Accept the cookie
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            // Verify the visibility of the 'Contact' link in the 'Header' section on the homepage.
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(homepage.buttonContact.isDisplayed());
            extentTest.pass("Verify the visibility of the 'Contact' link ");
            // Click the  'Contact' link in the 'Header' section on the homepage.
            homepage.buttonContact.click();
            extentTest.info("Click the  'Contact' link");
            // Verify that the URL address of the opened page is 'https://qa.easybusticket.com/contact'
            softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa.easybusticket.com/contact");
            extentTest.pass("Verify that the URL address of the opened page is 'https://qa.easybusticket.com/contact");
            softAssert.assertAll();
            // Close the page
            Driver.getDriver().quit();

        }


    }

}
