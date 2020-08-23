package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: Back and forth navigation
1-Open a chrome browser
2-Go to: https://google.com
3-Click to Gmail from top right.
4-Verify title contains:Expected: Gmail
5-Go back to Google by using the .back();
6-Verify title equals:Expected: Google
 */
public class P3_NavigationsAndTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://google.com");


        driver.findElement(By.linkText("Gmail")).click();

        String expectedGmailTitle="Gmail";
        String actualGmailTitle=driver.getTitle();

        if (actualGmailTitle.contains(expectedGmailTitle)){
            System.out.println("Gmail title verification PASSED");
        }else {
            System.out.println("Gmail title verification FAILED");
        }

        driver.navigate().back();

        String expectedGoogleTitle="google";
        String actualGoogleTitle=driver.getTitle();

        if (actualGoogleTitle.equalsIgnoreCase(expectedGoogleTitle)){
            System.out.println("Google title verification PASSED");
        }else {
            System.out.println("Google title verification PASSED");
        }



    }
}
