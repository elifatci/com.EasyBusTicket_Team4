package tests.US13_Elif;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class US13_TC03 {
    @Test
    public void test03() {
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        //extentTest=extentReports.createTest("Hata sonuc","Hatalarin tamami");
        //Click on 'SignIn' button
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        visitorHomepage.ButtonSignIn.click();
        // Enter correct username and password
        visitorHomepage.textBoxUsername.sendKeys("elifatci");
        visitorHomepage.textBoxPassword.sendKeys("123Elif_");
        // Click 'login' button
        visitorHomepage.buttonLogin.click();
        //Hover over the reservation link
        UserDashboard userDashboard = new UserDashboard();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.headerBooking).perform();
        //Click on the 'buy ticket' button
        userDashboard.LinkbuyTicket.click();
        //Select your starting point from the pickup point dropdown
        userDashboard.pickupPoint.click();
        userDashboard.dropdownDroppingHouston.click();
        //Select your dropping point from the dropping point dropdown
        userDashboard.droppingPoint.click();
        userDashboard.dropdownPickupNashville.click();
        // Click on 'Find Tickets' button
        userDashboard.findTickets.click();
        //Confirm that the available tickets are displayed
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(userDashboard.selectSeat.isDisplayed(), "the available tickets are not displayed");
        //extentTest.pass("Uygun biletler goruntulendi");
        //Click on the 'Select Seat' button for the available ticket
        ReusableMethods.clickWithJS(userDashboard.selectSeat);
        //Click on the available seat
        List<WebElement> tumKoltuklar = userDashboard.tableSeat;
        JavascriptExecutor js = (JavascriptExecutor) Driver.getDriver();
        //js.executeScript("arguments[0].click()", ReusableMethods.chooseSeat(tumKoltuklar));
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(userDashboard.koltukJ2);
        //Verify that the selected departure and arrival points are visible
        softAssert.assertTrue(userDashboard.dogrulamaGidisVaris.isDisplayed(), "departure and arrival points are not visible");
        //extentTest.pass("Gidis varis yerleri goruntulendi");
        //Select your gender
        ReusableMethods.clickWithJS(userDashboard.female);
        //Click on the 'Continue' button
        ReusableMethods.clickWithJS(userDashboard.Continue);
        //Confirm the displayed alert
        ReusableMethods.clickWithJS(userDashboard.Confirm);
        //Click on the 'Pay Now' button
        ReusableMethods.clickWithJS(userDashboard.stripeHosted);
        //Confirm the displayed alert
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(userDashboard.buttonConfirmPaymentStripe);
        //Click on the 'Pay Now' button
        ReusableMethods.clickWithJS(userDashboard.payNow);
        //Enter the card information and click on the 'Pay Now' button
        js = (JavascriptExecutor) Driver.getDriver();
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        ReusableMethods.waitFor(2);
        userDashboard.cardNumber.sendKeys("4242424242424242");
        userDashboard.expirationDate.sendKeys("02/30");
        userDashboard.CVC.sendKeys("111");
        userDashboard.payNOW.click();
        //Confirm that the booking history page is visible
        softAssert.assertTrue(userDashboard.headerBooking.isDisplayed(), "the booking history page is not visible");
        //extentTest.pass("Booking history sayfasi goruntulendi");
        //Confirm that the purchased ticket is visible on the page
        ReusableMethods.switchToWindow("Easy Bus Ticket - Ticket Print");
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("ticket"), "the purchased ticket is not visible on the page");
        //extentTest.pass("the purchased ticket sayfasi goruntulendi");
        //Click on the print ticket icon
        userDashboard.buttonFirstAction.click();
        //Click on the 'dowload ticket' button
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(userDashboard.buttonDownloadTicket);
        //Confirm that the ticket has been downloaded
        String filePath = System.getProperty("user.home") + "\\Downloads\\elifatci_1705338377.pdf";
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(Files.exists(Paths.get(filePath)));
        //ReusableMethods.getScreenshot()
        ReusableMethods.waitFor(2);
        softAssert.assertAll();
        //Close the browser
        Driver.quitDriver();


    }
}
