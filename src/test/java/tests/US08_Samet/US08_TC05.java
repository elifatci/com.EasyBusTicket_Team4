package tests.US08_Samet;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US08_TC05 extends TestBaseRapor {
    @Test
    public void mapTetst() {
        extentTest = extentReports.createTest("mapTest","Şirketin konumunu gösteren bir harita 'İletişim' sayfasında görüntülenebilmelidir.");
        // Go the "https://qa.easybusticket.com/contact" page
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));
        VisitorHomepage homepage = new VisitorHomepage();
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            extentTest.info("https://qa.easybusticket.com/contact sayfasına gidilir");
            //  Verify that a map showing the company's location is displayed on the 'Contact' page
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(homepage.mapGoogle.isDisplayed(),"Sayfada harita görünmüyor");
            extentTest.pass("Verify that a map showing the company's location is displayed on the 'Contact' page");
            // Close the page
            Driver.getDriver().close();


        }


    }
}