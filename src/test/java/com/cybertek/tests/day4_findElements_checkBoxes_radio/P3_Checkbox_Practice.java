package com.cybertek.tests.day4_findElements_checkBoxes_radio;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P3_Checkbox_Practice {

    public static void main(String[] args) throws InterruptedException {

        //Practice:	Cybertek	Checkboxes
        // 1.Go	to	http://practice.cybertekschool.com/checkboxes
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/checkboxes");

        //Locating the first checkbox
        WebElement checkbox1=driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        //Locating the second checkbox
        WebElement checkbox2=driver.findElement(By.xpath("//form[@id='checkboxes']/input[2]"));

        // 2.Confirm	checkbox	#1	is	NOT	selected	by	default
        if (!checkbox1.isSelected()){
            System.out.println("Checkbox 1 is NOT selected - verification PASSED");
        }else {
            System.out.println("Checkbox 1 is selected - verification FAILED");
        }

        // 3.Confirm	checkbox	#2	is	SELECTED	by	default.
        if (checkbox2.isSelected()){
            System.out.println("Checkbox 2 is selected - verification PASSED");
        }else {
            System.out.println("Checkbox 2 is NOT selected - verification FAILED");
        }
        Thread.sleep(1000);

        // 4.Click	checkbox	#1	to	select	it.
        checkbox1.click();
        Thread.sleep(1000);

        // 5.Click	checkbox	#2	to	deselect	it.
        checkbox2.click();
        Thread.sleep(1000);

        // 6.Confirm	checkbox	#1	is	SELECTED.
        if (checkbox1.isSelected()){
            System.out.println("Checkbox 1 is selected - verification PASSED");
        }else {
            System.out.println("Checkbox 1 is NOT selected - verification FAILED");
        }

        // 7.Confirm	checkbox	#2	is	NOT SELECTED.
        if (!checkbox2.isSelected()){
            System.out.println("Checkbox 2 is NOT selected - verification PASSED");
        }else {
            System.out.println("Checkbox 2 is selected - verification FAILED");
        }

        WebElement homeLink=driver.findElement(By.xpath("//a[@class='nav-link']"));

        homeLink.click();

        Thread.sleep(1000);

        driver.navigate().back();

        Thread.sleep(1000);

        driver.navigate().refresh();

        checkbox1=driver.findElement(By.xpath("//form[@id='checkboxes']/input[1]"));

        checkbox1.click();



    }
}
