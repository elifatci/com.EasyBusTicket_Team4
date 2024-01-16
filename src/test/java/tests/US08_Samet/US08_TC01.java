package tests.US08_Samet;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.Driver;
import utilities.ReusableMethods;

public class US08_TC01 {
    @Test
    public void contactTest() {
        // Navigate to 'https://qa.easybusticket.com/' which is the homapage of the site
        Driver.getDriver().get("https://qa.easybusticket.com/");
        VisitorHomepage homepage = new VisitorHomepage();
        // Accept the cookie
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            // Verify the visibility of the 'Contact' link in the 'Header' section on the homepage.
            SoftAssert softAssert = new SoftAssert();
            //softAssert.assertTrue(homepage.ButtonContact.isDisplayed());
            // Click the  'Contact' link in the 'Header' section on the homepage.
            //homepage.ButtonContact.click();
            // Verify that the URL address of the opened page is 'https://qa.easybusticket.com/contact'
            softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa.easybusticket.com/contact");
            ;
            Driver.getDriver().quit();

        }


    }

}
