package tests.US25_Omer;

import org.openqa.selenium.interactions.Actions;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;


public class US25_TC03 {

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
        //Succesfullpayment linki tıklanır.
        ReusableMethods.clickWithJS(adminDashboard.successfulPayment);
        // https://qa.easybusticket.com/admin/payment/successful sayfasında olduğumuz doğrulanır
        String expectedurl="https://qa.easybusticket.com/admin/payment/successful";
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),expectedurl,"Succesfullpayment sayfasına yönlendirilmedi");
        //ödenmiş biletler action butonu tıklanır.
        adminDashboard.paymentHistoryActionLinkii.click();
        //UserdepositinformationText görüntülendiği doğrulanır.
        softAssert.assertTrue(adminDashboard.UserdepositinformationText.isDisplayed());
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
        //driver kapatılır.
        Driver.closeDriver();
        softAssert.assertAll();

    }
}
