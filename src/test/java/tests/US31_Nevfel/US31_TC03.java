package tests.US31_Nevfel;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US31_TC03 extends TestBaseRapor {
    @Test
    public void test03(){

    //1.Browserı açar.
        //"2. Url: ""https://qa.easybusticket.com/admin/""
        // linki ile admin giriş sayfasına gider."
        extentTest=extentReports.createTest("Smoke-E2E Test","Admin Dashboard'da Fleet Type sayfasına ulaşıp var olan tipleri ve bilgilerini görüntüleyebilmeli, Yeni araç tipi ekleyip, bilgilerini görünütleyip, düzenleyip, eklediği araç tipini silebilmeli.");
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Anasayfaya gidilir.");

        //3.Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        adminDashboard.loginButonu.click();
        extentTest.info("Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.");

        //4.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.
        adminDashboard.manageFleets.click();
        ReusableMethods.wait(2);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",adminDashboard.vehicle);
        extentTest.info("Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.");


        //5.Fleet Type alt başlığına erişim sağlar.
        adminDashboard.fleetType.click();
        extentTest.info("Fleet Type alt başlığına erişim sağlar.");

        //6. Fleet Type sayfasında var olan araç tiplerini ve araç bilgilerini görüntülediğini doğrular..
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminDashboard.fleetTypePage
                  .isDisplayed(),"Fleet Type sayfasında araç tipleri ve araç bilgileri görüntülenemedi!");
        extentTest.pass("Fleet Type sayfasında var olan araç tiplerini ve araç bilgilerini görüntülediğini doğrular.");

        //7.Sağ üst köşedeki Add New buttonuna tıklar.
        adminDashboard.buttonFleetAddNew.click();
        extentTest.info("Sağ üst köşedeki Add New buttonuna tıklar.");
        ReusableMethods.wait(2);

        //8.Add Fleet Type penceresinin görüntülendiğini doğrular.
        softAssert.assertTrue(adminDashboard.textAddFleetType
                                            .isDisplayed(),"Add Fleet Type yazisi görüntülenemedi!");
        extentTest.pass("Add Fleet Type penceresinin görüntülendiğini doğrular.");

        //9.Add Fleet Type pencereside name textbox'ına araç ismi girer.
        Faker faker=new Faker();
        adminDashboard.textBoxFleetName.sendKeys(faker.company().name());
        extentTest.info("Add Fleet Type pencereside name textbox'ına araç ismi girer.");

        //10.Seat layout dropdown menuden bir opsiyon seçer.
        Select selectSeatLayout= new Select(adminDashboard.dropDownSeatLayout);
        selectSeatLayout.selectByIndex(1);
        extentTest.info("Seat layout dropdown menuden bir opsiyon seçer.");

        //11.Non of Deck  textbox'ına bir sayı girer.
        adminDashboard.textBoxNonOfDeck.sendKeys("1");
        extentTest.info("Non of Deck  textbox'ına bir sayı girer.");

        //12.Açılan Seats of Deck - 1 textbox'ına bir sayı  girer.
        adminDashboard.textBoxSeatsOfDeck1.sendKeys("2");
        extentTest.info("Açılan Seats of Deck - 1 textbox'ına bir sayı  girer.");

        //13.AC status text box'ı Ac olarak seçer.
        ReusableMethods.clickWithJS(adminDashboard.buttonNonAc);
        extentTest.info("AC status text box'ı Ac olarak seçer.");

        //14.Save buttonuna tıklar ve araç tipinin başarıyla eklendiğini çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonSave);
        ReusableMethods.waitForVisibility(adminDashboard.alertAddFleetType,10);
        String expectedAddFleetAlerti="Fleet type saved successfully";
        String actualAddFleetAlerti=adminDashboard.alertAddFleetType.getText();
        softAssert.assertEquals(actualAddFleetAlerti,expectedAddFleetAlerti,"Add Fleet Type Alertleri aynı değil!");
        extentTest.info("Save buttonuna tıklar");
        extentTest.pass("Arac tipinin başarıyla eklendiğini çıkan alert ile doğrular.");

        //15.Eklediği araç tipini  update etmek için satırdaki Action  Pen buttonuna tıklar.
        adminDashboard.iconPenFirstAction.click();
        extentTest.info("Eklediği araç tipini  update etmek için satırdaki Action  Pen buttonuna tıklar.");

        //16.Update Fleet Type penceresinin görüntülendiğini doğrular.
        ReusableMethods.wait(2);
        softAssert.assertTrue(adminDashboard.textUpdateFleetType
                                            .isDisplayed(),"Update Flee tType yazisi görüntülenmedi!");
        extentTest.pass("Update Fleet Type penceresinin görüntülendiğini doğrular.");

        //17.Eklediği aracın status buttonunu  Active olarak değiştirir.
        ReusableMethods.clickWithJS(adminDashboard.buttonNonAcUpdateFleetType);
        extentTest.info("Eklediği aracın status buttonunu  Active olarak değiştirir.");

        //18.Update buttonuna tıklar ve update işleminin başarıyla değiştirildiğini çıkan alert ile doğrular.
        ReusableMethods.clickWithJS( adminDashboard.buttonUpdate);
        ReusableMethods.wait(2);
        String expectedUpdateFleetAlerti="Fleet type updated successfully";
        String actualUpdateFleetAlerti=adminDashboard.alertFleetTypeUpdateSuccesfullYaziElementi.getText();
        softAssert.assertEquals(actualUpdateFleetAlerti,expectedUpdateFleetAlerti,"Update Fleet Alertleri aynı değil!");
        extentTest.info("Update buttonuna tıklar");
        extentTest.pass("Update işleminin başarıyla değiştirildiğini çıkan alert ile doğrular.");

        //19.Eklediği araç tipini  silmek  için satırdaki Action  Trash buttonuna tıklar.
        ReusableMethods.clickWithJS(adminDashboard.iconSlashEyeFleetTypePage);
        extentTest.info("Eklediği araç tipini  silmek  için satırdaki Action  Trash buttonuna tıklar.");
        ReusableMethods.wait(2);

        //20.Disable Fleet Type penceresinin açıldığını doğrular.
        softAssert.assertTrue(adminDashboard.textDisableFleetType
                .isDisplayed(),"Disable Fleet Type yazisi görüntülenemedi!");
        extentTest.pass("Disable Fleet Type penceresinin açıldığını doğrular.");

        //21.Disable buttonuna tıklar ve araç tipinin disable olduğunu çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonDisable);
        String expectedDisableAlerti="Fleet type disabled successfully.";
        String actualDisableAlerti=adminDashboard.alertFleetTypeDisableSuccesfullYazisi.getText();
        softAssert.assertEquals(actualDisableAlerti,expectedDisableAlerti,"Fleet type disabled alertleri aynı değildir!");
        extentTest.info("Disable buttonuna tıklar");
        extentTest.pass("Arac tipinin disable olduğunu çıkan alert ile doğrular.");
        ReusableMethods.wait(3);

        softAssert.assertAll();

        //22.Browser'ı kapatır.
        Driver.closeDriver();
        extentTest.info("Browser'ı kapatır.");
    }
}
