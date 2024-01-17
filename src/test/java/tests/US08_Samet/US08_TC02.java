package tests.US08_Samet;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US08_TC02 {
    @Test
    public void visibilityTest() {
        //  Navigate to "https://qa.easybusticket.com/contact" which is the Contact page of the site
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));
        // Accept the cookie
        VisitorHomepage homepage = new VisitorHomepage();
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            //  Verify the visibility of the address information on the 'Contact' page
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(homepage.textAddress.isDisplayed());
            //  Verify the visibility of the phone information on the 'Contact' page
            softAssert.assertTrue(homepage.textContactUs.isDisplayed());
            //  Verify the visibility of the email information on the 'Contact' page
            softAssert.assertTrue(homepage.IconEmailUs.isDisplayed());
            // Verify that the map showing the company's location is displayed
            softAssert.assertTrue(homepage.mapGoogle.isEnabled());
            //  Verify the phone element is active on the 'Contact' page.
            String expectedUrl=Driver.getDriver().getCurrentUrl();
            homepage.textContactUs.click();
            softAssert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl());
            //  Verify the email element is active on the 'Contact' page.
            homepage.IconEmailUs.click();
            softAssert.assertNotEquals(expectedUrl,Driver.getDriver().getCurrentUrl());
            softAssert.assertAll();
             //Close the page
             Driver.getDriver().quit();

        }


    }
}
