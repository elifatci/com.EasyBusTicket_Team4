package tests.US14_Omer;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US14_TC02 extends TestBaseRapor {
    @Test public void US14_TC01(){
        extentTest=extentReports.createTest("Smoke test","Sıkca sorulan sorular sayfasına erişilmeli");
        //1.Anasayfaya gidiliir.cookie kabul edilir.
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("EasyBus anasayfasina gidilir");
        //2.Cookies kabul edilir.
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButonCookieAccept.click();
        //2.Click on 'SignIn' button
        visitorHomepage.ButtonSignIn.click();
        extentTest.info("SignIn butonuna tiklanir");
        //3.Enter correct username and password (Doğru username ve şifreyi girin)
        visitorHomepage.textBoxUsername.sendKeys("ofom123");
        visitorHomepage.textBoxPassword.sendKeys("Ofom123.");
        //4.Click 'login' button (Giris yap butonuna tiklayin)
        visitorHomepage.buttonLogin.click();
        extentTest.pass("Gecerli bilgiler girilerek login butonuna tiklanir");
        SoftAssert softAssert=new SoftAssert();
        //5.Userdashboard da daha önce alınmış bilet nuramarası ile bilet görüntülendiği doğrulanır.
        extentTest.pass("Dashboard sayfasinda alinan biletin goruntulendigi dogrulanir");
        UserDashboard userDashboard=new UserDashboard();
        String actuelticketpnrno=userDashboard.textticketnoo.getText();
        String expectedticketno="7P8QVNNY9X";
        softAssert.assertEquals(actuelticketpnrno,expectedticketno);


        softAssert.assertAll();
        //6.browser closes
        Driver.closeDriver();

    }
}
