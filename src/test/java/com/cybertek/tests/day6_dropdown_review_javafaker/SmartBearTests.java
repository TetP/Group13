package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.Utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SmartBearTests {

    //TC #1: Smartbear software link verification

    WebDriver driver;


    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        driver= WebDriverFactory.getDriver("chrome");

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2. Go to website:
        //http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx
        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");

        SmartBearUtilities.loginToSmartBear(driver);        //1
    }

    @Test
    public void smartbearSoftwareLinkVerification(){
        /*      bu asamayi SmartBearUtilities e koyduk ve before methodda oradan cagiriyoruz()
        //3. Enter username: “Tester”
        driver.findElement(By.xpath("//input[@name='ctl00$MainContent$username']")).sendKeys("Tester");

        //4. Enter password: “test”
        driver.findElement(By.id("ctl00_MainContent_password")).sendKeys("test");

        //5. Click to Login button
        driver.findElement(By.id("ctl00_MainContent_login_button")).click();

         */

        //6. Print out count of all the links on landing page
        List<WebElement> allLinks = driver.findElements(By.xpath("//body//a"));

        System.out.println("Count of all links: "+allLinks.size());

        //7. Print out each link text on this page
        for (WebElement eachLink:allLinks){
            System.out.println("Each link: "+eachLink.getText());
        }
    }





    //TC#2: Smartbear software order placing

    @Test
    public void smartBearSoftwareOrderPlacing() throws InterruptedException {
        //6. Click on Order

        WebElement orderButton=driver.findElement(By.xpath("//a[.='Order']"));
        orderButton.click();

        //7. Select familyAlbum from product, set quantity to 2
        Select dropdownProduct=new Select(driver.findElement(By.xpath("//select[@name='ctl00$MainContent$fmwOrder$ddlProduct']")));
        dropdownProduct.selectByVisibleText("FamilyAlbum");

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtQuantity")).sendKeys(Keys.BACK_SPACE,"2");

        //8. Click to “Calculate” button
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        //9. Fill address Info with JavaFaker
        //• Generate: name, street, city, state, zip code
        Faker faker=new Faker();

        String name=faker.name().fullName();
        String street=faker.address().streetAddress();
        String city=faker.address().city();
        String state=faker.address().state();
        String zip=faker.address().zipCode();

        zip=zip.substring(0,5);

        //name
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_txtName")).sendKeys(name);

        //street
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox2")).sendKeys(street);

        //city
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox3")).sendKeys(city);

        //state
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox4")).sendKeys(state);

        //zip
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox5")).sendKeys(zip);

        //10. Click on “visa” radio button
        driver.findElement(By.name("ctl00$MainContent$fmwOrder$cardList")).click();

        //11. Generate card number using JavaFaker
        String cardNumber=faker.finance().creditCard();
        cardNumber=cardNumber.replaceAll("-","");

        //card
        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox6")).sendKeys(cardNumber);

        driver.findElement(By.id("ctl00_MainContent_fmwOrder_TextBox1")).sendKeys("02/25");

        //12. Click on “Process”
        driver.findElement(By.xpath("//a[@id='ctl00_MainContent_fmwOrder_InsertButton']")).click();

        //13. Verify success message “New order has been successfully added.”

        Thread.sleep(1000);

        String message=driver.findElement(By.xpath("//strong")).getText();

        Assert.assertEquals(message,"New order has been successfully added.");
    }






















}
