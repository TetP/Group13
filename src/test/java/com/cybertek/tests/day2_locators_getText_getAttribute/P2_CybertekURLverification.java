package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P2_CybertekURLverification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://practice.cybertekschool.com");


        String expectedUrl="cybertekschool";
        String actualUrl=driver.getCurrentUrl();

        if (actualUrl.contains(expectedUrl)){
            System.out.println("URL verification PASSED");
        }else {
            System.out.println("URL verification FAILED");
        }


        String expectedTitle="practice";
        String actualTitle=driver.getTitle();

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Title verification PASSED");
        }else {
            System.out.println("Title verification PASSED");
        }



    }
}
