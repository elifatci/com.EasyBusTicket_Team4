package tests.US28_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US28_TC01 {
    @Test
    public void test01(){
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/admin"homepage.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        //Log in with your valid username and password.
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin33");
        adminDashboard.passwordKutusu.sendKeys("123123123");

        //4.Click on "Log in" button
        adminDashboard.loginButonu.click();

        //5.Click on the "Support Requests" menu.
        adminDashboard.supportRequests.click();
        ReusableMethods.waitFor(2);

        //6.Verify that the "All Requests" link is visible.
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(adminDashboard.allRequests.isDisplayed(),"All requests are not visible" );

        //7.Confirm that the "Pending Requests" link is visible.
        softAssert.assertTrue(adminDashboard.pendingRequests.isDisplayed(),"Pending Requests are not visible" );

        //8.Ensure that the "Closed Requests" link is visible.
        softAssert.assertTrue(adminDashboard.closedRequests.isDisplayed(),"Closed Requests are not visible" );

        //9.Validate that the "Answered Requests" link is visible.
        softAssert.assertTrue(adminDashboard.answeredRequests.isDisplayed(),"Answered Requests are not visible");
        softAssert.assertAll();
        Driver.closeDriver();

    }

}
