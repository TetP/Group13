package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.tests.day3_cssSelector_xpath.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class P05_SeleniumEasy_Task2 {

    public static void main(String[] args) throws InterruptedException {

        //TC #3: SeleniumEasy Checkbox Verification – Section 2

        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");

        //2. Go to https://www.seleniumeasy.com/test/basic-checkbox-demo.html
        driver.get("https://www.seleniumeasy.com/test/basic-checkbox-demo.html");
        Thread.sleep(1000);

        //3. Verify “Check All” button's text is “Check All”
        WebElement checkAllButton=driver.findElement(By.xpath("//input[@type='button']"));
        String actualText=checkAllButton.getAttribute("value");
        String expectedText="Check All";

        if (actualText.equals(expectedText)){
            System.out.println("Check All verification PASSED");
        }else {
            System.out.println("Check All verification FAILED");
        }

        //4. Click to “Check All” button
        checkAllButton.click();
        Thread.sleep(1000);

        //5. Verify all check boxes are checked
        for (int i=1; i<=4; i++){
            WebElement optionButton=driver.findElement(By.xpath("//*[@id='easycont']/div/div[2]/div[2]/div[2]/div["+i+"]/label/input"));
            System.out.println("Option "+i+" is selected: "+optionButton.isSelected());
        }

        //6. Verify button text changed to “Uncheck All”
        String actualUncheckAllText=checkAllButton.getAttribute("value");
        String expectedUncheckAllText="Uncheck All";

        if (actualUncheckAllText.equals(expectedUncheckAllText)){
            System.out.println("Uncheck All verification PASSED");
        }else {
            System.out.println("Uncheck All verification FAILED");
        }



    }
}
