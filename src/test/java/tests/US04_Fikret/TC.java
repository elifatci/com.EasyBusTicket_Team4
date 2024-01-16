package tests.US04_Fikret;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.VisitorHomepage;
import utilities.Driver;
import utilities.ReusableMethods;

public class TC {

    @Test
    public void test01() {
        //1.“ https://qa.easybusticket.com/” adresine gidin
        Driver.getDriver().get("https://qa.easybusticket.com/");
        VisitorHomepage homepage = new VisitorHomepage();
        //2. Cookies kabul edin
             //Cookies varsa click yapar, yoksa kod calismaya devam eder
        if (homepage.ButonCookieAccept.isDisplayed() && homepage.ButonCookieAccept.isEnabled()) {
            homepage.ButonCookieAccept.click();
        }
        //3. Footer'a kadar inin
        ReusableMethods.clickWithJS(homepage.footer);
        //4. "Useful Links", "Policies", "Contact Info" yazilarini dogrulayin
            //Actual ve expected textler'in karsilastirmasi ile dogrulama yapilir
        SoftAssert softAssert = new SoftAssert();
        String expectedUsefulLinksText = "Useful Links";
        String actualUsefulLinksText = homepage.usefulLinksFooter.getText();
        softAssert.assertEquals(actualUsefulLinksText, expectedUsefulLinksText, "different");
        String expectedPoliciesText = "Policies";
        String actualPoliciesText = homepage.policiesFooter.getText();
        softAssert.assertEquals(actualPoliciesText, expectedPoliciesText, "different");
        String expectedContactInfoText = "Contact Info";
        String actualContactInfoText = homepage.contactInfoFooter.getText();
        softAssert.assertEquals(actualContactInfoText, expectedContactInfoText, "different");
        //5. About,FAQs,Blog,Contact linklerine tek tek tikleyip ilgili sayfaya yonlendirildigini dogrulayin
            //Actual ve expected textler'in karsilastirmasi ile dogrulama yapilir
        ReusableMethods.clickWithJS(homepage.aboutFooter);
        String expectedAboutPageText = "About";
        String actualAboutPageText = homepage.aboutPage.getText();
        softAssert.assertEquals(actualAboutPageText, expectedAboutPageText, "different");
        ReusableMethods.clickWithJS(homepage.ButtonFAQs);
        String expectedFAQsText = "FAQs";
        String actualFAQsText = homepage.faqsPage.getText();
        softAssert.assertEquals(actualFAQsText, expectedFAQsText, "different");

        ReusableMethods.clickWithJS(homepage.ButtonBlog);
        String expectedBlogText = "Blog";
        String actualBlogText = homepage.blogPage.getText();
        softAssert.assertEquals(actualBlogText, expectedBlogText, "different");

        ReusableMethods.clickWithJS(homepage.ButtonContact);
        String expectedContactText = "Contact";
        String actualContactText = homepage.contactUsPage.getText();
        softAssert.assertEquals(actualContactText,expectedContactText,"different");

        //6. Privacy Policy,Terms and Conditions,Ticket Policies linklerine tek tek tikleyip ilgili sayfaya yonlendirildigini dogrulayin
        //Actual ve expected textler'in karsilastirmasi ile dogrulama yapilir
        ReusableMethods.clickWithJS(homepage.privacyPolicyLinki);
        String expectedPrivacyPolicyText = "Privacy Policy";
        String actualPrivacyPolicyText = homepage.privacyPolicyPageText.getText();
        softAssert.assertEquals(actualPrivacyPolicyText, expectedPrivacyPolicyText, "different");

        //7. Twitter,Instagram,Youtube ve Facebook linklerinin aktif oldugunu dogrulayin
        // Dogrulamalar Url' lerden yapildi
        ReusableMethods.clickWithJS(homepage.twitterIkonu);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://twitter.com/");
        ReusableMethods.wait(2);
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(homepage.facebookIkonu);
        ReusableMethods.wait(2);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.facebook.com/");
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(homepage.youtubeIkonu);
        ReusableMethods.wait(2);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.youtube.com/");
        Driver.getDriver().navigate().back();
        ReusableMethods.clickWithJS(homepage.instagramIkonu);
        ReusableMethods.wait(2);
        softAssert.assertEquals(Driver.getDriver().getCurrentUrl(), "https://www.instagram.com/");
        Driver.getDriver().navigate().back();
        softAssert.assertAll();
        //8. Sayfayi kapatin
        Driver.closeDriver();

        //


    }
}
