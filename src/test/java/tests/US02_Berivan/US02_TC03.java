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

public class US02_TC03 {

    @Test
    public void test01() throws InterruptedException {
        // 1.Launch browser
        // 2.Navigate to url "https://qa.easybusticket.com/"
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        // 3.These Items should be displayed;
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        SoftAssert softAssert = new SoftAssert();

        // FAQs
        String currentUrlFAQBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonFAQs.sendKeys(Keys.ENTER);
        String  currentUrlFAQAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlFAQBeforeClick,currentUrlFAQAfterClick);

        //SignIn button
        String currentUrlSignInBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.ButtonSignIn.sendKeys(Keys.ENTER);
        String  currentUrlSignInAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlSignInBeforeClick,currentUrlSignInAfterClick);

        //SignUpButton
        Driver.getDriver().navigate().back();
        String currentUrlSignUpBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.ButtonSignUp.sendKeys(Keys.ENTER);
        String  currentUrlSignUpAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlSignUpBeforeClick,currentUrlSignUpAfterClick);

        // Home
        Driver.getDriver().navigate().back();
        String currentUrlHomeBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonHome.sendKeys(Keys.ENTER);
        String currentUrlHomeAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlHomeBeforeClick,currentUrlHomeAfterClick);

        // About
        String currentUrlAboutBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonAbout.sendKeys(Keys.ENTER);
        String currentUrlAboutAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlAboutBeforeClick, currentUrlAboutAfterClick);

        // Blog
        String currentUrlBlogBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonBlog.sendKeys(Keys.ENTER);
        String currentUrlBlogAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlBlogBeforeClick,currentUrlBlogAfterClick);

        // Contact
        String currentUrlContactBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonContact.sendKeys(Keys.ENTER);
        String currentUrlContactAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlContactBeforeClick,currentUrlContactAfterClick);

        // Buy TICKET button
        String currentUrlBuyTicketBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.buttonBuyTickets.sendKeys(Keys.ENTER);
        String currentUrlBuyTicketAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlBuyTicketBeforeClick,currentUrlBuyTicketAfterClick);

        //Twitter icon
        String currentUrlTwitterBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconTwitter.sendKeys(Keys.ENTER);
        String currentUrlTwitterAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlTwitterBeforeClick,currentUrlTwitterAfterClick);

        //Facebook icon
        Driver.getDriver().navigate().back();
        String currentUrlFacebookBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconFacebook.sendKeys(Keys.ENTER);
        String currentUrlFacebookAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlFacebookBeforeClick,currentUrlFacebookAfterClick);

        //Youtube
        Driver.getDriver().navigate().back();
        String currentUrlYoutubeBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconYoutube.sendKeys(Keys.ENTER);
        String currentUrlYoutubeAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlYoutubeBeforeClick,currentUrlYoutubeAfterClick);

        //Instagram
        Driver.getDriver().navigate().back();
        String currentUrlInstagramBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.IconInstagram.sendKeys(Keys.ENTER);
        String currentUrlInstagramAfterClick =Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlInstagramBeforeClick,currentUrlInstagramAfterClick);

        //Phone Number
        Driver.getDriver().navigate().back();
        String currentUrlTelNoBeforeClick = Driver.getDriver().getCurrentUrl();
        visitorHomepage.TelNo.sendKeys(Keys.ENTER);
        String currentUrlTelNoAfterClick = Driver.getDriver().getCurrentUrl();
       softAssert.assertNotEquals(currentUrlTelNoBeforeClick,currentUrlTelNoAfterClick,"Phone Number aktif değil");

        // e-mail address,
        String currentUrlMailBeforeClick =Driver.getDriver().getCurrentUrl();
        visitorHomepage.mail.click();
        String currentUrlMailAfterClick = Driver.getDriver().getCurrentUrl();
        softAssert.assertNotEquals(currentUrlMailBeforeClick,currentUrlMailAfterClick,"Email address aktif değil");

        softAssert.assertAll();

        }
    }

