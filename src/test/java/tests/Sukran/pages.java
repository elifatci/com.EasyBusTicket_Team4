package tests.Sukran;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class pages {
    public pages(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
