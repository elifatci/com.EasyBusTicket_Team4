package tests.US26_Fikret;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.Driver;
import utilities.ReusableMethods;

import java.util.List;

public class TC {
    List<WebElement> baslikVeIcerikElementList;
    List<String> baslikVeIcerikList;
    String actualAllUsersText;
    String expectedAllUsersText;
    @Test
    public void test04(){
        //1.“ https://qa.easybusticket.com/admin” adresine gider
        Driver.getDriver().get("https://qa.easybusticket.com/admin");
        //2.Admin Login sayfasindaki textbox'lara geçerli username ve geçerli password girerek login olur
        AdminDashboard adminDashboard = new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin32");
        adminDashboard.passwordKutusu.sendKeys("Prs12345.");
        ReusableMethods.clickWithJS(adminDashboard.loginButonu);
        //3. Sol menüden Booking History linkine tıklar
        ReusableMethods.clickWithJS(adminDashboard.bookingHistory);
        //4.Pending Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        SoftAssert softAssert = new SoftAssert();
        ReusableMethods.clickWithJS(adminDashboard.pendingTicket);
        actualAllUsersText = adminDashboard.pendingTicketYazisi.getText();
        expectedAllUsersText = "Pending Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println(baslikVeIcerikList);
        Driver.getDriver().navigate().back();
        //5.Booked Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        ReusableMethods.clickWithJS(adminDashboard.bookedTicket);
        actualAllUsersText = adminDashboard.bookedTicketYazisi.getText();
        expectedAllUsersText = "Booked Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println(baslikVeIcerikList);
        Driver.getDriver().navigate().back();
        //6.Rejected Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        ReusableMethods.clickWithJS(adminDashboard.rejectedTicket);
        actualAllUsersText = adminDashboard.rejectedTicketYazisi.getText();
        expectedAllUsersText = "Rejected Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println(baslikVeIcerikList);
        Driver.getDriver().navigate().back();
        //7.All Ticket linkine tıklar, User,Email-Phone,Country,Joined A User,
            // PNR Number,Journey Date,Trip,Pickup Point,Dropping Point,Status,Ticket Count,Fare
            // başlıklarını görüntüler, altındaki bilgileri yazdırır
        ReusableMethods.clickWithJS(adminDashboard.allTicket);
        actualAllUsersText = adminDashboard.allTicketYazisi.getText();
        expectedAllUsersText = "All Ticket";
        softAssert.assertEquals(actualAllUsersText, expectedAllUsersText);
        baslikVeIcerikElementList = adminDashboard.tableElementi;
        baslikVeIcerikList = ReusableMethods.getElementsText(baslikVeIcerikElementList);
        System.out.println(baslikVeIcerikList);
        //8.Profile tıklar
        ReusableMethods.clickWithJS(adminDashboard.profileButton);
        //9.Logout' a tıklar ve çıkış yapar
        ReusableMethods.clickWithJS(adminDashboard.logoutButton);
        softAssert.assertAll();
        //10. Sayfayı kapatır
        Driver.closeDriver();
    }

}
