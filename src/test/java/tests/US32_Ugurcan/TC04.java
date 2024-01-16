package tests.US32_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;


public class TC04 {
    @Test
    public void TC04(){

        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        // 3. Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisildiğini dogrulayin.
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();

        // 4. Manage trips butonu tiklandiginda acilir menu de Trip butonu tiklanir
        ReusableMethods.clickWithJS(page.manageTrips);

        // 5. Manage trips butonu tiklandiginda acilir menü de Trip butonuna tiklanir
        ReusableMethods.clickWithJS(page.trip);

        // 6. "https://qa.easybusticket.com/admin/manage/trip" sayfasina ulasildigi dogrulanir
        String expedted = "https://qa.easybusticket.com/admin/manage/trip";
        String actuel = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuel, expedted);

        // 7. Add new butonu tiklanir
        ReusableMethods.clickWithJS(page.buttonAddNewTrip);

        // 9. Title alani tiklanir ve bir baslik yazilir
        ReusableMethods.clickWithJS(page.textBoxTitle);
        page.textBoxTitle.sendKeys("LUX BUS - Houston - Austin");

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

        // 11. Save butonu tiklanir
        ReusableMethods.clickWithJS(page.ButtonSaveTrip);


        // 12. Ekledigimiz seferin sayfada gorunur ve aktif oldugu dogrulanir
        Assert.assertTrue(page.statusActiveButton.isDisplayed());


    }
}
