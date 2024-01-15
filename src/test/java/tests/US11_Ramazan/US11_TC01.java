package tests.US11_Ramazan;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import org.testng.asserts.SoftAssert;

public class US11_TC01 {
    /*
    US11-Main: As a registered user, I should be able to access all site functions from the dashboard page by clicking on the site logo.
    TC01: I should be able to access the user dashboard page by logging in from the site homepage
    TC02: I should be able to view the site homepage when I click on the site logo on the user dashboard page
    TC03: I should be able to view the elements on the site homepage and verify that the active functions are working actively
    Pre-Condition: The user must have a valid account, username and password. Username: rsarialtin  password: 123Br.
     */

    @Test
    public void test01() throws InterruptedException {
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));

        //Accept the cookie
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        visitorHomepage.ButonCookieAccept.click();

        //Click the SignIn button on the home page
        SoftAssert softAssert = new SoftAssert();
        visitorHomepage.ButtonSignIn.click();


        //Enter username, password and click Log in
        visitorHomepage.textBoxUsername.sendKeys("rsarialtin");
        visitorHomepage.textBoxPassword.sendKeys("123Br.");
        visitorHomepage.buttonLogin.click();

        //Verify you are at user dashboard
        //by URL
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        //by Dashboard text on User Dashboard page
        UserDashboard userDashboard = new UserDashboard();
        softAssert.assertEquals(userDashboard.textDashboard.getText(), "Dashboard");

        //TC02: Verify that navigate to the site homepage when clicked on the site logo in the dashboard page
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].click();", userDashboard.logoElementi);
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")));

        //TC03: Verify that the elements on the site homepage can be seen verify that functions are working actively



        //Close the browser
        Driver.closeDriver();
    }

}
