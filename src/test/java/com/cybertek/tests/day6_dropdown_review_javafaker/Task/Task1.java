package com.cybertek.tests.day6_dropdown_review_javafaker.Task;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Task1 {

    WebDriver driver;
    //TC #2: Selecting state from State dropdown and verifying result

    @BeforeMethod
    public void setUpMethod(){
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @Test
    public void selectingStateDropdown() throws InterruptedException {
        Select stateDropdown=new Select(driver.findElement(By.xpath("//select[@id='state']")));
        //3. Select Illinois
        stateDropdown.selectByVisibleText("Illinois");
        Thread.sleep(1000);

        //4. Select Virginia
        stateDropdown.selectByValue("VA");
        Thread.sleep(1000);

        //5. Select California
        stateDropdown.selectByIndex(5);
        Thread.sleep(1000);

        //6. Verify final selected option is California.
        String actualStateText=stateDropdown.getFirstSelectedOption().getText();
        String expectedState="California";
        Thread.sleep(1000);

        Assert.assertEquals(actualStateText,expectedState,"State verification FAILED!");
        Thread.sleep(1000);
        //Use all Select options. (visible text, value, index)
    }


    @AfterMethod
    public void tearDownMethod(){
        driver.close();
    }




}
