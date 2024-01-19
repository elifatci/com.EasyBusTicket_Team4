package tests.US16_Berivan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US16_TC03 extends TestBaseRapor {
    @Test
    public void test01(){
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/"homepage.
        extentTest=extentReports.createTest("Smoke test","Details of the past requests can be accessed with the Action button.");
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
        ReusableMethods.waitFor(2);
        userDashboard.headerSupportRequest.click();
        userDashboard.Requests.click();
        extentTest.pass("User can click on the link for Requests under the Support Requests menu.");

        //6.Click on the Action button on one of the displayed requests.
        userDashboard.buttonAction.click();
        extentTest.pass("User can click on the Action button on one of the displayed requests..");

        //7.Verify that the sender's information of the request is displayed.
        ReusableMethods.clickWithJS(userDashboard.yorumAlani);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(userDashboard.senderInformation.isDisplayed(),"Sender's information is not displayed");
        extentTest.pass("User can verify that the sender's information of the request is displayed.");

        //8.Confirm that the message information of the request is displayed.
        softAssert.assertTrue(userDashboard.closedSenderInfo.isDisplayed(),"the message information of the request is not displayed");
        extentTest.pass("User can confirm that the message information of the request is displayed.");

        softAssert.assertAll();
        Driver.closeDriver();

    }

}
