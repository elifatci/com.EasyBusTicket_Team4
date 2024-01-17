package tests.US12_Suleyman;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US12_TC01 extends TestBaseRapor {
    @Test
    public void test01() throws InterruptedException {
        extentTest = extentReports.createTest("TC01","When I log in as a registered user, I should be able to access the dashboard link user dashboard page " +
                "from the site homepage and refresh the page with the dasboard link.");
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get("https://qa.easybusticket.com/");
        extentTest.info("Navigate to url");
        // 3.Accept the cookie
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        if (visitorHomepage.ButonCookieAccept.isDisplayed() && visitorHomepage.ButonCookieAccept.isEnabled()) {
            visitorHomepage.ButonCookieAccept.click();}
        extentTest.info("Accept the cookie");
        // 4.Click the SignIn button on the home page
        SoftAssert softAssert = new SoftAssert();
        visitorHomepage.ButtonSignIn.click();
        extentTest.pass("Click the SignIn button on the home page");
        // 5.Enter username, password and click Log in
        visitorHomepage.textBoxUsername.sendKeys("solomon");
        visitorHomepage.textBoxPassword.sendKeys("Solomon61.");
        visitorHomepage.buttonLogin.click();
        extentTest.pass("Enter username, password and click Log in");
        // 6.Verify you are at user dashboard by Dashboard text on User Dashboard page
        UserDashboard userDashboard = new UserDashboard();
        softAssert.assertEquals(userDashboard.textDashboard.getText(), "Dashboard");
        extentTest.pass("Verify you are at user dashboard by Dashboard text on User Dashboard page");
        // 7.Verifies that when the sitelog is pressed on the dashboard page, it is on the dashboard page.
        userDashboard.headerDashboard.click();
        softAssert.assertEquals(userDashboard.textDashboard.getText(), "Dashboard");
        softAssert.assertAll();
        extentTest.info("Verifies that when the sitelog is pressed on the dashboard page, it is on the dashboard page.");
        // 8.Close the browser
        Driver.closeDriver();
        extentTest.info("Close the browser");
    }
}
