package com.cybertek.tests.day4_findElements_checkBoxes_radio;

import com.cybertek.tests.day3_cssSelector_xpath.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class P0_FindElements_Practice1 {

    public static void main(String[] args) {

        //TC #0: FINDELEMENTS
        // 1.Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        // 2.Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        // 3.Print out the texts of all links

        List<WebElement> listOfLinks=driver.findElements(By.xpath("//body//a"));

        for (WebElement each:listOfLinks){
            System.out.println(each.getText());
        }

        // 4.Print out how many total link

        int numberOfLinks=listOfLinks.size();

        System.out.println("Number of links: "+numberOfLinks);



    }
}
