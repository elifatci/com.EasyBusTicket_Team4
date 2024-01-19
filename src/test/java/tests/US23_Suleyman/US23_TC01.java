package tests.US23_Suleyman;

import org.openqa.selenium.Keys;
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

public class US23_TC01 extends TestBaseRapor {
@Test
    public void test01(){
    extentTest=extentReports.createTest("US23","Admin, Manage Users ve alt başlıkları görüntüler.");
    // 1. Open the browser.
    // 2.Navigate to url "https://qa.easybusticket.com/admin"
    Driver.getDriver().get("https://qa.easybusticket.com/admin");
    extentTest.info("Navigate to url \"https://qa.easybusticket.com/admni\"");
    // 3.Logs in with valid username and valid password.
    AdminDashboard adminDashboard = new AdminDashboard();
    adminDashboard.usernameKutusu.sendKeys("admin38");
    adminDashboard.passwordKutusu.sendKeys("123123123");
    adminDashboard.loginButonu.click();
    extentTest.info("Logs in with valid username and valid password..");
    // 4.Click on Manage Users link in the left menu.
    adminDashboard.manageUsers.click();
    extentTest.info("Click on Manage Users link in the left menu.");
    // 5.Displays all users, active users, banned users, email unverified, sms unverified.
    List<WebElement> baslikVeIcerikElementList = adminDashboard.table;
    List<String> baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
    System.out.println("Users listesi : "+baslikVeIcerikList);
    extentTest.info("Displays all users, active users, banned users, email unverified, sms unverified.");
    // 6.Verifies that the relevant pages are accessed by clicking on All users, active users, banned users,
    // Email unverified, sms unverified page links.
    SoftAssert softAssert=new SoftAssert();
    ReusableMethods.clickWithJS(adminDashboard.allUsers);
    extentTest.pass("Verifies that you are on the Manage page.");
    softAssert.assertTrue(adminDashboard.manageUsersYazisi.getText().contains("Manage"));
    ReusableMethods.clickWithJS(adminDashboard.activeUsers);
    softAssert.assertTrue(adminDashboard.manageActiveUsersYazisi.getText().contains("Active"));
    extentTest.pass("Verifies that it is on the Active page.");
    ReusableMethods.clickWithJS(adminDashboard.bannedUsers);
    softAssert.assertTrue(adminDashboard.bannedUsersYazisi.getText().contains("Banned"));
    extentTest.pass("It confirms that you are on the Banned page.");
    System.out.println("Banned sayısı : "+adminDashboard.table.size());
    ReusableMethods.clickWithJS(adminDashboard.emailUnverified);
    softAssert.assertTrue(adminDashboard.emailUnverifiedUsersYazisi.getText().contains("Email"));
    extentTest.pass("Verifies that it is on the email page.");
    System.out.println("Email sayısı : "+adminDashboard.table.size());
    ReusableMethods.clickWithJS(adminDashboard.smsUnverified);
    softAssert.assertTrue(adminDashboard.SMSUnverifiedUsersYazisi.getText().contains("SMS"));
    extentTest.pass("Verifies that you are on the SMS page.");
    System.out.println("SMS sayısı : "+adminDashboard.table.size());
    ReusableMethods.clickWithJS(adminDashboard.allUsers);
    // 7.Verifies that the search textboxes are available.
    softAssert.assertTrue(adminDashboard.allPnrNumberAramaKutusu.isEnabled());
    extentTest.pass("Verifies that the textbox is available.");
    // 8.Search textboxes are searched by entering email address and username.
    adminDashboard.usernameOrEmailSearchKutusu.sendKeys("solomon"+ Keys.ENTER);
    extentTest.pass("Search textboxes are searched by entering email address and username");
    // 9.Verifies that the searched person is reached.
    softAssert.assertTrue(adminDashboard.userSearchTitle.isEnabled());
    extentTest.pass("Verifies that you can search by username and view the person in the search result.");
    // 10.Clicks the Email to All link under Manage Users.
    adminDashboard.emailToAll.click();
    extentTest.pass("Clicks the Email to All link under Manage Users");
    // 11.Verifies that you have reached the page.
    softAssert.assertTrue(adminDashboard.sendEmailToAllUsersYazisi.isDisplayed());
    extentTest.pass("Verifies that you have reached the page.");
    // 12.Verifies that the Subject and Message textboxes are available.
    softAssert.assertTrue(adminDashboard.subjectKutusu.isEnabled());
    softAssert.assertTrue(adminDashboard.messageKutusu.isEnabled());
    extentTest.pass("Verifies that the Subject and Message textboxes are available.");
    // 13.Enters the necessary data in the textboxes and clicks the Send Email button.
    adminDashboard.subjectKutusu.sendKeys("deneme");
    adminDashboard.messageKutusu.sendKeys("iptal");
    adminDashboard.sendEmailButonu.click();
    extentTest.pass("Enters the necessary data in the textboxes and clicks the Send Email button.");
    // 14.Verifies that the e-mail is sent to all users.
    extentTest.pass("Verifies that the e-mail is sent to all users.");
    softAssert.assertTrue(adminDashboard.emailUnverifiedUsersYazisi.getText().contains("succesfull"),"BURADA EMAİL GÖNDERİLEMİYOR.");
    softAssert.assertAll();
    // 15.Close the browser
    Driver.closeDriver();
    extentTest.info("Close the browser");
}
}
