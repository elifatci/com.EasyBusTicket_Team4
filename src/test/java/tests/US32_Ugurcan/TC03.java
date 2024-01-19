package tests.US32_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC03 extends TestBaseRapor {
    @Test
    public void TC03() {
        extentTest = extentReports.createTest("Admin Manage trips sayfasinin testi","Admin Manage trips sayfasinin altindaki basliklarin testi");
        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        extentTest.pass("Admin 'https://qa.easybusticket.com/admin' ana sayfasına gider");

        // 3. Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisildiğini dogrulayin.
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();
        extentTest.pass("Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisildiğini dogrular");


        // 4. Manage trips butonu tiklandiginda acilir menü de Schedule butonuna tiklanir
        ReusableMethods.clickWithJS(page.manageTrips);
        ReusableMethods.clickWithJS(page.schedule);
        extentTest.pass("Manage trips butonu tiklandiginda acilir menü de Schedule butonuna tiklani");


        // 5. All Schedules yazisi olan tüm seferlerin oldugu listeye gelindigi dogrulanir ve geri donulur.
        Assert.assertTrue(page.textAllSchedules.isDisplayed());
        extentTest.pass("All Schedules yazisi olan tüm seferlerin oldugu listeye gelindigi dogrulanir ve geriye dondu");



        // 6. Active Schedule action formu geldigi dogrulanir
        Assert.assertTrue(page.buttonScheduleAddNew.isDisplayed());
        extentTest.pass("Active Schedule action formu geldigi dogrulandi");

        ReusableMethods.clickWithJS(page.buttonScheduleAddNew);

        // 7. Active Schedule da Start From ve End At saat giriniz

        page.textBoxStartFromAdd.sendKeys("13:30");
        page.textBoxEndAtAdd.sendKeys("18:40");
        ReusableMethods.clickWithJS(page.buttonUpdate);
        extentTest.pass("Active Schedule da Start From ve End At saat girildi");



        // 8. Active Schedule butonu tiklanir
        ReusableMethods.clickWithJS(page.textUpdateSchedule);
        extentTest.pass("Active Schedule butonu tiklandi");


        // 9. Close  butonu tiklanir
        ReusableMethods.clickWithJS(page.buttonCloseUpdateSchedule);
        extentTest.pass("Close  butonu tiklanildi");


        Driver.closeDriver();
        extentTest.pass("Sayfayi kapatir");
    }
}