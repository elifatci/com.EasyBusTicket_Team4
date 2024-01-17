package tests.US34_Elif;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US34_TC01 extends TestBaseRapor {

    @Test
    public void test01(){

        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/admin"
        extentTest=extentReports.createTest("Smoke test","Admin sayfasinda change password sayfasina erişilebilmeli");
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Kullanici easyBus Admin ana sayfaya gider");
        //Verify that login page is visible successfully
        String expectedTitle="Easy Bus Ticket - Admin Login";
        String actualTitle=Driver.getDriver().getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"login page is not visible");
        extentTest.pass("Login sayfasinin gorunur oldugunu dogrular");
        // Enter correct username and password
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin31");
        extentTest.info("Kullanici username textboxina gecerli username girer");
        adminDashboard.passwordKutusu.sendKeys("123123123e");
        extentTest.info("Kullanici password textboxina gecerli password girer");
        // Click 'login' button
        adminDashboard.loginButonu.click();
        extentTest.info("Kullanici login butonuna tiklar");
        //Verify dashboard page is visible
        actualTitle=Driver.getDriver().getTitle();
        softAssert.assertTrue(actualTitle.contains("dashboard"),"dashboard page is not visible");
        extentTest.pass("Kullanici dashboard sayfasinin gorunur oldugunu dogrular");
        //Click on the username text
        adminDashboard.adminUserLinki.click();
        extentTest.info("Kullanici username textine tiklar");
        //Verify password button is visible
        softAssert.assertTrue(adminDashboard.passwordButton.isDisplayed());
        extentTest.pass("Kullanici password kutusunun gorunur oldugunu dogrular");
        //Click on the password button
        adminDashboard.passwordButton.click();
        extentTest.info("Kullanici password butonuna tiklar");
        //Click on the password setting button
        adminDashboard.passwordSettingButon.click();
        extentTest.info("Kullanici şifre ayarlari butonuna tiklar");
        //Verify password setting page is visible
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertTrue(actualUrl.contains("password"),"password setting page is not visible");
        extentTest.pass("Kullanici şifre ayarlari sayfasinin gorunur oldugunu dogrular");
        softAssert.assertAll();
        //Close the browser
        Driver.closeDriver();

    }


}
