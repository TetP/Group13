package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

/*
TC #1: Information alert practice
1.Open browser
2.Go to website: http://practice.cybertekschool.com/javascript_alerts
3.Click to “Click for JS Alert”button
4.Click to OK button from the alert
5.Verify “You successfulyclicked an alert” text is displayed.
 */
public class AlertPractices {

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");
    }


    @Test
    public void informationAlertPractice(){

        WebElement jSalert=driver.findElement(By.xpath("//button[.='Click for JS Alert']"));
        jSalert.click();

        BrowserUtils.wait(2);

        Alert alert=driver.switchTo().alert();

        alert.accept();

        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));

        Assert.assertTrue(resultText.isDisplayed(),"Result text id not displayed. Verification failed");
    }



    //TC #2: Confirmationalert practice

    @Test
    public void  confirmationAlertPractice(){
        // 3.Click to “Click for JS Confirm” button
        WebElement warningAlertButton = driver.findElement(By.xpath("//button[.='Click for JS Confirm']"));
        warningAlertButton.click();

        // 4.Click to OK button from the alert
        Alert alert=driver.switchTo().alert();
        alert.accept();

        // 5.Verify “You clicked: Ok” text is displayed.
        WebElement resultText=driver.findElement(By.xpath("//p[@id='result']"));
        Assert.assertTrue(resultText.isDisplayed(),"Result text id not displayed. Verification failed");
    }


    //TC #3: Information alert practice
    @Test
    public void informationAlertPractice2(){

        // 3.Click to “Click for JS Prompt” button
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();

        BrowserUtils.wait(2);

        // 4.Send “hello”text to alert
        Alert alert=driver.switchTo().alert();
        BrowserUtils.wait(2);
        alert.sendKeys("hello");
        BrowserUtils.wait(2);
        alert.accept();


        BrowserUtils.wait(2);

        // 5.Click to OK button from the alert

        // 6.Verify “You entered:  hello” text is displayed.
        String resultText=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedResult="You entered: hello";

        Assert.assertEquals(resultText,expectedResult);

    }








}
