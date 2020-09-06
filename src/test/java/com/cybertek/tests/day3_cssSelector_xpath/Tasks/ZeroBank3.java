package com.cybertek.tests.day3_cssSelector_xpath.Tasks;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC #3: Zero Bank login title verification
1. Open Chrome browser
2. Go to http://zero.webappsecurity.com/login.html
3. Enter username: username
4. Enter password: password
5. Verify title changed to:
Expected: “Zero – Account Summary”
 */
public class ZeroBank3 {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();

        driver.get("http://zero.webappsecurity.com/login.html");

        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password"+ Keys.ENTER);

        String actualTitle=driver.getTitle();
        String expectedTitle="Zero - Account Summary";

        if (actualTitle.equals(expectedTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }






    }
}
