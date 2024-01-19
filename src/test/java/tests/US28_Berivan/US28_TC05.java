package tests.US28_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US28_TC05 extends TestBaseRapor {
    @Test
    public void test01() {
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/admin"homepage.
        extentTest=extentReports.createTest("Smoke test","On the Answered Requests page, which can be found on the left menu of the dashboard page, the Admin should be able to view all answered requests. I should also be able to access the details of a request through the action buttons such as Close, Reply, and Delete.");
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

        //6.Click on the "Answered Requests" link
        adminDashboard.answeredRequests.click();
        extentTest.pass("User can click on the \"Answered Requests\" link");

        // 7.Verify that Answered Requests are visible.
        SoftAssert softAssert = new SoftAssert();
        String expectedUrl = "https://qa.easybusticket.com/admin/tickets/answered";
        String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Closed requests are NOT visible");
        extentTest.pass("User can verify that Answered Requests are visible.");

        //8.Click on the "Action" button next to any request.
        adminDashboard.ActionclosedRequests.click();
        extentTest.pass("User can click on the Action button next to any request.");

        //9.Verify that the sender's information of the request is displayed.
        softAssert.assertTrue(adminDashboard.closedSenderInfo.isDisplayed(),"the sender's information of the request is NOT displayed");
        extentTest.pass("User can verify that the sender's information of the request is displayed.");

        //10.Confirm that the submission time of the request is displayed.
        softAssert.assertTrue(adminDashboard.closedTime.isDisplayed(),"the submission time of the request is NOT displayed");
        extentTest.pass("User can confirm that the submission time of the request is displayed.");

        //11.Verify that the content of the request message is displayed.
        softAssert.assertTrue(adminDashboard.closedMessage.isDisplayed(),"the content of the request message is NOT displayed");
        extentTest.pass("User can verify that the content of the request message is displayed.");

        //12.Enter the text in the message section.
        adminDashboard.pendingYourMessage.sendKeys("Message is added");
        extentTest.pass("User can enter the text in the message section.");

        //13.Click on the "Reply" button.
        adminDashboard.pendingReply.click();
        extentTest.pass("User can click on the Reply button.");

        //14.Confirm that the reply has been added.
        softAssert.assertTrue(adminDashboard.pendingAddedReply.isDisplayed(),"the reply has NOT been added");
        extentTest.pass("User can confirm that the reply has been added.");

        //15.Click on the "Close Ticket" button.
        adminDashboard.pendingCloseTicket.click();
        extentTest.pass("User can click on the Close Ticket button.");

        //16.Verify that the message "Are you sure you want to close this support ticket?" is displayed,
        // then click on the "Close Ticket" button.
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(adminDashboard.pendingTextCloseTicket.isDisplayed(),"the message is NOT displayed");
        adminDashboard.pendingCloseTicketButton.click();
        extentTest.pass("User can verify that the message Are you sure you want to close this support ticket? is displayed, then click on the \"Close Ticket\" button.");

        //17.Verify that the request label has changed to "Closed."
        String expectedText = "Closed";
        String actualText = adminDashboard.pendingTextClosed.getText();
        softAssert.assertEquals(actualText,expectedText,"Expected and actual are not the same");
        extentTest.pass("User can verify that the request label has changed to \"Closed.\"");

        //18.Click on the Delete button to delete the selected request
        adminDashboard.pendingDeleteButton.click();
        extentTest.pass("User can click on the Delete button to delete the selected request");

        //19.Verify that the message "Are you sure to delete this?" is displayed, then click on the Delete button.
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(adminDashboard.pendingTextDelete.isDisplayed(),"Text is not displayed");
        adminDashboard.pendingDelete.click();
        extentTest.pass("User can verify that the message \"Are you sure to delete this?\" is displayed, then click on the Delete button.");

        softAssert.assertAll();

        Driver.closeDriver();

    }
}
