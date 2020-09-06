package com.cybertek.tests.day3_cssSelector_xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P4_PracticeCybertek_XPath {

    public static void main(String[] args) {

        WebDriver driver=WebDriverFactory.getDriver("Chrome");
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement button2=driver.findElement(By.xpath("//button[@name='button2']"));
        button2.click();

        WebElement button1=driver.findElement(By.xpath("//button[@class='btn btn-primary']"));
        button1.click();



    }
}
