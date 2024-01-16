package tests.US25_Omer;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US25_TC02 {
    @Test
    public void testUS25_01(){
        //browser açılır
        //url "https://qa.easybusticket.com/admin"e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        SoftAssert softAssert=new SoftAssert();
        // Doğru kullanıcı adı ve parola girilir.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin33");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        //login butonuna tıklanır.
        adminDashboard.loginButonu.click();
        //Payment History butonu tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.paymentHistory);
        //Pending Payment butonuna tıklanır
        ReusableMethods.clickWithJS(adminDashboard.pendingPayment);
        // "https://qa.easybusticket.com/admin/payment/pending" sayfasına yönlendirildiği doğrulanır.
        String expectedrul="https://qa.easybusticket.com/admin/payment/pending";
        String actuelurl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedrul,actuelurl);
        // pending payment sayfasında ödeme sayfasında ödeme olduğu doğrulanır ,
        softAssert.assertTrue(adminDashboard.paymentHistoryActionLinki.isDisplayed());
        //ödeme detayları tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.paymentHistoryActionLinki);





        softAssert.assertAll();



    }
}
