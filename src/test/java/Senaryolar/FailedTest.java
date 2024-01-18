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
        ReusableMethods.wait(1);
        adminDashboard.passwordKutusu.sendKeys("Prs12345.");
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        extentTest.info("Logs in with valid username and valid password..");
        // Click on Manage Users link in the left menu.
        ReusableMethods.wait(1);
        adminDashboard.manageUsers.click();
        ReusableMethods.wait(1);
        extentTest.info("Click on Manage Users link in the left menu");
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.clickWithJS(adminDashboard.adminDashboard);
        softAssert.assertTrue(adminDashboard.adminDashboard.getText().contains("Dash"));
        extentTest.pass("Verifies that you are on the Dashboard");
        ReusableMethods.clickWithJS(adminDashboard.emailToAll);
        ReusableMethods.wait(1);
        extentTest.pass("Clicks the Email to All link under Manage Users");
        // Verifies that you have reached the page.
        softAssert.assertTrue(adminDashboard.sendEmailToAllUsersYazisi.isDisplayed());
        extentTest.pass("Verifies that you have reached the page");
        // Verifies that the Subject and Message textboxes are available.
        ReusableMethods.wait(1);
        softAssert.assertTrue(adminDashboard.subjectKutusu.isEnabled());
        softAssert.assertTrue(adminDashboard.messageKutusu.isEnabled());
        ReusableMethods.wait(1);
        extentTest.pass("Verifies that the Subject and Message textboxes are available");
        // Enters the necessary data in the textboxes
        adminDashboard.subjectKutusu.sendKeys("My message");
        adminDashboard.messageKutusu.sendKeys("I forgot what message I was going to write");
        ReusableMethods.wait(2);
        // Clicks the Send Email button.
        ReusableMethods.clickWithJS(adminDashboard.sendEmailButonu);
        extentTest.pass("Enters the necessary data in the textboxes and clicks the Send Email button");
        // Verifies that the e-mail is sent to all users.
        softAssert.assertTrue(adminDashboard.emailUnverifiedUsersYazisi.getText().contains("Succesfull"));
        extentTest.pass("Verifies that the e-mail is sent to all users");
        softAssert.assertAll();
        ReusableMethods.wait(1);
        // Close the browser
        Driver.closeDriver();
        extentTest.info("Close the browser");
    }
}
