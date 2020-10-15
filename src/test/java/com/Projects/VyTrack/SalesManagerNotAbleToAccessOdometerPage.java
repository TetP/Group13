package com.Projects.VyTrack;

import com.Projects.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class SalesManagerNotAbleToAccessOdometerPage {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("salesmanager263");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("UserUser123"+ Keys.ENTER);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void SalesManagerNotAbleToAccessOdometerPage() throws InterruptedException {
        WebElement fleet=driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();
        driver.findElement(By.linkText("Vehicle Odometer")).click();
        Thread.sleep(2000);

        String expectedTitle="Dashboard";   //Because page should deny your entry to get in Vehicles odometer thats why your driverTitle should stay same as a "Dashboard"
        String actualTitle=driver.getTitle();


        Assert.assertEquals(actualTitle,expectedTitle,"Sales Manager has reached to Vehicles Odometers Page - Verification FAILED");




    }










}
