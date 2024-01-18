package tests.US34_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US34_TC02 extends TestBaseRapor {

    @Test
    public void test02(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/admin"
        extentTest=extentReports.createTest("Smoke test","Admin sayfasindan şifre guncellenmeli, çıkış yapilip login sayfasina gidilebilmeli)");
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Kullanici easyBus Admin ana sayfaya gider");
        // Enter correct username and password
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin31");
        extentTest.info("kullanici gecerli username girer");
        adminDashboard.passwordKutusu.sendKeys("123123123e");
        extentTest.info("kullanici gecerli passwrord girer");
        // Click 'login' button
        adminDashboard.loginButonu.click();
        extentTest.info("kullanici login butonuna tiklar");
        //Click on the username text
        adminDashboard.adminUserLinki.click();
        extentTest.info("kullanici username'ine tiklar");
        //Click on the password button
        adminDashboard.passwordButton.click();
        extentTest.info("kullanici password butonuna tiklar");
        //Click on the password setting button
        adminDashboard.passwordSettingButon.click();
        extentTest.info("kullanici password settings butonuna tiklar");
        //Verify password, new password, confirm password textboxs are visible
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminDashboard.passwordText.isDisplayed());
        extentTest.pass("password yazisinin gorunur oldugunu test eder");
        softAssert.assertTrue(adminDashboard.newPasswordText.isDisplayed());
        extentTest.pass("Newpassword yazisinin gorunur oldugunu test eder");
        softAssert.assertTrue(adminDashboard.confirmPasswordText.isDisplayed());
        extentTest.pass("Confirm password yazisinin gorunur oldugunu test eder");
        //Enter current password in password textbox
        adminDashboard.passwordBox.sendKeys("123123123e");
        extentTest.info("password kutusuna guncel şifre girilir");
        //Enter new password in new password textbox
        adminDashboard.newPasswordBox.sendKeys("123123123");
        extentTest.info("New password kutusuna yeni şifre girilir");
        //Enter new password in confirm password textbox
        adminDashboard.confirmPasswordBox.sendKeys("123123123");
        extentTest.info("Confirm password kutusuna yeni şifre girilir");
        //Click on the save changes button
        adminDashboard.saveChangesButton.click();
        extentTest.info("Save Changes butonuna tiklanir");
        //Verify Password changed successfully message is visible
        softAssert.assertTrue(adminDashboard.messagePasswordChanged.isDisplayed());
        extentTest.pass("Şifre basariyla degistirildi mesajinin gorunur oldugunu test eder");
        //Click on the username text
        adminDashboard.adminUserLinki.click();
        extentTest.info("kullanici username'ine tiklar");
        //Click on the logout button
        adminDashboard.logoutButton.click();
        extentTest.info("logout butonuna tiklar");
        //Verify admin login page is visible
        String actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains("Admin Login"));
        extentTest.pass("Admin giris sayasinin gorunur oldugunu test eder");
        softAssert.assertAll();
        //Close the browser
        Driver.closeDriver();
    }
}
