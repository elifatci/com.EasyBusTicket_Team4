package tests.US28_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US28_TC01 extends TestBaseRapor {
    @Test
    public void test01(){
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/admin"homepage.
        extentTest=extentReports.createTest("Smoke test","It should be verified that the All request, Pending request, Closed request and Answered request links are displayed under the Support Request link in the left menu on the admin dashboard page.");
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("User goes to easyBus home page");

        //Log in with your valid username and password.
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin33");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        extentTest.pass("User can log in with your valid username and password");

        //4.Click on "Log in" button
        adminDashboard.loginButonu.click();
        extentTest.pass("User can click on Log in button");

        //5.Click on the "Support Requests" menu.
        adminDashboard.supportRequests.click();
        ReusableMethods.waitFor(2);
        extentTest.pass("User can click on the Support Requests menu.");

        //6.Verify that the "All Requests" link is visible.
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(adminDashboard.allRequests.isDisplayed(),"All requests are not visible" );
        extentTest.pass("User can verify that the All Requests link is visible.");

        //7.Confirm that the "Pending Requests" link is visible.
        softAssert.assertTrue(adminDashboard.pendingRequests.isDisplayed(),"Pending Requests are not visible" );
        extentTest.pass("User can confirm that the Pending Requests link is visible.");

        //8.Ensure that the "Closed Requests" link is visible.
        softAssert.assertTrue(adminDashboard.closedRequests.isDisplayed(),"Closed Requests are not visible" );
        extentTest.pass("User can ensure that the Closed Requests link is visible.");

        //9.Validate that the "Answered Requests" link is visible.
        softAssert.assertTrue(adminDashboard.answeredRequests.isDisplayed(),"Answered Requests are not visible");
        extentTest.pass("User can validate that the Answered Requests link is visible.");
        softAssert.assertAll();
        Driver.closeDriver();

    }

}
