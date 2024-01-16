package tests.US13_Elif;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US13_TC02 extends TestBaseRapor {
    @Test
    public void test02(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        extentTest=extentReports.createTest("Smoke test","Rezervasyon menüsündeki Bilet Al linki üzerinden bilet satın alma ekranı erisilebilir olmali");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("Kullanici easyBus ana sayfaya gider");
        //Click on 'SignIn' button
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButtonSignIn.click();
        extentTest.info("Kullanici signIn butonuna tiklar");
        // Enter correct username and password
        visitorHomepage.textBoxUsername.sendKeys("elifatci");
        extentTest.info("kullanici gecerli username girer");
        visitorHomepage.textBoxPassword.sendKeys("123Elif_");
        extentTest.info("kullanici gecerli password girer");
        // Click 'login' button
        visitorHomepage.buttonLogin.click();
        extentTest.info("kullanici login butonuna tiklar");
        //Hover over the reservation link
        UserDashboard userDashboard=new UserDashboard();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.headerBooking).perform();
        extentTest.info("kullanici rezervasyon linki uzerine gelir");
        //Click on 'Buy Ticket' link
        userDashboard.LinkbuyTicket.click();
        extentTest.info("kullanici bilet satin al linkine tiklar");
        //Verify 'buy ticket' page is visible
        String actualUrl=Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualUrl.contains("tickets"));
        extentTest.pass("kullanici bilet satin alma sayfasinin gorunur oldugunu dogrular");
        softAssert.assertAll();
        //Close the browser
        Driver.closeDriver();
    }
}
