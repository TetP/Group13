package com.cybertek.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #4: Zero Bank login title verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Click to “Account Activity” link
6. Verify title changed to:
Expected: “Zero – Account Activity”
7. Click to “Transfer Funds” link
8. Verify title changed to:
Expected: “Zero – Transfer Funds”
9. Click to “Pay Bills” link
10. Verify title changed to:
Expected: “Zero - Pay Bills”
11. Click to “My Money Map” link
12. Verify title changed to:
Expected: “Zero – My Money Map”
13. Click to “Online Statements” link
14. Verify title changed to:
Expected: “Zero – Online Statements”
 */
public class ZeroBank4 {

    public static void main(String[] args) {

        //TC #4: Zero Bank login title verification

        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");

        //3. Enter username: username
        driver.findElement(By.id("user_login")).sendKeys("username");

        //4. Enter password: password
        driver.findElement(By.id("user_password")).sendKeys("password"+ Keys.ENTER);

        //5. Click to “Account Activity” link
        driver.findElement(By.linkText("Account Activity")).click();

        //6. Verify title changed to:
        //Expected: “Zero – Account Activity”
        String expectedTitleAA="Zero - Account Activity";
        String actualTitleAA=driver.getTitle();

        if (actualTitleAA.equals(expectedTitleAA)){
            System.out.println("AA PASSED");
        }else {
            System.out.println("AA FAILED");
        }

        //7. Click to “Transfer Funds” link
        driver.findElement(By.linkText("Transfer Funds")).click();

        //8. Verify title changed to:
        //Expected: “Zero – Transfer Funds”
        String expectedTitleTF="Zero - Transfer Funds";
        String actualTitleTF=driver.getTitle();

        if (actualTitleTF.equals(expectedTitleTF)){
            System.out.println("TF PASSED");
        }else {
            System.out.println("TF FAILED");
        }

        //9. Click to “Pay Bills” link
        driver.findElement(By.linkText("Pay Bills")).click();

        //10. Verify title changed to:
        //Expected: “Zero - Pay Bills”
        String expectedTitlePB="Zero - Pay Bills";
        String actualTitlePB=driver.getTitle();

        if (actualTitlePB.equals(expectedTitlePB)){
            System.out.println("PB PASSED");
        }else {
            System.out.println("PB FAILED");
        }

        //11. Click to “My Money Map” link
        driver.findElement(By.linkText("My Money Map")).click();

        //12. Verify title changed to:
        //Expected: “Zero – My Money Map”
        String expectedTitleMMM="Zero - My Money Map";
        String actualTitleMMM=driver.getTitle();

        if (actualTitleMMM.equals(expectedTitleMMM)){
            System.out.println("MMM PASSED");
        }else {
            System.out.println("MMM FAILED");
        }


        //13. Click to “Online Statements” link
        driver.findElement(By.linkText("Online Statements")).click();

        //14. Verify title changed to:
        //Expected: “Zero – Online Statements”
        String expectedTitleOS="Zero - Online Statements";
        String actualTitleOS=driver.getTitle();

        if (actualTitleOS.equals(expectedTitleOS)){
            System.out.println("OS PASSED");
        }else {
            System.out.println("OS FAILED");
        }
















    }
}
