package tests.US30_Samet;

import com.github.javafaker.Faker;
import jdk.jfr.consumer.RecordedMethod;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AdminDashboard;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;
import utilities.TestBaseRapor;

import java.util.List;

public class US30_TC02 extends TestBaseRapor {
    @Test
    public void counterStatusTest() {
        extentTest=extentReports.createTest("counterStatusTest","Sayaç sayfasında yeni bir Sayaç eklenmeli, eklenen sayacın bilgileri görüntülenip düzenlenmeli");
        //  Go the https://qa.easybusticket.com/admin page
        Driver.getDriver().get(ConfigReader.getProperty("adminUrl"));
        AdminDashboard pageAdmin = new AdminDashboard();
        extentTest.info("Go the https://qa.easybusticket.com/admin page");
        //  Login as a admin
        pageAdmin.usernameKutusu.sendKeys("admin37");
        pageAdmin.passwordKutusu.sendKeys("123123123");
        pageAdmin.loginButonu.click();
        extentTest.info("Login as a admin");
        //  Click the Counter link
        pageAdmin.counter.click();
        List<WebElement> webElements = pageAdmin.table;
        List<String> listString = ReusableMethods.getElementsText(webElements);
        extentTest.info("Click the Counter link");
        // Click the Add New button
        pageAdmin.allCounterAddNewButtonu.click();
        extentTest.info("Click the Add New button");
        // Enter appropriate data into all fields
        Faker faker = new Faker();
        pageAdmin.addCounterNameTextBox.sendKeys(faker.name().firstName());
        pageAdmin.addCounterCityTextBox.sendKeys(faker.name().lastName());
        pageAdmin.addCounterLocationTextBox.sendKeys(faker.country().name());
        pageAdmin.addCounterMobileTextBox.sendKeys(faker.number().digits(6));
        extentTest.info("Enter appropriate data into all fields");
        // Click the Save button
        pageAdmin.addCounterSaveButtonu.click();
        // Verify that the new counter has been added
        String expectedMessage = "Counter save successfully.";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(pageAdmin.addCounterSaveAlert.getText(), expectedMessage, "Counter kaydedilemedi");
        extentTest.pass("Click the Save button and verify that the new counter has been added");
        // Verify that the added counter is added to the list
        List<WebElement> newwebElements = pageAdmin.table;
        List<String> newlistString = ReusableMethods.getElementsText(webElements);
        softAssert.assertFalse(listString.size() == newlistString.size(), "Eklenen counter listede yok!");
        extentTest.pass("Verify that the added counter is added to the list");
        softAssert.assertAll();
        // Close the page
        Driver.closeDriver();


    }
}