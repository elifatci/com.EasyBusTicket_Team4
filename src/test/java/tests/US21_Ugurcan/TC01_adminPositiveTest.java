package tests.US21_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;

public class TC01_adminPositiveTest {

    @Test
    public void TC01_adminPositiveTest(){

        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasına gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        // 3. Admin sayfasının acildigini goruntuleyin
        String expedtedUrl = "https://qa.easybusticket.com/admin" ;
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actuelUrl.contains(expedtedUrl));

        // 4. Yonetici giris sayfasindaki username textbox'in ve password textbox'in gorunur
        //    ve aktif oldugunu dogrulayın

        AdminDashboard page = new AdminDashboard();
        Assert.assertTrue(page.usernameKutusu.isDisplayed());
        Assert.assertTrue(page.passwordKutusu.isDisplayed());

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();


        Driver.closeDriver();

    }
}
