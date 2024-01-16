package tests.US31_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US31_TC03 {
    @Test
    public void test03(){

    //1.Browserı açar.
        //"2. Url: ""https://qa.easybusticket.com/admin/""
        // linki ile admin giriş sayfasına gider."
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //3.Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        adminDashboard.loginButonu.click();
        //4.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.
        adminDashboard.manageFleets.click();
        ReusableMethods.wait(2);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",adminDashboard.vehicle);
        //5.Fleet Type alt başlığına erişim sağlar.
        adminDashboard.fleetType.click();
        //6. Fleet Type sayfasında var olan araç tiplerini ve araç bilgilerini görüntülediğini doğrular..
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminDashboard.fleetTypePage
                  .isDisplayed(),"Fleet Type sayfasında araç tipleri ve araç bilgileri görüntülenemedi!");
        //7.Sağ üst köşedeki Add New buttonuna tıklar.
        adminDashboard.buttonFleetAddNew.click();
        //8.Add Fleet Type penceresinin görüntülendiğini doğrular.
        softAssert.assertTrue(adminDashboard.textAddFleetType
                                            .isDisplayed(),"Add Fleet Type yazisi görüntülenemedi!");
        //9.Add Fleet Type pencereside name textbox'ına araç ismi girer.
        adminDashboard.textBoxFleetName.sendKeys("First");
        //10.Seat layout dropdown menuden bir opsiyon seçer.
        Select selectSeatLayout= new Select(adminDashboard.dropDownSeatLayout);
        selectSeatLayout.selectByIndex(1);
        //11.Non of Deck  textbox'ının en sağındaki üst ikonuna bir kez tıklar
        adminDashboard.textBoxNonOfDeck.sendKeys("1");
        //Actions actions=new Actions(Driver.getDriver());
        //actions.moveToElement(adminDashboard.iconNoOfDeckUp).click();
        //12.Açılan Seats of Deck - 1 textbox'ına bir rakam girer.
        adminDashboard.textBoxSeatsOfDeck1.sendKeys("2");
        //13.AC status text box'ı Ac olarak seçer.
        adminDashboard.buttonNonAc.click();
        //14.Save buttonuna tıklar ve araç tipinin başarıyla eklendiğini çıkan alert ile doğrular.
        adminDashboard.buttonSave.click();
        ReusableMethods.waitForVisibility(adminDashboard.alertAddFleetType,10);
        //15.Eklediği araç tipini  update etmek için satırdaki Action  Pen buttonuna tıklar.
        //16.Update Fleet Type penceresinin görüntülendiğini doğrular.
        //17.Eklediği aracın status buttonunu  Active olarak değiştirir.
        //18.Update buttonuna tıklar ve update işleminin başarıyla değiştirildiğini çıkan alert ile doğrular.
        //19.Eklediği araç tipini  silmek  için satırdaki Action  Trash buttonuna tıklar.
        //20.Disable Fleet Type penceresinin açıldığını doğrular.
        //21.Disable buttonuna tıklar ve araç tipinin disable olduğunu çıkan alert ile doğrular.
        //22.Browser'ı kapatır.
    }
}
