package com.cybertek.tests.VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class LoginForVytrack {

    public static void main(String[] args) throws InterruptedException  {

        WebDriverManager.chromedriver().setup();

        WebDriver driver=new ChromeDriver();

        driver.get("https://qa2.vytrack.com/user/login");

        driver.findElement(By.id("prependedInput")).sendKeys("user163");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123"+ Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.cssSelector("span[class='title title-level-1']")).click();
        Thread.sleep(2000);

        driver.findElement(By.linkText("Vehicles")).click();
        Thread.sleep(2000);

        WebElement gridSettings = driver.findElement(By.xpath("//div[@class='column-manager dropdown']"));
        Thread.sleep(3000);


        Assert.assertFalse(gridSettings.isDisplayed(),"Shouldnt be displayed");

        gridSettings.click();









    }
}
