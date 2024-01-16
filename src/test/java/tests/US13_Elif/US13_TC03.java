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
import java.util.*;

public class US13_TC03 extends TestBaseRapor{
    @Test
    public void test03() {
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest=extentReports.createTest("End2End"," Kullanici 'Bilet al' linki uzerinden bilet alma islemini tamamlayip bilet bilgilerini goruntulemeli ");
        //Click on 'SignIn' button
        VisitorHomepage visitorHomepage = new VisitorHomepage();
        visitorHomepage.ButtonSignIn.click();
        ReusableMethods.waitFor(1);
        extentTest.info("Kullanici signIn butonuna tiklar");
        // Enter correct username and password
        visitorHomepage.textBoxUsername.sendKeys("elifatci");
        extentTest.info("kullanici gecerli username girer");
        visitorHomepage.textBoxPassword.sendKeys("123Elif_");
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici gecerli password girer");
        // Click 'login' button
        visitorHomepage.buttonLogin.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici login butonuna tiklar");
        //Hover over the reservation link
        UserDashboard userDashboard = new UserDashboard();
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(userDashboard.headerBooking).perform();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici rezervasyon linki uzerine gelir");
        //Click on the 'buy ticket' button
        userDashboard.LinkbuyTicket.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici bilet satin al linkine tiklar");
        //Select your starting point from the pickup point dropdown
        userDashboard.pickupPoint.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici gidis yeri acilir menusune tiklar");
        userDashboard.dropdownDroppingHouston.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici gidis yerini secer");
        //Select your dropping point from the dropping point dropdown
        userDashboard.droppingPoint.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici varis yeri acilir menusune tiklar");
        userDashboard.dropdownPickupNashville.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici varis yerini secer");
        // Click on 'Find Tickets' button
        userDashboard.findTickets.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici bilet ara butonuna tiklar");
        //Confirm that the available tickets are displayed
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(userDashboard.selectSeat.isDisplayed(), "the available tickets are not displayed");
        extentTest.pass("kullanici uygun biletlerin goruntulendigini dogrular");
        //Click on the 'Select Seat' button for the available ticket
        ReusableMethods.clickWithJS(userDashboard.selectSeat);
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici koltuk sec butonuna tiklar");
        //Click on the available seat
        ReusableMethods.clickWithJS(userDashboard.koltukA1);
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici koltuk secer");
        //Verify that the selected departure and arrival points are visible
        softAssert.assertTrue(userDashboard.dogrulamaGidisVaris.isDisplayed(), "departure and arrival points are not visible");
        extentTest.pass("kullanici gidis varis yerlerinin gorunur oldugunu dogrular");
        //Select your gender
        ReusableMethods.clickWithJS(userDashboard.female);
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici cinsiyetini secer");
        //Click on the 'Continue' button
        ReusableMethods.clickWithJS(userDashboard.Continue);
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici continue butonuna tiklar");
        //Confirm the displayed alert
        ReusableMethods.clickWithJS(userDashboard.Confirm);
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici confirm butonuna tiklar");
        //Click on the 'Pay Now' button
        ReusableMethods.clickWithJS(userDashboard.stripeHosted);
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici pay now butonuna tiklar");
        //Confirm the displayed alert
        ReusableMethods.waitFor(2);
        ReusableMethods.clickWithJS(userDashboard.buttonConfirmPaymentStripe);
        //Click on the 'Pay Now' button
        ReusableMethods.clickWithJS(userDashboard.payNow);
        ReusableMethods.waitFor(1);
        //Enter the card information and click on the 'Pay Now' button
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        extentTest.info("kullanici sayfayi asagi kaydirir");
        ReusableMethods.waitFor(2);
        userDashboard.cardNumber.sendKeys("4242424242424242");
        extentTest.info("kullanici kart numarasini girer");
        userDashboard.expirationDate.sendKeys("02/30");
        extentTest.info("kullanici kartinin son kullanma tarihini girer");
        userDashboard.CVC.sendKeys("111");
        extentTest.info("kullanici CVC numarasini girer");
        userDashboard.payNOW.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici pay now tiklar");
        //Verify that the 'Payment Successfully Saved' message is visible
        ReusableMethods.waitForVisibility(userDashboard.messagePaymentSuccesfully,4);
        softAssert.assertTrue(userDashboard.messagePaymentSuccesfully.isDisplayed());
        extentTest.pass("kullanici odemeniz basariyla kaydedildi mesajinin gorunur oldugunu dogrular");
        //Confirm that the booking history page is visible
        softAssert.assertTrue(userDashboard.headerBooking.isDisplayed(), "the booking history page is not visible");
        extentTest.pass("kullanici rezervasyon sayfasinin goruntulendigini dogrular");
        //Confirm that the purchased ticket is visible on the page
        ReusableMethods.switchToWindow("Easy Bus Ticket - Ticket Print");
        softAssert.assertTrue(Driver.getDriver().getCurrentUrl().contains("ticket"), "the purchased ticket is not visible on the page");
        extentTest.pass("kullanici sayfada aldigi biletin gorunur oldugunu dogrular");
        //Click on the print ticket icon
        userDashboard.buttonFirstAction.click();
        ReusableMethods.waitFor(1);
        extentTest.info("kullanici bilet yazdirma butonuna tiklar");
        //Click on the 'dowload ticket' button
        ReusableMethods.waitFor(1);
        ReusableMethods.clickWithJS(userDashboard.buttonDownloadTicket);
        extentTest.info("kullanici bilet indir butonuna tiklar");
        //Confirm that the ticket has been downloaded
        String filePath = System.getProperty("user.home") + "\\Downloads\\elifatci_1705338377.pdf";
        ReusableMethods.waitFor(3);
        softAssert.assertTrue(Files.exists(Paths.get(filePath)));
        extentTest.pass("kullanici biletin indirildigini dogrular");
        //ReusableMethods.getScreenshot()
        ReusableMethods.waitFor(2);
        softAssert.assertAll();
        //Close the browser
        Driver.quitDriver();


    }
}
