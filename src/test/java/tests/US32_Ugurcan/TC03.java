package tests.US32_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC03 {
    @Test
    public void TC03() {

        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        // 3. Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisildiğini dogrulayin.
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();

        // 4. Manage trips butonu tiklandiginda acilir menü de Schedule butonuna tiklanir
        ReusableMethods.clickWithJS(page.manageTrips);
        ReusableMethods.clickWithJS(page.schedule);

        // 5. All Schedules yazisi olan tüm seferlerin oldugu listeye gelindigi dogrulanir ve geri donulur.
        Assert.assertTrue(page.textAllSchedules.isDisplayed());

        // 6. All Schedules sayfasinda ilk sefer bilgisi yanındaki AktiveSchedule ikonu tiklanir


        // 7. Active Schedule action formu geldigi dogrulanir

        // 8. Active Schedule butonu tiklanir

        // 12. Close  butonu tiklanir

        // 13. Degisiklik yapilmadan action kapandigi dogrulanir
    }
}