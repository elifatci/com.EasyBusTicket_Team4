package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class VisitorHomepage {

    public VisitorHomepage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    //Visitor header elements
    @FindBy(xpath = "//*[@class='header-top']") public WebElement headerTop;
    @FindBy(xpath = "//*[@class='header-top']") public WebElement headerButtom;
    @FindBy (xpath = "//*[text()=\"Home\"]") public WebElement buttonHome;
    @FindBy (xpath = "//*[text()='About']") public  WebElement buttonAbout;
    @FindBy (xpath = "//*[text()='FAQs']") public WebElement buttonFAQs;
    @FindBy (xpath = "//*[text()='Blog']") public WebElement buttonBlog;
    @FindBy (xpath = "//*[text()='Contact']") public WebElement buttonContact;
    @FindBy (xpath = "//*[text()='Buy Tickets']") public WebElement buttonBuyTickets;
    @FindBy(xpath = "//img[@alt='Logo']") public WebElement logoEasyBuyTickets;
    @FindBy(xpath = "//a[@class='sign-in']") public WebElement ButtonSignIn;
    @FindBy(xpath = "//a[@class='sign-up']") public WebElement ButtonSignUp;
    @FindBy(xpath = "//h2[text()='Blog Details']") public WebElement TextBlogDetails;
    @FindBy(xpath ="(//a)[1]") public WebElement TelNo;
    @FindBy(xpath = "(//a)[2]") public  WebElement mail;
    @FindBy(xpath = "(//a)[3]") public WebElement IconTwitter;
    @FindBy(xpath = "(//a)[4]") public WebElement IconFacebook;
    @FindBy(xpath = "(//a)[5]") public WebElement IconYoutube;
    @FindBy(xpath = "(//a)[6]") public WebElement IconInstagram;

    //FAQs sayfası ;
    @FindBy (xpath ="(//div[@class='faq-title'])[1]") public WebElement textFirstQuestion;
    @FindBy(xpath = "(//p)[2]") public WebElement textFirstAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[2]") public WebElement textSecondQuestion;
    @FindBy(xpath = "(//p)[3]") public WebElement textSecondAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[3]") public WebElement textThirdQuestion;
    @FindBy(xpath = "(//p)[4]") public WebElement textThirdAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[4]") public WebElement textFourthQuestion;
    @FindBy(xpath = "(//p)[5]") public WebElement textFourthAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[5]") public WebElement textFifthQuestion;
    @FindBy(xpath = "(//p)[6]") public WebElement textFifthAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[6]") public WebElement textSixthQuestion;
    @FindBy(xpath = "(//p)[7]") public WebElement textSixthAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[7]") public WebElement textSeventhQuestion;
    @FindBy(xpath = "(//p)[8]") public WebElement textSeventhAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[8]") public WebElement textEighthQuestion;
    @FindBy(xpath = "(//p)[9]") public WebElement textEighthAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[9]") public WebElement textNinethQuestion;
    @FindBy(xpath = "(//p)[10]") public WebElement textNinethAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[10]") public WebElement textTenthQuestion;
    @FindBy(xpath = "(//p)[11]") public WebElement textTenthAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[11]") public WebElement textEleventhQuestion;
    @FindBy(xpath = "(//p)[12]") public WebElement textEleventhAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[12]") public WebElement textTwelvethQuestion;
    @FindBy(xpath = "(//p)[13]") public WebElement textTwelvethAnswer;
    @FindBy (xpath ="(//div[@class='faq-title'])[13]") public WebElement textThirteenthQuestion;
    @FindBy(xpath = "(//p)[14]") public WebElement textThirteenthAnswer;

    //Contact Sayfası;
    @FindBy(xpath = "//*[text()='Contact Us']") public WebElement textContactUs;
    @FindBy(xpath  ="//*[text()='Our Address']") public WebElement textAddress;
    @FindBy(xpath = "(//a)[16]") public WebElement IconCallUs;
    @FindBy(xpath = "(//a)[17]") public WebElement IconEmailUs;
    @FindBy(xpath = "//*[@class='title mb-4']") public WebElement textHaveAnyQuestions;
    @FindBy(id = "name") public WebElement PlaceholderName;
    @FindBy(id="email") public WebElement PlaceholderEmail;
    @FindBy(id = "subject") public WebElement PlaceholderSubject;
    @FindBy(id = "msg") public WebElement PlaceholderMessage;
    @FindBy(className = "contact-button") public WebElement ButtonSendUsMessage;
    @FindBy (xpath = "//div[@class=\"map-wrapper\"]") public WebElement mapGoogle;

    //Contact Sayfasındaki maps bö
    @FindBy(xpath = "//button[@aria-label='Zoom in']") public WebElement IconZoomIn;
    @FindBy(xpath = "//button[@aria-label='Zoom out']") public WebElement IconZoomOut;
    @FindBy(xpath = "//a[@aria-label='View larger map']") public WebElement TextViewLargerMap;
    @FindBy(xpath = "//*[@class='gm-inset-map-impl']") public WebElement ImgSatelliteImage;

    //cookies accept (AnaSayfaya erişildiğinde gelen cookie kabul  allerti)
    @FindBy(className = "cookies-btn")public WebElement ButonCookieAccept;

    //Find tickets "pickup point" dropdown
    @FindBy (xpath = "//h4[text()='Choose Your Ticket']") public WebElement TextChooseYourTickets;
    @FindBy(xpath = "//*[@id='one-way']/form/div[2]/div/span") public WebElement DropdownPickUpPoint;
    @FindBy(xpath = "(//*[@id='one-way']/form/div[3]") public WebElement DropdownDroppingPoint;
    @FindBy(xpath = "//*[@id='dp1704920498389']")public WebElement DropdownDepartureDate;

    @FindBy(xpath = "//*[text()='Get ticket now']")public WebElement ButonFindTickets;
    @FindBy(xpath="//*[text()='Looking For a Bus?']")public WebElement TextLookingforbus;
    @FindBy(xpath ="//*[text()='Select Your Ticket']")public WebElement Textselectyourticket;
    @FindBy(xpath ="//*[text()='Pay Your Bill']")public WebElement Textpayyourbill;


    @FindBy(xpath = "//*[text()='Select Seat']")public WebElement ButonSelectSeet;
    @FindBy(xpath = "//*[@class='ticket-item-inner book-ticket']")public WebElement TextTicketprice;
    //Koltukseçimisayfası cisniyet ve koltuk seçimi
    @FindBy(xpath = "//*[@id='male']")public WebElement ButonMalecinsiyet;
    @FindBy(xpath = "//*[@id='female']")public WebElement ButonFemalecinsiyet;
    @FindBy(xpath = "//*[@id='other']")public WebElement ButonOthercinsiyet;
    @FindBy(xpath = "(//*[@class='seat'])[1]")public WebElement ButonA1Koltuk;
    @FindBy(xpath = "(//*[@class='seat'])[2]")public WebElement ButonA2Koltuk;
    @FindBy(className = "book-bus-btn")public WebElement ButonContinue;
    @FindBy(xpath = "//*[@id='btnBookConfirm']")public WebElement ButonConfirmBooking;

    //Offered Facilities -olanaklar(otobüs imkanları)
    @FindBy(xpath ="//*[text()='Wifi']")public WebElement TextWifi;
    @FindBy(xpath ="//*[text()='Pillow']")public WebElement TextPillow;
    @FindBy(xpath ="//*[text()='Water']")public WebElement TextWater;
    @FindBy(xpath ="//*[text()='Tea & Coffee']")public WebElement TextTeaandcoffee;

    //Our Testimonials (yorumlar)
    @FindBy(xpath ="//*[@id='slick-slide-control00']")public WebElement yorum1butonu;
    @FindBy(xpath ="//*[@id='slick-slide-control01']")public WebElement yorum2butonu;
    @FindBy(xpath ="//*[@id='slick-slide-control02']")public WebElement yorum3butonu;

    //Recent Blog Post
    @FindBy(xpath ="//*[text()='Travel Trends: The Best Times to Explore New Places']")public WebElement Blogyazisi1;
    @FindBy(xpath ="//*[text()='Traveling with Technology: Making Your Journey Easier with Apps and Devices']")public WebElement Blogyazisi2;
    @FindBy(xpath ="//*[text()='Safety Measures: What to Pay Attention to During Travel']")public WebElement Blogyazisi3;

    //https://qa.easybusticket.com/blog
    @FindBy(xpath ="(//*[@class='title'])[1]") public WebElement Blogyazisiust;
    @FindBy(xpath = "(//*[@class='post-content'])[1]")public WebElement Birinciblokyazisi;
    @FindBy(xpath = "(//*[@class='post-content'])[2]")public WebElement Ikinciblokyazisi;
    @FindBy(xpath = "(//*[@class='post-content'])[3]")public WebElement ucuncublokyazisi;
    @FindBy(xpath = "(//*[@class='post-content'])[4]")public WebElement Dorduncublokyazisi;
    @FindBy(xpath = "(//*[@class='post-content'])[5]")public WebElement Besinciblokyazisi;
    @FindBy(xpath = "(//*[@class='post-content'])[6]")public WebElement Altinciblokyazisi;
    @FindBy(xpath = "(//*[@class='post-content'])[7]")public WebElement Yedinciblokyazisi;

    //Recent Blog Post https://qa.easybusticket.com/blog
    @FindBy(xpath = "(//*[@class='post-content'])[8]")public WebElement Recentblogilkyazi;
    @FindBy(xpath = "(//*[@class='post-content'])[9]")public WebElement Recentblogikinciyazi;
    @FindBy(xpath = "(//*[@class='post-content'])[10]")public WebElement Recentblogucuncuyazi;

    // All footer
    @FindBy(className ="footer-top")public WebElement footer;
    @FindBy(xpath = "//*[@href='https://www.twitter.com']")public WebElement twitterFooter;
    @FindBy(xpath = "//*[@href='https://www.facebook.com']")public WebElement facebookFooter;
    @FindBy(xpath = "//*[@href='https://www.youtube.com']")public WebElement youtubeFooter;
    @FindBy(xpath = "//*[@href='https://www.instagram.com']")public WebElement instagramFooter;
    @FindBy(xpath = "(//img[@alt=\"Logo\"])[2]")public WebElement easyBusTicketImageFooter;
    @FindBy(xpath = "(//h4[@class=\"widget-title\"])[1]")public WebElement usefulLinksFooter;
    @FindBy(xpath = "(//h4[@class=\"widget-title\"])[2]")public WebElement policiesFooter;
    @FindBy(xpath = "(//h4[@class=\"widget-title\"])[3]")public WebElement contactInfoFooter;
    @FindBy(xpath = "(//a)[24]")public WebElement aboutFooter;
    @FindBy(xpath = "(//a)[25]")public WebElement faqsFooter;
    @FindBy(xpath = "(//a)[26]")public WebElement blogFooter;
    @FindBy(xpath = "(//a)[27]")public WebElement contactFooter;
    @FindBy(xpath = "(//a)[28]")public WebElement privacyPolicyFooter;
    @FindBy(xpath = "(//a)[29]")public WebElement termsAndConditionsFooter;
    @FindBy(xpath = "(//a)[30]")public WebElement ticketPoliciesFooter;
    @FindBy(xpath = "(//a)[31]")public WebElement phoneNumberFooter;
    @FindBy(xpath = "(//a)[32]")public WebElement infoEmailFooter;
    @FindBy(xpath = "/html/body/section[6]/div/div/div/div[4]/div/ul/li[1]/text()[2]")public WebElement locationFooter;

    // Footer'dan Yönlendirilen Sayfalar
    @FindBy(xpath = "//h2[text()=\"About\"]")public WebElement aboutPage;
    @FindBy(xpath = "//h2[text()=\"FAQs\"]")public WebElement faqsPage;
    @FindBy(xpath = "//h2[text()=\"Blog\"]")public WebElement blogPage;
    @FindBy(xpath = "//h2[text()=\"Contact Us\"]")public WebElement contactUsPage;
    @FindBy(xpath = "//h2[text()=\"Privacy Policy\"]")public WebElement privacyPolicyPage;
    @FindBy(xpath = "//h2[text()=\"Terms and Conditions\"]")public WebElement termsAndConditionsPage;
    @FindBy(xpath = "//h2[text()=\"Ticket Policies\"]]")public WebElement ticketPoliciesPage;


    @FindBy(xpath = "//a[@href='https://qa.easybusticket.com/policy/69/privacy-policy']") public WebElement privacyPolicyLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement privacyPolicyPageText;
    @FindBy(xpath = "//*[@href='https://www.twitter.com']") public WebElement twitterIkonu;
    @FindBy(xpath = "//*[@href='https://www.facebook.com']") public WebElement facebookIkonu;
    @FindBy(xpath = "//*[@href='https://www.youtube.com']") public WebElement youtubeIkonu;
    @FindBy(xpath = "//*[@href='https://www.instagram.com']") public WebElement instagramIkonu;


    //Headerdaki Sign-In e tıklayınca
    @FindBy(css = "#username") public WebElement textBoxUsername;
    @FindBy(css = "#password") public WebElement textBoxPassword;
    @FindBy(css = ".account-button.w-100") public WebElement buttonLogin;
    @FindBy(xpath = "//a[text()='Forgot Password?']") public WebElement TextForgetPassword;

    //Headerdaki Sign-Up e tıklayınca;
    @FindBy(id = "firstname") public WebElement PlaceholderFirstName;
    @FindBy(id = "lastname") public WebElement PlaceHolderLastname;
    @FindBy(id = "country") public WebElement PlaceholderCountry;
    @FindBy(xpath = "//input[@type='number']") public WebElement PlaceholderMobile;
    @FindBy(id = "username") public WebElement PlaceholderSignUpUsername;
    @FindBy(id = "email") public WebElement PlaceholderSignUpEmail;
    @FindBy(xpath = "//input[@id='password']") public WebElement PlaceholderSignupPassword;
    @FindBy(id = "password-confirm") public WebElement PlaceholderConfirmPassword;
    @FindBy(id ="agree") public WebElement CheckListAgree;
    @FindBy(xpath = "//button[@class='account-button w-100']") public WebElement ButtonSignUpSignUpPage;
    @FindBy(xpath = "//*[@*='account-form-wrapper']") public WebElement SignUpYourAccountAndRegisterForm;

    @FindBy(xpath = "//*[text()='Support Tickets']") public WebElement textSupportTickets;
    @FindBy(xpath = "//*[text()='Subject']") public WebElement textSubject;
    @FindBy(xpath = "//*[text()='Status']") public WebElement textStatus;
    @FindBy(xpath = "//*[text()='Priority']") public WebElement textPriority;
    @FindBy(xpath = "//*[text()='Last Reply']") public WebElement textLastReply;


    //SignUp olamadığında çıkan Alert
    @FindBy(xpath = "//*[text()='You already have an account please Sign in ']") public WebElement nonSignUp;

    //Sign in sayfasında Forgot Password Text'ine tıklandığında çıkan Reset Password sayfası
    @FindBy(xpath = "//*[@class='form--control']") public WebElement dropDownSelectOneResetPage;
    @FindBy(xpath = "(//*[text()='E-Mail Address'])[2]") public WebElement emailAddressYazisiResetPage;
    @FindBy(xpath = "//*[@class='form--control ']") public WebElement textBoxEmailAddressResetPage;
    @FindBy(xpath = "(//*[text()='Username'])[2]") public WebElement usernameYazisiResetPage;
    @FindBy(xpath = "//*[@class='form--control ']") public WebElement textBoxUsernameResetPage;
    @FindBy(xpath = "//*[text()='Send Password Code']") public WebElement buttonSendPasswordCodeResetPage;
    @FindBy(xpath = "//*[text='Password reset email sent successfully']") public WebElement resetEmailYazisiResetPage;

    //Account Recovery page'deki Try to send again texti
    @FindBy(xpath = "//*[text()='Try to send again']") public WebElement textTryToSendAgainAccountRecoveryPage;

// Every journey texti
@FindBy(xpath = "//*[@class='banner-content']") public WebElement textEvery;


}
