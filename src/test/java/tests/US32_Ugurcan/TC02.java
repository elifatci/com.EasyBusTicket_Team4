package tests.US32_Ugurcan;

import org.openqa.selenium.devtools.v85.page.Page;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC02 extends TestBaseRapor {

    @Test
    public void TC02(){
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


        // 4. Manage trips butonu tıklanir ve  menü de Route butonuna tiklanir.
        ReusableMethods.clickWithJS(page.manageTrips);
        ReusableMethods.clickWithJS(page.route);
        extentTest.pass("Manage trips butonu tıklanir ve  menü de Route butonuna tiklar");


        // 5. Sayfada All Routes yazisi oldugunu dogrulanir
        Assert.assertTrue(page.textSupportRequest.isDisplayed());
        extentTest.pass("Sayfada All Routes yazisi oldugunu dogrulanir");


        // 6. All Routes sayfasinda ilk Name'in gorunur oldugunu dogrula
        Assert.assertTrue(page.textFirstName.isDisplayed());
        extentTest.pass(" All Routes sayfasinda ilk Name'in gorunur oldugunu dogrula");


        // 7. Add New buttona tiklana bilindigini ve gorunurlugunu test edin
        Assert.assertTrue(page.buttonRouteAddNew.isDisplayed());
        ReusableMethods.clickWithJS(page.buttonRouteAddNew);
        Driver.getDriver().navigate().back();
        extentTest.pass(" Add New buttona tiklana bilindigini ve gorunurlugunu test edin");


        // 8. Action da kaleme ikonuna tikla
        page.iconPenFirstAction.click();
        extentTest.pass(" Action da kaleme ikonuna tikla");


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
        extentTest.pass("Information of Route yazisini ve Name, Strat From, Ent To, Time, Distance goruntule kutucuklari doldurur");


        Driver.closeDriver();
        extentTest.pass("Sayfayi kapatir");


    }
}
