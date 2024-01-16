package tests.US06_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US06_TC01 extends TestBaseRapor {
    @Test
    public void test01(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        extentTest=extentReports.createTest("Smoke test","Sıkca sorulan sorular sayfasına erişilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("Kullanici easyBus ana sayfaya gider");
        //Verify that home page is visible successfully
        String expectedTitle="Easy Bus Ticket - Home";
        String actualTitle=Driver.getDriver().getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"homepage is not visible");
        extentTest.pass("Kullanici easyBus ana sayfasinin gorunur oldugunu dogrular");
        //Click on 'FAQs' link
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.buttonFAQs.click();
        extentTest.info("Kullanici sıkca sorulan sorular butonuna tiklar");
        //Verify that FAQs page is visible successfully
        expectedTitle="Easy Bus Ticket - FAQs";
        softAssert.assertTrue(Driver.getDriver().getTitle().equals(expectedTitle));
        extentTest.pass("Kullanici FAQs sayfasinin goruntulendigini dogrular");
        softAssert.assertAll();
        //Close the browser
        Driver.closeDriver();
    }
}
