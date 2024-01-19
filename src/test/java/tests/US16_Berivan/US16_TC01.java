package tests.US16_Berivan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US16_TC01 extends TestBaseRapor {
    @Test
    public void test01()  {
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/"homepage.
        extentTest=extentReports.createTest("Smoke test","By clicking on the requests link in the Support Request menu, the support history page should be accessible..");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("User goes to easyBus home page");

        //3.Click on the "Sign In" button on the homepage.
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        visitorHomepage.ButtonSignIn.sendKeys(Keys.ENTER);
        extentTest.pass("User can click the Sign In button");


        //4.Sign in with your username and password on the login page
        visitorHomepage.textBoxUsername.sendKeys("bberivansalman@gmail.com");
        visitorHomepage.textBoxPassword.sendKeys("Berivan.2018");
        visitorHomepage.buttonLogin.click();
        extentTest.pass("User can sign in with their username and password on the login page");

        //5.Click on the link for "Requests" under the Support Requests menu.
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.headerSupportRequest.click();
        userDashboard.Requests.click();
        extentTest.pass("User can click on the link for Requests under the Support Requests menu.");

        //6.Confirm that you are on the Support Tickets page.
        SoftAssert softAssert = new SoftAssert();
        String expectedPageText = "Support Tickets";
        String actualPageText = visitorHomepage.textSupportTickets.getText();
        softAssert.assertEquals(actualPageText,expectedPageText,"İstenilen sayfada degilsiniz");
        extentTest.pass("User can confirm that user is on the Support Tickets page");
        softAssert.assertAll();
        Driver.closeDriver();

    }
}
