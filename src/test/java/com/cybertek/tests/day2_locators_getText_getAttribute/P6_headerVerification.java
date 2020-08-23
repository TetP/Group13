package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #6: Zero Bankheader verification
1.Open Chrome browser
2.Go to http://zero.webappsecurity.com/login.html
3.Verify header text
Expected: “Log in to ZeroBank”
 */
public class P6_headerVerification {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        //WebElement header=driver.findElement(By.tagName("h3")); //find element returns WebElement

        String actualText=driver.findElement(By.tagName("h3")).getText();   //returns string
        String expectedText="Log in to ZeroBank";

        if (actualText.equals(expectedText)){
            System.out.println("Header verification PASSED!");
        }else {
            System.out.println("Header title verification FAILED!");
        }




    }
}
