package tests.US25_Omer;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US25_TC01 {
    @Test public void testUS25_01(){
        //browser açılır
        //url "https://qa.easybusticket.com/admin"e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //Login sayfasına girildiği doğrulanır.
        String expectedTitle="Easy Bus Ticket - Admin Login";
        String actualTitle=Driver.getDriver().getTitle();
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertEquals(actualTitle,expectedTitle,"login sayfası görüntülenemedi");
        // Doğru kullanıcı adı ve parola girilir.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin33");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        //login butonuna tıklanır.
        adminDashboard.loginButonu.click();
        //login sayfasına ulaşıldığı doğrulanır.
        String expectedurl="https://qa.easybusticket.com/admin/dashboard";
        String actuelurl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedurl,actuelurl);
        //Payment History butonu tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.paymentHistory);
        //Admin dashboard sayfasındaki sol menüde bulunan payment history linki ile pending history,Successful History,
        //rejected payment ve All payment linklerini linklerinin görüldüğü doğrulanır.
        softAssert.assertTrue(adminDashboard.pendingPayment.isEnabled());
        softAssert.assertTrue(adminDashboard.successfulPayment.isEnabled());
        softAssert.assertTrue(adminDashboard.rejectedPayment.isEnabled());
        softAssert.assertTrue(adminDashboard.allPayment.isEnabled());
        softAssert.assertAll();
        //driver kapatılır.
        Driver.closeDriver();


    }

}
