package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class P1_GoogleTitleVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.google.com");

        String title = driver.getTitle();
        System.out.println("Title is: "+title);

        driver.navigate().to("https://practice.cybertekschool.com");
        String url = driver.getCurrentUrl();
        String cybertekTitle=driver.getTitle();

        System.out.println("Title is: "+cybertekTitle+"\nURL is: "+url);




    }
}
