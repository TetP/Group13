package com.cybertek.tests.day6_dropdown_review_javafaker.Task;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task2 {

    WebDriver driver;

    //TC #3: Selecting date on dropdown and verifying

    @BeforeMethod
    public void setUpMethod() throws InterruptedException {
        //1. Open Chrome browser
        driver= WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
        Thread.sleep(1000);
    }


    @Test
    public void selectingDateOnDropdown() throws InterruptedException {

        //Select year using : visible text
        Select yearDropdown=new Select(driver.findElement(By.xpath("//select[@id='year']")));
        yearDropdown.selectByVisibleText("1921");
        Thread.sleep(1000);

        //Select month using : value attribute
        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        monthDropdown.selectByValue("11");
        Thread.sleep(1000);

        //Select day using : index number
        Select dayDropdown=new Select(driver.findElement(By.xpath("//select[@id='day']")));
        dayDropdown.selectByIndex(0);
        Thread.sleep(1000);

        //3. Select “December 1st, 1921” and verify it is selected.
        String actualDate=monthDropdown.getFirstSelectedOption().getText()+" "+dayDropdown.getFirstSelectedOption().getText()+"st, "+yearDropdown.getFirstSelectedOption().getText();

        String expectedDate="December 1st, 1921";

        Assert.assertEquals(actualDate,expectedDate,"Date verification FAILED");
    }

    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }

}
