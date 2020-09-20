package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SmartBearUtilities {

    //Mini-Task:
    //• Create a method called loginToSmartBear
    //• This method simply logs in to SmartBear when you call it.
    //• Accepts WebDriver type as parameter
    public static void loginToSmartBear(WebDriver driver){
        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");

        //4. Enter password: “test”
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //5. Click to Login button
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

    }
}
