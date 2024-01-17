package tests.US10_Ugurcan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;

public class TC02_negativeTest {
    @Test
    public void TC02_negativeTest(){


        // 1. Kullanici "https://www.easybusticket.com/login" Adresine gider
        Driver.getDriver().get(ConfigReader.getProperty("easyBusLogin"));

        // 2. Kullanici sayfanın acildigini dogrular
        String expedtedUrl = "https://qa.easybusticket.com/login" ;
        String actuelUrl = Driver.getDriver().getCurrentUrl();

        Assert.assertEquals(actuelUrl,expedtedUrl);

        // 3. Kullanici Username textbox ici bos birakilir
        VisitorHomepage page = new VisitorHomepage();

        page.textBoxUsername.sendKeys("");

        // 4. Kullanici password textbox'in icine gecerli-gecersiz sifre girer
        page.textBoxPassword.sendKeys("12234");

        // 5. Kullanici LogIn buttonuna tiklar
        page.buttonLogin.click();

        // 6. Kullanici Username textbox icine bosluk karakteri girer
        page.textBoxUsername.click();
        page.textBoxUsername.sendKeys("1234 5678");

            // 7. Kullanici password textbox'in icine gecerli-gecersiz sifre girer
        page.textBoxPassword.sendKeys("Deneme01.");

        // 8. Kullanici LogIn buttonuna tiklar
        page.buttonLogin.click();


        Driver.closeDriver();

    }
}
