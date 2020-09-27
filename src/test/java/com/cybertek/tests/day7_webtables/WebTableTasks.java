package com.cybertek.tests.day7_webtables;
/*
    TC#3: Smartbear software order verification
    1. Open browser and login to Smartbear software
    2. Click on View all orders
    3. Verify Susan McLaren has order on date “01/05/2010”
     */

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WebTableTasks {

    //TC#3: Smartbear software order verification

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //    1. Open browser and login to Smartbear software
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);        //1
    }


    @Test
    public void susanMclarenHasOrder(){

        //    2. Click on View all orders
        //    3. Verify Susan McLaren has order on date “01/05/2010”

        WebElement susanDate=driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[6]/td[5]"));
        //WebElement susansDate = driver.findElement(By.xpath("//td[.='Susan McLaren']/following-sibling::td[3]"));

        String expectedDate="01/05/2010";
        String actualDate=susanDate.getText();


        Assert.assertEquals(actualDate,expectedDate);

    }


}
