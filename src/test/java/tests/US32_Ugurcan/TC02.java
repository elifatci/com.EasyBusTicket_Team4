package tests.US32_Ugurcan;

import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02 {

    @Test
    public void TC02(){

        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        // 3. Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisildiğini dogrulayin.
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();

        // 4. Manage trips butonu tıklanir ve  menü de Route butonuna tiklanir.
        ReusableMethods.clickWithJS(page.manageTrips);
        ReusableMethods.clickWithJS(page.route);

        // 5. Sayfada All Routes yazisi oldugunu dogrulanir
        Assert.assertTrue(page.textSupportRequest.isDisplayed());

        // 6. All Routes sayfasinda ilk Name'in gorunur oldugunu dogrula
        Assert.assertTrue(page.textFirstName.isDisplayed());

        // 7. Add New buttona tiklana bilindigini ve gorunurlugunu test edin
        Assert.assertTrue(page.buttonRouteAddNew.isDisplayed());
        ReusableMethods.clickWithJS(page.buttonRouteAddNew);
        Driver.getDriver().navigate().back();

        // 8. Action da kaleme ikonuna tikla
        page.iconPenFirstAction.click();

        // 9. Information of Route yazisini ve Name, Strat From, Ent To, Time, Distance goruntule kutucuklari doldur
        Assert.assertTrue(page.textInformationOfRoute.isDisplayed());

        Assert.assertTrue(page.textBoxName.isDisplayed());
        page.textBoxName.clear();
        page.textBoxName.sendKeys("Deneme");

        Assert.assertTrue(page.dropDownStartFrom.isDisplayed());
        Assert.assertTrue(page.dropDownEndTo.isDisplayed());

        ReusableMethods.clickWithJS(page.radioButtonHasMoreStoppage);

        page.textBoxTime.sendKeys("100");
        page.textBoxDistance.sendKeys("1000");

        ReusableMethods.clickWithJS(page.buttonSaveChanges);

        Driver.closeDriver();

   }
}
