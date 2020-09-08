package com.cybertek.tests.day4.task;

import com.cybertek.tests.day3_cssSelector_xpath.WebDriverFactory;
import org.openqa.selenium.*;

/*
TC #2: PracticeCybertek.com_AddRemoveElements WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/add_remove_elements/
3. Click to “Add Element” button
4. Verify “Delete” button is displayed after clicking.
5. Click to “Delete” button.
6. Verify “Delete” button is NOT displayed after clicking.
USE XPATH and/or CSS Selector LOCATOR FOR ALL WEBELEMENT LOCATORS
Better if you do with both for practice purposes.
 */
public class task2 {

    public static void main(String[] args) throws InterruptedException {

        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/add_remove_elements
        driver.get("http://practice.cybertekschool.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton=driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        //                                                          //tagName[@attribute='value']
        addElementButton.click();

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton=driver.findElement(By.cssSelector("button[class='added-manually']"));
        //String str=deleteButton.getText();
        //                                                          div[class='uh7']
        //System.out.println(str);
        if (deleteButton.isDisplayed()){
            System.out.println("Delete button displayed passed");
        }else {
            System.out.println("Delete button displayed failed");
        }

        //5. Click to “Delete” button.
        Thread.sleep(2000);
        deleteButton.click();

        //6. Verify “Delete” button is NOT displayed after clicking.


        try {
            System.out.println("Delete button is not displayed passed");
        }catch (StaleElementReferenceException exception){
            System.out.println("Delete button is not displayed failed");
        }





        /*
        try {
            System.out.println("deleteElement = " + !deleteButton.isDisplayed());
        } catch (StaleElementReferenceException e) {
            System.out.println("deleteElement = is not displayed: " +true );
        }

         */







    }
}
