package com.cybertek.tests.day6_dropdown_review_javafaker.Task;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Task4 {

    //TC #5: Selecting value from non-select dropdown

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void nonSelectDropdown() throws InterruptedException {
        //3. Click to non-select dropdown
        WebElement nonSelectDropdown=driver.findElement(By.xpath(" //a[@class='btn btn-secondary dropdown-toggle']"));
        nonSelectDropdown.click();
        Thread.sleep(1000);

        //4. Select Facebook from dropdown
        driver.findElement(By.xpath("//*[@id='content']/div/div/a[4]")).click();
        Thread.sleep(1000);

        //5. Verify title is “Facebook - Log In or Sign Up”
        String actualTitle=driver.getTitle();
        String expectedTitle="Facebook - Log In or Sign Up";

        Assert.assertEquals(actualTitle,expectedTitle,"Title verification FAILED");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }




}
