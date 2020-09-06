package com.cybertek.tests.VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginForVytrack {

    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user163");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);

        //driver.findElement(By.linkText("Fleet")).findElements(By.name("dropdown-menu-wrapper dropdown-menu-wrapper__placeholder"));

        driver.get("https://qa2.vytrack.com/entity/Extend_Entity_Carreservation");



        Thread.sleep(2000);
        driver.findElement(By.linkText("Reset")).click();



        /*
        driver.findElement(By.className("nav-multilevel main-menu")).findElement(By.className("dropdown dropdown-level-1")).findElement(By.className("title title-level-2")).click();


        WebElement dropDown=driver.findElement(By.className("dropdown dropdown-level-1"));
        Select dropdown = new Select(dropDown);
        dropdown.selectByIndex(1);

         */






    }
}
