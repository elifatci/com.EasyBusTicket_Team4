package tests.US32_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;


public class TC04 extends TestBaseRapor {
    @Test
    public void TC04(){
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
        extentTest.pass("Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisildiğini dogrulandi");

        // 4. Manage trips butonu tiklandiginda acilir menu de Trip butonu tiklanir
        ReusableMethods.clickWithJS(page.manageTrips);
        extentTest.pass("Manage trips butonu tiklandiginda acilir menu de Trip butonu tiklandi");


        // 5. Manage trips butonu tiklandiginda acilir menü de Trip butonuna tiklanir
        ReusableMethods.clickWithJS(page.trip);
        extentTest.pass(" Manage trips butonu tiklandiginda acilir menü de Trip butonuna tiklandi");


        // 6. "https://qa.easybusticket.com/admin/manage/trip" sayfasina ulasildigi dogrulanir
        String expedted = "https://qa.easybusticket.com/admin/manage/trip";
        String actuel = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuel, expedted);
        extentTest.pass("https://qa.easybusticket.com/admin/manage/trip sayfasina ulasildigi dogrulandi");


        // 7. Add new butonu tiklanir
        ReusableMethods.clickWithJS(page.buttonAddNewTrip);
        extentTest.pass("Add new butonu tiklandi");


        // 9. Title alani tiklanir ve bir baslik yazilir
        ReusableMethods.clickWithJS(page.textBoxTitle);
        page.textBoxTitle.sendKeys("LUX BUS - Houston - Austin");
        extentTest.pass("Title alani tiklanir ve bir baslik yazilir");


        // 10. Sira ile Fleet Type ,Route ,Schedule ,Start From ,End To ,Day Off butonlari tiklanir ve gecerli bilgiler girilir
        page.dropdownFleet.click();
        page.ClassicBus.click();

        page.routeDropdown.click();
        page.ExpressHoustonMemphis.click();

        page.dropDownSchedule.click();
        page.optionSchedule1.click();

        page.dropdownStartFrom.click();
        page.optionDallas.click();

        page.dropdownEndTo.click();
        page.optionForthWorth.click();

        page.dropDownDayOf.click();
        page.dayBox.sendKeys("Wednesday");
        extentTest.pass("Sira ile Fleet Type ,Route ,Schedule ,Start From ,End To ,Day Off butonlari tiklanir ve gecerli bilgiler girildi");


        // 11. Save butonu tiklanir
        ReusableMethods.clickWithJS(page.ButtonSaveTrip);
        extentTest.pass("Save butonu tiklandi");

        // 12. Ekledigimiz seferin sayfada gorunur ve aktif oldugu dogrulanir
        Assert.assertTrue(page.statusActiveButton.isDisplayed());
        extentTest.pass("Ekledigimiz seferin sayfada gorunur ve aktif oldugu dogrulandi");

        Driver.closeDriver();
        extentTest.pass("Sayfayi kapatir");



    }
}
