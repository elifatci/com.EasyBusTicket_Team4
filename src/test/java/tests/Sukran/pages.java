package tests.Sukran;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class pages {
    public pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    // Buy Ticket otobus secme alani Pickup Point, Dropping Point, Date of Journey, Find Tickets, Select Seat
    @FindBy(xpath = "//*[@role='combobox']") public WebElement pickupPoint;
    @FindBy(xpath = "//*[@role='textbox']") public WebElement droppingPoint;
    @FindBy(xpath = "//*[@name='date_of_journey']") public WebElement dateOfJourney;
    @FindBy(xpath = "(//*[@class='form--group'])[4]") public WebElement findTickets;
    @FindBy(xpath = "(//*[@class='btn btn--base'])[4]") public WebElement selectSeat;

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
    @FindBy(xpath = "//*[@type='submit']") public WebElement Confirm;

    // Odeme islemleri
    @FindBy(xpath = "//*[@class='card-img-top']") public WebElement stripeHosted;
    @FindBy(xpath = "//*[@href='javascript:void(0)']]") public WebElement payNow;
    @FindBy(xpath = "//*[@href='https://easybusticket.com/user/ticket-booking/payment/confirm']") public WebElement payNow2;

    // Kart giris bilgileri
    @FindBy(xpath = "(//*[@class='input-group'])[1]") public WebElement nameOnCard;
    @FindBy(xpath = "(//*[@class='input-group'])[2]") public WebElement cardNumber;
    @FindBy(xpath = "//*[@name='cardExpiry']") public WebElement expirationDate;
    @FindBy(xpath = "//*[@name='cardCVC']") public WebElement CVC;
    @FindBy(xpath = "//*[@type='submit']")  public WebElement payNOW;
}
