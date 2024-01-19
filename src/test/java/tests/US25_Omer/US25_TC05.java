package tests.US25_Omer;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US25_TC05 extends TestBaseRapor {
    @Test
    public void testUS25_01() {
        extentTest=extentReports.createTest("Smoke test");
        //browser açılır
        //url "https://qa.easybusticket.com/admin"e gidilir.
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("AdminUrl sayfasina gidilir");
        SoftAssert softAssert = new SoftAssert();
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
        //allpayment(tüm ödemeler) tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.allPayment);
        extentTest.info("All payment butonuna tiklanir");
        //https://qa.easybusticket.com/admin/payment/all sayfasına yönlendirildiği doğrulanır
        String expectedurl="https://qa.easybusticket.com/admin/payment/all";
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedurl,"all payment sayfasına yönlendirilmedi");
        ////birinci bilet için allpayment action butonu tıklanır.
        adminDashboard.paymentHistoryActionLinkii.click();
        //UserdepositinformationText görüntülendiği doğrulanır.
        softAssert.assertTrue(adminDashboard.UserdepositinformationText.isDisplayed(),"bilet yok");
        //sayfada geri dönülür.
        Driver.getDriver().navigate().back();
        //bilet trx no ile bilet araması yapılır.
        String bilettrxno="1MHE29ESB3TG";
        ReusableMethods.clickWithJS(adminDashboard.Trxnumber);
        Actions act=new Actions(Driver.getDriver());
        act.sendKeys(adminDashboard.Trxnumber,"1MHE29ESB3TG");
        act.perform();
        adminDashboard.Trxnumber.sendKeys(bilettrxno);
        adminDashboard.Searchtrxnumber.click();
        //bilet bulunduğu doğrulanır.
        extentTest.info("Bilet bulundugu dogrulanir");
        adminDashboard.paymentHistoryActionLinkii.click();
        softAssert.assertTrue(adminDashboard.UserdepositinformationText.isDisplayed(),"bilet doğrulanamadı");
        // doğru bilet numarası görüntülendiği doğrulanır.
        String actuelbiletno=adminDashboard.TransactionNumber.getText();
        softAssert.assertEquals(actuelbiletno,bilettrxno);

        //driver kapatılır.
        Driver.closeDriver();
        softAssert.assertAll();





    }
}
