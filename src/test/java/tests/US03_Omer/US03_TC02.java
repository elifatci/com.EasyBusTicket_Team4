package tests.US03_Omer;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class US03_TC02 {@Test
public void US03_TC2_AnasayfaVisitorBiletalma(){
    //1.Anasayfaya gidiliir.

    Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
    VisitorHomepage homepage=new VisitorHomepage();

    //2.Cookies kabul edilir.
    homepage.ButonCookieAccept.click();
    //3.anasayfada olduğumuz doğrulanır.
    Assert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")));
    ReusableMethods.wait(1);
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
    //5.Tarih seçilir
    act.sendKeys(Keys.TAB);
    LocalDateTime ldt=LocalDateTime.now();
    DateTimeFormatter dtf=DateTimeFormatter.ofPattern("dd/MM/YYYY");
    String str=dtf.format(ldt);
    act.sendKeys(str);
    act.sendKeys(Keys.ENTER);
    ReusableMethods.wait(2);
    //6-Find tickets tıklanır.
    act.sendKeys(Keys.ENTER);
    act.perform();
    //7-"https://qa.easybusticket.com/tickets"sayfasında bilet fiyatı görünür olduğu doğrulanır.



}
}
