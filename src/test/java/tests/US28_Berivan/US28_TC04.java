package tests.US28_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US28_TC04 {
    @Test
    public void test01() {
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

        //6.Click on the "Closed Requests" link
        adminDashboard.closedRequests.click();
       // 7.Verify that Closed Requests are visible.
        SoftAssert softAssert = new SoftAssert();
       String expectedUrl = "https://qa.easybusticket.com/admin/tickets/closed";
       String actualUrl = Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Closed requests are NOT visible");

        //8.Click on the "Action" button next to any request.
        adminDashboard.ActionclosedRequests.click();

        //9.Verify that the sender's information of the request is displayed.
        softAssert.assertTrue(adminDashboard.closedSenderInfo.isDisplayed(),"the sender's information of the request is NOT displayed");

        //10.Confirm that the submission time of the request is displayed.
        softAssert.assertTrue(adminDashboard.closedTime.isDisplayed(),"the submission time of the request is NOT displayed");

        //11.Verify that the content of the request message is displayed.
        softAssert.assertTrue(adminDashboard.closedMessage.isDisplayed(),"the content of the request message is NOT displayed");

        //12.Enter the text in the message section.
        adminDashboard.pendingYourMessage.sendKeys("Message is added");

        //13.Click on the "Reply" button.
        adminDashboard.pendingReply.click();

        //14.Confirm that the reply has been added.
        softAssert.assertTrue(adminDashboard.pendingAddedReply.isDisplayed(),"the reply has NOT been added");

        //15.Click on the "Close Ticket" button.
        adminDashboard.pendingCloseTicket.click();

        //16.Verify that the message "Are you sure you want to close this support ticket?" is displayed,
        // then click on the "Close Ticket" button.
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(adminDashboard.pendingTextCloseTicket.isDisplayed(),"the message is NOT displayed");
        adminDashboard.pendingCloseTicketButton.click();

        //17.Verify that the request label has changed to "Closed."
        String expectedText = "Closed";
        String actualText = adminDashboard.pendingTextClosed.getText();
        softAssert.assertEquals(actualText,expectedText,"Expected and actual are not the same");

        //18.Click on the Delete button to delete the selected request
        adminDashboard.pendingDeleteButton.click();

        //19.Verify that the message "Are you sure to delete this?" is displayed, then click on the Delete button.
        ReusableMethods.waitFor(2);
        softAssert.assertTrue(adminDashboard.pendingTextDelete.isDisplayed(),"Text is not displayed");
        adminDashboard.pendingDelete.click();
        softAssert.assertAll();

        Driver.closeDriver();

    }
}
