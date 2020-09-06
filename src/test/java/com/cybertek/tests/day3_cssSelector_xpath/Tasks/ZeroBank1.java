package com.cybertek.tests.day3_cssSelector_xpath.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #1: Zero Bank title verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify title
Expected: “Zero - Log in”
 */
public class ZeroBank1 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        String expectedTitle="Zero - Log in";
        String actualTitle=driver.getTitle();

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }


    }
}
