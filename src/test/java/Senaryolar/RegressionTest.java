package Senaryolar;
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

        extentTest = extentReports.createTest("Regression Test");
        //1.“ https://qa.easybusticket.com/admin” adresine gider.
        Driver.getDriver().get("https://qa.easybusticket.com/admin");
        extentTest.info("Ana sayfaya gider");
        //2. Admin Login sayfasinda geçerli username ve geçerli password girerek login olur.
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        extentTest.info("Gecerli username ve pasword girerek login olur");
        //3. Sol menüden Manage Users linkine tıklar.
        ReusableMethods.clickWithJS(adminDashboard.manageUsers);
        extentTest.info("Manage Users linkine tiklar");
        //4. Açılan menüde All Users linkine tıklayıp ilgili sayfaya yönlendirildiğini doğrular.
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.clickWithJS(adminDashboard.allUsers);
        extentTest.info("All Users linkine tiklar");
        String actualAllUsersText = adminDashboard.manageUsersYazisi.getText();
        String expectedAllUsersText = "Manage Users";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        extentTest.pass("Manage Users sayfasina gidildigini dogrular");
        ReusableMethods.wait(2);
        // Arama Kutusuna eski bir kullanıcı ismi girer.
        adminDashboard.manageUsersSearchBoxKutusu.sendKeys("MEHMET"+ Keys.ENTER);
        //5.Güncel tarihle giriş yapmış bir kişinin Action butonuna tıklar.
        ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(adminDashboard.manageUsersActionIconu);
        extentTest.info("Manage Users Action butonuna tiklar");
        //6.Kişiye ait Firstname i "Deniz",Mobile Number'ı "999999999" olarak update eder.
        adminDashboard.usersDetailFirstnameTextBox.clear();
        adminDashboard.usersDetailFirstnameTextBox.sendKeys("Deniz");
        ReusableMethods.wait(2);
        adminDashboard.usersDetailMobileNumberTextBox.clear();
        adminDashboard.usersDetailMobileNumberTextBox.sendKeys("999999999");
        ReusableMethods.wait(2);
        //8.Save Changes butonuna basarak değişiklikleri kaydeder.
        ReusableMethods.clickWithJS(adminDashboard.ButtonsaveChanges);
        extentTest.info("Save Changes butonuna basarak değişiklikleri kaydeder.");
        ReusableMethods.wait(2);
        //9. “Login as User” butonuna tıklar
        ReusableMethods.clickWithJS(adminDashboard.loginAsUserButton);
        extentTest.info("Login as User butonuna tiklayarak o kisi olarak giris yapar");
        ReusableMethods.wait(2);
        //10. Açılan User Dashboard sayfasında Profile menüsüne tıklar
        ReusableMethods.switchToWindow("Easy Bus Ticket - Dashboard");
        //ReusableMethods.wait(2);
        UserDashboard userDashboard = new UserDashboard();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.profile).perform();
        extentTest.info("Profile menusu uzerine move yapar");
        //11. Profile menüsünden Profile linkine tıklar
        ReusableMethods.clickWithJS(userDashboard.profileProfileLinki);
        extentTest.info("Profile linkine tiklar");
        //12. Profile Settings sayfasını text' inden görüntüler ve dogrular
        String profileSettingsYazisi = userDashboard.profileText.getText();
        softAssert.assertTrue(profileSettingsYazisi.contains("Profile"));
        extentTest.pass("Profile Settings sayfasinda oldugunu dogrular");
        //13.Profile Settings sayfasındaki Firstname ve Mobile Number text bilgilerini handle eder.
        String actualFirstname = userDashboard.firstname.getAttribute("value");
        extentTest.pass("Profile Sayfasindaki Firstname handle eder.");
        String expectedFirstname = "Deniz";
        softAssert.assertEquals(actualFirstname, expectedFirstname, "isimler aynı değil!");
        extentTest.pass("Firstname'in update edilmiş olduğunu doğrular.");
        String actualMobileNumber = userDashboard.textBoxProfileMobileNumber.getAttribute("value");
        extentTest.pass("Profile Sayfasindaki Mobile Number'ı handle eder.");
        String expectedMobileNumber = "999999999";
        softAssert.assertEquals(actualMobileNumber, expectedMobileNumber, "aynı değil!");
        extentTest.pass("Mobile Number'in update edilmiş olduğunu doğrular.");

        softAssert.assertAll();
        //14. Sayfayı kapatır
        Driver.quitDriver();
       extentTest.info("Sayfayi kapatir");
    }
}


