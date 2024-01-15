package tests.US06_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US06_TC01 {
    @Test
    public void test01(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        //Verify that home page is visible successfully
        String expectedTitle=" Easy Bus Ticket - Home";
        String actualTitle=Driver.getDriver().getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"homepage is not visible");
        //Click on 'FAQs' link
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.buttonFAQs.click();
        //Verify that FAQs page is visible successfully
        expectedTitle=" Easy Bus Ticket - FAQs";
        softAssert.assertTrue(Driver.getDriver().getTitle().equals(expectedTitle));
        //Close the browser
        Driver.closeDriver();
    }
}
