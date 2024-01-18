package tests.US08_Samet;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US08_TC02___ extends TestBaseRapor {
    @Test
    public void visibilityTest() {
        extentTest=extentReports.createTest("Visibility Testi","Bize ulaşın' sayfasında adres, telefon ve e-posta bilgileri görünür olmalı, telefon ve e-posta öğelerinin aktif olduğu doğrulanmalıdır.");
        //  Navigate to "https://qa.easybusticket.com/contact" which is the Contact page of the site
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));

        // Accept the cookie
        VisitorHomepage homepage = new VisitorHomepage();
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            //  Verify the visibility of the address information on the 'Contact' page
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(homepage.textAddress.isDisplayed());
            extentTest.pass("Verify the visibility of the address information");
            //  Verify the visibility of the phone information on the 'Contact' page
            softAssert.assertTrue(homepage.textContactUs.isDisplayed());
            extentTest.pass("Verify the visibility of the phone information");
            //  Verify the visibility of the email information on the 'Contact' page
            softAssert.assertTrue(homepage.IconEmailUs.isDisplayed());
            extentTest.pass("Verify the visibility of the email information");
            // Verify that the map showing the company's location is displayed
            softAssert.assertTrue(homepage.mapGoogle.isEnabled());
            extentTest.pass("Verify the visibility of the company's location information");
            //  Verify the phone element is active on the 'Contact' page.
            String expectedUrl=Driver.getDriver().getCurrentUrl();
            homepage.textContactUs.click();
            softAssert.assertEquals(expectedUrl,Driver.getDriver().getCurrentUrl(),"Contact Us linki aktif");
            extentTest.pass("Verify the phone element is active on the 'Contact' page.");
            //  Verify the email element is active on the 'Contact' page.
            try {
                homepage.IconEmailUs.click();
            } catch (Exception e) {
                System.out.println("Email Us aktif değil ");
            }
            softAssert.assertNotEquals(expectedUrl,Driver.getDriver().getCurrentUrl(),"Email Us linki yönlendirme yapmadı");
            extentTest.pass("Verify the email element is active on the 'Contact' page.");
            softAssert.assertAll();
            //Close the page
            Driver.getDriver().quit();


        }


    }
}
