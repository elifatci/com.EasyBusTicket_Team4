package tests.US01_Suleyman;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class US01_TC_02 {


    @Test
    public void test01(){
        //1.Anasayfaya gidiliir.

        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        VisitorHomepage homepage=new VisitorHomepage();

        //2.Cookies kabul edilir.
        homepage.ButonCookieAccept.click();

        //3.anasayfada olduğumuz doğrulanır.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().equals(ConfigReader.getProperty("easyBusUrl")),"Ana sayfada değisiliniz");





    }







}
