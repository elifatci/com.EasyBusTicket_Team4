package tests.US16_Berivan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US16_TC01 {
    @Test
    public void test01()  {
        //1.Launch Browser
        //2.Navigate to url "https://www.qa.easybusticket.com/"homepage.
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));

        //3.Click on the "Sign In" button on the homepage.
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        visitorHomepage.ButtonSignIn.sendKeys(Keys.ENTER);

        //4.Sign in with your username and password on the login page
        visitorHomepage.textBoxUsername.sendKeys("bberivansalman@gmail.com");
        visitorHomepage.textBoxPassword.sendKeys("Berivan.2018");
        visitorHomepage.buttonLogin.click();

        //5.Click on the link for "Requests" under the Support Requests menu.
        UserDashboard userDashboard = new UserDashboard();
        userDashboard.headerSupportRequest.click();
        userDashboard.Requests.click();

        //6.Confirm that you are on the Support Tickets page.
        SoftAssert softAssert = new SoftAssert();
        String expectedPageText = "Support Tickets";
        String actualPageText = visitorHomepage.textSupportTickets.getText();
        softAssert.assertEquals(actualPageText,expectedPageText,"İstenilen sayfada degilsiniz");
        softAssert.assertAll();











    }
}
