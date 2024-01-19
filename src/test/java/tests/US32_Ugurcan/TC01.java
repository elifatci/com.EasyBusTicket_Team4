package tests.US32_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC01 extends TestBaseRapor {

    @Test
    public void TC01(){
        extentTest = extentReports.createTest("Admin Manage trips sayfasinin testi","Admin Manage trips sayfasinin altindaki basliklarin testi");
        // 1.  Tarayiciyi acin
        // 2.  https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.pass("Admin 'https://qa.easybusticket.com/admin' ana sayfasına gider");

        // 3.  Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erişildiğini dogrulayin.
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        ReusableMethods.clickWithJS(page.loginButonu);
        extentTest.pass("Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erişildiğini dogrular");


        // 4.  Manage trips gorunurlugunu dogrula
        Assert.assertTrue(page.manageTrips.isDisplayed());
        extentTest.pass("Manage trips gorunurlugunu dogrular");

        // 5.  Sayfa solunda Manage Trips butonu tiklanir.
        ReusableMethods.clickWithJS(page.manageTrips);
        extentTest.pass("Sayfa solunda Manage Trips butonu tiklar");

        // 6.  Route butonu tıklandığında sayfanin acildigini dogrula
        ReusableMethods.clickWithJS(page.route);
        Assert.assertTrue(page.textAllRoutes.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        extentTest.pass("Route butonu tıklandığında sayfanin acildigini dogrular");


        // 7.  Schedule butonu tıkalndığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.schedule);
        Assert.assertTrue(page.textAllSchedules.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        extentTest.pass("Schedule butonu tıkalndığında sayfanin acildigini dogrular");


        // 8.  Ticket Price butonu tıklandığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.ticketPrice);
        Assert.assertTrue(page.textAllTicketPrice.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        extentTest.pass("Ticket Price butonu tıklandığında sayfanin acildigini dogrular");


        // 9. Trip butonu tıklanıldığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.trip);
        Assert.assertTrue(page.textAllTicketPrice.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        extentTest.pass("Trip butonu tıklanıldığında sayfanin acildigini dogrular");


        // 10. Assigned Vehicles butonu tıklanıldığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.assignedVehicle);
        Assert.assertTrue(page.textAssignedVehicles.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        extentTest.pass("Assigned Vehicles butonu tıklanıldığında sayfanin acildigini dogrular");


        Driver.closeDriver();
        extentTest.pass("Sayfayi kapatir");
    }
}
