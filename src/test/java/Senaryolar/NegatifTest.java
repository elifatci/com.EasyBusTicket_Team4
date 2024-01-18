package Senaryolar;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class NegatifTest extends TestBaseRapor {

    @Test
    public void NegatifTest(){
        //Web driver calistirilarak "https://qa.easybusticket.com/login/" sayfasina gidilir
        Driver.getDriver().get(ConfigReader.getProperty("easyBusLogin"));
        extentTest=extentReports.createTest("Negatif Test","Kullanici gecersiz bilgilerle login olamamali");
        //Username textbox'in içine gecersiz username girilir
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        SoftAssert softAssert=new SoftAssert();
        visitorHomepage.textBoxUsername.sendKeys("team4");
        extentTest.info("Kullanici username textboxina gecersiz username girer");
        ReusableMethods.waitFor(2);
        //Username textbox'in icine gecerli sifre girilir
        visitorHomepage.textBoxPassword.sendKeys("123Team");
        extentTest.info("Kullanici password textboxina gecerli password girer");
        ReusableMethods.waitFor(3);
        //Login butonuna click yapilir
        visitorHomepage.buttonLogin.click();
        extentTest.info("Kullanici login butonuna tiklar");
        ReusableMethods.waitFor(3);
        //Login olamadigi dogrulanir
        String expectedUrl="https://qa.easybusticket.com/login";
        String actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Login olamadigi dogrulanamadi");
        extentTest.pass("Login olamadigi dogrulanir");
        ReusableMethods.waitFor(3);
        //Username textbox'in içine gecersiz kullanici adi girilir
        visitorHomepage.textBoxUsername.sendKeys("team4");
        extentTest.info("Kullanici username textboxina gecersiz username girer");
        ReusableMethods.waitFor(2);
        //Password  textbox'in içine gecersiz sifre girilir
        visitorHomepage.textBoxPassword.sendKeys("4team");
        extentTest.info("Kullanici password textboxina gecersiz password girer");
        ReusableMethods.waitFor(3);
        //Login butonuna click yapilir
        visitorHomepage.buttonLogin.click();
        extentTest.info("Kullanici login butonuna tiklar");
        ReusableMethods.waitFor(3);
        //Login olamadigi dogrulanir
        expectedUrl="https://qa.easybusticket.com/login";
        actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Login olamadigi dogrulanamadi");
        extentTest.pass("Login olamadigi dogrulanir");
        ReusableMethods.waitFor(3);
        //Username textbox'in içine gecerli kullanici adi girilir
        visitorHomepage.textBoxUsername.sendKeys("Team_4");
        extentTest.info("Kullanici username textboxina gecerli username girer");
        ReusableMethods.waitFor(2);
        //Password textbox'in içine gecersiz sifre girilir
        visitorHomepage.textBoxPassword.sendKeys("4team");
        extentTest.info("Kullanici password textboxina gecersiz password girer");
        ReusableMethods.waitFor(3);
        //Login butonuna click yapilir
        visitorHomepage.buttonLogin.click();
        extentTest.info("Kullanici login butonuna tiklar");
        ReusableMethods.waitFor(3);
        //Login olamadigi dogrulanir
        expectedUrl="https://qa.easybusticket.com/login";
        actualUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualUrl,expectedUrl,"Login olamadigi dogrulanamadi");
        extentTest.pass("Login olamadigi dogrulanir");
        ReusableMethods.waitFor(3);
        //browser kapatilir
        Driver.closeDriver();
        extentTest.info("Browser kapatilir");

    }
}
