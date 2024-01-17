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

public class US08_TC05 {
    @Test
    public void mapTetst() {
        // Go the "https://qa.easybusticket.com/contact" page
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));
        VisitorHomepage homepage = new VisitorHomepage();
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            //  Verify that a map showing the company's location is displayed on the 'Contact' page
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(homepage.mapGoogle.isDisplayed(),"Sayfada harita görünmüyor");
            //  Verify that there is a red marker at the location of the address
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",homepage.PlaceholderSubject);
            ReusableMethods.wait(2);
            softAssert.assertTrue(homepage.addressInMap.getText().contains("Atlanta"),"Haritada Atlanta görünmüyor");
            //  Verify that the '+' button on the map is functional
            WebElement iFrameElementi = Driver.getDriver().findElement(By.tagName("iframe"));
            Driver.getDriver().switchTo().frame(iFrameElementi);
            softAssert.assertTrue(homepage.IconZoomIn.isEnabled(),"Haritada + görünmüyor");
            //  Verify that the '-' button on the map is functional
            softAssert.assertTrue(homepage.IconZoomOut.isEnabled(),"Haritada - görünmüyor");
            //  Verify that the 'Show satellite imagery' button on the map is functional
            Driver.getDriver().switchTo().parentFrame();
            homepage.ImgSatelliteImage.click();
            ReusableMethods.wait(1);
            softAssert.assertTrue(homepage.satellitieImagery.isDisplayed(),"Harita görünümü değişmedi");
            //  Verify that the 'View larger map' button on the map is functional
            String contactPageUrl = Driver.getDriver().getCurrentUrl();
            homepage.TextViewLargerMap.click();
            ReusableMethods.wait(1);
            softAssert.assertNotEquals(Driver.getDriver().getCurrentUrl(), contactPageUrl);
            // Close the page
            Driver.getDriver().close();


        }


    }
}