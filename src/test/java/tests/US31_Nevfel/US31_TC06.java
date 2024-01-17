package tests.US31_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US31_TC06 {
    @Test
    public void test06(){
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

        //5.Vehicles alt başlığına erişim sağlar.
        ReusableMethods.clickWithJS(adminDashboard.vehicle);

        //6.Eklediği aracın durumunu değiştirmek için Action Red eye buttonuna tıklar.
        adminDashboard.allVehiclesActionREDeyeIconu.click();
        ReusableMethods.wait(2);
        //7.Disable Vehicle penceresinin görüntülendiğini doğrular.
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(adminDashboard.textDisableVehicleWindowWriting
                                            .isDisplayed(),"Disable Vehicle yazisi görüntülenemedi!");

        //8.Disable buttonuna tıklar ve aracın durumunun başarılı bir şekilde değiştirildiğini  çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonDisable);
        ReusableMethods.wait(2);
        String expectedDisableAlert="Vehicle disabled successfully.";
        String actualDisableAlert=adminDashboard.alertDisableVehicleSuccesfullYazisi.getText();
        softAssert.assertEquals(actualDisableAlert,expectedDisableAlert,"Vehicle Disable alertler aynı değildir!");

        //9.Eklediği aracın durumunu değiştirmek için Action Green eye buttonuna tıklar.
        adminDashboard.allVehiclesActionGREENeyeIconu.click();
        ReusableMethods.wait(2);

        //10.Active Vehicle penceresinin görüntülendiğini doğrular.
        softAssert.assertTrue(adminDashboard.textActiveVehicleWindowWritting
                                            .isDisplayed(),"Active Vehicle penceresi görüntülenmedi!");

        //11.Active  buttonuna tıklar ve aracın durumunun başarılı bir şekilde değiştirildiğini  çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.buttonActiveActiveVehicle);
        ReusableMethods.wait(2);
        String expectedActiveAlert="Vehicle active successfully.";
        String actualActiveAlert=adminDashboard.alertActiveVehicleSuccesfullYazisi.getText();
        softAssert.assertEquals(actualActiveAlert,expectedActiveAlert,"Active Alert yazilari ayni değil!");
        ReusableMethods.wait(2);

        softAssert.assertAll();
        //12.Browserı kapatır.
        Driver.closeDriver();

    }
}
