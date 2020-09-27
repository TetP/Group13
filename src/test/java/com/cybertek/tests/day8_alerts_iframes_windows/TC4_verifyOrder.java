package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
PRACTICE #4: Method: verifyOrder
• Create a method named verifyOrder in SmartBearUtils class.
• Method takes WebDriver object and String(name).
• Method should verify if given name exists in orders.
• This method should simply accepts a name(String), and assert whether
given name is in the list or not.
• Create a new TestNG test to test if the method is working as expected.
 */
public class TC4_verifyOrder {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //    1. Open browser and login to Smartbear software
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");//1

    }


    @Test
    public void verifyOrder(){

        SmartBearUtilities.verifyOrder(driver,"Bob Feather");


    }



}
