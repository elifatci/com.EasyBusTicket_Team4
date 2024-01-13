package tests.US34_Elif;

import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.Driver;

public class US34_TC01 {

    @Test
    public void test01(){
        Driver.getDriver().get(ConfigReader.getProperty("easyBusUrl"));
    }
}
