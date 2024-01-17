package tests.US31_Nevfel;

import com.github.javafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class US31_TC05 {
    @Test
    public void test05(){
        //1.Browserı açar.
        //"2. Url: ""https://qa.easybusticket.com/admin/""
        // linki ile admin giriş sayfasına gider."
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        //3.Gecerli admin username ve gecerli password girip login butonuna tıklayıp login olur.
        AdminDashboard adminDashboard=new AdminDashboard();
        adminDashboard.usernameKutusu.sendKeys("admin35");
        adminDashboard.passwordKutusu.sendKeys("123123123");
        adminDashboard.loginButonu.click();

        //4.Admin Dashboard sayfasındaki sol menude  Manage Fleets baslığınına tıklar.
        adminDashboard.manageFleets.click();
        ReusableMethods.wait(2);
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true);",adminDashboard.vehicle);

        //5.Vehicles alt başlığına erişim sağlar.
        ReusableMethods.clickWithJS(adminDashboard.vehicle);

        //6.Sağ üstte buluna  Add New buttonuna tıklar.
        adminDashboard.allVehiclesAddNewButtonu.click();
        ReusableMethods.wait(2);

        //7.Sayfada Add Vehicle penceresinin açıldığını doğrular.
        SoftAssert softAssert =new SoftAssert();
        softAssert.assertTrue(adminDashboard.addVehiclePenceresi
                                            .isDisplayed(),"Add Vehicle penceresi açılmadı!");
        //8.Add Vehicle Nick Name textbox'ına nickname girer.
        Faker faker=new Faker();
        adminDashboard.addVehicleNickNameTextBox.sendKeys(faker.company().name());
        Select select=new Select(adminDashboard.addVehicleFleetTypeTextBox);
        select.selectByValue("62");
        //10.Register No. textboxına bir numara girer.
        adminDashboard.addVehicleRegisterNoTextBox.sendKeys(faker.code().ean8());

        //11.Engine No. textboxına bir numara girer.
        adminDashboard.addVehicleEngineNoTextBox.sendKeys(faker.code().ean13());

        //12.Chasis No.textboxına bir numara girer.
        adminDashboard.addVehicleChasisNoTextBox.sendKeys(faker.code().gtin8());

        //14.Model No.textboxına bir numara girer.
        adminDashboard.addVehicleModelNoTextBox.sendKeys(faker.code().isbn10());

        //15.Save buttonuna tıklar ve aracın başarılı bir şekilde eklendiğini çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.addVehicleSaveButtonu);
        String expectedAddVehicleAlert="Vehicle save successfully.";
        String actualAddVehicleAlert=adminDashboard.alertAddVehicleSuccesfullYazisi.getText();
        softAssert.assertEquals(actualAddVehicleAlert,expectedAddVehicleAlert,"Add Vehicle alertleri aynı değil!");
        ReusableMethods.wait(2);

        //16.Eklediği araç bilgilerini   update etmek için satırdaki  Action Pen buttonuna tıklar.
        ReusableMethods.clickWithJS(adminDashboard.allVehiclesActionPenIconu);
        ReusableMethods.wait(2);

        //17.Update Vehicle penceresinin açıldığını doğrular.
        softAssert.assertTrue(adminDashboard.updateVehiclePenceresi
                                            .isDisplayed(),"Update Vehicle penceresi açılmadı!");
        //18.Aracın nickname ini düzenler.
        adminDashboard.updateVehicleNickNameTextBox.clear();
        ReusableMethods.wait(1);
        adminDashboard.updateVehicleNickNameTextBox.sendKeys("X PLUS");
        ReusableMethods.wait(2);

        //19.Update buttonuna tıklar ve değişikliğin başarılı bir şekilde gerçekleştirildiğini çıkan alert ile doğrular.
        ReusableMethods.clickWithJS(adminDashboard.updateVehicleUpdateButtonu);

        String expectedUpdateVehicle="Vehicle update successfully.";
        String actualUpdateVehicle=adminDashboard.alertUpdateVehicleSuccesfullYazisi.getText();
        softAssert.assertEquals(actualUpdateVehicle,expectedUpdateVehicle,"Update ler aynı değil!");
        ReusableMethods.wait(3);

        softAssert.assertAll();
        //20.Browserı kapatır.
        Driver.closeDriver();









    }
}
