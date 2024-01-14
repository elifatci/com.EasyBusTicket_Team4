package tests.US15_Fikret;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;


public class TC {

    @Test
    public void test01() {
        //1.“ https://qa.easybusticket.com/” adresine gider
        Driver.getDriver().get("https://qa.easybusticket.com/");
        VisitorHomepage homepage = new VisitorHomepage();
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
        ReusableMethods.clickWithJS(homepage.buttonLogin);
        //5. Dashboard sayfasinda Support Reques menusune tiklar
        UserDashboard userDashboard = new UserDashboard();
        ReusableMethods.clickWithJS(userDashboard.headerSupportRequest);
        //6. Creat new linkine tiklar
        ReusableMethods.clickWithJS(userDashboard.createNewButonu);
        //7. Boş olarak gelen kutulara gerekli bilgileri girer
        userDashboard.Subject.sendKeys("mesajim");
        Select dropdown = new Select(userDashboard.priorityDropBox);
        dropdown.selectByVisibleText("Medium"); // veya başka bir seçenek belirleyebilirsiniz
        userDashboard.yorumAlani.sendKeys("Mars'a araciniz yok, koyarmisiniz lutfen..");
        //8. Bir doküman ekleyin
        String filePath = "C:\\Users\\Z€YB\\Desktop\\denemem.docx";
        userDashboard.dosyaSec.sendKeys(filePath);
        //9. Mesajı gönderin
        ReusableMethods.clickWithJS(userDashboard.submitButtonu);
        //10. Subject, Status, Priority ve Last Reply başlıklarını ve içeriklerini görüntüleyin



        //11. Action butonuna tıklayın
        //12. Açılan sayfada mesajınızı görüntüleyin
        //13. Attachment 1 tıklayıp, dosyanın indirildiğini doğrulayın
        //14. Your reply placeholder içeren textBox’ a cevabınızı yazın
        //14. Replay butonuna tıklayıp cevabınızı gönderin
        //15.Cevabın başarılı bir şekilde gönderildiğini doğrulayın-Replied ile doğrulama yapılabilir
        //16.Sayfayı kapatın
        ReusableMethods.wait(7);
        Driver.closeDriver();
    }
}
