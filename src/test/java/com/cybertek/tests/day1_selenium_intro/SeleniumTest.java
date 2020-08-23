package com.cybertek.tests.day1_selenium_intro;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumTest {

    public static void main(String[] args) throws InterruptedException {

        //1- Setup the driver
        WebDriverManager.chromedriver().setup();

        //2- Create instance of the driver
        WebDriver driver = new ChromeDriver();

        //3- Use the driver instance to test selenium
        driver.get("https://www.google.com");

        System.out.println("Title of the page is: "+driver.getTitle());

        String actualTitle = driver.getTitle();
        System.out.println("Title of the page is: "+actualTitle);

        String actualUrl = driver.getCurrentUrl();
        System.out.println("URL of the page is: "+actualUrl);

        Thread.sleep(3000);
        driver.navigate().back();

        Thread.sleep(3000);
        driver.navigate().forward();

        Thread.sleep(3000);
        driver.navigate().refresh();

        Thread.sleep(3000);
        driver.navigate().to("https://facebook.com");

        String pageSource = driver.getPageSource();
        System.out.println("Page source"+pageSource);


        driver.manage().window().fullscreen();

        driver.close();

        driver.quit();


    }
}
