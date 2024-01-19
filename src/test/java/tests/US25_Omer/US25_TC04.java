package tests.US25_Omer;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US25_TC04 extends TestBaseRapor {
    @Test
    public void testUS25_01() {
        extentTest=extentReports.createTest("Smoke test");
        //browser açılır
        //url "https://qa.easybusticket.com/admin"e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        SoftAssert softAssert = new SoftAssert();
        extentTest.info("AdminUrl sayfasina gidilir");
        // Doğru kullanıcı adı ve parola girilir.
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin33");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        //login butonuna tıklanır.
        adminDashboard.loginButonu.click();
        extentTest.info("Gecerli bilgilerle giris yapilarak login butonuna tiklanir");
        //Payment History butonu tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.paymentHistory);
        extentTest.info("Payment History butonuna tiklanir");
        //Rejected Payment tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.rejectedPayment);
        extentTest.info("Rejected payment butonuna tiklanir");
        //https://qa.easybusticket.com/admin/payment/rejected sayfasına yönlendirildiği doğrulanır
        String expectedurl="https://qa.easybusticket.com/admin/payment/rejected";
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedurl,"Succesfullpayment sayfasına yönlendirilmedi");
        extentTest.pass("Sayfaya erisildigi dogrulanir");
        ////rejected biletler action butonu tıklanır.
        adminDashboard.paymentHistoryActionLinkii.click();
        //UserdepositinformationText görüntülendiği doğrulanır.
        softAssert.assertTrue(adminDashboard.UserdepositinformationText.isDisplayed(),"bilet yok");
        //driver kapatılır.
        Driver.closeDriver();
        softAssert.assertAll();





    }
}
