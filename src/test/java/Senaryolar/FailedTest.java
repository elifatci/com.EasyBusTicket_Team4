package Senaryolar;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class FailedTest extends TestBaseRapor {
    @Test
    public void test01(){
        extentTest = extentReports.createTest("Failed Test");
        // Open the browser.
        // Navigate to url "https://qa.easybusticket.com/admin"
        Driver.getDriver().get("https://qa.easybusticket.com/admin");
        extentTest.info("Goes to home page");
        // Logs in with valid username and valid password.
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin32");
        adminDashboard.passwordKutusu.sendKeys("Prs12345.");
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        extentTest.info("Logs in with valid username and valid password..");
        // Click on Manage Users link in the left menu.
        ReusableMethods.waitFor(4);
        adminDashboard.manageUsers.click();
        ReusableMethods.waitFor(3);
        extentTest.info("Click on Manage Users link in the left menu");
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(adminDashboard.adminDashboard.getText().contains("Dash"));
        extentTest.pass("Verifies that you are on the Dashboard");
        ReusableMethods.waitFor(4);
        ReusableMethods.clickWithJS(adminDashboard.emailToAll);
        ReusableMethods.waitFor(2);
        extentTest.pass("Clicks the Email to All link under Manage Users");
        // Verifies that you have reached the page.
        softAssert.assertTrue(adminDashboard.sendEmailToAllUsersYazisi.isDisplayed());
        ReusableMethods.waitFor(3);
        extentTest.pass("Verifies that you have reached the page");
        // Verifies that the Subject and Message textboxes are available.
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(adminDashboard.subjectKutusu.isEnabled());
        softAssert.assertTrue(adminDashboard.messageKutusu.isEnabled());
        ReusableMethods.waitFor(3);
        extentTest.pass("Verifies that the Subject and Message textboxes are available");
        // Enters the necessary data in the textboxes
        adminDashboard.subjectKutusu.sendKeys("My message");
        ReusableMethods.waitFor(3);
        adminDashboard.messageKutusu.sendKeys("I forgot what message I was going to write");
        ReusableMethods.waitFor(2);
        // Clicks the Send Email button.
        ReusableMethods.clickWithJS(adminDashboard.sendEmailButonu);
        extentTest.pass("Enters the necessary data in the textboxes and clicks the Send Email button");
        ReusableMethods.waitFor(2);
        // Verifies that the e-mail is sent to all users.
        ReusableMethods.waitFor(7);
        softAssert.assertTrue(adminDashboard.emailUnverifiedUsersYazisi.getText().contains("Succesfull"),"The e-mail is not sent to all users.");
        extentTest.pass("Verifies that the e-mail is sent to all users");
        softAssert.assertAll();

        // Close the browser
        Driver.closeDriver();
        extentTest.info("Close the browser");
    }
}
