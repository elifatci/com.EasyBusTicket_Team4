package tests.US28_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US28_TC02 extends TestBaseRapor {
    @Test
    public void test01() {
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/admin"homepage.
        extentTest=extentReports.createTest("Smoke test","All requests should be displayed when clicking on the All Request page in the left menu on the admin dashboard page, the details of the request should be accessible with the action button and the request  should be closed, answered and deleted.");
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
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashboard.allRequests.isDisplayed(), "All requests are not visible");
        extentTest.pass("User can verify that the All Requests link is visible.");

        //7.Click on the "All Requests" link.
        adminDashboard.allRequests.click();
        extentTest.pass("User can click on the All Requests link.");

        //8.Click on the "Action" button next to any request.
        adminDashboard.allRequestsAction.click();
        extentTest.pass("User can click on the Action button next to any request.");

        //9.Verify that the sender's information of the request is displayed.
        softAssert.assertTrue(adminDashboard.senderInformationRequest.isDisplayed(),"the sender's information of the request is NOT displayed");
        extentTest.pass("User can verify that the sender's information of the request is displayed.");

        //10.Confirm that the submission time of the request is displayed.
        softAssert.assertTrue(adminDashboard.timeOfRequest.isDisplayed(),"the submission time of the request is NOT displayed");
        extentTest.pass("User can confirm that the submission time of the request is displayed.");

        //11.Verify that the content of the request message is displayed.
        softAssert.assertTrue(adminDashboard.requestMessage.isDisplayed(),"the content of the request message is NOT displayed");
        extentTest.pass("User can verify that the content of the request message is displayed.");

        //12.Enter the text in the message section.
        adminDashboard.yourMessage.sendKeys("Message is added");
        extentTest.pass("User can enter the text in the message section.");

        //13.Click on the "Reply" button.
        adminDashboard.buttonReply.click();
        extentTest.pass("User can click on the Reply button.");

        //14.Confirm that the reply has been added.
        softAssert.assertTrue(adminDashboard.addedReply.isDisplayed(),"the reply has NOT been added");
        extentTest.pass("User can confirm that the reply has been added.");

        //15.Click on the "Close Ticket" button.
        adminDashboard.buttonCloseTicket.click();
        extentTest.pass("User can click on the Close Ticket button.");

        //16.Verify that the message "Are you sure you want to close this support ticket?" is displayed,
       // then click on the "Close Ticket" button.
        ReusableMethods.waitFor(2);
        extentTest.pass("User can verify that the message Are you sure you want to close this support ticket? is displayed, then click on the \"Close Ticket\" button.");

        softAssert.assertTrue(adminDashboard.textCloseTicket.isDisplayed(),"the message is NOT displayed");
        adminDashboard.closeTicketButton.click();

        //17.Verify that the request label has changed to "Closed."
        String expectedText = "Closed";
        String actualText = adminDashboard.textClosed.getText();
        softAssert.assertEquals(actualText,expectedText,"Expected and actual are not the same");
        extentTest.pass("User can verify that the request label has changed to \"Closed.\"");

        //18.Click on the Delete button to delete the selected request
        adminDashboard.buttonDelete.click();
         ReusableMethods.waitFor(2);
        extentTest.pass("User can click on the Delete button to delete the selected request");

        //19.Verify that the message "Are you sure to delete this?" is displayed, then click on the Delete button.
        softAssert.assertTrue(adminDashboard.textDelete.isDisplayed(),"Text is not displayed");
        adminDashboard.buttonDelete2.click();
        extentTest.pass("User can verify that the message \"Are you sure to delete this?\" is displayed, then click on the Delete button.");
        softAssert.assertAll();

        //Close the browser
        Driver.closeDriver();
    }
}
