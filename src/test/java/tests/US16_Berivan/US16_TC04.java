package tests.US16_Berivan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.Duration;

public class US16_TC04 {
    @Test
    public void test01() {
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

        //6- Confirm that there is a "New Ticket" button on the opened page
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(userDashboard.buttonNewTicket.isDisplayed(), "New ticket button is not displayed");

        //7- Click on the "New Ticket" button.
        userDashboard.buttonNewTicket.click();

        //8- Fill in the necessary fields and click on the "Submit" button
        ReusableMethods.clickWithJS(userDashboard.Name);
        userDashboard.Subject.sendKeys("Ticket");
        userDashboard.messageSection.sendKeys("I have a message");
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(userDashboard.submitButtonu);
        softAssert.assertAll();
        Driver.closeDriver();
    }
}
