package tests.US13_Elif;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US13_TC02 {
    @Test
    public void test02(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        //Click on 'SignIn' button
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButtonSignIn.click();
        // Enter correct username and password
        visitorHomepage.textBoxUsername.sendKeys("elifatci");
        visitorHomepage.textBoxPassword.sendKeys("123Elif_");
        // Click 'login' button
        visitorHomepage.buttonLogin.click();
        //Hover over the reservation link
        UserDashboard userDashboard=new UserDashboard();
        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.headerBooking).perform();
        //Click on 'Buy Ticket' link
        userDashboard.buyTicket.click();
        //Verify 'buy ticket' page is visible
        String actualUrl=Driver.getDriver().getCurrentUrl();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualUrl.contains("tickets"));
        //Close the browser
        Driver.closeDriver();
    }
}
