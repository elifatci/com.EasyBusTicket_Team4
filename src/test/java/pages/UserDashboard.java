package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class UserDashboard {

    public UserDashboard(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    // User sayfasinda headar da telefon, mail, Easy bus
    @FindBy(xpath = "(//*[@href='tel:+1 (603) 624-1800'])[1]") public WebElement headerNumber;
    @FindBy(xpath = "(//*[@href='mailto:info@easybusticket.com'])[1]") public WebElement headerMail;
    @FindBy(xpath = "(//*[@alt='Logo'])[1]") public  WebElement headerEasyBusLogo;

    // User sayfasinda header da Dashboard
    @FindBy(xpath = "//*[@href='https://easybusticket.com/user/dashboard']") public WebElement headerDashboard;

    // User sayfasinda header da Booking
    @FindBy(xpath = "(//*[@href='javascript::void()'])[1]") public WebElement headerBooking;

    // Header da Booking basliginin altinda Buy Ticket buttonu
    @FindBy(linkText = "Buy Ticket") public WebElement LinkbuyTicket;

    // Header da Booking basliginin altinda Booking History buttonu
    @FindBy(xpath = "//*[@href='https://easybusticket.com/user/booked-ticket/history']") public WebElement bookingHistory;
    @FindBy(linkText = "Rejected") public WebElement statusRejected;
    @FindBy(xpath = "//*[@class='checkinfo'])[1]") public WebElement actionButtonu;
    @FindBy(xpath = "(//*[@type='button'])[2]") public WebElement actionKapatma;

    // User sayfasinda header da Support Request
    @FindBy(xpath = "(//*[@href='javascript::void()'])[2]") public WebElement headerSupportRequest;

    // Header da Support Request basliginin altinda Create New buttonu
    @FindBy(xpath = "//*[@href='https://easybusticket.com/ticket/new']") public WebElement createNew;
    @FindBy(xpath = "(//*[@href='https://easybusticket.com/ticket'])[2]") public WebElement MySupportRequest;
    @FindBy(xpath = "//*[@name='name']") public WebElement Name;
    @FindBy(xpath = "//*[@name='email']") public WebElement Mail;
    @FindBy(xpath = "//*[@name='subject']") public WebElement Subject;
    @FindBy(xpath = "//*[@name='priority']") public WebElement Priority;
    @FindBy(id = "inputAttachments") public WebElement dosyaSec;
    @FindBy(id = "recaptcha") public WebElement submitButtonu;

    // Header da Support Request da Requests buttonu
    @FindBy(xpath = "//*[@href='https://easybusticket.com/ticket']") public WebElement Requests;
    @FindBy(linkText = "High") public WebElement requestsPriority;
    @FindBy(xpath = "(//*[@href='https://easybusticket.com/ticket/view/713431'])[2]") public WebElement requestsAction;
    @FindBy(id = "inputMessage") public WebElement yorumAlani;
    @FindBy(xpath = "//*[@type='file']") public WebElement actionDosyaSec;
    @FindBy(xpath = "//*[@type='submit']") public WebElement actionReply;

    // User sayfasin da headerın Profile alaninda profile buttonu
    @FindBy(xpath = "//*[@href='#0']") public WebElement profile;
    @FindBy(xpath = "//*[@href='https://easybusticket.com/user/profile-setting']") public WebElement profileProfil;
    @FindBy(xpath = "//*[@name='firstname']") public WebElement firstname;
    @FindBy(xpath = "//*[@name='lastname']") public WebElement lastName;
    @FindBy(id = "email") public WebElement email;
    @FindBy(id = "phone") public WebElement phone;
    @FindBy(id = "address") public WebElement address;
    @FindBy(id = "state") public WebElement state;
    @FindBy(xpath = "(//*[@name='zip'])[1]") public WebElement zip;
    @FindBy(id = "city") public WebElement city;
    @FindBy(xpath = "(//*[@name='zip'])[2]") public WebElement zip2;
    @FindBy(xpath = "//*[@value='Turkey']") public WebElement Country;
    @FindBy(xpath = "//*[@type='submit']") public WebElement UpdateProfile;

    // User sayfasin da headerın Profile alaninda Change Password buttonu
    @FindBy(xpath = "//*[@name='current_password']") public WebElement currentPassword;
    @FindBy(id = "password") public WebElement Password;
    @FindBy(xpath = "//*[@name='password_confirmation']") public WebElement confirmPassword;
    @FindBy(xpath = "//*[@type='submit']") public WebElement changePassword;

    // User sayfasin da headerın Profile alanida Logout buttonu
    @FindBy(xpath = "//*[@href='https://easybusticket.com/logout']") public WebElement Logout;

    //Dashboard texti
    @FindBy(xpath = "(//*[text()='Dashboard'])[2]") public WebElement textDashboard;

    //Dashboard sayfasindaki pencereler
    @FindBy(xpath = "(//*[@class='dashboard-widget'])[1]") public WebElement windowTotalBookedTicket;
    @FindBy(xpath = "(//*[@class='dashboard-widget'])[2]") public WebElement windowTotalRejectedTicket;
    @FindBy(xpath = "(//*[@class='dashboard-widget'])[3]") public WebElement windowTotalPendingTicket;

    //Dashboard sayfasindaki tablo
    @FindBy(css = ".badge.badge--success") public WebElement textFirstStatus;
    @FindBy(css = ".las.la-info-circle") public WebElement buttonFirstAction;
    @FindBy(className = "modal-title") public WebElement textTicketBookingHistory;
    @FindBy(xpath= "(//*[@type='button'])[2]") public WebElement buttonClose;

    //Logo Elementi
    @FindBy(xpath = "(//*[@alt='Logo'])[2]")public WebElement logoElementi;
    //Sosyal medya ikonları tıklandığında gidilen sayfalar URL'lerden doğrulanmalı
    @FindBy(xpath = "//*[@href='https://www.twitter.com']") public WebElement twitterIkonu;
    @FindBy(xpath = "//*[@href='https://www.facebook.com']") public WebElement facebookIkonu;
    @FindBy(xpath = "//*[@href='https://www.youtube.com']") public WebElement youtubeIkonu;
    @FindBy(xpath = "//*[@href='https://www.instagram.com']") public WebElement instagramIkonu;

    //Useful Links altindaki linkler ve tıklandığında gidilen sayfa textleri
    @FindBy(xpath = "(//a[@href='https://qa.easybusticket.com/about-us'])[2]") public WebElement aboutLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement aboutPageText;
    @FindBy(xpath = "(//a[@href='https://qa.easybusticket.com/faq'])[2]") public WebElement fAQsLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement fAQsPageText;
    @FindBy(xpath = "(//a[@href='https://qa.easybusticket.com/blog'])[2]") public WebElement blogLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement blogPageText;
    @FindBy(xpath = "(//a[@href='https://qa.easybusticket.com/contact'])[2]") public WebElement contactLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement contactPageText;

    //Policies altindaki linkler ve tıklandığında gidilen sayfa textleri
    @FindBy(xpath = "//a[@href='https://qa.easybusticket.com/policy/69/privacy-policy']") public WebElement privacyPolicyLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement privacyPolicyPageText;
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/policy/71/terms-and-conditions']") public WebElement termsAndConditionsLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement termsAndConditionsPageText;
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/policy/90/ticket-policies']") public WebElement ticketPoliciesLinki;
    @FindBy(xpath = "(//*[@class='title'])[1]") public WebElement ticketPoliciesPageText;

    //Contact ınfo altindaki linkler
    @FindBy(xpath = "//*[text()=' +1 (603) 624-1800']") public WebElement phoneLinki;
    @FindBy(xpath = "//*[text()=' info@easybusticket.com']") public WebElement mailLinki;


    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/user/booked-ticket/history']") public WebElement bookingHistoryLink;
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/ticket/new']") public WebElement createNewButonu;
    @FindBy(xpath = "//*[@name='priority']") public WebElement priorityDropBox;
    @FindBy(xpath = "//*[@class='booking-table']") public List<WebElement> requestTable;
    @FindBy(xpath = "(//*[@class='btn btn--base btn-sm'])[2]") public WebElement actionReq;
    @FindBy(xpath = "(//p)[3]") public WebElement mesajim;
    @FindBy(xpath = "(//*[@class='mr-3'])") public WebElement attachment;
    @FindBy(xpath = "//*[@class='badge badge--warning py-2 px-3']") public WebElement replayedYazisi;
    @FindBy(tagName = "h2") public WebElement profileText;
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/user/profile-setting']") public WebElement profileProfileLinki;








}
