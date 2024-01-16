package tests.US06_Elif;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US06_TC02 {

    @Test
    public void test02(){
        //Launch browser
        //Navigate to url "https://qa.easybusticket.com/" (Url'e gidin)
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        //Click on 'FAQs' link
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        visitorHomepage.ButonCookieAccept.click();
        js.executeScript("arguments[0].click();",visitorHomepage.buttonFAQs);
        //Click on 'What is EasyBusTicket, and what services does it provide?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textFirstQuestion);
        //Verify that the answer is visible
        SoftAssert softAssert=new SoftAssert();
        softAssert.assertTrue(visitorHomepage.textFirstAnswer.isDisplayed(),"the answer is not visible");
        //Click on 'How can I cancel a ticket, and is there a fee for cancellation?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textSecondQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textSecondAnswer.isDisplayed());
        //Click on 'What are the in-bus services provided?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textThirdQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textThirdAnswer.isDisplayed());
        //Click on 'How can I reach customer services?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textFourthQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textFourthAnswer.isDisplayed());
        //Click on 'Can I make changes to my tickets?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textFifthQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textFifthAnswer.isDisplayed());
        //Click on 'Where can I find information about departure times?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textSixthQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textSixthAnswer.isDisplayed());
        //Click on 'Is it possible to use the EasyBusTicket app?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textSeventhQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textSeventhAnswer.isDisplayed());
        //Click on 'How can I purchase a ticket?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textEighthQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textEighthAnswer.isDisplayed());
        //Click on 'How long does the refund process take?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textNinethQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textNinethAnswer.isDisplayed());
        //Click on 'What is the Best Price Guarantee at EasyBusTicket?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textTenthQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textTenthAnswer.isDisplayed());
        //Click on 'How do Cashback and special offers work?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textEleventhQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textEleventhAnswer.isDisplayed());
        //Click on 'What payment methods are accepted?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textTwelvethQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textTwelvethAnswer.isDisplayed());
        //Click on 'What is the baggage policy during travel?' textbox
        js.executeScript("arguments[0].click();",visitorHomepage.textThirteenthQuestion);
        //Verify that the answer is visible
        softAssert.assertTrue(visitorHomepage.textThirteenthAnswer.isDisplayed());
        //Close the browser
        Driver.closeDriver();
    }
}
