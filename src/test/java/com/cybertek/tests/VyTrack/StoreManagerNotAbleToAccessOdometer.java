package com.cybertek.tests.VyTrack;

import com.cybertek.tests.day3_cssSelector_xpath.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class StoreManagerNotAbleToAccessOdometer {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        driver= WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager213");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        Thread.sleep(2000);
    }

    @Test
    public void storeManagerNotAbleToOdometer() throws InterruptedException {
        WebElement fleet=driver.findElement(By.xpath("//li[@class='dropdown dropdown-level-1'][1]"));
        fleet.click();

        driver.findElement(By.linkText("Vehicle Odometer")).click();

        Thread.sleep(2000);

        String expectedErrorMessage="You do not have permission to perform this action.";
        String actualErrorMessage=driver.findElement(By.xpath("//*[@id='flash-messages']/div/div/div[2]/div")).getText();

        Assert.assertEquals(actualErrorMessage,expectedErrorMessage,"ERROR messages not matching");
    }









}
