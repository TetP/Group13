package com.cybertek.tests.day3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #2: Zero Bank link text verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Verify link text from top left:
Expected: “Zero Bank”
4. Verify link href attribute value contains:
Expected: “index.html”
 */
public class ZeroBank2 {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        String actualText = driver.findElement(By.linkText("Zero Bank")).getAttribute("href");
        String expectedText = "index.html";

        if (actualText.contains(expectedText)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }






    }
}
