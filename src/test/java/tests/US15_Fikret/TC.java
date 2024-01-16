package tests.US15_Fikret;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;


public class TC {
    String filePath;

    @Test
    public void test01() {
        //1.“ https://qa.easybusticket.com/” adresine gider
        Driver.getDriver().get("https://qa.easybusticket.com/");
        VisitorHomepage homepage = new VisitorHomepage();
        SoftAssert softAssert = new SoftAssert();
        //2. Cookies kabul eder
        //Cookies varsa click yapar, yoksa kod calismaya devam eder
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
        }
        //3. SignIn butona tiklar
        ReusableMethods.clickWithJS(homepage.ButtonSignIn);
        //4. Sign In your Account sayfasinda geçerli username ve geçerli password girerek login olur
        homepage.textBoxUsername.sendKeys("fikretZ");
        homepage.textBoxPassword.sendKeys("Prs12345.");
        //ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(homepage.buttonLogin);
        //5. Dashboard sayfasinda Support Reques menusune tiklar
        UserDashboard userDashboard = new UserDashboard();
        ReusableMethods.clickWithJS(userDashboard.headerSupportRequest);
        //ReusableMethods.wait(2);
        //6. Creat new linkine tiklar
        ReusableMethods.clickWithJS(userDashboard.createNewButonu);
        //7. Boş olarak gelen kutulara gerekli bilgileri girer
        userDashboard.Subject.sendKeys("mesajim");
        //ReusableMethods.wait(2);
        Select select = new Select(userDashboard.priorityDropBox);
        //ReusableMethods.wait(2);
        select.selectByVisibleText("High"); // veya başka bir seçenek belirleyebilirsiniz
        // "High" secili oldugunu dogrular
        String actualOption = select.getFirstSelectedOption().getText();
        String expectedOption = "High";
        softAssert.assertEquals(actualOption,expectedOption,"High secili degil");
        userDashboard.yorumAlani.sendKeys("Mars'a araciniz yok, koyarmisiniz lutfen..");
        //ReusableMethods.wait(2);
        //8. Yerel PC' den bir doküman ekler
        filePath = "C:\\Users\\Z€YB\\Desktop\\denemem.docx";
        userDashboard.dosyaSec.sendKeys(filePath);
        //ReusableMethods.wait(2);
        //9. Mesajı gönderir
        ReusableMethods.clickWithJS(userDashboard.submitButtonu);
        //10. Subject, Status, Priority ve Last Reply başlıklarını ve içeriklerini görüntüler
        List<WebElement> baslikVeIcerikElementList = userDashboard.requestTable;
        List<String> baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println(baslikVeIcerikList);
        //11. Action butonuna tıklar
        //ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(userDashboard.actionReq);
        //12. Açılan sayfadaki mesajın kendi measajı oldugunu dogrular
        String actualMesaj = userDashboard.mesajim.getText();
        String expectedMesaj = "Mars'a araciniz yok, koyarmisiniz lutfen..";
        softAssert.assertEquals(actualMesaj, expectedMesaj, "different");
        //13. Attachment 1 tıklayıp, dosyanın indirildiğini doğrular
        //ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(userDashboard.attachment);
        filePath = System.getProperty("user.home") + "\\Downloads\\mesajim.docx";
        softAssert.assertTrue(Files.exists(Paths.get(filePath)));
        //14. Your reply placeholder içeren textBox’ ın kullanılabilir oldugunu test eder
        softAssert.assertTrue(userDashboard.yorumAlani.isEnabled(), "kullanilamiyor");
        //15. Your reply placeholder içeren textBox’ a cevabını yazar
        userDashboard.yorumAlani.sendKeys("Mars seferlerimiz yakinda..");
        //ReusableMethods.wait(2);
        //16. Replay butonuna tıklayarak cevabını gönderir
        ReusableMethods.clickWithJS(userDashboard.actionReply);
        //17.Cevabın başarılı bir şekilde gönderildiğini doğrular
            //Replied yazisi ile doğrulama yapılır
        softAssert.assertTrue(userDashboard.replayedYazisi.isDisplayed(), "Replied yazisi goruntulenemedi");
        //18.Profile tıklar
        ReusableMethods.clickWithJS(userDashboard.profile);
        //19.Logout' a tıklar ve çıkış yapar
        ReusableMethods.clickWithJS(userDashboard.profileProfileLinki);
        softAssert.assertAll();
        //20.Sayfayı kapatır

        Driver.closeDriver();
    }
}
