package com.cybertek.tests.day9_windows_tabs;

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

public class Alert3Practice {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://practice.cybertekschool.com/javascript_alerts");

    }

    /*
    TC #3: Information alert practice
    1. Open browser
    2. Go to website: http://practice.cybertekschool.com/javascript_alerts
    3. Click to “Click for JS Prompt” button
    4. Send “hello” text to alert
    5. Click to OK button from the alert
    6. Verify “You entered: hello” text is displayed.
     */
    @Test
    public void p3_prompt_alert_practice(){
        WebElement promptAlertButton=driver.findElement(By.xpath("//button[@onclick='jsPrompt()']"));

        promptAlertButton.click();

        Alert alert=driver.switchTo().alert();
        BrowserUtils.wait(2);

        alert.sendKeys("hello");
        BrowserUtils.wait(2);

        alert.accept();

        String actualText=driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedText="You entered: hello";

        Assert.assertEquals(actualText,expectedText,"Message doesn't match, Verification Failed!");



    }

}