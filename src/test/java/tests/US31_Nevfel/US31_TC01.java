package tests.US31_Nevfel;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US31_TC01 {

    @Test
    public void test01(){

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
        softAssert.assertTrue(adminDashboard.manageFleets
                                            .isDisplayed(),"Manage Fleets baslığı görüntülenemedi!");
        ReusableMethods.wait(2);

        //5.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.
        adminDashboard.manageFleets.click();
        ReusableMethods.wait(2);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",adminDashboard.vehicle);

        //6.Manage Fleets başlığının alt başlıklarını görüntüler.
        softAssert.assertTrue(adminDashboard.seatLayouts.isDisplayed(),"Seat Layouts başlığı görüntülenemedi!");
        softAssert.assertTrue(adminDashboard.fleetType.isDisplayed(),"Fleet Type başlığı görüntülenemedi!");
        softAssert.assertTrue(adminDashboard.vehicle.isDisplayed(),"Vehicle başlığı görüntülenemedi!");

        //7.Seat Layouts başlığına erişebildiğini doğrular.
        ReusableMethods.clickWithJS(adminDashboard.seatLayouts);
        softAssert.assertTrue(adminDashboard.seatLayouts.isEnabled(),"Seat Layouts başlığı erişilemedi!");
        ReusableMethods.wait(2);

        //8.Fleet Type başlığına erişebildiğini doğrular.
        ReusableMethods.clickWithJS(adminDashboard.fleetType);
        softAssert.assertTrue(adminDashboard.fleetType.isEnabled(),"Fleet Type başlığı erişilemedi!");
        ReusableMethods.wait(2);

        //9.Vehicles başlığına erişebildiğini doğrular.
        ReusableMethods.clickWithJS(adminDashboard.vehicle);
        softAssert.assertTrue(adminDashboard.vehicle.isEnabled(),"Vehicle başlığı erişilemedi!");
        ReusableMethods.wait(3);

        softAssert.assertAll();

        //10.Browser'ı kapatır.
        Driver.closeDriver();
    }
}
