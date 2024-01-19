package tests.US16_Berivan;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US16_TC02 extends TestBaseRapor {
    @Test
    public void test01()  {
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/"homepage.
        extentTest=extentReports.createTest("Smoke test","Subject, Status, Priority, Last Reply information of the items in the list should be displayed.");
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

        //6.Verify that the Subject information is displayed in the support list.
        SoftAssert softAssert = new SoftAssert();
        String expectedTextSubject = "Subject";
        String actualTextSubject = visitorHomepage.textSubject.getText();
        softAssert.assertEquals(actualTextSubject,expectedTextSubject,"İstenilen Subject texti yok");
        extentTest.pass("User can verify that the Subject information is displayed in the support list. ");

        //7.Confirm that the Status information is displayed in the support list.
        String expectedTextStatus = "Status";
        String actualTextStatus = visitorHomepage.textStatus.getText();
        softAssert.assertEquals(actualTextStatus,expectedTextStatus,"İstenilen Status texti yok");
        extentTest.pass("User can confirm that the Status information is displayed in the support list.");

        //8.Verify that the Priority information is displayed in the support list.
        String expectedTextPriority = "Priority";
        String actualTextPriority = visitorHomepage.textPriority.getText();
        softAssert.assertEquals(actualTextPriority,expectedTextPriority,"İstenilen Priority texti yok");
        extentTest.pass("User can verify that the Priority information is displayed in the support list.");

        //9.Confirm that the Last Reply information is displayed in the support list.
        String expectedTextLastReply = "Last Reply";
        String actualTextLastReply = visitorHomepage.textLastReply.getText();
        softAssert.assertEquals(actualTextLastReply,expectedTextLastReply,"İstenilen Last Reply texti yok");
        extentTest.pass("User can confirm that the Last Reply information is displayed in the support list..");

        softAssert.assertAll();
        Driver.closeDriver();

    }
}
