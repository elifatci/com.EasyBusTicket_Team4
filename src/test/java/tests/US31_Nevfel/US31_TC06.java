package tests.US31_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US31_TC06 extends TestBaseRapor {
    @Test
    public void test06(){
        //1.Browserı açar.
        //"2. Url: ""https://qa.easybusticket.com/admin/""
        // linki ile admin giriş sayfasına gider."
        extentTest=extentReports.createTest("Smoke-E2E Test","Admin Dashboard'da Vehicles sayfasına ulaşıp araç durumunu active/disable yapabilmeli.");
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

        //5.Vehicles alt başlığına erişim sağlar.
        ReusableMethods.clickWithJS(adminDashboard.vehicle);
        extentTest.info("Vehicles alt başlığına erişim sağlar.");

        //6.Eklediği aracın durumunu değiştirmek için Action Red eye buttonuna tıklar.
        adminDashboard.allVehiclesActionREDeyeIconu.click();
        extentTest.info("Eklediği aracın durumunu değiştirmek için Action Red eye buttonuna tıklar.");

        ReusableMethods.wait(2);
        //7.Disable Vehicle penceresinin görüntülendiğini doğrular.
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(adminDashboard.textDisableVehicleWindowWriting
                                            .isDisplayed(),"Disable Vehicle yazisi görüntülenemedi!");
        extentTest.pass("Disable Vehicle penceresinin görüntülendiğini doğrular.");

        //8.Disable buttonuna tıklar ve aracın durumunun başarılı bir şekilde değiştirildiğini  çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonDisable);
        extentTest.info("Disable buttonuna tıklar ");
        ReusableMethods.wait(2);
        String expectedDisableAlert="Vehicle disabled successfully.";
        String actualDisableAlert=adminDashboard.alertDisableVehicleSuccesfullYazisi.getText();
        softAssert.assertEquals(actualDisableAlert,expectedDisableAlert,"Vehicle Disable alertler aynı değildir!");
        extentTest.pass("aracın durumunun başarılı bir şekilde değiştirildiğini  çıkan alert ile doğrular.");

        //9.Eklediği aracın durumunu değiştirmek için Action Green eye buttonuna tıklar.
        adminDashboard.allVehiclesActionGREENeyeIconu.click();
        extentTest.info("Eklediği aracın durumunu değiştirmek için Action Green eye buttonuna tıklar.");
        ReusableMethods.wait(2);

        //10.Active Vehicle penceresinin görüntülendiğini doğrular.
        softAssert.assertTrue(adminDashboard.textActiveVehicleWindowWritting
                                            .isDisplayed(),"Active Vehicle penceresi görüntülenmedi!");
        extentTest.pass("Active Vehicle penceresinin görüntülendiğini doğrular.");

        //11.Active  buttonuna tıklar ve aracın durumunun başarılı bir şekilde değiştirildiğini  çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonActiveActiveVehicle);
        extentTest.info("Active  buttonuna tıklar");
        ReusableMethods.wait(2);

        String expectedActiveAlert="Vehicle active successfully.";
        String actualActiveAlert=adminDashboard.alertActiveVehicleSuccesfullYazisi.getText();
        softAssert.assertEquals(actualActiveAlert,expectedActiveAlert,"Active Alert yazilari ayni değil!");
        extentTest.pass("Aracın durumunun başarılı bir şekilde değiştirildiğini  çıkan alert ile doğrular.");
        ReusableMethods.wait(2);

        softAssert.assertAll();
        //12.Browserı kapatır.
        Driver.closeDriver();
        extentTest.info("Browserı kapatır.");

    }
}
