package com.cybertek.tests.day5_testNG_intro_dropdowns;

import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Apple {

    public static void main(String[] args) throws InterruptedException {

        //TC #02: FINDELEMENTS_APPLE
        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2. Go to https://www.apple.com
        driver.get("https://www.apple.com");

        //3. Click to iPhone
        WebElement iPhone=driver.findElement(By.xpath("//a[@class='ac-gn-link ac-gn-link-iphone']"));
        iPhone.click();
        Thread.sleep(1000);

        //4. Print out the texts of all links
        List<WebElement> iphonePageLinks=driver.findElements(By.xpath("//body//a"));

        for (WebElement eachLink:iphonePageLinks){
            System.out.println(eachLink.getText());
        }


        //5. Print out how many link is missing text
        int linkWithTex=0;
        int linkWithOutTex=0;

        for (WebElement eachLink:iphonePageLinks){
            String eachLinkText=eachLink.getText();

            if (eachLinkText.isEmpty()){
                linkWithOutTex++;
            }else {
                linkWithTex++;
            }
        }

        System.out.println("Links with missing text: "+linkWithOutTex);

        //6. Print out how many link has text
        System.out.println("Links with text: "+linkWithTex);

        //7. Print out how many total link
        System.out.println("Total link is: "+(linkWithOutTex+linkWithTex));








    }
}
