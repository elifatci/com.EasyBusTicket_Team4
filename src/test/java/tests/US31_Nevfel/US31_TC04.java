package tests.US31_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US31_TC04 {
    @Test
    public void test04(){

        //1.Browserı açar.
        //"2. Url: ""https://qa.easybusticket.com/admin/"" linki ile admin giriş sayfasına gider."
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        //3.Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        adminDashboard.loginButonu.click();

        //4.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.
        ReusableMethods.clickWithJS(adminDashboard.manageFleets);
        ReusableMethods.wait(2);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",adminDashboard.vehicle);

        //5.Vehicles alt başlığına erişim sağlar.
        ReusableMethods.clickWithJS(adminDashboard.vehicle);

        //6.All Vehicles  sayfasında var olan  araç bilgilerini görüntülediğini doğrular.
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(adminDashboard.allVehiclesYazisi
                                            .isDisplayed(),"All Vehicles sayfası görüntülenemedi!");

        //7.Sağ üstteki Reg.No textbox'ına  bir aracın kayıt numarasını girer ve enter tuşuna basar.
        adminDashboard.allVehiclesRegNoTextBox.sendKeys("1234"+ Keys.ENTER);
        ReusableMethods.wait(1);

        //8.Aradığı aracın sayfada görüntülendiğini doğrular.
        String expectedSonucSayfasi="https://qa.easybusticket.com/admin/manage/vehicles/search?search=1234";
        String actualSonucSayfasi=adminDashboard.allVehicleSearchRegNoSonucSayfasi.getText();
        softAssert.assertEquals(actualSonucSayfasi,expectedSonucSayfasi,"Sayfalar aynı değil!");
        ReusableMethods.wait(3);

        //9.Browserı kapatır.
        Driver.closeDriver();
    }
}
