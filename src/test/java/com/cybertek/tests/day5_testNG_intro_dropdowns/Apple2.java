package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.tests.day3_cssSelector_xpath.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Apple2 {

    public static void main(String[] args) throws InterruptedException {

        //TC #03: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2. Go to https://www.apple.com
        driver.get("https://www.apple.com");

        //3. Click to all of the headers one by one
        //a. Mac, iPad, iPhone, Watch, TV, Music, Support
        //4. Print out how many links on each page with the titles of the pages
        //5. Loop through all

        int totalLinkWithText=0;
        int totalLinkWithOutText=0;

        for (int i=2; i<=8; i++){
            WebElement products=driver.findElement(By.xpath("//ul[@class='ac-gn-list']/li["+i+"]"));
            //Thread.sleep(500);
            String productName = products.getText();

            System.out.println(productName);

            int linkWithText=0;
            int linkWithOutText=0;

            List<WebElement> elementList=driver.findElements(By.xpath("//body//a"));

            for (WebElement eachLink:elementList){
                if (eachLink.getText().isEmpty()){
                    linkWithOutText++;
                    totalLinkWithOutText++;
                }else {
                    linkWithText++;
                    totalLinkWithText++;
                }
            }
            System.out.println("Link with text: "+linkWithText);
            System.out.println("Link without text: "+linkWithOutText);

            products.click();
            System.out.println("======================");
        }

        //6. Print out how many link is missing text TOTAL
        //7. Print out how many link has text TOTAL
        System.out.println("Link with text: "+totalLinkWithText);
        System.out.println("Link without text: "+totalLinkWithOutText);

        //8. Print out how many total link TOTAL
        System.out.println("Total Link: "+(totalLinkWithOutText+totalLinkWithText));









    }
}
