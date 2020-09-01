package com.cybertek.tests.VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class LoginForVytrack {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user163");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);

        driver.findElement(By.className("nav-multilevel main-menu")).findElement(By.className("dropdown dropdown-level-1")).findElement(By.className("title title-level-2")).click();


        WebElement dropDown=driver.findElement(By.className("dropdown dropdown-level-1"));
        Select dropdown = new Select(dropDown);
        dropdown.selectByIndex(1);






    }
}
