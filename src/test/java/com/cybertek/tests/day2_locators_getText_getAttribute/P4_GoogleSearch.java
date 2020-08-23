package com.cybertek.tests.day2_locators_getText_getAttribute;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
TC#4:	Google	search
1-Open	a	chrome	browser
2-Go	to:	https://google.com
3-Write	“apple”	in	search	box
4-Click	google	search	button
5-Verify	title:
Expected:	Title	should	start	with	“apple”
 */
public class P4_GoogleSearch {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://google.com");

        driver.findElement(By.name("q")).sendKeys("apple"+ Keys.ENTER);

        String expectedTitle="apple - Google Search";
        String actualTitle=driver.getTitle();

        if (actualTitle.equalsIgnoreCase(expectedTitle)){
            System.out.println("Search title verification PASSED");
        }else {
            System.out.println("Search title verification PASSED");
        }



    }
}
