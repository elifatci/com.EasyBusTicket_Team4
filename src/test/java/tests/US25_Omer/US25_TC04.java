package tests.US25_Omer;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US25_TC04 {
    @Test
    public void testUS25_01() {
        //browser açılır
        //url "https://qa.easybusticket.com/admin"e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        SoftAssert softAssert = new SoftAssert();
        // Doğru kullanıcı adı ve parola girilir.
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin33");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        //login butonuna tıklanır.
        adminDashboard.loginButonu.click();
        //Payment History butonu tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.paymentHistory);
        //Rejected Payment tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.rejectedPayment);
        //https://qa.easybusticket.com/admin/payment/rejected sayfasına yönlendirildiği doğrulanır
        String expectedurl="https://qa.easybusticket.com/admin/payment/rejected";
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedurl,"Succesfullpayment sayfasına yönlendirilmedi");
        ////rejected biletler action butonu tıklanır.
        adminDashboard.paymentHistoryActionLinkii.click();
        //UserdepositinformationText görüntülendiği doğrulanır.
        softAssert.assertTrue(adminDashboard.UserdepositinformationText.isDisplayed(),"bilet yok");
        //driver kapatılır.
        Driver.closeDriver();
        softAssert.assertAll();





    }
}
