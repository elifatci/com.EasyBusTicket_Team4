package tests.US03_Omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class US03_TC02 extends TestBaseRapor {@Test
public void US03_TC2_AnasayfaVisitorBiletalma(){
    //1.Anasayfaya gidiliir.
    extentTest=extentReports.createTest("Smoke test");
    Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
    VisitorHomepage homepage=new VisitorHomepage();
    extentTest.info("Kullanici easyBus ana sayfaya gider");
    //2.Cookies kabul edilir.
    homepage.ButonCookieAccept.click();
    //3.anasayfada olduğumuz doğrulanır.
    SoftAssert softAssert=new SoftAssert();
    softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")));
    ReusableMethods.wait(1);
    extentTest.pass("EasyBus ana sayfaya erisidigi dogrulanir");
    //4.Find ticekets kısmından rota ve tarih seçilir
    homepage.DropdownPickUpPoint.click();
    Actions act=new Actions(Driver.getDriver());
    act.sendKeys(Keys.ARROW_DOWN);
    act.sendKeys(Keys.ENTER);
    act.sendKeys(Keys.TAB);
    act.sendKeys(Keys.ENTER);
    ReusableMethods.wait(1);
    act.sendKeys(Keys.ARROW_DOWN);
    act.sendKeys(Keys.ARROW_DOWN);
    ReusableMethods.wait(3);
    act.sendKeys(Keys.ENTER);
    extentTest.info("Rota secimi yapilir");
    //5.Tarih seçilir
    act.sendKeys(Keys.TAB);
    LocalDateTime ldt=LocalDateTime.now();
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/YYYY");
    String str=dtf.format(ldt);
    act.sendKeys(str);
    act.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    extentTest.info("Tarih secimi yapilir");
    //6-Find tickets tıklanır.
    act.sendKeys(Keys.ENTER);
    act.perform();
    //7-"https://qa.easybusticket.com/tickets"sayfasında bilet fiyatı görünür olduğu doğrulanır.
    softAssert.assertTrue(homepage.TextTicketprice.isEnabled(),"bilet fiyatı gözükmüyorclkkkkkkkkkkk");
    extentTest.pass("Bilet fiyatinin gorunur oldugu dogrulanir");
    //8-select seed butonu tıklanır ve koltuk seçimi sayfasına gidilir.
    ReusableMethods.clickWithJS(homepage.ButonSelectSeet);
    //9.Cinsiuyet ve koltuk seçimi yapılır.
    ReusableMethods.clickWithJS(homepage.ButonA1Koltuk);
    ReusableMethods.clickWithJS(homepage.ButonMalecinsiyet);
    ReusableMethods.clickWithJS(homepage.ButonContinue);
    extentTest.info("Koltuk ve cinsiyet secimi yapilir");
    //10.Continue butonu tıklanıp confirm booking yapılır
    ReusableMethods.waitFor(3);
    homepage.ButonConfirmBooking.click();
    //11.Üye olmadan bilet alınamaz o yüzden üye olma sayfasına yönlendirdiği doğrulanır.
    softAssert.assertEquals(Driver.getDriver().getCurrentUrl(),"https://qa.easybusticket.com/login","login sayfasına yönlendirilmedi");
    extentTest.pass("Uye olunmadan bilet alinamadigi dogrulanir");
    //12.Tarayıcı kapatılır
    softAssert.assertAll();
    Driver.quitDriver();




}
}
