package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AdminDashboard {

    public AdminDashboard(){
        PageFactory.initElements(Driver.getDriver(),this);}

    //Admin Dashboard Header

    @FindBy(className = "navbar-user__name") public WebElement adminUserLinki;
    @FindBy(className = "navbar-search__btn-open") public WebElement searchButton;
    @FindBy(id = "navbar-search__field") public WebElement searchBoxtext;
    @FindBy(className = "las la-bell text--primary") public WebElement notificationButton;
    @FindBy(className = "view-all-message") public WebElement vieweAllNotificationLinki;
    @FindBy(className = "page-title") public WebElement notificationYazisi;
    @FindBy(xpath = "//*[@class='btn btn--primary']") public WebElement markAllAsReadButonu;
    @FindBy(xpath = "//*[@class='navbar-user']") public WebElement signInbuttonu;
    @FindBy(xpath = "(//span[@class='dropdown-menu__caption'])[1]") public WebElement profileButton;
    @FindBy(xpath = "(//*[@class='dropdown-menu__caption'])[2]") public WebElement passwordButton;
    @FindBy(xpath = "(//*[@class='dropdown-menu__caption'])[3]") public WebElement logoutButton;

    //Profil sayfası

    @FindBy(className = "page-title") public WebElement profileText;
    @FindBy(className = "d-flex p-3 bg--primary") public WebElement adminProfilImage;
    @FindBy(xpath = "(//*[@class='list-group-item d-flex justify-content-between align-items-center'])[1]") public WebElement adminProfilNameText;
    @FindBy(xpath = "(//*[@class='list-group-item d-flex justify-content-between align-items-center'])[2]") public WebElement adminProfilUsernameText;
    @FindBy(className = "card-title mb-50 border-bottom pb-2") public WebElement profilInformationText;
    @FindBy(className = "form-control-label font-weight-bold") public WebElement nameText;
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public WebElement nameBox;
    @FindBy(className = "form-control-label  font-weight-bold") public WebElement mailText;
    @FindBy(xpath = "(//*[@class='form-control'])[2]") public WebElement mailBox;
    @FindBy(className = "profilePicPreview") public WebElement profilInformationImage;
    @FindBy(xpath = "//*[@for='profilePicUpload1']") public WebElement uploadImageButon;
    @FindBy(className = "mt-2 text-facebook") public WebElement uploadImageText;
    @FindBy(className = "btn btn--primary btn-block btn-lg") public WebElement saveButton;

    //password Settings
    @FindBy(xpath = "//*[@class='btn btn-sm btn--primary box--shadow1 text--small']") public WebElement passwordSettingButon;
    @FindBy(className = "page-title") public WebElement passwordSettingText;
    @FindBy(className = "card-title mb-50 border-bottom pb-2") public WebElement changePasswordText;
    @FindBy(xpath = "(//*[@class='col-lg-3 col-form-label form-control-label'])[1]") public WebElement passwordText;
    @FindBy(xpath = "(//*[@class='col-lg-3 col-form-label form-control-label'])[2]") public WebElement newPasswordText;
    @FindBy(xpath = "(//*[@class='col-lg-3 col-form-label form-control-label'])[3]") public WebElement confirmPasswordText;
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public WebElement passwordBox;
    @FindBy(xpath = "(//*[@class='form-control'])[2]") public WebElement newPasswordBox;
    @FindBy(xpath = "(//*[@class='form-control'])[3]") public WebElement confirmPasswordBox;
    @FindBy(className = "btn btn--primary btn-block btn-lg") public WebElement saveChangesButton;

    //Admin usernameKutusu,passwordKutusu,loginButonu
    @FindBy(xpath = "//*[@name='username']")public WebElement usernameKutusu;
    @FindBy(xpath = "//*[@name='password']")public WebElement passwordKutusu;
    @FindBy(xpath = "//*[@type='submit']")public WebElement loginButonu;

    //Admin Dashboard
    @FindBy(xpath = "(//*[@class='menu-title'])[1]")public WebElement adminDashboard;

    // Admin Manage Users ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[2]")public WebElement manageUsers;
    @FindBy(xpath = "(//*[@class='menu-title'])[3]")public WebElement allUsers;
    @FindBy(xpath = "(//*[@class='menu-title'])[4]")public WebElement activeUsers;
    @FindBy(xpath = "(//*[@class='menu-title'])[5]")public WebElement bannedUsers;
    @FindBy(xpath = "(//*[@class='menu-title'])[6]")public WebElement emailUnverified;
    @FindBy(xpath = "(//*[@class='menu-title'])[7]")public WebElement smsUnverified;
    @FindBy(xpath = "(//*[@class='menu-title'])[8]")public WebElement emailToAll;
    @FindBy(className = "page-title")public WebElement bannedUsersYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement usernameOrEmailSearchKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary']")public WebElement usernameOrEmailSearchButonu;
    @FindBy(xpath = "(//*[@data-label='Action']")public WebElement bannedUserActionLinki;
    @FindBy(className = "page-title")public WebElement sendEmailToAllUsersYazisi;
    @FindBy(xpath = "//*[@name='subject']")public WebElement subjectKutusu;
    @FindBy(xpath = "//*[@contenteditable='true']")public WebElement messageKutusu;
    @FindBy(xpath = "(//*[@type='submit'])[2]")public WebElement sendEmailButonu;

    // Admin Payment History ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[9]")public WebElement paymentHistory;
    @FindBy(xpath = "(//*[@class='menu-title'])[10]")public WebElement pendingPayment;
    @FindBy(xpath = "(//*[@class='menu-title'])[11]")public WebElement successfulPayment;
    @FindBy(xpath = "(//*[@class='menu-title'])[12]")public WebElement rejectedPayment;
    @FindBy(xpath = "(//*[@class='menu-title'])[13]")public WebElement allPayment;
    @FindBy(xpath = "(//input)[2]")public WebElement trxNumberAramaKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary'][1]")public WebElement trxNumberSearchButonu;
    @FindBy(xpath = "(//input)[3]")public WebElement minDateMaxDateAramaKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary'][2]")public WebElement minDateMaxDateSearchButonu;
    @FindBy(xpath = "(//*[@data-label='Action'])[1]")public WebElement paymentHistoryActionLinki;

    // Booking History ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[14]")public WebElement bookingHistory;
    @FindBy(xpath = "(//*[@class='menu-title'])[15]")public WebElement pendingTicket;
    @FindBy(xpath = "(//*[@class='menu-title'])[16]")public WebElement bookedTicket;
    @FindBy(xpath = "(//*[@class='menu-title'])[17]")public WebElement rejectedTicket;
    @FindBy(xpath = "(//*[@class='menu-title'])[18]")public WebElement allTicket;
    @FindBy(className = "page-title")public WebElement pendingTicketYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement searchPnrNumberKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary']")public WebElement searchPnrNumberButonu;
    @FindBy(className = "page-title")public WebElement bookedTicketYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement bookedpnrNumberAramaKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary'][1]")public WebElement bookedpnrNumberSearchButonu;
    @FindBy(className = "page-title")public WebElement rejectedTicketYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement rejectedPnrNumberAramaKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary'][1]")public WebElement rejectedPnrNumberSearchButonu;
    @FindBy(className = "page-title")public WebElement allTicketYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement allPnrNumberAramaKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary'][1]")public WebElement allPnrNumberSearchButonu;
    @FindBy(className = "page-title")public WebElement automaticGatewaysYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement automaticGatewaysAramaKutusu;
    @FindBy(className = "page-title")public WebElement manualGatewaysYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement manualGatewaysAramaKutusu;
    @FindBy(xpath = " (//*[@class='icon-btn editGatewayBtn'])[1]")public WebElement manualGatewaysActionEditButonu;
    @FindBy(className = "page-title")public WebElement manualGatewaysActionActivateButonu;
    @FindBy(xpath = "//*[@class='btn btn--primary']")public WebElement popupActivateButonu;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[1]']")public WebElement popupCloseButonu;
    @FindBy(xpath = "//*[@class='btn btn-sm btn--primary box--shadow1 text--small']")public WebElement addNewButonu;
    @FindBy(className = "page-title")public WebElement  newManualGatewayYazisi;
    @FindBy(xpath = "//*[@class='la la-fw la-backward']']")public WebElement goBackButonu;
    @FindBy(xpath = "//*[@class='la la-pencil']")public WebElement resimYuklemeLinki;
    @FindBy(xpath = "(//*[@type='text'])[1]")public WebElement gatewayNameKutusu;
    @FindBy(xpath = "(//*[@type='text'])[2]")public WebElement currencyKutusu;
    @FindBy(xpath = "(//*[@type='text'])[3]")public WebElement rateKutusu;
    @FindBy(xpath = "(//*[@type='text'])[4]")public WebElement minimumAmountKutusu;
    @FindBy(xpath = "(//*[@type='text'])[5]")public WebElement maximumAmountKutusu;
    @FindBy(xpath = "(//*[@type='text'])[6]")public WebElement fixedChargeKutusu;
    @FindBy(xpath = "(//*[@type='text'])[7]")public WebElement percentChargeKutusu;
    @FindBy(xpath = "//*[@class=' nicEdit-main     ']")public WebElement depositInstructionAramaKutusu;
    @FindBy(xpath = "//*[@class='btn btn-sm btn-outline-light float-right addUserData']")public WebElement userDataAddNewButonu;
    @FindBy(xpath = "(//*[@type='text'])[8]")public WebElement fieldNamePlaceHolderKutusu;
    @FindBy(xpath = "(//*[@class='form-control'])[7]")public WebElement inputTextKutusu;
    @FindBy(xpath = "((//*[@class='form-control'])[8]")public WebElement optionalKutusu;
    @FindBy(xpath = "//*[@class='input-group-btn']")public WebElement userDataPencereKapatmaButonu;
    @FindBy(xpath = "(//*[@type='submit'])[2]")public WebElement saveMethodButonu;

    // Payment Gateways ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[19]")public WebElement paymentGateways;
    @FindBy(xpath = "(//*[@class='menu-title'])[20]")public WebElement automaticGateways;
    @FindBy(xpath = "(//*[@class='menu-title'])[21]")public WebElement manualGateways;

    // Support Requests ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[22]")public WebElement supportRequests;
    @FindBy(xpath = "(//*[@class='menu-title'])[23]")public WebElement allRequests;
    @FindBy(xpath = "(//*[@class='menu-title'])[24]")public WebElement pendingRequests;
    @FindBy(xpath = "(//*[@class='menu-title'])[25]")public WebElement closedRequests;
    @FindBy(xpath = "(//*[@class='menu-title'])[26]")public WebElement answeredRequests;

    // Report ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[27]")public WebElement report;
    @FindBy(xpath = "(//*[@class='menu-title'])[28]")public WebElement loginHistory;
    @FindBy(xpath = "(//*[@class='menu-title'])[29]")public WebElement emailHistory;
    @FindBy(className = "page-title")public WebElement userLoginHistoryYazisi;
    @FindBy(xpath = "(//input)[2]")public WebElement userLoginHistoryAramaKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary'][1]")public WebElement userLoginHistorySearchButonuu;
    @FindBy(className = "page-title")public WebElement emailHistoryYazisi;
    @FindBy(xpath = "(//*[@data-label='Action']")public WebElement emailHistoryActionLinki;

    //Counter
    @FindBy(xpath = "(//*[@class='menu-title'])[30]")public WebElement counter;

    // Manage Fleets ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[31]")public WebElement manageFleets;
    @FindBy(xpath = "(//*[@class='menu-title'])[32]")public WebElement seatLayouts;
    @FindBy(xpath = "(//*[@class='menu-title'])[33]")public WebElement fleetType;
    @FindBy(xpath = "(//*[@class='menu-title'])[34]")public WebElement vehicle;

    // Manage Trips ve alt başlıkları
    @FindBy(xpath = "(//*[@class='menu-title'])[35]")public WebElement manageTrips;
    @FindBy(xpath = "(//*[@class='menu-title'])[36]")public WebElement route;
    @FindBy(xpath = "(//*[@class='menu-title'])[37]")public WebElement schedule;
    @FindBy(xpath = "(//*[@class='menu-title'])[38]")public WebElement ticketPrice;
    @FindBy(xpath = "(//*[@class='menu-title'])[39]")public WebElement trip;
    @FindBy(xpath = "(//*[@class='menu-title'])[40]")public WebElement assignedVehicle;

    //All Requests Page
    @FindBy(className = "page-title") public WebElement textSupportRequest;
    @FindBy(xpath = "//tr[1]/td[1]") public WebElement linkFirstSubject;
    @FindBy(xpath = "//tr[1]/td[2]") public WebElement linkFirstSubmittedBy;
    @FindBy(xpath = "(//*[@class='las la-desktop'])[1]") public WebElement buttonFirstAction;

    //Pending Requests Page
    @FindBy(className = "page-title") public WebElement textPendingRequests;
    @FindBy(xpath = "//tr[1]/td[1]") public WebElement linkPendingFirstSubject;
    @FindBy(xpath = "//tr[1]/td[2]") public WebElement linkPendingFirstSubmittedBy;
    @FindBy(xpath = "(//*[@class='las la-desktop'])[1]") public WebElement buttonPendingFirstAction;

    //Closed Requests Page
    @FindBy(className = "page-title") public WebElement textClosedRequests;
    @FindBy(xpath = "//tr[1]/td[1]") public WebElement linkClosedFirstSubject;
    @FindBy(xpath = "//tr[1]/td[2]") public WebElement linkClosedFirstSubmittedBy;
    @FindBy(xpath = "(//*[@class='las la-desktop'])[1]") public WebElement buttonClosedFirstAction;

    //Answered Requests Page
    @FindBy(className = "page-title") public WebElement textAnsweredRequests;

    //Seat Layouts Page
    @FindBy(className = "page-title") public WebElement textSeatLayouts;
    @FindBy(xpath = "//tr[1]/td[1]") public WebElement textSeatFirstSN;
    @FindBy(xpath = "//tr[1]/td[2]") public WebElement textSeatFirstLayout;
    @FindBy(css = ".btn.btn-sm.btn--primary.box--shadow1.text--small.addBtn") public WebElement buttonSeatAddNew;
    @FindBy(xpath = "(//*[@class='modal-title'])[1]") public WebElement textAddSeatLayouts;
    @FindBy(xpath = "(//input[@type='text'])[1]") public WebElement textBoxLayout;
    @FindBy(xpath = "(//button[@type='button'])[14]") public WebElement buttonCancelAddSeatLayout;
    @FindBy(xpath = "(//button[@type='submit'])[2]") public WebElement buttonSaveAddSeatLayout;

    //Fleet Type Page
    @FindBy(className = "page-title") public WebElement textFleetType;
    @FindBy(xpath = "//tr[1]/td[1]") public WebElement textFleetExpressBus;
    @FindBy(xpath = "//tr[2]/td[1]") public WebElement textFleetClassicBus;
    @FindBy(xpath = "//tr[3]/td[1]") public WebElement textFleetLuxBus;
    @FindBy(css = ".btn.btn-sm.btn--primary.box--shadow1.text--small.addBtn") public WebElement buttonFleetAddNew;
    @FindBy(xpath = "(//*[@class='modal-title'])[1]") public WebElement textAddFleetType;
    @FindBy(xpath = "(//*[@placeholder='Enter Fleet Name'])[1]") public WebElement textBoxFleetName;
    @FindBy(xpath = "(//*[@name='seat_layout'])[1]") public WebElement dropDownSeatLayout;
    @FindBy(xpath = "(//*[@title='Öğeyi kaldırmak'])[1]") public WebElement iconDeleteCayKahve;
    @FindBy(xpath = "(//*[@title='Öğeyi kaldırmak'])[2]") public WebElement iconDeleteSu;
    @FindBy(xpath = "(//*[@title='Öğeyi kaldırmak'])[3]") public WebElement iconDeleteYastik;
    @FindBy(xpath = "(//*[@title='Öğeyi kaldırmak'])[4]") public WebElement iconDeleteWifi;
    @FindBy(xpath = "(//*[@class='btn btn--success toggle-on'])[1]") public WebElement buttonAc;
    @FindBy(xpath = "(//*[@class='toggle btn btn--danger off'])[1]") public WebElement buttonNonAc;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[1]") public WebElement buttonClose;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement buttonSave;

    //Route Page
    @FindBy(className = "page-title") public WebElement textAllRoutes;
    @FindBy(xpath = "//tr[1]/td[1]") public WebElement textFirstName;
    @FindBy(css = ".btn.btn-sm.btn--primary.box--shadow1.text--small.addBtn") public WebElement buttonRouteAddNew;
    @FindBy(xpath = "(//*[@class='la la-pen'])[1]") public WebElement iconPenFirstAction;
    @FindBy(css = ".card-title.border-bottom.pb-2") public WebElement textInformationOfRoute;
    @FindBy(xpath = "//*[@placeholder='Enter Name']") public WebElement textBoxName;
    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[1]") public WebElement dropDownStartFrom;
    @FindBy(xpath = "(//*[@class='select2-selection__rendered'])[2]") public WebElement dropDownEndTo;
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement Austin;
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement Dallas;
    @FindBy(xpath = "(//*[@role='option'])[4]") public WebElement ForthWorth;
    @FindBy(xpath = "(//*[@role='option'])[5]") public WebElement Houston;
    @FindBy(xpath = "(//*[@role='option'])[6]") public WebElement Lousiana;
    @FindBy(xpath = "(//*[@role='option'])[7]") public WebElement SanAntonio;
    @FindBy(xpath = "(//*[@role='option'])[8]") public WebElement Memphis;
    @FindBy(xpath = "(//*[@role='option'])[9]") public WebElement Nashville;
    @FindBy(xpath = "(//*[@role='option'])[10]") public WebElement Atlanta;
    @FindBy(xpath = "//*[@for='has-stoppage']") public WebElement radioButtonHasMoreStoppage;
    @FindBy(xpath = "(//*[@role='presentation'])[5]") public WebElement dropdownOneSelectStoppage;
    @FindBy(xpath = "(//*[@class='las la-times'])[3]") public WebElement iconXOneDropdown;
    @FindBy(xpath = "(//*[@role='presentation'])[7]") public WebElement dropdownTwoSelectStoppage;
    @FindBy(xpath = "(//*[@class='las la-times'])[4]") public WebElement iconXTwoDropdown;
    @FindBy(xpath = "(//*[@class='form-control'])[2]") public WebElement textBoxTime;
    @FindBy(xpath = "(//*[@class='form-control'])[3]") public WebElement textBoxDistance;
    @FindBy(xpath = "(//*[@type='submit'])[2]") public WebElement buttonSaveChanges;
    @FindBy(xpath = "//*[text()='Go Back']") public WebElement buttonGoBack;
    @FindBy(xpath = "(//*[@class='la la-eye-slash'])[1]") public WebElement iconEyeFirstAction;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[2]") public WebElement buttonCloseDisable;
    @FindBy(xpath = "//*[@class='btn btn--danger']") public WebElement buttonDisable;

    //Schedule page
    @FindBy(className = "page-title") public WebElement textAllSchedules;
    @FindBy(xpath = "//tr[1]/td[1]") public WebElement textFirstStartFrom;
    @FindBy(css = ".btn.btn-sm.btn--primary.box--shadow1.text--small.addBtn") public WebElement buttonScheduleAddNew;
    @FindBy(xpath = "(//*[@class='modal-title'])[1]") public WebElement textAddSchedule;
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public WebElement textBoxStartFromAdd;
    @FindBy(xpath = "(//*[@class='form-control'])[2]") public WebElement textBoxEndAtAdd;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[1]") public WebElement buttonCloseAddSchedule;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement buttonSaveAddSchedule;
    @FindBy(xpath = "(//*[@class='la la-pen'])[1]") public WebElement iconPenFirst;
    @FindBy(xpath = "(//*[@class='modal-title'])[2]") public WebElement textUpdateSchedule;
    @FindBy(xpath = "(//*[@class='form-control'])[3]") public WebElement textBoxStartFromUpdate;
    @FindBy(xpath = "(//*[@class='form-control'])[4]") public WebElement textBoxEndAt;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[2]") public WebElement buttonCloseUpdateSchedule;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[2]") public WebElement buttonUpdate;
    @FindBy(xpath = "(//*[@class='la la-eye'])[1]") public WebElement iconEyeFirst;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[2]") public WebElement buttonCloseActiveSchedule;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[3]") public WebElement buttonActive;
    @FindBy(xpath = "(//*[@class='page-link'])[2]") public WebElement iconSecondPage;
    @FindBy(xpath = "(//*[@class='page-link'])[3]") public WebElement iconThirdPage;
    @FindBy(xpath = "(//*[@class='page-link'])[4]") public WebElement iconFourthPage;

    //Ticket Price Page
    @FindBy(className = "page-title") public WebElement textAllTicketPrice;
    @FindBy(css = ".btn.btn-sm.btn--primary.box--shadow1.text--small") public WebElement buttonAddNewTicketPrice;
    @FindBy(css = ".card-title.border-bottom.pb-2") public WebElement textInformationAboutTicketPrice;
    @FindBy(xpath = "(//*[@role='presentation'])[1]") public WebElement dropdownFleetType;
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement optionLuxBus;
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement optionClassicBus;
    @FindBy(xpath = "(//*[@role='option'])[4]") public WebElement optionExpressBus;
    @FindBy(xpath = "(//*[@role='presentation'])[3]") public WebElement dropdownRoute;

    //Ticket Price Page >> AddNew Button >> Route Dropdown==> Express->Houston->Memphis
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement optionExpressHoustonMemphis;

    //Ticket Price Page >> AddNew Button >> Route Dropdown==> Express->Lousiana->Nashville
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement optionExpressLousianaNashville;

    //Ticket Price Page >> AddNew Button >> Route Dropdown==> Express->SanAntonio->Lousiana
    @FindBy(xpath = "(//*[@role='option'])[4]") public WebElement optionExpressSanAntonioLousiana;

    //Ticket Price Page >> AddNew Button >> Route Dropdown==> Mehphis->Oklahoma->CityAtlanta
    @FindBy(xpath = "(//*[@role='option'])[5]") public WebElement optionMehphisOklahomaCityAtlanta;

    //Ticket Price Page >> AddNew Button >> Route Dropdown==> Mehphis->Lousiana->Houston
    @FindBy(xpath = "(//*[@role='option'])[6]") public WebElement optionMemphisLousianaHouston;

    //Ticket Price Page >> AddNew Button >> Route Dropdown==> Houston->Lousiana->Memphis
    @FindBy(xpath = "(//*[@role='option'])[7]") public WebElement optionHoustonLousianaMemphis;

    //Ticket Price Page >> AddNew Button >> Price For Source To Destination TextBox
    @FindBy(xpath = "//*[@placeholder='Enter a price']") WebElement textBoxPriceForSourceToDestination;

    //Ticket Price Page >> AddNew Button >> Save Button
    @FindBy(xpath = "(//*[@type='submit'])[2]") WebElement ButtonSave;

    //Ticket Price Page >> AddNew Button >> GoBack Button
    @FindBy(xpath = ".la.la-fw.la-backward") public WebElement ButtonGoBack;

    //Ticket Price Page >> First Row on the Table >> Icon Pen
    @FindBy(xpath = "(//*[@class='la la-pen'])[1]") public WebElement iconPenFirstTicketPrice;

    //Ticket Price Page >> First Row on the Table >> Icon Pen >> Price TextBox
    @FindBy(id = "point-1") public WebElement textBoxPrice;

    //Ticket Price Page >> First Row on the Table >> Icon Pen >> Update Button
    @FindBy(xpath = "(//*[@type='submit'])[2]") public WebElement ButtonUpdate;

    //Ticket Price Page >> First Row on the Table >> Icon Delete
    @FindBy(xpath = "(//*[@type='button'])[7]") public WebElement iconDeleteFirstTicketPrice;

    //Ticket Price Page >> Second Page Icon
    @FindBy(xpath = "(//*[@class='page-link'])[2]") public WebElement iconSecondPageTicketPrice;

    //Trip Page >> Text >> All Trip
    @FindBy(className = "page-title") public WebElement textAllTrip;

    //Trip Page >> AddNew Button
    @FindBy(css = ".btn.btn-sm.btn--primary.box--shadow1.text--small") public WebElement buttonAddNewTrip;

    //Trip Page >> First Row on the Table >> Icon Pen
    @FindBy(xpath = "(//*[@class='la la-pen'])[1]") public WebElement iconPenFirstTrip;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Title TextBox
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public WebElement textBoxTitle;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window>> Fleet Type Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[1]") public WebElement dropdownFleet;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Fleet Type Dropdown-LuxBus
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement LuxBus;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Fleet Type Dropdown-ClassicBus
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement ClassicBus;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Fleet Type Dropdown-ExpressBus
    @FindBy(xpath = "(//*[@role='option'])[4]") public WebElement ExpressBus;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Route Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[3]") public WebElement routeDropdown;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Route Dropdown==> Express->Houston->Memphis
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement ExpressHoustonMemphis;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Route Dropdown==> Express->Lousiana->Nashville
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement ExpressLousianaNashville;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Route Dropdown==> Express->SanAntonio->Lousiana
    @FindBy(xpath = "(//*[@role='option'])[4]") public WebElement ExpressSanAntonioLousiana;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Route Dropdown==> Mehphis->Oklahoma->CityAtlanta
    @FindBy(xpath = "(//*[@role='option'])[5]") public WebElement MehphisOklahomaCityAtlanta;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Route Dropdown==> Mehphis->Lousiana->Houston
    @FindBy(xpath = "(//*[@role='option'])[6]") public WebElement MemphisLousianaHouston;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Route Dropdown==> Houston->Lousiana->Memphis
    @FindBy(xpath = "(//*[@role='option'])[7]") public WebElement HoustonLousianaMemphis;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Schedule Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[6]") public WebElement dropDownSchedule;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Schedule Dropdown==>05:45 am - 10:10 am
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement optionSchedule1;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Schedule Dropdown==>05:45 am - 06:25 am
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement optionSchedule2;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[8]") public WebElement dropdownStartFrom;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> End To Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[10]") public WebElement dropdownEndTo;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Austin
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement optionAustin;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Dallas
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement optionDallas;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Forth Worth
    @FindBy(xpath = "(//*[@role='option'])[4]") public WebElement optionForthWorth;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Houston
    @FindBy(xpath = "(//*[@role='option'])[5]") public WebElement optionHouston;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Lousiana
    @FindBy(xpath = "(//*[@role='option'])[6]") public WebElement optionLousiana;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-San Antonio
    @FindBy(xpath = "(//*[@role='option'])[7]") public WebElement optionSanAntonio;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Memphis
    @FindBy(xpath = "(//*[@role='option'])[8]") public WebElement optionMemphis;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Nashville
    @FindBy(xpath = "(//*[@role='option'])[9]") public WebElement optionNashville;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Start From && End To Dropdown-Atlanta
    @FindBy(xpath = "(//*[@role='option'])[10]") public WebElement optionAtlanta;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Day Of Dropdown
    @FindBy(xpath = "(//*[@role='combobox'])[6]") public WebElement dropDownDayOf;

    //Trip Page >> AddNew Button-Icon Pen >>Add Trip-Update Trip Window >> Close Button
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[1]") public WebElement ButtonCloseTrip;

    //Trip Page >> AddNew Button >> Save Button
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement ButtonSaveTrip;

    //Trip Page >> Icon Pen >> Update Button
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[3]") public WebElement ButtonUpdateTrip;

    //Trip Page >> First Row on the Table >> Icon Eye
    @FindBy(xpath = "(//*[@class='la la-eye-slash'])[1]") public WebElement IconEyeFirstRow;

    //Trip Page >> First Row on the Table >> Icon Eye >> Disable Button
    @FindBy(xpath = "//*[@class='btn btn--danger']") public WebElement disableButton;

    //Trip Page >> First Row on the Table >> Icon Eye >> Close Button
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[4]") public WebElement closeButton;

    //Assigned Vehicle Page
    @FindBy(className = "page-title") public WebElement textAssignedVehicles;
    @FindBy(css = ".btn.btn-sm.btn--primary.box--shadow1.text--small.addBtn") public WebElement buttonAssignedAddVehicle;

    //Assigned Vehicle Page >> First Row on the Table >> Icon Pen
    @FindBy(xpath = "(//*[@class='la la-pen'])[1]") public WebElement penIconFirstAction;

    //Assigned Vehicle Page >> Icon Pen >> Trip Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[6]") public WebElement DropdownTrip;

    //Assigned Vehicle Page >> Icon Pen >> Trip Dropdown==>LUX BUS - Fort Worth - Dallas
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement optionLuxBusForthWorthDallas;

    //Assigned Vehicle Page >> Icon Pen >> Trip Dropdown==>LUX BUS - Austin - Fort Worth
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement optionLuxBusAustinForthWorth;

    //Assigned Vehicle Page >> Icon Pen >> Vehicle Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[8]") public WebElement DropdownVehicle;

    //Assigned Vehicle Page >> Icon Pen >> Vehicle Dropdown==> EBT-002 (EBT-002)
    @FindBy(xpath = "(//*[@role='option'])[2]") public WebElement optionEBT002;

    //Assigned Vehicle Page >> Icon Pen >> Vehicle Dropdown==> EBT-004 (EBT-004)
    @FindBy(xpath = "(//*[@role='option'])[3]") public WebElement optionEBT004;

    //Assigned Vehicle Page >> Icon Pen >> Close Button
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[2]") public WebElement buttonCloseIconPen;

    //Assigned Vehicle Page >> Icon Pen >> Update Button
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[3]") public WebElement buttonUpdateIconPen;

    //Assigned Vehicle Page >> AddNew Button >> Trip Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[2]") public WebElement dropdownTripAssignedPage;

    //Assigned Vehicle Page >> AddNew Button >> Vehicle Dropdown
    @FindBy(xpath = "(//*[@role='presentation'])[4]") public WebElement dropdownVehicle;

    //Assigned Vehicle Page >> AddNew Button >> Close Button
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[1]") public WebElement buttonCloseAddNew;

    //Assigned Vehicle Page >> AddNew Button >> Save Button
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement buttonSaveAddNew;

    //Admin Dashboard sayfasındaki renkli  dikdörtgen kutuların hepsi
    @FindBy(xpath = "//*[@class='details']") public WebElement dashboardRenkliKutular;

    //Admin Dashboard sayfasındaki renkli kutuların Viev All Linkleri
    @FindBy(xpath = "(//a[text()='View All'])[1]") public WebElement linkViewAllTotalUsers;
    @FindBy(xpath = "(//a[text()='View All'])[2]") public WebElement linkViewAllTotalVerifiedUsers;
    @FindBy(xpath = "(//a[text()='View All'])[3]") public WebElement linkViewAllTotalEmailUnverifiedUsers;
    @FindBy(xpath = "(//a[text()='View All'])[4]") public WebElement linkViewAllTotalSMSUnverifiedUsers;
    @FindBy(xpath = "(//a[text()='View All'])[5]") public WebElement linkViewAllSuccessfulPayment;
    @FindBy(xpath = "(//a[text()='View All'])[6]") public WebElement linkViewAllPendingPayment;
    @FindBy(xpath = "(//a[text()='View All'])[7]") public WebElement linkViewAllRejectedPayment;
    @FindBy(xpath = "(//a[text()='View All'])[8]") public WebElement linkViewAllAcVehicle;
    @FindBy(xpath = "(//a[text()='View All'])[9]") public WebElement linkViewAllNonAcVehicle;
    @FindBy(xpath = "(//a[text()='View All'])[10]") public WebElement linkViewAllTotalCounter;

    //Admin Dashboard sayfasındaki renkli  dikdörtgen kutularına View All yapıldığında gidilen sayfalar
    //1 Totol Users = All users sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement manageUsersYazisi;
    @FindBy(xpath = "(//*[@class='icon-btn'])[1]") public WebElement manageUsersActionIconu;
    @FindBy(xpath = "//*[@class='form-control']") public WebElement manageUsersSearchBoxKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary']") public WebElement ManageUsersSearchBoxIconu;

    //2 Total Verified Users = Active Users sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement manageActiveUsersYazisi;
    @FindBy(xpath = "(//*[@class='icon-btn'])[1]") public WebElement manageActiveUsersActionIconu;
    @FindBy(xpath = "//*[@class='form-control']") public WebElement manageActiveUsersSearchBoxKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary']") public WebElement manageActiveUsersSearchBoxIconu;

    //3 Total Email Unverified Users = Email Unverified sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement emailUnverifiedUsersYazisi;
    @FindBy(xpath = "(//*[@class='icon-btn'])[1]") public WebElement emailUnverifiedUsersActionIconu;
    @FindBy(xpath = "//*[@class='form-control']") public WebElement emailUnverifiedUsersSearchBoxKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary']") public WebElement emailUnverifiedUsersSearchBoxIconu;

    //4 Total SMS Unverified Users = SMS Unverified sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement SMSUnverifiedUsersYazisi;
    @FindBy(xpath = "(//*[@class='icon-btn'])[1]") public WebElement SMSUnverifiedUsersActionIconu;
    @FindBy(xpath = "//*[@class='form-control']") public WebElement SMSUnverifiedUsersSearchBoxKutusu;
    @FindBy(xpath = "//*[@class='btn btn--primary']") public WebElement SMSUnverifiedUsersSearchBoxIconu;

    //5 Successful Payment sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement successfulPaymentYazisi;
    @FindBy(xpath = "//*[@class='form-control']") public WebElement successfulPaymentTrxNumberUsernameSearchBox;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement successfulPaymentTrxNumberUsernameSearchBoxIconu;
    @FindBy(xpath = "//*[@*='bottom right']") public WebElement successfulPaymentMinDateMaxDateSearchBoxKutusu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[2]") public WebElement successfulPaymentMinDateMaxDateSearchBoxIconu;
    @FindBy(xpath = "(//*[text()='Stripe Hosted'])[1]") public WebElement stripeHostedLinki;
    @FindBy(xpath = "(//*[@class='icon-btn ml-1 '])[1]") public WebElement stripeHostedActionIconu;
    @FindBy(xpath = "//*[@class='row mb-none-30']") public WebElement userPaymentDetailPage;

    //6 Pending Payment sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement pendingPaymentYazisi;
    @FindBy(xpath = "//*[@class='form-control']") public WebElement pendingPaymentTrxNumberUsernameSearchBoxKutusu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement pendingPaymentTrxNumberUsernameSearchBoxIconu;
    @FindBy(xpath = "//*[@*='bottom right']") public WebElement pendingPaymentMinDateMaxDateSearchBoxKutusu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[2]") public WebElement pendingPaymentMinDateMaxDateSearchBoxIconu;

    //7 Rejected Payment sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement rejectedPaymentYazisi;
    @FindBy(xpath = "//*[@class='form-control']") public WebElement rejectedPaymentTrxNumberUsernameSearchBoxKutusu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement rejectedPaymentTrxNumberUsernameSearchBoxIconu;
    @FindBy(xpath = "//*[@*='bottom right']") public WebElement rejectedPaymentMinDateMaxDateSearchBoxKutusu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[2]") public WebElement rejectedPaymentMinDateMaxDateSearchBoxIconu;

    //8 AC Vehicle = Vehicles = Non-AC Vehicle sayfalarının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement allVehiclesYazisi;
    @FindBy(xpath = "//*[@*='btn btn--primary box--shadow1 addBtn']") public  WebElement allVehiclesAddNewButtonu;
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public  WebElement allVehiclesRegNoTextBox;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[1]") public WebElement allVehiclesRegNoTextBoxIconu;
    @FindBy(xpath = "(//*[@class='la la-pen'])[1]") public WebElement allVehiclesActionPenIconu;
    @FindBy(xpath = "(//*[@class='la la-eye'])[1]") public WebElement allVehiclesActionGREENeyeIconu;
    @FindBy(xpath = "(//*[@class='la la-eye-slash'])[1]") public WebElement allVehiclesActionREDeyeIconu;
    //Add New buttonuna basınca çıkan Add Vehicle Penceresi ve textbox'ları
    @FindBy(xpath = "(//*[@class='modal-content'])[1]") public WebElement addVehiclePenceresi;
    @FindBy(xpath = "(//*[@class='form-control'])[2]") public  WebElement addVehicleNickNameTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[3]") public  WebElement addVehicleFleetTypeTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[4]") public  WebElement addVehicleRegisterNoTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[5]") public  WebElement addVehicleEngineNoTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[6]") public  WebElement addVehicleChasisNoTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[7]") public  WebElement addVehicleModelNoTextBox;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[1]") public WebElement addVehicleCloseButtonu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[2]") public WebElement addVehicleSaveButtonu;
    //All Vehicle sayfasında Action Pen İcon'una tıklandığında açılan pencere ve ayrıntıları
    @FindBy(xpath = "(//*[@class='modal-content'])[2]") public WebElement updateVehiclePenceresi;
    @FindBy(xpath = "(//*[@class='form-control'])[8]") public WebElement updateVehicleNickNameTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[9]") public WebElement updateVehicleFleetTypeTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[10]") public  WebElement updateVehicleRegisterNoTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[11]") public  WebElement updateVehicleEngineNoTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[12]") public  WebElement updateVehicleChasisNoTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[13]") public  WebElement updateVehicleModelNoTextBox;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[2]") public WebElement updateVehicleCloseButtonu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[3]") public WebElement updateVehicleUpdateButtonu;


    //9  Non-AC Vehicle = Vehicles sayfasının ayrıntıları...
    //bu sayfada bug var üstteki sayfayla aynı yere gidiyor kopyalarsam da altını çiziyor!



    //10 Total Counter = Counter sayfasının ayrıntıları...
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement allCounterYazisi;
    @FindBy(xpath = "//*[text()='Add New']") public WebElement allCounterAddNewButtonu;
    @FindBy(xpath = "(//*[@class='la la-pen'])[13]") public WebElement addCounterActionPenIconu;
    @FindBy(xpath = "(//*[@class='la la-eye-slash'])[13]") public WebElement addCounterActionREDeyeIconu;
    @FindBy(xpath = "(//*[@class='la la-eye'])[1]") public WebElement addCounterActionGREENeyeIconu;
    //Add New buttonuna basınca çıkan Add Vehicle Penceresi ve textbox'ları
    @FindBy(xpath = "(//*[@class='modal-content'])[1]") public WebElement addCounterPenceresi;
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public WebElement addCounterNameTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[2]") public WebElement addCounterCityTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[3]") public WebElement addCounterLocationTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[4]") public WebElement addCounterMobileTextBox;
    @FindBy(xpath = "(//*[text()='Close'])[1]") public WebElement addCounterCloseButtonu;
    @FindBy(xpath = "//*[text()='Save']") public WebElement addCounterSaveButtonu;

    //All Counter sayfasında Action Pen İcon'una tıklandığında açılan pencere ve ayrıntıları
    @FindBy(xpath = "(//*[@class='modal-content'])[2]") public WebElement updateCounterPenceresi;
    @FindBy(xpath = "(//*[@class='form-control'])[5]") public WebElement updateCounterNameTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[6]") public WebElement updateCounterCityTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[7]") public WebElement updateCounterLocationTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[8]") public WebElement updateCounterMobileTextBox;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[2]") public WebElement updateCounterCloseButtonu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[2]") public WebElement updaCounterUpdateButtonu;

    //All Counter sayfasında Action Green eyes ve Red eyes İCon'larına Tıklandıgında açılan Alertler
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[3]") public WebElement activeCounterCloseButtonu;
    @FindBy(xpath = "(//*[@class='btn btn--primary'])[3]") public WebElement activeCounterActiveButtonu;
    @FindBy(xpath = "(//*[@class='btn btn--dark'])[4]") public WebElement disableCounterCloseButtonu;
    @FindBy(xpath = "//*[@class='btn btn--danger']") public WebElement disableCounterDisableButtonu;


    //Users Detail Sayfası ve ayrıntıları
    @FindBy(xpath = "//*[@class='col-lg-6 col-sm-6']") public WebElement usersDetailYazisi;
    @FindBy(xpath = "(//*[@*='card-body'])[3]") public WebElement informationOfUsersPenceresi;
    @FindBy(xpath = "(//*[@class='form-control'])[1]") public WebElement usersDetailFirstnameTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[2]") public WebElement usersDetailLastnameTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[3]") public WebElement usersDetailEmailTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[4]") public WebElement usersDetailMobileNumberTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[5]") public WebElement usersDetailAddressTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[6]") public WebElement usersDetailCityTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[7]") public WebElement usersDetailStateTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[8]") public WebElement usersDetailZipPostalTextBox;
    @FindBy(xpath = "(//*[@class='form-control'])[9]") public WebElement usersDetailCOUNTRYTextBox;
    @FindBy(xpath = "(//*[text()='Active'])[2]") public WebElement statusActiveButton;
    @FindBy(xpath = "(//*[text()='Banned'])[2]") public WebElement statusBannedButton;
    @FindBy(xpath = "(//*[text()='Verified'])[1]") public WebElement emailVerificationVerifiedButton;
    @FindBy(xpath = "(//*[text()='Unverified'])[1]") public WebElement emailVerificationUnverifiedButton;
    @FindBy(xpath = "(//*[text()='Verified'])[2]") public WebElement SMSVerificationVerifiedButton;
    @FindBy(xpath = "(//*[text()='Unverified'])[2]") public WebElement SMSVerificationUnverifiedButton;
    @FindBy(xpath = "//*[@*='btn btn--primary btn-block btn-lg']") public WebElement ButtonsaveChanges;

    //User detail sayfasındaki User Action Penceresi ve Button Linkler
    @FindBy(xpath = "(//*[@*='card-body'])[2]") public WebElement userActionPenceresi;
    @FindBy(xpath = "//*[@*='btn btn--primary btn--shadow btn-block btn-lg']") public WebElement loginLogsButton;
    @FindBy(xpath = "//*[@*='btn btn--info btn--shadow btn-block btn-lg']") public WebElement sendEmailButton;
    @FindBy(xpath = "//*[@*='btn btn--dark btn--shadow btn-block btn-lg']") public WebElement loginAsUserButton;
    @FindBy(xpath = "//*[@*='btn btn--warning btn--shadow btn-block btn-lg']") public WebElement emailLogButton;
    @FindBy(xpath = "(//*[@class='las la-user'])[1]") public WebElement emailLogSayfasindakiUserIconu;


    //Admin Dashboard sayfasındaki Latest Booking History Bilgileri sayfası
    @FindBy(xpath = "(//*[@class='card-body'])[1]") public  WebElement latestBookingHistoryBilgileri;

    //Admin Dashboard sayfasındaki Latest Booking History Action iconu
    @FindBy(xpath = "(//*[@class='la la-desktop'])[1]") public WebElement latestBookingHistoryActionIconu;

    //Admin Dashboard Booking History Tablosu
    @FindBy(xpath = "//*[@*='card-body']") public  WebElement BookingHistoryTablosu;

    //Admin Dashboard sayfasındaki Last 30 days Payment History grafigi
    @FindBy(xpath = "(//*[@class='card-body'])[2]") public  WebElement last30DaysPaymentHistoryGrafigi;

    //Admin Dashboard sayfasındaki Login By Browser,Login By OS ve Login By Country görselleri
    @FindBy(xpath = "(//*[@class='card-body'])[3]") public  WebElement loginByBrowser;
    @FindBy(xpath = "(//*[@class='card-body'])[4]") public  WebElement loginByOS;
    @FindBy(xpath = "(//*[@class='card-body'])[5]") public  WebElement loginByCountry;

}
