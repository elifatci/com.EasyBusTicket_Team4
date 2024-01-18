package tests.US31_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US31_TC02 extends TestBaseRapor {
    @Test
    public void test02(){
        //1.Browserı açar.
        //"2. Url: ""https://qa.easybusticket.com/admin/""
        // linki ile admin giriş sayfasına gider."
        extentTest=extentReports.createTest("Smoke-E2E Test","Admin Dashboard'da Seat Layouts sayfasına  ulaşıp var olan düzenleri ve bilgilerini görüntüleyebilmeli, Yeni koltuk düzeni ekleyip, bilgilerini görünütleyip, düzenleyip, eklediği koltuk düzenini silebilmeli.");
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.info("Anasayfaya gidilir.");

        //3.Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        adminDashboard.loginButonu.click();
        extentTest.info("Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.");


        //4.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığını görüntülediğini doğrular.
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(adminDashboard.manageFleets
                                            .isDisplayed(),"Manage Fleets baslığı görüntülenemedi!");
        extentTest.pass("Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığını görüntülediğini doğrular.");

        ReusableMethods.wait(2);

        //5.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.
        adminDashboard.manageFleets.click();
        ReusableMethods.wait(2);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",adminDashboard.vehicle);
        extentTest.info("Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.");


        //6.Seat Layouts alt başlığına erişim sağlar.
        adminDashboard.seatLayouts.click();
        extentTest.info("Seat Layouts alt başlığına erişim sağlar.");

        //7.Seat Layouts sayfasında koltuk düzenlerini ve koltuk bilgilerini görüntülediğini doğrular.
        softAssert.assertTrue(adminDashboard.seatLayoutsPage
                                            .isDisplayed(),"Seat Layouts sayfa bilgileri görüntülenemedi");
        extentTest.pass("Seat Layouts sayfasında koltuk düzenlerini ve koltuk bilgilerini görüntülediğini doğrular.");
        ReusableMethods.wait(2);

        //8.Sağ üst köşedeki Add New buttonuna tıklar.
        adminDashboard.buttonSeatAddNew.click();
        extentTest.info("Sağ üst köşedeki Add New buttonuna tıklar.");

        //9.Add Seat Layouts  penceresinin görüntülendiğini doğrular.
        String expectedSeatLayoutsUrl="https://qa.easybusticket.com/admin/manage/seat_layouts";
        String actualSeatLayoutsUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(actualSeatLayoutsUrl,expectedSeatLayoutsUrl,"Seat Layouts sayfasında değiliz!");
        ReusableMethods.wait(2);
        extentTest.pass("Add Seat Layouts  penceresinin görüntülendiğini doğrular.");

        //10.Layouts textbox'ına eklemek istediği koltuk düzenini girer
        adminDashboard.textBoxLayout.sendKeys("a9");
        extentTest.info("Layouts textbox'ına eklemek istediği koltuk düzenini girer");

        //11.Save buttonuna tıklar ve koltuk düzeninin başarıyla oluşturulduğunu  çıkan alert ile doğrular.
        adminDashboard.buttonSaveAddSeatLayout.click();
        extentTest.info("Save buttonuna tıklar ");

        ReusableMethods.waitForVisibility(adminDashboard.alertSeatLayoutSavedSuccesfullYazisi,3);
        String expectedSavedAlert="Seat layout saved successfully.";
        String actualSavedAlert=adminDashboard.alertSeatLayoutSavedSuccesfullYazisi.getText();
        softAssert.assertEquals(actualSavedAlert,expectedSavedAlert,"Saved Alertleri aynı değildir!");
        extentTest.pass("Koltuk düzeninin başarıyla oluşturulduğunu  çıkan alert ile doğrular.");

        //12.Oluşturduğu koltuk düzenini update etmek için satırdaki Action  Pen buttonuna tıklar.
        adminDashboard.iconSeatLayoutFirstPenAction.click();
        extentTest.info("Oluşturduğu koltuk düzenini update etmek için satırdaki Action  Pen buttonuna tıklar.");
        ReusableMethods.wait(2);

        //13.Update Seat Layouts penceresinin görüntülendiğini doğrular.
        softAssert.assertTrue(adminDashboard.textUpdateSeatLayouts
                                            .isDisplayed(),"Update Seat Layouts yazisi görüntülenemedi!");
        extentTest.pass("Update Seat Layouts penceresinin görüntülendiğini doğrular");

        //14.Layouts textbox'ındaki koltuk düzenini silip yeni koltuk düzenini girer.
        adminDashboard.textBoxLayoutSeatLayouts.clear();
        ReusableMethods.wait(1);
        adminDashboard.textBoxLayoutSeatLayouts.sendKeys("a1");
        extentTest.info("Layouts textbox'ındaki koltuk düzenini silip yeni koltuk düzenini girer.");

        //15.Update buttonuna tıklar ve koltuk düzeninin başarıyla değiştirildiğini çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonUpdateSeatLayoutsUpdate);
        ReusableMethods.wait(2);
        String expectedUpdateAlerti="Seat layout updated successfully.";
        String actualUpdateAlerti=adminDashboard.alertSeatLayoutUpdateSuccesfullYazisi.getText();
        softAssert.assertEquals(actualUpdateAlerti,expectedUpdateAlerti,"Update Alertleri aynı değildir!");
        extentTest.info("Update buttonuna tıklar");
        extentTest.pass("Koltuk düzeninin başarıyla değiştirildiğini çıkan alert ile doğrular.");

        //16.Oluşturduğu koltuk düzenini silmek  için satırdaki Action  Trash buttonuna tıklar.
        adminDashboard.iconSeatLayoutFirstTrashAction.click();
        extentTest.info("Oluşturduğu koltuk düzenini silmek  için satırdaki Action  Trash buttonuna tıklar.");
        ReusableMethods.wait(2);

        //17.Delete Seat Layouts penceresinin görüntülendiğini doğrular.
        softAssert.assertTrue(adminDashboard.textDeleteSeatLayouts
                                            .isDisplayed(),"Delete Seat Layouts yazisi görüntülenemedi!");
        extentTest.pass("Delete Seat Layouts penceresinin görüntülendiğini doğrular.");

        //18.Delete buttonuna tıklar ve koltuk düzeninin başarıyla silindiğini çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonDeleteSeatLayouts);
        ReusableMethods.wait(2);
        String expectedDeleteAlerti="Seat layout deleted successfully.";
        String actualDeleteAlerti=adminDashboard.alertSeatLayoutDeleteSuccesfullYazisi.getText();
        softAssert.assertEquals(actualDeleteAlerti,expectedDeleteAlerti,"Delete alertleri aynı değildir!");
        extentTest.info("Delete buttonuna tıklar");
        extentTest.pass("Koltuk düzeninin başarıyla silindiğini çıkan alert ile doğrular.");

        softAssert.assertAll();

        //19.Browser'ı kapatır.
        Driver.closeDriver();
        extentTest.info("Browser'ı kapatır.");
    }
}
