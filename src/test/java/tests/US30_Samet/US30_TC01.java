package tests.US30_Samet;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class US30_TC01 extends TestBaseRapor {
    @Test
    public void counterTest(){
        extentTest=extentReports.createTest("counterTest","Counter sayfasına ulaşılabildiği doğrulanmalı");
        //  Go the https://qa.easybusticket.com/admin page
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        AdminDashboard pageAdmin = new AdminDashboard();
        extentTest.info("Go the https://qa.easybusticket.com/admin page");
        //  Login as a admin
        pageAdmin.usernameKutusu.sendKeys("admin37");
        pageAdmin.passwordKutusu.sendKeys("123123123");
        pageAdmin.loginButonu.click();
        extentTest.info("Login as a admin");
        //  Verify that the Counter link appears
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(pageAdmin.counter.isDisplayed());
        extentTest.info("Verify that the Counter link appears");
        //  Click the Counter link
        pageAdmin.counter.click();
        //  Verify that you are accessing the Counter page
        softAssert.assertEquals(pageAdmin.allCounterYazisi.getText(), "All Counter");
        extentTest.pass("Click the Counter link and verify that you are accessing the Counter page");
        //  Close the page
        Driver.closeDriver();


    }
}
