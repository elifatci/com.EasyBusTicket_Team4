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
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/user/dashboard']") public WebElement headerDashboard;

    // User sayfasinda header da Booking
    @FindBy(xpath = "(//*[@href='javascript::void()'])[1]") public WebElement headerBooking;

    // Header da Booking basliginin altinda Buy Ticket buttonu
    @FindBy(linkText = "Buy Ticket") public WebElement LinkbuyTicket;

    // Header da Booking basliginin altinda Booking History buttonu
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/user/booked-ticket/history']") public WebElement bookingHistory;
    @FindBy(linkText = "Rejected") public WebElement statusRejected;
    @FindBy(xpath = "//*[@class='checkinfo'])[1]") public WebElement actionButtonu;
    @FindBy(xpath = "(//*[@type='button'])[2]") public WebElement actionKapatma;

    // User sayfasinda header da Support Request
    @FindBy(xpath = "(//*[@href='javascript::void()'])[2]") public WebElement headerSupportRequest;

    // Header da Support Request basliginin altinda Create New buttonu
    @FindBy(xpath = "//*[@class='btn btn--base btn-sm']") public WebElement buttonNewTicket;
    @FindBy(xpath = "(//*[@href='https://qa.easybusticket.com/ticket'])[2]") public WebElement MySupportRequest;
    @FindBy(xpath = "//*[@name='name']") public WebElement Name;
    @FindBy(xpath = "//*[@name='email']") public WebElement Mail;
    @FindBy(xpath = "//*[@name='subject']") public WebElement Subject;
    @FindBy(xpath = "//*[@name='priority']") public WebElement Priority;
    @FindBy(xpath = "(//*[@class='form--control'])[5]") public WebElement messageSection;
    @FindBy(id = "inputAttachments") public WebElement dosyaSec;
    @FindBy(xpath = "//*[@class='btn btn--base h-40']") public WebElement submitButtonu;
    @FindBy(xpath = "(//*[@class='fa fa-desktop'])[1]") public WebElement buttonAction;

    // Header da Support Request da Requests buttonu
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/ticket']") public WebElement Requests;
    @FindBy(linkText = "High") public WebElement requestsPriority;
    @FindBy(xpath = "(//*[@href='https://qa.easybusticket.com/ticket/view/713431'])[2]") public WebElement requestsAction;
    @FindBy(xpath = "//*[@class='col-md-9 ps-2']") public WebElement senderInformation;
    @FindBy(id = "inputMessage") public WebElement yorumAlani;
    @FindBy(xpath = "//*[@type='file']") public WebElement actionDosyaSec;
    @FindBy(xpath = "//*[@type='submit']") public WebElement actionReply;

    // User sayfasin da headerın Profile alaninda profile buttonu
    @FindBy(xpath = "//*[@href='#0']") public WebElement profile;
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/user/profile-setting']") public WebElement profileProfil;
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
    @FindBy(xpath = "//*[@href='https://qa.easybusticket.com/logout']") public WebElement Logout;

    //Dashboard texti
    @FindBy(xpath = "(//*[text()='Dashboard'])[2]") public WebElement textDashboard;

    //Dashboard sayfasindaki pencereler
    @FindBy(xpath = "(//*[@class='dashboard-widget'])[1]") public WebElement windowTotalBookedTicket;
    @FindBy(xpath = "(//*[@class='dashboard-widget'])[2]") public WebElement windowTotalRejectedTicket;
    @FindBy(xpath = "(//*[@class='dashboard-widget'])[3]") public WebElement windowTotalPendingTicket;

    //Dashboard sayfasindaki tablo
    @FindBy(css = ".badge.badge--success") public WebElement textFirstStatus;
    @FindBy(xpath = "//tr[1]/td[10]") public WebElement buttonFirstAction;
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
    @FindBy(xpath = "//a[@href='https://qa.easybusticket.com/contact']") public WebElement contactLinki;
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







    // Buy Ticket otobus secme alani Pickup Point, Dropping Point, Date of Journey, Find Tickets, Select Seat
    @FindBy(xpath = "(//*[@role='presentation'])[1]") public WebElement pickupPoint;
    @FindBy(xpath = "//*[@role='textbox']") public WebElement droppingPoint;
    @FindBy(xpath = "//*[@name='date_of_journey']") public WebElement dateOfJourney;
    @FindBy(xpath = "(//*[@class='form--group'])[4]") public WebElement findTickets;
    @FindBy(xpath = "(//*[@class='btn btn--base'])[1]") public WebElement selectSeat;

    // Otobus koltuk secme ve cinsiyet secme bolumu
    @FindBy(xpath = "//*[@for='male']") public WebElement male;
    @FindBy(xpath = "//*[@for='female']") public WebElement female;
    @FindBy(xpath = "//*[@for='other']") public WebElement other;

    @FindBy(xpath = "//*[@data-seat='1-A1']") public WebElement koltukA1;
    @FindBy(xpath = "//*[@data-seat='1-A2']") public WebElement koltukA2;
    @FindBy(xpath = "//*[@data-seat='1-A3']") public WebElement koltukA3;

    @FindBy(xpath = "//*[@data-seat='1-B1']") public WebElement koltukB1;
    @FindBy(xpath = "//*[@data-seat='1-B2']") public WebElement koltukB2;
    @FindBy(xpath = "//*[@data-seat='1-B3']") public WebElement koltukB3;

    @FindBy(xpath = "//*[@data-seat='1-C1']") public WebElement koltukC1;
    @FindBy(xpath = "//*[@data-seat='1-C2']") public WebElement koltukC2;
    @FindBy(xpath = "//*[@data-seat='1-C3']") public WebElement koltukC3;

    @FindBy(xpath = "//*[@data-seat='1-D1']") public WebElement koltukD1;
    @FindBy(xpath = "//*[@data-seat='1-D2']") public WebElement koltukD2;
    @FindBy(xpath = "//*[@data-seat='1-D3']") public WebElement koltukD3;

    @FindBy(xpath = "//*[@data-seat='1-E1']") public WebElement koltukE1;
    @FindBy(xpath = "//*[@data-seat='1-E2']") public WebElement koltukE2;
    @FindBy(xpath = "//*[@data-seat='1-E3']") public WebElement koltukE3;

    @FindBy(xpath = "//*[@data-seat='1-F1']") public WebElement koltukF1;
    @FindBy(xpath = "//*[@data-seat='1-F2']") public WebElement koltukF2;
    @FindBy(xpath = "//*[@data-seat='1-F3']") public WebElement koltukF3;

    @FindBy(xpath = "//*[@data-seat='1-G1']") public WebElement koltukG1;
    @FindBy(xpath = "//*[@data-seat='1-G2']") public WebElement koltukG2;
    @FindBy(xpath = "//*[@data-seat='1-G3']") public WebElement koltukG3;

    @FindBy(xpath = "//*[@data-seat='1-H1']") public WebElement koltukH1;
    @FindBy(xpath = "//*[@data-seat='1-H2']") public WebElement koltukH2;
    @FindBy(xpath = "//*[@data-seat='1-H3']") public WebElement koltukH3;

    @FindBy(xpath = "//*[@data-seat='1-I1']") public WebElement koltukI1;
    @FindBy(xpath = "//*[@data-seat='1-I2']") public WebElement koltukI2;
    @FindBy(xpath = "//*[@data-seat='1-I3']") public WebElement koltukI3;

    @FindBy(xpath = "//*[@data-seat='1-J1']") public WebElement koltukJ1;
    @FindBy(xpath = "//*[@data-seat='1-J2']") public WebElement koltukJ2;
    @FindBy(xpath = "//*[@data-seat='1-J3']") public WebElement koltukJ3;

    @FindBy(xpath = "//*[@data-seat='1-K1']") public WebElement koltukK1;
    @FindBy(xpath = "//*[@data-seat='1-K2']") public WebElement koltukK2;
    @FindBy(xpath = "//*[@data-seat='1-K3']") public WebElement koltukK3;


    @FindBy(xpath = "//*[@class='book-bus-btn']") public WebElement Continue;

    // Bu koltukları ayirttıgini onayla veya onaylama
    @FindBy(xpath = "//*[@type='button']") public WebElement Close;
    @FindBy(id = "btnBookConfirm") public WebElement Confirm;

    // Odeme islemleri
    @FindBy(xpath = "//*[@data-name='Stripe Hosted']") public WebElement stripeHosted;
    @FindBy(css = ".btn.btn--base.btn--md.w-100.radius-5.mt-3") public WebElement payNow;
    @FindBy(xpath = "//*[@href='https://easybusticket.com/user/ticket-booking/payment/confirm']") public WebElement payNow2;

    // Kart giris bilgileri
    @FindBy(xpath = "(//*[@class='input-group'])[1]") public WebElement nameOnCard;
    @FindBy(name = "cardNumber") public WebElement cardNumber;
    @FindBy(xpath = "//*[@name='cardExpiry']") public WebElement expirationDate;
    @FindBy(xpath = "//*[@name='cardCVC']") public WebElement CVC;
    @FindBy(xpath = "//*[@type='submit']")  public WebElement payNOW;

    @FindBy(xpath = "(//*[text()='Nashville'])[2]") public WebElement dropdownPickupNashville;
    @FindBy(xpath = "(//*[text()='Houston'])[3]") public WebElement dropdownDroppingHouston;
    @FindBy(className = "seat-overview-wrapper") public WebElement dogrulamaGidisVaris;
    @FindBy(id = "UGF5bWVudCUyMGNhcHR1cmVkJTIwc3VjY2Vzc2Z1bGx5LmdyZWVu") public WebElement messagePaymentSuccesfully;
    @FindBy(css = ".btn.btn--success.confirm-btn.btn--sm") public WebElement buttonConfirmPaymentStripe;
    @FindBy(xpath = "//button[@type='button']") public WebElement buttonDownloadTicket;
    @FindBy(xpath = "//*[@class='col-md-9'][1]") public WebElement closedSenderInfo;
  
    //koltuklarin listesi
    @FindBy(xpath = "//*[@class='seat']") public List<WebElement> listBosKoltuk;
    @FindBy(xpath = "//*[@class='seat selected']") public List<WebElement> listDoluKoltuk;


    // Gönderilen mesaj
    @FindBy (xpath ="/html/body/div[5]/div/div/div/div[2]/div[2]/div/div/div/div/div[2]/p[2]" ) public WebElement messageText;



    @FindBy(xpath = ("(//*[@class='ticket-no'])[1]"))public WebElement textticketnoo;

    //Profile Settings Mobile Number textbox'ı
    @FindBy(id = "phone") public WebElement textBoxProfileMobileNumber;

    //Profile Setting Lastname textbox'ı
    @FindBy(id = "lastname") public WebElement textBoxProfileLastname;





}
