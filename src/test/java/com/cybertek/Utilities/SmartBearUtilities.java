package com.cybertek.Utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

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

    public static void verifyOrder(WebDriver driver, String name){
        loginToSmartBear(driver);
        String actualName=driver.findElement(By.xpath("//td[.='"+name+"']")).getText();
        String expectedName=name;
        Assert.assertEquals(actualName,expectedName);
    }

    public static void printNamesAndCities(WebDriver driver){
        //• Create a method named printNamesAndCities in SmartBearUtils class.
        //• Method takes WebDriver object.
        //• This method should simply print all the names and cities in the List of All Orders.

        loginToSmartBear(driver);

        for (int i=2; i<=9; i++){
            String name = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+i+"]/td[2]")).getText();    //name
            String city = driver.findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr["+i+"]/td[7]")).getText();    //city

            //• Name1: name , City1: city
            System.out.println("Name"+(i-1)+": "+name+", City"+(i-1)+": "+city);
        }



    }



}
