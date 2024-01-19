package tests.US02_Berivan;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US02_TC01 extends TestBaseRapor {
    @Test
    public void test01(){
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        extentTest=extentReports.createTest("Smoke test","The header section should be displayed successfully");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("User goes to easyBus home page");

        // 3.Verify that header section is displayed successfully
        SoftAssert softAssert = new SoftAssert();
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        softAssert.assertTrue(visitorHomepage.headerTop.isDisplayed());
        softAssert.assertTrue(visitorHomepage.headerButtom.isDisplayed());
        extentTest.pass("User verifies that the easyBus home page is visible");
        //4.Close the browser
        Driver.closeDriver();



    }
}
