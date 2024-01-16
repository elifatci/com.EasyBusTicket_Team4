package tests.US32_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC01 {

    @Test
    public void TC01(){


        // 1.  Tarayiciyi acin
        // 2.  https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        // 3.  Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erişildiğini doğrulayın.
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        ReusableMethods.clickWithJS(page.loginButonu);

        // 4.  Manage trips gorunurlugunu dogrula
        Assert.assertTrue(page.manageTrips.isDisplayed());

        // 5.  Sayfa solunda Manage Trips butonu tiklanir.
        ReusableMethods.clickWithJS(page.manageTrips);
        // 6.  Route butonu tıklandığında sayfanin acildigini dogrula
        ReusableMethods.clickWithJS(page.route);
        Assert.assertTrue(page.textAllRoutes.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();


        // 7.  Schedule butonu tıkalndığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.schedule);
        Assert.assertTrue(page.textAllSchedules.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        // 8.  Ticket Price butonu tıklandığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.ticketPrice);
        Assert.assertTrue(page.textAllTicketPrice.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        // 9. Trip butonu tıklanıldığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.trip);
        Assert.assertTrue(page.textAllTicketPrice.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        // 10. Assigned Vehicles butonu tıklanıldığında sayfanin acildigini dogrular
        ReusableMethods.clickWithJS(page.assignedVehicle);
        Assert.assertTrue(page.textAssignedVehicles.isDisplayed());
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        Driver.closeDriver();
    }
}
