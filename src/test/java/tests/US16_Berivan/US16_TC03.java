package tests.US16_Berivan;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US16_TC03 {
    @Test
    public void test01(){
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

        //6.Click on the Action button on one of the displayed requests.
        userDashboard.buttonAction.click();

        //7.Verify that the sender's information of the request is displayed.
        ReusableMethods.clickWithJS(userDashboard.yorumAlani);
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(userDashboard.senderInformation.isDisplayed(),"Sender's information is not displayed");

    }

}
