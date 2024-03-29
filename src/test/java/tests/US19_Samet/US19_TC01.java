package tests.US19_Samet;

import jdk.jfr.consumer.RecordedMethod;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US19_TC01 extends TestBaseRapor {
    @Test
    public void profileTetst() {
        extentTest = extentReports.createTest("profileTest","A registered user should be log-out of the system using the logout link in the Profile menu located in the Header section");
        // Go the "https://qa.easybusticket.com" page as a  user
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));
        VisitorHomepage homepage = new VisitorHomepage();
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
            homepage.ButtonSignIn.click();
            homepage.textBoxUsername.sendKeys("Tetaci");
            homepage.textBoxPassword.sendKeys("Sa.1234");
            homepage.buttonLogin.click();
            extentTest.info("Go the \"https://qa.easybusticket.com\" page as a  user");
            // Verify that the Profile menu is visible and active in the Header section.
            UserDashboard dashboardpage = new UserDashboard();
            SoftAssert softAssert = new SoftAssert();
            softAssert.assertTrue(dashboardpage.profile.isDisplayed(),"Dasbordda profile yok");
            extentTest.pass("Verify that the Profile menu is visible and active in the Header section.");
            // Click the Profile menu
            Actions actions = new Actions(Driver.getDriver());
            actions.moveToElement(dashboardpage.profile).perform();
            ReusableMethods.wait(2);
            // Verify that when clicking on the Profile menu, the 'Logout' link is visible in the dropdown menu
            softAssert.assertTrue(dashboardpage.Logout.isDisplayed(),"Dasbordda Logout yok");
            extentTest.pass("Click the Profile menu and verify that when clicking on the Profile menu, the 'Logout' link is visible");
            // Click the Logout link in the Profile menu
            dashboardpage.Logout.click();
            // Verify the user has exited the dashboard
            softAssert.assertNotEquals(Driver.getDriver().getCurrentUrl(), "https://qa.easybusticket.com/user/dashboard");
           extentTest.pass("Click the Logout link in the Profile menu and verify the user has exited the dashboard ");
            // Verify that after logging out, the navigated page is 'https://qa.easybusticket.com/login'
            softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://qa.easybusticket.com/login");
            extentTest.pass("Verify that after logging out, the navigated page is 'https://qa.easybusticket.com/login'");
            softAssert.assertAll();
            // Close the page
            Driver.getDriver().close();

        }
    }
}