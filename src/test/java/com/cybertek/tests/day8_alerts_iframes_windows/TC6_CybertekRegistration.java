package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC6_CybertekRegistration {

    //TC#6: Cybertek registration form confirmation
    //Note: Use JavaFaker when possible.

    WebDriver driver;

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/registration_form
        driver=WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/registration_form");
    }


    @Test
    public void cybertekRegistrationForm() throws InterruptedException {
        Faker faker=new Faker();

        String firstName=faker.name().firstName();
        String lastName=faker.name().lastName();
        String userName=firstName+lastName;

        String email=faker.internet().emailAddress();
        String password=faker.internet().password();
        String phoneNumber=faker.number().digits(10);

        phoneNumber=phoneNumber.substring(0,3)+"-"+phoneNumber.substring(3,6)+"-"+phoneNumber.substring(6);

        //3. Enter first name
        driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(firstName);

        //4. Enter last name
        driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(lastName);

        //5. Enter username
        driver.findElement(By.xpath("//input[@name='username']")).sendKeys(userName);

        //6. Enter email address
        driver.findElement(By.xpath("//input[@name='email']")).sendKeys(email);

        //7. Enter password
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys(password);

        //8. Enter phone number
        driver.findElement(By.xpath("//input[@name='phone']")).sendKeys(phoneNumber);

        //9. Select a gender from radio buttons
        driver.findElement(By.xpath("//input[@value='female']")).click();

        //10. Enter date of birth
        driver.findElement(By.xpath("//input[@name='birthday']")).sendKeys("1/1/1990");

        //11. Select Department/Office
        Select department=new Select(driver.findElement(By.xpath("//select[@name='department']")));
        department.selectByVisibleText("Department of Engineering");

        //12. Select Job Title
        Select jobTitle=new Select(driver.findElement(By.xpath("//select[@name='job_title']")));
        jobTitle.selectByVisibleText("SDET");

        //13. Select programming language from checkboxes
        driver.findElement(By.id("inlineCheckbox2")).click();

        //14. Click to sign up button
        driver.findElement(By.id("wooden_spoon")).click();
        Thread.sleep(1000);

        //15. Verify success message “You’ve successfully completed registration.” is
        //displayed.
        String expectedMessage="You've successfully completed registration!";
        String actualMessage=driver.findElement(By.tagName("p")).getText();

        Assert.assertEquals(actualMessage,expectedMessage,"Cybertek Registration Failed");
    }

    @AfterMethod
    public void tearDownMethod() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }





}
