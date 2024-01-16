package tests.US12_Suleyman;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US12_TC01 {
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
        visitorHomepage.textBoxUsername.sendKeys("solomon");
        visitorHomepage.textBoxPassword.sendKeys("Solomon61.");
        visitorHomepage.buttonLogin.click();

        //Verify you are at user dashboard
        //by URL
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        //by Dashboard text on User Dashboard page
        UserDashboard userDashboard = new UserDashboard();
        softAssert.assertEquals(userDashboard.textDashboard.getText(), "Dashboard");


}}
