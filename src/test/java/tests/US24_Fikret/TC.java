package tests.US24_Fikret;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import pages.UserDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC extends TestBaseRapor {
    List<WebElement> baslikVeIcerikElementList;
    List<String> baslikVeIcerikList;

    @Test
    public void test01() {
        extentTest = extentReports.createTest("US_24");
        //1.“ https://qa.easybusticket.com/admin” adresine gider
        Driver.getDriver().get("https://qa.easybusticket.com/admin");
        extentTest.info("Ana sayfaya gider");
        //2. Admin Login sayfasinda geçerli username ve geçerli password girerek login olur
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin32");
        adminDashboard.passwordKutusu.sendKeys("Prs12345.");
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        extentTest.info("Gecerli username ve pasword girerek login olur");
        //3. Sol menüden Manage Users linkine tıklar
        ReusableMethods.clickWithJS(adminDashboard.manageUsers);
        extentTest.info("Manage Users linkine tiklar");
        //4. Açılan menü menüde All Users, Active Users, Banned Users, Email Unverified, Sms Unverified
        // liklerine tek tek tıklayıp ilgili sayfalara yönlendirildiğini doğrular; User,Email-Phone,Country,
        // Joined At başlıklarını ve altındaki bilgileri yazdırır
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.clickWithJS(adminDashboard.allUsers);
        extentTest.info("All Users linkine tiklar");
        String actualAllUsersText = adminDashboard.manageUsersYazisi.getText();
        String expectedAllUsersText = "Manage Users";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        extentTest.pass("Manage Users sayfasina gidildigini dogrular");
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println(baslikVeIcerikList);
        System.out.println("Sayi : " +adminDashboard.table.size());
        extentTest.info("Baslik ve alt verileri goruntuler ve yazdirir");
        //ReusableMethods.wait(2);
        System.out.println(baslikVeIcerikList.size());
        ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(adminDashboard.activeUsers);
        extentTest.info("Active Users linkine tiklar");
        String actualActiveUsersText = adminDashboard.manageActiveUsersYazisi.getText();
        String expectedActiveUsersText = "Active Users";
        softAssert.assertEquals(actualActiveUsersText, expectedActiveUsersText);
        extentTest.pass("Active Users link adi ile gidilen sayfa adinin ayni oldugunu dogrular");
        //ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(adminDashboard.bannedUsers);
        String actualBannedUsersText = adminDashboard.bannedUsersYazisi.getText();
        String expectedBannedUsersText = "Banned Users";
        softAssert.assertEquals(actualBannedUsersText, expectedBannedUsersText);
        extentTest.pass("Banned Users link adi ile gidilen sayfa adinin ayni oldugunu dogrular");
        //ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(adminDashboard.emailUnverified);
        String actualEmailUnverifiedText = adminDashboard.emailUnverifiedUsersYazisi.getText();
        String expectedEmailUnverifiedText = "Email Unverified";
        softAssert.assertEquals(actualEmailUnverifiedText, expectedEmailUnverifiedText);
        extentTest.pass("Email Unverified link adi ile gidilen sayfa adinin ayni oldugunu dogrular");
        //ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(adminDashboard.smsUnverified);
        String actualSmsUnverifiedText = adminDashboard.SMSUnverifiedUsersYazisi.getText();
        String expectedSmsUnverifiedText = "Sms Unverified";
        softAssert.assertEquals(actualSmsUnverifiedText, expectedSmsUnverifiedText);
        extentTest.pass("Sms Unverified link adi ile gidilen sayfa adinin ayni oldugunu dogrular");
        //ReusableMethods.wait(2);
        ReusableMethods.clickWithJS(adminDashboard.allUsers);
        extentTest.info("All Users linkine tiklar");
        //5. Herhangi bir Action butonuna tıklar
        ReusableMethods.clickWithJS(adminDashboard.manageUsersActionIconu);
        extentTest.info("Manage Users Action butonuna tiklar");
        //6. Açılan sayfadaki “Information of user” da Firstname textBox' ındaki veriyi handle eder
        String informationOfUserFirstname = adminDashboard.usersDetailFirstnameTextBox.getAttribute("value");
        System.out.println("Information Of User Firstname :" + informationOfUserFirstname);
        extentTest.info("Information Of User sayfasindaki Firstname'i handle eder ve yazdirir");
        //7. “Login as User” butonuna tıklar
        ReusableMethods.clickWithJS(adminDashboard.loginAsUserButton);
        extentTest.info("Login as User butonuna tiklayarak o kisi olrak giris yapar");
        //8. Açılan user Dashboard sayfasında Profile menüsüne tıklar
        ReusableMethods.switchToWindow("Easy Bus Ticket - Dashboard");
        //ReusableMethods.wait(2);
        UserDashboard userDashboard = new UserDashboard();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.profile).perform();
        extentTest.info("Profile menusu uzerine move yapar");
        //9. Profile menüsünden Profile linkine tıklar
        ReusableMethods.clickWithJS(userDashboard.profileProfileLinki);
        extentTest.info("Profile linkine tiklar");
        //10. Profile Settings sayfasını text' inden görüntüler ve dogrular
        String profileSettingsYazisi = userDashboard.profileText.getText();
        softAssert.assertTrue(profileSettingsYazisi.contains("Profile"));
        extentTest.pass("Profile Settings sayfasinda oldugunu dogrular");
        //11.Profile Settings sayfasındaki Firstname text bilgisinin
            // Admin manage/User Detail sayfasındaki Firstname ile aynı olduğunu doğrular
       String profileSettingFirstname = userDashboard.firstname.getAttribute("value");
       System.out.println("Profile Settings Firstname :" + profileSettingFirstname);
       extentTest.info("Profile Sayfasindaki Firstname handle eder ve yazdirir");
       softAssert.assertEquals(informationOfUserFirstname,profileSettingFirstname);
       extentTest.pass("Information Of User sayfasindaki Firstname ile " +
                               "Profile Sayfasindaki Firstname' in ayni oldugunu dogrular");
       softAssert.assertAll();
        //12. Sayfayı kapatır
       Driver.quitDriver();
       extentTest.info("Sayfayi kapatir");
    }
}
