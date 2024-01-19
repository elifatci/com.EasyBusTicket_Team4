package tests.US02_Berivan;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class US02_TC03 extends TestBaseRapor {

    @Test
    public void test01() throws InterruptedException {
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        extentTest=extentReports.createTest("Smoke test","The items in header section should be active");
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        extentTest.info("User goes to easyBus home page");
        // 3.These Items should be displayed;
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        SoftAssert softAssert = new SoftAssert();

        // FAQs
        String currentUrlFAQBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonFAQs.sendKeys(Keys.ENTER);
        String  currentUrlFAQAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlFAQBeforeClick,currentUrlFAQAfterClick);
        extentTest.pass("User verifies that the FAQs link is active");

        //SignIn button
        String currentUrlSignInBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.ButtonSignIn.sendKeys(Keys.ENTER);
        String  currentUrlSignInAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlSignInBeforeClick,currentUrlSignInAfterClick);
        extentTest.pass("User verifies that the SignIn button is active");

        //SignUpButton
        Driver.getDriver().navigate().back();
        String currentUrlSignUpBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.ButtonSignUp.sendKeys(Keys.ENTER);
        String  currentUrlSignUpAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlSignUpBeforeClick,currentUrlSignUpAfterClick);
        extentTest.pass("User verifies that the SignUpButton is active ");

        // Home
        Driver.getDriver().navigate().back();
        String currentUrlHomeBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonHome.sendKeys(Keys.ENTER);
        String currentUrlHomeAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlHomeBeforeClick,currentUrlHomeAfterClick);
        extentTest.pass("User verifies that the Home link is active ");

        // About
        String currentUrlAboutBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonAbout.sendKeys(Keys.ENTER);
        String currentUrlAboutAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlAboutBeforeClick, currentUrlAboutAfterClick);
        extentTest.pass("User verifies that the About link is active ");

        // Blog
        String currentUrlBlogBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonBlog.sendKeys(Keys.ENTER);
        String currentUrlBlogAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlBlogBeforeClick,currentUrlBlogAfterClick);
        extentTest.pass("User verifies that the Blog link is active ");

        // Contact
        String currentUrlContactBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonContact.sendKeys(Keys.ENTER);
        String currentUrlContactAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlContactBeforeClick,currentUrlContactAfterClick);
        extentTest.pass("User verifies that the Contact link is active ");

        // Buy TICKET button
        String currentUrlBuyTicketBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonBuyTickets.sendKeys(Keys.ENTER);
        String currentUrlBuyTicketAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlBuyTicketBeforeClick,currentUrlBuyTicketAfterClick);
        extentTest.pass("User verifies that the Buy Ticket button is active ");

        //Twitter icon
        String currentUrlTwitterBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconTwitter.sendKeys(Keys.ENTER);
        String currentUrlTwitterAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlTwitterBeforeClick,currentUrlTwitterAfterClick);
        extentTest.pass("User verifies that the Twitter icon is active ");

        //Facebook icon
        Driver.getDriver().navigate().back();
        String currentUrlFacebookBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconFacebook.sendKeys(Keys.ENTER);
        String currentUrlFacebookAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlFacebookBeforeClick,currentUrlFacebookAfterClick);
        extentTest.pass("User verifies that the Facebook icon is active ");

        //Youtube icon
        Driver.getDriver().navigate().back();
        String currentUrlYoutubeBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconYoutube.sendKeys(Keys.ENTER);
        String currentUrlYoutubeAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlYoutubeBeforeClick,currentUrlYoutubeAfterClick);
        extentTest.pass("User verifies that the Youtube icon is active ");

        //Instagram icon
        Driver.getDriver().navigate().back();
        String currentUrlInstagramBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconInstagram.sendKeys(Keys.ENTER);
        String currentUrlInstagramAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlInstagramBeforeClick,currentUrlInstagramAfterClick);
        extentTest.pass("User verifies that the Instagram icon is active ");

        //Phone Number
        Driver.getDriver().navigate().back();
        String currentUrlTelNoBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.TelNo.sendKeys(Keys.ENTER);
        String currentUrlTelNoAfterClick = Driver.getDriver().getCurrentUrl();
       softAssert.assertNotEquals(currentUrlTelNoBeforeClick,currentUrlTelNoAfterClick,"Phone Number aktif değil");
        extentTest.pass("User verifies that the Phone number is active ");

        // e-mail address,
        String currentUrlMailBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.mail.click();
        String currentUrlMailAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlMailBeforeClick,currentUrlMailAfterClick,"Email address aktif değil");
        extentTest.pass("User verifies that the E-mail address is active ");

        softAssert.assertAll();

        }
    }

