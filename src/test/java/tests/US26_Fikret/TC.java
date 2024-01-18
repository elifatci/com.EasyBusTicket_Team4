package tests.US26_Fikret;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class TC extends TestBaseRapor {
    List<WebElement> baslikVeIcerikElementList;
    List<String> baslikVeIcerikList;
    String actualAllUsersText;
    String expectedAllUsersText;
    @Test
    public void test04(){
        extentTest = extentReports.createTest("US_26");
        //1.“ https://qa.easybusticket.com/admin” adresine gider
        Driver.getDriver().get("https://qa.easybusticket.com/admin");
        extentTest.info("Ana sayfaya gider");
        //2.Admin Login sayfasindaki textbox'lara geçerli username ve geçerli password girerek login olur
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin32");
        adminDashboard.passwordKutusu.sendKeys("Prs12345.");
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        extentTest.info("Gecerli username ve pasword girerek login olur");
        //3. Sol menüden Booking History linkine tıklar
        ReusableMethods.clickWithJS(adminDashboard.bookingHistory);
        //4.Pending Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.clickWithJS(adminDashboard.pendingTicket);
        extentTest.info("Pending Ticket linkine tiklar");
        actualAllUsersText = adminDashboard.pendingTicketYazisi.getText();
        expectedAllUsersText = "Pending Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        extentTest.pass("Pending Ticket sayfasina gidildigini dogrular");
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println("======PENDING TICKET======");
        System.out.println(baslikVeIcerikList);
        extentTest.info("Baslik ve alt bilgileri yazdirir");
        //5.Booked Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        ReusableMethods.clickWithJS(adminDashboard.bookedTicket);
        extentTest.info("Booked Ticket linkine tiklar");
        actualAllUsersText = adminDashboard.bookedTicketYazisi.getText();
        expectedAllUsersText = "Booked Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        extentTest.pass("Booked Ticket sayfasina gidildigini dogrular");
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println("======BOOKED TICKET======");
        System.out.println(baslikVeIcerikList);
        extentTest.info("Baslik ve alt bilgileri yazdirir");
        //6.Rejected Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        ReusableMethods.clickWithJS(adminDashboard.rejectedTicket);
        extentTest.info("Rejected Ticket linkine tiklar");
        actualAllUsersText = adminDashboard.rejectedTicketYazisi.getText();
        expectedAllUsersText = "Rejected Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        extentTest.pass("Rejected Ticket sayfasina gidildigini dogrular");
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println("======REJECTED TICKET======");
        System.out.println(baslikVeIcerikList);
        extentTest.info("Baslik ve alt bilgileri yazdirir");
        //7.All Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        ReusableMethods.clickWithJS(adminDashboard.allTicket);
        extentTest.info("All Ticket linkine tiklar");
        actualAllUsersText = adminDashboard.allTicketYazisi.getText();
        expectedAllUsersText = "All Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        extentTest.pass("All Ticket sayfasina gidildigini dogrular");
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println("======ALL TICKET======");
        System.out.println(baslikVeIcerikList);
        extentTest.info("Baslik ve alt bilgileri yazdirir");
        //8.Profile tıklar
        ReusableMethods.clickWithJS(adminDashboard.profileButton);
        extentTest.info("Profile linkine tiklar");
        //9.Logout' a tıklar ve çıkış yapar
        ReusableMethods.clickWithJS(adminDashboard.logoutButton);
        extentTest.info("Logout' a tıklar ve çıkış yapar");
        softAssert.assertAll();
        //10. Sayfayı kapatır
        Driver.closeDriver();
        extentTest.info("Sayfayı kapatır");
    }

}
