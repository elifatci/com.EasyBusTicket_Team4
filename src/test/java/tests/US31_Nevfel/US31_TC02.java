package tests.US31_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US31_TC02 {
    @Test
    public void test02(){
        //1.Browserı açar.
        //"2. Url: ""https://qa.easybusticket.com/admin/""
        // linki ile admin giriş sayfasına gider."
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //3.Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        adminDashboard.loginButonu.click();
        //4.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığını görüntülediğini doğrular.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminDashboard.manageFleets.isDisplayed(),"Manage Fleets baslığı görüntülenemedi!");
        ReusableMethods.wait(2);
        //5.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.
        adminDashboard.manageFleets.click();
        ReusableMethods.wait(2);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",adminDashboard.vehicle);
        //6.Seat Layouts alt başlığına erişim sağlar.
        adminDashboard.seatLayouts.click();
        //7.Seat Layouts sayfasında koltuk düzenlerini ve koltuk bilgilerini görüntüler.
        softAssert.assertTrue(adminDashboard.seatLayoutsPage
                                            .isDisplayed(),"Seat Layouts sayfa bilgileri görüntülenemedi");
ReusableMethods.wait(2);
        //8.Sağ üst köşedeki Add New buttonuna tıklar.
        adminDashboard.buttonSeatAddNew.click();
        //9.Add Seat Layouts  penceresinin görüntülendiğini doğrular.
        softAssert.assertTrue(adminDashboard.textAddSeatLayouts
                                            .isDisplayed(),"Add Seat Layouts yazisi görüntülenemedi!");
        //10.Layouts textbox'ına eklemek istediği koltuk düzenini girer
        adminDashboard.textBoxLayout.sendKeys("79");
        //11.Save buttonuna tıklar ve koltuk düzeninin başarıyla oluşturulduğunu  çıkan alert ile doğrular.
        adminDashboard.buttonSaveAddSeatLayout.click();
        ReusableMethods.waitForVisibility(adminDashboard.alertSeatLayoutSuccesfuullYazisi,3);
        softAssert.assertTrue(adminDashboard.alertSeatLayoutSuccesfuullYazisi.isDisplayed(),"Yazi görüntülenemedi!");

        //12.Oluşturduğu koltuk düzenini update etmek için satırdaki Action  Pen buttonuna tıklar.
        //13.Update Seat Layouts penceresinin görüntülendiğini doğrular.
        //14.Layouts textbox'ındaki koltuk düzenini silip yeni koltuk düzenini girer.
        //15.Update buttonuna tıklar ve koltuk düzeninin başarıyla değiştirildiğini çıkan alert ile doğrular.
        //12.Oluşturduğu koltuk düzenini silmek  için satırdaki Action  Trash buttonuna tıklar.
        //13.Delete Seat Layouts penceresinin görüntülendiğini doğrular.
        //14.Delete buttonuna tıklar ve koltuk düzeninin başarıyla silindiğini çıkan alert ile doğrular.
        softAssert.assertAll();
        //15.Browser'ı kapatır.
        Driver.closeDriver();
    }
}
