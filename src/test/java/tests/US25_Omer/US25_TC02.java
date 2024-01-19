package tests.US25_Omer;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US25_TC02 extends TestBaseRapor {
    @Test
    public void testUS25_01(){
        extentTest=extentReports.createTest("Smoke test","Sıkca sorulan sorular sayfasına erişilmeli");
        //browser açılır
        //url "https://qa.easybusticket.com/admin"e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("AdminUrl sayfasina gidilir");
        SoftAssert softAssert=new SoftAssert();
        // Doğru kullanıcı adı ve parola girilir.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin33");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        //login butonuna tıklanır.
        adminDashboard.loginButonu.click();
        extentTest.info("Gecerli bilgilerle giris yapilarak login butonuna tiklanir");
        //Payment History butonu tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.paymentHistory);
        extentTest.info("Payment History butonuna tiklanir");
        //Pending Payment butonuna tıklanır
        ReusableMethods.clickWithJS(adminDashboard.pendingPayment);
        extentTest.info("Pending Payment butonuna tiklanir");
        // "https://qa.easybusticket.com/admin/payment/pending" sayfasına yönlendirildiği doğrulanır.
        String expectedrul="https://qa.easybusticket.com/admin/payment/pending";
        String actuelurl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(expectedrul,actuelurl);
        extentTest.pass("Sayfaya erisildigi dogrulanir");
        // pending payment sayfasında ödeme sayfasında ödeme olduğu doğrulanır ,
        softAssert.assertTrue(adminDashboard.paymentHistoryActionLinki.isDisplayed());
        //ödeme detayları tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.paymentHistoryActionLinkii);
        //ödeme detayları içerisinde User Deposit Information yazısı olduğu doğrulanır.
        softAssert.assertTrue(adminDashboard.UserdepositinformationText.isDisplayed(),"bilet depozit bilgileri yazısına ulaşılamadı");
        //tarayıcı kapatılır.
        Driver.closeDriver();
        softAssert.assertAll();



    }
}
