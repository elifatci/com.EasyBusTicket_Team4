package tests.US28_Berivan;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US28_TC02 {
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

        //6.Verify that the "All Requests" link is visible.
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashboard.allRequests.isDisplayed(), "All requests are not visible");

        //7.Click on the "All Requests" link.
        adminDashboard.allRequests.click();

        //8.Click on the "Action" button next to any request.
        adminDashboard.allRequestsAction.click();

        //9.Verify that the sender's information of the request is displayed.
        softAssert.assertTrue(adminDashboard.senderInformationRequest.isDisplayed(),"the sender's information of the request is NOT displayed");

        //10.Confirm that the submission time of the request is displayed.
        softAssert.assertTrue(adminDashboard.timeOfRequest.isDisplayed(),"the submission time of the request is NOT displayed");

        //11.Verify that the content of the request message is displayed.
        softAssert.assertTrue(adminDashboard.requestMessage.isDisplayed(),"the content of the request message is NOT displayed");

        //12.Enter the text in the message section.
        adminDashboard.yourMessage.sendKeys("Message is added");

        //13.Click on the "Reply" button.
        adminDashboard.buttonReply.click();

        //14.Confirm that the reply has been added.
        softAssert.assertTrue(adminDashboard.addedReply.isDisplayed(),"the reply has NOT been added");

        //15.Click on the "Close Ticket" button.
        adminDashboard.buttonCloseTicket.click();

        //16.Verify that the message "Are you sure you want to close this support ticket?" is displayed,
       // then click on the "Close Ticket" button.
        ReusableMethods.waitFor(2);

        softAssert.assertTrue(adminDashboard.textCloseTicket.isDisplayed(),"the message is NOT displayed");
        adminDashboard.closeTicketButton.click();

        //17.Verify that the request label has changed to "Closed."
        String expectedText = "Closed";
        String actualText = adminDashboard.textClosed.getText();
        softAssert.assertEquals(actualText,expectedText,"Expected and actual are not the same");

        //18.Click on the Delete button to delete the selected request
        adminDashboard.buttonDelete.click();
         ReusableMethods.waitFor(2);
        //19.Verify that the message "Are you sure to delete this?" is displayed, then click on the Delete button.
        softAssert.assertTrue(adminDashboard.textDelete.isDisplayed(),"Text is not displayed");
        adminDashboard.buttonDelete2.click();
        softAssert.assertAll();

        //Close the browser
        Driver.closeDriver();
    }
}
