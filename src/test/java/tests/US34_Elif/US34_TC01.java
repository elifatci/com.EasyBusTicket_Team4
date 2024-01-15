package tests.US34_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;

public class US34_TC01 {

    @Test
    public void test01(){

        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/admin"
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Verify that login page is visible successfully
        String expectedTitle="Easy Bus Ticket - Admin Login";
        String actualTitle=Driver.getDriver().getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"login page is not visible");
        // Enter correct username and password
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin31");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        // Click 'login' button
        adminDashboard.loginButonu.click();
        //Verify dashboard page is visible
        actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains("dashboard"),"dashboard page is not visible");
        //Click on the username text
        adminDashboard.adminUserLinki.click();
        //Verify password button is visible
        softAssert.assertTrue(adminDashboard.passwordButton.isDisplayed());
        //Click on the password button
        adminDashboard.passwordButton.click();
        //Click on the password setting button
        adminDashboard.passwordSettingButon.click();
        //Verify password setting page is visible
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("password"),"password setting page is not visible");
        //Close the browser
        Driver.closeDriver();

    }


}
