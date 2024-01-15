package tests.US14_Omer;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.UserDashboard;
import pages.VisitorHomepage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US14_TC01 {
    @Test public void US14_TC01(){
        //1.Anasayfaya gidiliir.cookie kabul edilir.
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
        //2.Cookies kabul edilir.
        VisitorHomepage visitorHomepage=new VisitorHomepage();
        visitorHomepage.ButonCookieAccept.click();
        //2.Click on 'SignIn' button
        visitorHomepage.ButtonSignIn.click();
        //3.Enter correct username and password (Doğru username ve şifreyi girin)
        visitorHomepage.textBoxUsername.sendKeys("ofom123");
        visitorHomepage.textBoxPassword.sendKeys("Ofom123.");
        //4.Click 'login' button (Giris yap butonuna tiklayin)
        visitorHomepage.buttonLogin.click();
        //5."https://qa.easybusticket.com/user/dashboard" sayfasına ulaştığımı doğrulamalıyım.
        SoftAssert softAssert=new SoftAssert();
        String ExpectedURl="https://qa.easybusticket.com/user/dashboard";
        String ActuelUrl=Driver.getDriver().getCurrentUrl();
        softAssert.assertEquals(ActuelUrl,ExpectedURl,"Üye girişi tamamlanamadı");
        //6.Dashboard yazısı olduğu doğrulanır.
        UserDashboard userDashboard=new UserDashboard();
        String Actuelyazi=userDashboard.textDashboard.getText();
        String expectedyazi="Dashboard";
        softAssert.assertEquals(Actuelyazi,expectedyazi,"Dashboard görüntülenemedi");
        //7-Total Booked Ticket,Total Rejected Ticket,Total Pending Ticket pencereleri göründüğü doğrulanır.
        softAssert.assertTrue(userDashboard.windowTotalBookedTicket.isDisplayed(),"windowTotalBookedTicket göntülenemedi");
        softAssert.assertTrue(userDashboard.windowTotalPendingTicket.isDisplayed(),"windowTotalPendingTicket göntülenemedi");
        softAssert.assertTrue(userDashboard.windowTotalRejectedTicket.isDisplayed(),"TotalRejectedTicket göntülenemedi");
        //8-Alınan biletler listesinde action butonu tıklanır
        ReusableMethods.clickWithJS(userDashboard.buttonFirstAction);
        //9.bilet yazıdrma sayfası çıktığı TicketBookingHistory yazısı ile doğrulanır.
        softAssert.assertTrue(userDashboard.textTicketBookingHistory.isDisplayed());
        //10.bilet yazdırma sayfası kapatılır.
        ReusableMethods.waitFor(3);
        ReusableMethods.clickWithJS(userDashboard.buttonClose);
        ReusableMethods.waitFor(3);
        //11.browser closes
        Driver.closeDriver();

    }


}
