package tests.US02_Berivan;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US02_TC01 {
    @Test
    public void test01(){
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        // 3.Verify that header section is displayed successfully
        SoftAssert softAssert = new SoftAssert();
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        softAssert.assertTrue(visitorHomepage.headerTop.isDisplayed());
        softAssert.assertTrue(visitorHomepage.headerButtom.isDisplayed());
        //4.Close the browser
        Driver.closeDriver();



    }
}
