package scenarios;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import pages.UserDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class RegressionTest extends TestBaseRapor {
    @Test
    public void updateTesti() {

        extentTest = extentReports.createTest("Regression Test","Eski data verilerinde update işlemi gerçekleştirebilmeli");
        //1.“ https://qa.easybusticket.com/admin” adresine gider.
        Driver.getDriver().get("https://qa.easybusticket.com/admin");
        extentTest.info("Ana sayfaya gider");
        ReusableMethods.waitFor(3);
        //2. Admin Login sayfasinda geçerli username ve geçerli password girerek login olur.
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        extentTest.info("Gecerli username ve pasword girerek login olur");
        ReusableMethods.waitFor(6);
        //3. Sol menüden Manage Users linkine tıklar.
        ReusableMethods.clickWithJS(adminDashboard.manageUsers);
        extentTest.info("Manage Users linkine tiklar");
        ReusableMethods.waitFor(4);
        //4. Açılan menüde All Users linkine tıklayıp ilgili sayfaya yönlendirildiğini doğrular.
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.clickWithJS(adminDashboard.allUsers);
        extentTest.info("All Users linkine tiklar");
        String actualAllUsersText = adminDashboard.manageUsersYazisi.getText();
        String expectedAllUsersText = "Manage Users";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        extentTest.pass("Manage Users sayfasina gidildigini dogrular");
        ReusableMethods.waitFor(5);
        // Arama Kutusuna eski bir kullanıcı ismi girer.
        adminDashboard.manageUsersSearchBoxKutusu.sendKeys("MEHMET"+ Keys.ENTER);
        ReusableMethods.waitFor(5);
        //5.Aramada çıkan kişinin Action butonuna tıklar.

        ReusableMethods.clickWithJS(adminDashboard.manageUsersActionIconu);
        extentTest.info("Manage Users Action butonuna tiklar");
        ReusableMethods.waitFor(4);
        //6.Kişiye ait Firstname i "AHMET",Lastname'i "TOPRAK" olarak update eder.
        adminDashboard.usersDetailFirstnameTextBox.clear();
        adminDashboard.usersDetailFirstnameTextBox.sendKeys("AHMET");
        ReusableMethods.waitFor(3);
        adminDashboard.usersDetailLastnameTextBox.clear();
        adminDashboard.usersDetailLastnameTextBox.sendKeys("TOPRAK");
        ReusableMethods.waitFor(3);
        //8.Save Changes butonuna basarak değişiklikleri kaydeder.
        ReusableMethods.clickWithJS(adminDashboard.ButtonsaveChanges);
        extentTest.info("Save Changes butonuna basarak değişiklikleri kaydeder.");
        ReusableMethods.waitFor(5);
        //9.User action penceresindeki  “Login as User” butonuna tıklar.
        ReusableMethods.clickWithJS(adminDashboard.loginAsUserButton);
        extentTest.info("Login as User butonuna tiklayarak o kisi olarak giris yapar");
        ReusableMethods.waitFor(5);
        //10. Açılan User Dashboard sayfasında Profile menüsüne tıklar.
        ReusableMethods.switchToWindow("Easy Bus Ticket - Dashboard");
        ReusableMethods.waitFor(5);
        UserDashboard userDashboard = new UserDashboard();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.profile).perform();
        extentTest.info("Profile menusu uzerine move yapar");
        //11. Profile menüsünden Profile linkine tıklar.
        ReusableMethods.clickWithJS(userDashboard.profileProfileLinki);
        extentTest.info("Profile linkine tiklar");
        ReusableMethods.waitFor(3);
        //12. Profile Settings sayfasını text' inden görüntüler ve dogrular.
        String profileSettingsYazisi = userDashboard.profileText.getText();
        softAssert.assertTrue(profileSettingsYazisi.contains("Profile"));
        extentTest.pass("Profile Settings sayfasinda oldugunu dogrular");
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(5);
        //13.Profile Settings sayfasındaki Firstname ve Lastname text bilgilerini handle eder.
        String actualFirstname = userDashboard.firstname.getAttribute("value");
        extentTest.pass("Profile Sayfasindaki Firstname handle eder.");
        String expectedFirstname = "AHMET";
        softAssert.assertEquals(actualFirstname, expectedFirstname, "Firstname'ler aynı değil!");
        extentTest.pass("Firstname'in update edilmiş olduğunu doğrular.");
        ReusableMethods.waitFor(5);
        String actualLastName = userDashboard.textBoxProfileLastname.getAttribute("value");
        extentTest.pass("Profile Sayfasindaki LastName'i handle eder.");
        String expectedLastName = "TOPRAK";
        softAssert.assertEquals(actualLastName, expectedLastName, "Lastname'ler aynı değil!");
        extentTest.pass("Mobile Number'in update edilmiş olduğunu doğrular.");
        ReusableMethods.waitFor(5);

        softAssert.assertAll();
        //14. Sayfayı kapatır
        Driver.quitDriver();
        extentTest.info("Sayfayi kapatir");
    }
}



