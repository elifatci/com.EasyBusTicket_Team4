package tests.US13_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US13_TC01 {

    @Test
    public void test01(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        //Click on 'SignIn' button
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButtonSignIn.click();
        //Verify login page is visible
        String actualTitle=Driver.getDriver().getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(actualTitle.contains("login"));
        // Enter correct email address and password
        visitorHomepage.textBoxUsername.sendKeys("elifatci");
        visitorHomepage.textBoxPassword.sendKeys("123Elif_");
        // Click 'login' button
        visitorHomepage.buttonLogin.click();
        //Verify dashboard page is visible
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("dashboard"));
        //Close the browser
        Driver.closeDriver();
    }
}
