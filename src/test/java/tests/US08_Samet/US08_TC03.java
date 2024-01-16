package tests.US08_Samet;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US08_TC03 {
    @Test
    public void test3() {
        //   Navigate to "https://qa.easybusticket.com/contact" which is the Contact page of the site
        Driver.getDriver().get(ConfigReader.getProperty("easyBusContactUrl"));
        //   Verify the visibility of the contact form named 'Have any Questions? on the 'Contact' page
        VisitorHomepage homepage = new VisitorHomepage();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(homepage.textHaveAnyQuestions.isDisplayed());
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
        //  Fill in the required fields
        homepage.PlaceholderName.sendKeys("samet");
        homepage.PlaceholderEmail.sendKeys("hjkh@kjhjkh.com");
        homepage.PlaceholderSubject.sendKeys("Subject");
        homepage.PlaceholderMessage.sendKeys("This is my message");
        //  Click the Send Us Message button
        ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
        ReusableMethods.wait(2);
        //  Verify that the alert message is "Your message has been sent. Thank you for contacting us."
        String actualMessage = homepage.messageYourmessagehasbeensent.getText();
        String expectedMessage = "Your message has been sent. Thank you for contacting us.";
        softAssert.assertEquals(expectedMessage, actualMessage);
        //  Click the Sign İn button
         ReusableMethods.clickWithJS(homepage.ButtonSignIn);
        // Fill in the required fields.
           homepage.textBoxUsername.sendKeys("Tetaci");
           homepage.textBoxPassword.sendKeys("Sa.1234");
        // Click the Log In button
            homepage.buttonLogin.click();
            ReusableMethods.wait(2);
            UserDashboard pageUser= new UserDashboard();
        //  Click the Contact button
            JavascriptExecutor jse = (JavascriptExecutor) Driver.getDriver();
            jse.executeScript("arguments[0].scrollIntoViewIfNeeded(true);",pageUser.contactLinki);
            ReusableMethods.clickWithJS(pageUser.contactLinki);
            ReusableMethods.wait(2);
        //  Fill in the required fields in the Have any questions section
            homepage.PlaceholderSubject.sendKeys("Subject");
            homepage.PlaceholderMessage.sendKeys("This is my message");
        //  Click the button named 'Send Us Message'
            ReusableMethods.clickWithJS(homepage.ButtonSendUsMessage);
            ReusableMethods.wait(2);

        //  Verify that the message has been successfully sent and visible in the admin dashboard
            String actualMessageText= pageUser.messageText.getText();
            softAssert.assertTrue(actualMessageText.contains("This is my message"));

            softAssert.assertAll();
            Driver.getDriver().close();

    }
}}