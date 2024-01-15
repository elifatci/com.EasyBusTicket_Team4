package tests.US21_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC02_adminNegativeTest {

    @Test
    public void TC02_adminNegativeTest(){


        // 1. Tarayiciyi acin
        // 2. https://qa.easybusticket.com/admin ana sayfasina gidin
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));

        // 3. Admin sayfasinin acildigini goruntuleyin
        String expedtedUrl = "https://qa.easybusticket.com/admin" ;
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actuelUrl.contains(expedtedUrl));

        // 4. Login penceresindeki password textBox bos birakilamaz oldugunu dogrulayın
        AdminDashboard page = new AdminDashboard();

        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.clear();
        page.loginButonu.click();

        String expectedPassword = page.usernameKutusu.getText();
        String actualPassword = "The password field is required.";

        Assert.assertTrue(actualPassword.contains(expectedPassword));

        ReusableMethods.wait(3);

        // 5. Login penceresindeki username textBox harf, rakam, ozel karakter girilebildigini dogrulayin
        page.usernameKutusu.clear();
        page.usernameKutusu.sendKeys("a1/.2b");

        Assert.assertTrue(page.usernameKutusu.isDisplayed());
        page.loginButonu.click();

        ReusableMethods.wait(3);

        // 6. Admin Login sayfasinda username ve password ile giris yaparak kontrol paneline erisin
        page.usernameKutusu.clear();
        page.usernameKutusu.sendKeys("admin40");
        page.passwordKutusu.sendKeys("123123123");
        page.loginButonu.click();

        // 7. Dashboard sayfasinin gorunur oldugunu dogrulayin
        String expedtedDashboard = "https://qa.easybusticket.com/admin" ;
        String actuelDashboard = Driver.getDriver().getCurrentUrl();

        Assert.assertTrue(actuelDashboard.contains(expedtedDashboard));


        Driver.closeDriver();
    }

}
