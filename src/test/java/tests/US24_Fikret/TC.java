package tests.US24_Fikret;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import pages.UserDashboard;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC {
    List<WebElement> baslikVeIcerikElementList;
    List<String> baslikVeIcerikList;

    @Test
    public void test01() {
        //1.“ https://qa.easybusticket.com/admin” adresine gider
        Driver.getDriver().get("https://qa.easybusticket.com/admin");
        //2. Admin Login sayfasinda geçerli username ve geçerli password girerek login olur
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin32");
        adminDashboard.passwordKutusu.sendKeys("Prs12345.");
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        //3. Sol menüden Manage Users linkine tıklar
        ReusableMethods.clickWithJS(adminDashboard.manageUsers);
        //4. Açılan menü menüde All Users, Active Users, Banned Users, Email Unverified, Sms Unverified
        // liklerine tek tek tıklayıp ilgili sayfalara yönlendirildiğini doğrular; User,Email-Phone,Country,
        // Joined At başlıklarını ve altındaki bilgileri yazdırır
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.clickWithJS(adminDashboard.allUsers);
        String actualAllUsersText = adminDashboard.manageUsersYazisi.getText();
        String expectedAllUsersText = "Manage Users";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println("===========================================================");
        System.out.println(baslikVeIcerikList);
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.clickWithJS(adminDashboard.activeUsers);
        String actualActiveUsersText = adminDashboard.manageActiveUsersYazisi.getText();
        String expectedActiveUsersText = "Active Users";
        softAssert.assertEquals(actualActiveUsersText, expectedActiveUsersText);
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.clickWithJS(adminDashboard.bannedUsers);
        String actualBannedUsersText = adminDashboard.bannedUsersYazisi.getText();
        String expectedBannedUsersText = "Banned Users";
        softAssert.assertEquals(actualBannedUsersText, expectedBannedUsersText);
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.clickWithJS(adminDashboard.emailUnverified);
        String actualEmailUnverifiedText = adminDashboard.emailUnverifiedUsersYazisi.getText();
        String expectedEmailUnverifiedText = "Email Unverified";
        softAssert.assertEquals(actualEmailUnverifiedText, expectedEmailUnverifiedText);
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();

        ReusableMethods.clickWithJS(adminDashboard.smsUnverified);
        String actualSmsUnverifiedText = adminDashboard.SMSUnverifiedUsersYazisi.getText();
        String expectedSmsUnverifiedText = "Sms Unverified";
        softAssert.assertEquals(actualSmsUnverifiedText, expectedSmsUnverifiedText);
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(adminDashboard.allUsers);
        //5. Herhangi bir Action butonuna tıklar
        ReusableMethods.clickWithJS(adminDashboard.manageUsersActionIconu);
        //6. Açılan sayfadaki “Information of user” altındaki bilgileri yazdırır
        System.out.println(adminDashboard.usersDetailFirstnameTextBox.getText());
        //7. “Login as User” butonuna tıklar
        ReusableMethods.clickWithJS(adminDashboard.loginAsUserButton);
        //8. Açılan user Dashboard sayfasında Profile menüsüne tıklar
        ReusableMethods.switchToWindow("Easy Bus Ticket - Dashboard");
        ReusableMethods.wait(2);
        UserDashboard userDashboard = new UserDashboard();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.profile).perform();
        //9. Profile menüsünden Profile linkine tıklar
        ReusableMethods.clickWithJS(userDashboard.profileProfileLinki);
        //10. Profile Settings sayfasını text' inden görüntüler ve dogrular
        String profileSettingsYazisi = userDashboard.profileText.getText();
        softAssert.assertTrue(profileSettingsYazisi.contains("Profile"));
        softAssert.assertAll();
        //11. Sayfayı kapatır
        Driver.quitDriver();
    }
}
