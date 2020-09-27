package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
Practice #5: Method: printNamesAndCities
• Create a method named printNamesAndCities in SmartBearUtils class.
• Method takes WebDriver object.
• This method should simply print all the names in the List of All Orders.
• Create a new TestNG test to test if the method is working as expected.
• Output should be like:
• Name1: name , City1: city
• Name2: name , City2: city
 */
public class TC5_namesCities {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }


    @Test
    public void nameAndCities(){
        SmartBearUtilities.printNamesAndCities(driver);


    }

}
