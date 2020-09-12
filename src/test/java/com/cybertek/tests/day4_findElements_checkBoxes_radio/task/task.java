package com.cybertek.tests.day4_findElements_checkBoxes_radio.task;

import com.cybertek.tests.day3_cssSelector_xpath.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/*
XPATH and CSS Selector PRACTICES
DO NOT USE ANY DEVELOPER TOOLS TO GET ANY LOCATORS.
TC
TC #1: PracticeCybertek.com_ForgotPassword WebElement verification
1. Open Chrome browser
2. Go to http://practice.cybertekschool.com/forgot_password
3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
a. “Home” link
b. “Forgot password” header
c. “E-mail” text
d. E-mail input box
e. “Retrieve password” button
f. “Powered by Cybertek School” text
4. Verify all WebElements are displayed.
Better if you do with both XPATH and CSS selector for practice purposes.
 */
public class task {

    public static void main(String[] args) {

        //1. Open Chrome browser
        WebDriver driver= WebDriverFactory.getDriver("chrome");

        //2. Go to http://practice.cybertekschool.com/forgot_password
        driver.get("http://practice.cybertekschool.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS locator only (total of 6)
        //a. “Home” link

        //Css Selector solution
        WebElement homeButton=driver.findElement(By.cssSelector("a[class='nav-link'] "));
        if (homeButton.isDisplayed()){
            System.out.println("Home button Passed");
        }else {
            System.out.println("Home button Failed");
        }

        //Xpath Selector solution
        WebElement homeButton2=driver.findElement(By.xpath("//a[.='Home']"));
        if (homeButton2.isDisplayed()){
            System.out.println("Home button Passed");
        }else {
            System.out.println("Home button Failed");
        }

        //b. “Forgot password” header

        //Css Selector solution
        WebElement forgetPassword=driver.findElement(By.cssSelector("h2"));
        if (forgetPassword.isDisplayed()){
            System.out.println("Forget password passed");
        }else {
            System.out.println("Forget password failed");
        }

        //Xpath Selector solution
        WebElement forgetPassword2=driver.findElement(By.xpath("//h2[.='Forgot Password']"));
        if (forgetPassword2.isDisplayed()){
            System.out.println("Forget password passed");
        }else {
            System.out.println("Forget password failed");
        }

        //c. “E-mail” text

        //Css Selector solution
        WebElement email=driver.findElement(By.cssSelector("label[for='email']"));
        if (email.isDisplayed()){
            System.out.println("Email passed");
        }else {
            System.out.println("Email failed");
        }

        //Xpath Selector solution
        WebElement email2=driver.findElement(By.xpath("//label[@for='email']"));
        if (email2.isDisplayed()){
            System.out.println("Email passed");
        }else {
            System.out.println("Email failed");
        }

        //d. E-mail input box

        //Css Selector solution
        WebElement emailInputBox=driver.findElement(By.cssSelector("input[type='text']"));
        if (emailInputBox.isDisplayed()){
            System.out.println("Email input box passed");
        }else {
            System.out.println("Email input box failed");
        }


        //Xpath Selector solution
        WebElement emailInputBox2=driver.findElement(By.xpath("//input[@type='text']"));
        if (emailInputBox2.isDisplayed()){
            System.out.println("Email input box passed");
        }else {
            System.out.println("Email input box failed");
        }


        //e. “Retrieve password” button

        //Css Selector solution
        WebElement retrievePassword=driver.findElement(By.cssSelector("i[class='icon-2x icon-signin']"));
        if (retrievePassword.isDisplayed()){
            System.out.println("Retrieve password passed");
        }else {
            System.out.println("Retrieve password failed");
        }

        //Xpath Selector solution
        WebElement retrievePassword2=driver.findElement(By.xpath("//i[.='Retrieve password']"));
        if (retrievePassword2.isDisplayed()){
            System.out.println("Retrieve password passed");
        }else {
            System.out.println("Retrieve password failed");
        }


        //f. “Powered by Cybertek School” text

        //Css Selector solution
        WebElement cybertekText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        if (cybertekText.isDisplayed()){
            System.out.println("Powered by Cybertek School text passed");
        }else {
            System.out.println("Powered by Cybertek School text failed");
        }

        //Xpath Selector solution
        WebElement cybertekText2=driver.findElement(By.xpath("//div[@style='text-align: center;']"));
        if (cybertekText2.isDisplayed()){
            System.out.println("Powered by Cybertek School text passed");
        }else {
            System.out.println("Powered by Cybertek School text failed");
        }


        //4. Verify all WebElements are displayed.

        //Css Selector solution
        WebElement allElements = driver.findElement(By.cssSelector("html[class='no-js']"));
        if (allElements.isDisplayed()){
            System.out.println("All WebElements passed");
        }else {
            System.out.println("All WebElements failed");
        }

        //Xpath Selector solution/
        WebElement allElements2=driver.findElement(By.xpath("//html[@class='no-js']"));
        if (allElements2.isDisplayed()){
            System.out.println("All WebElements passed");
        }else {
            System.out.println("All WebElements failed");
        }



        System.out.println(allElements.getText());







    }


}
