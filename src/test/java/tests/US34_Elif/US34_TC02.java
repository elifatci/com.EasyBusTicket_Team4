package tests.US34_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;

public class US34_TC02 {

    @Test
    public void test02(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/admin"
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        // Enter correct username and password
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin31");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        // Click 'login' button
        adminDashboard.loginButonu.click();
        //Click on the username text
        adminDashboard.adminUserLinki.click();
        //Click on the password button
        adminDashboard.passwordButton.click();
        //Click on the password setting button
        adminDashboard.passwordSettingButon.click();
        //Verify password, new password, confirm password textboxs are visible
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminDashboard.passwordText.isDisplayed());
        softAssert.assertTrue(adminDashboard.newPasswordText.isDisplayed());
        softAssert.assertTrue(adminDashboard.confirmPasswordText.isDisplayed());
        //Enter current password in password textbox
        adminDashboard.passwordBox.sendKeys("123123123");
        //Enter new password in new password textbox
        adminDashboard.newPasswordBox.sendKeys("123123123e");
        //Enter new password in confirm password textbox
        adminDashboard.confirmPasswordBox.sendKeys("123123123e");
        //Click on the save changes button
        adminDashboard.saveChangesButton.click();
        //Verify Password changed successfully message is visible
        softAssert.assertTrue(adminDashboard.messagePasswordChanged.isDisplayed());
        //Click on the username text
        adminDashboard.adminUserLinki.click();
        //Click on the logout button
        adminDashboard.logoutButton.click();
        //Verify admin login page is visible
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains("Admin Login"));
        //Close the browser
        Driver.closeDriver();
    }
}
