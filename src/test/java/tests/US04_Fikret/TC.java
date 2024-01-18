package tests.US04_Fikret;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

public class TC extends TestBaseRapor {

    @Test
    public void test01() {
        extentTest = extentReports.createTest("US_04");
        //1.“ https://qa.easybusticket.com/” adresine gidin
        Driver.getDriver().get("https://qa.easybusticket.com/");
        extentTest.info("Ana sayfaya gider");
        VisitorHomepage homepage = new VisitorHomepage();
        //2. Cookies kabul edin
             //Cookies varsa click yapar, yoksa kod calismaya devam eder
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
        }
        extentTest.info("Cookies kabul eder");
        //3. Footer'a kadar inin
        ReusableMethods.clickWithJS(homepage.footer);
        extentTest.info("Footer' a kadar iner");
        //4. "Useful Links", "Policies", "Contact Info" yazilarini dogrulayin
            //Actual ve expected textler'in karsilastirmasi ile dogrulama yapilir
        SoftAssert softAssert = new SoftAssert();
        String expectedUsefulLinksText = "Useful Links";
        String actualUsefulLinksText = homepage.usefulLinksFooter.getText();
        softAssert.assertEquals(actualUsefulLinksText, expectedUsefulLinksText, "different");
        extentTest.pass("Footer'da Useful Links doğrular");
        String expectedPoliciesText = "Policies";
        String actualPoliciesText = homepage.policiesFooter.getText();
        softAssert.assertEquals(actualPoliciesText, expectedPoliciesText, "different");
        extentTest.pass("Footer'da Policies Links doğrular");
        String expectedContactInfoText = "Contact Info";
        String actualContactInfoText = homepage.contactInfoFooter.getText();
        softAssert.assertEquals(actualContactInfoText, expectedContactInfoText, "different");
        extentTest.pass("Footer'da Contact Info Links doğrular");
        //5. About,FAQs,Blog,Contact linklerine tek tek tikleyip ilgili sayfaya yonlendirildigini dogrulayin
            //Actual ve expected textler'in karsilastirmasi ile dogrulama yapilir
        ReusableMethods.clickWithJS(homepage.buttonAbout);
        extentTest.info("About' a tıklar");
        String expectedAboutPageText = "About";
        String actualAboutPageText = homepage.aboutPage.getText();
        softAssert.assertEquals(actualAboutPageText, expectedAboutPageText, "different");
        extentTest.pass("About sayfasında olduğunu doğrular");
        softAssert.assertTrue(homepage.telefonNo.getAttribute("href").startsWith("tel:"), "Geçerli bir telefon numarası değil.");
        extentTest.pass("Telefon numarasını doğrular");
        ReusableMethods.clickWithJS(homepage.buttonFAQs);
        extentTest.info("FAQs' a tıklar");
        String expectedFAQsText = "FAQs";
        String actualFAQsText = homepage.faqsPage.getText();
        softAssert.assertEquals(actualFAQsText, expectedFAQsText, "different");
        extentTest.pass("FAQs sayfasında olduğunu doğrular");
        ReusableMethods.clickWithJS(homepage.buttonBlog);
        extentTest.info("Blog' a tıklar");
        String expectedBlogText = "Blog";
        String actualBlogText = homepage.blogPage.getText();
        softAssert.assertEquals(actualBlogText, expectedBlogText, "different");
        extentTest.pass("Blog sayfasında olduğunu doğrular");
        ReusableMethods.clickWithJS(homepage.buttonContact);
        extentTest.info("Contact' a tıklar");
        String expectedContactText = "Contact";
        String actualContactText = homepage.contactUsPage.getText();
        softAssert.assertEquals(actualContactText,expectedContactText,"different");
        extentTest.pass("Contact sayfasının başlığını doğrular");
        //6. Privacy Policy,Terms and Conditions,Ticket Policies linklerine tek tek tikleyip ilgili sayfaya yonlendirildigini dogrulayin
           //Actual ve expected textler'in karsilastirmasi ile dogrulama yapilir
        ReusableMethods.clickWithJS(homepage.privacyPolicyLinki);
        extentTest.info("Privacy Policy'e tıklar");
        String expectedPrivacyPolicyText = "Privacy Policy";
        String actualPrivacyPolicyText = homepage.privacyPolicyPageText.getText();
        softAssert.assertEquals(actualPrivacyPolicyText, expectedPrivacyPolicyText, "different");
        extentTest.pass("Privacy Policy sayfasının başlığını doğrular");
        //7. Twitter,Instagram,Youtube ve Facebook linklerinin aktif oldugunu dogrulayin
        // Dogrulamalar Url' lerden yapildi
        ReusableMethods.clickWithJS(homepage.twitterIkonu);
        extentTest.info("Twitter' a tıklar");
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://twitter.com/");
        extentTest.pass("Twitter sayfasında olduğunu doğrular");
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(homepage.facebookIkonu);
        extentTest.info("Facebook' a tıklar");
        ReusableMethods.wait(2);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.facebook.com/");
        extentTest.pass("Facebook sayfasında olduğunu doğrular");
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(homepage.youtubeIkonu);
        extentTest.info("Youtube' a tıklar");
        ReusableMethods.wait(2);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.youtube.com/");
        extentTest.pass("Youtube sayfasında olduğunu doğrular");
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(homepage.instagramIkonu);
        extentTest.info("Instagram' a tıklar");
        ReusableMethods.wait(2);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.instagram.com/");
        extentTest.pass("Instagram sayfasında olduğunu doğrular");
        Driver.getDriver().navigate().back();
        softAssert.assertAll();
        //8. Sayfayi kapatir
        Driver.quitDriver();
        extentTest.info("Sayfayı kapatır");



    }
}
