package com.cybertek.tests.day8_alerts_iframes_windows;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC7_TC8_CybertekMonthDropdown {

    WebDriver driver;

    //TC#7: Cybertek “month” dropdown default value

    @BeforeMethod
    public void setUpMethod(){
        //1. Open browser
        //2. Go to website: http://practice.cybertekschool.com/dropdown
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://practice.cybertekschool.com/dropdown");
    }


    @Test
    public void verifyMonthDropdown(){
        //3. Verify default value is always showing the current month
        //o Expected: If currently in June, should show June selected.

        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));

        String actualMonth=monthDropdown.getFirstSelectedOption().getText().toLowerCase();

        LocalDate today=LocalDate.now();
        String expectedMonth=today.getMonth().name().toLowerCase();

        Assert.assertEquals(actualMonth,expectedMonth,"Month are not matching, VERIFICATION FAILED!");
    }




    //TC#8: Cybertek “month” dropdown list of default values verification

    @Test
    public void verifyMonthDropdown2() {
        /*
        //This line gets all of the options from the dropdown and store the value in a list
        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        List<WebElement> actualMonthOptions = monthDropdown.getOptions();

        //Creating a list of strings to store months
        List<String> expectedMonthOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                "August","September","October", "November", "December");

        //Create a new list of Strings called: actualMonthsTexts , and store the texts of web elements into this new list
        List<String> actualMonthsTexts = new ArrayList<>();

        for (WebElement each : actualMonthOptions) {
            actualMonthsTexts.add(each.getText());
        }

        //Passing List into assertions:
        //First it will check the size, then it will check the content
        Assert.assertEquals(actualMonthsTexts, expectedMonthOptions);

         */

        /*
        List<WebElement>monthList=driver.findElements(By.xpath("//select[@id='month']"));

        String actualMonths="\n";
        for (WebElement eachMonth:monthList){
            actualMonths+=eachMonth.getText().toLowerCase();
        }
        String expectedMonths="";
        for (int i=1; i<=12; i++){
            LocalDate months=LocalDate.of(2020,i,1);
            expectedMonths+="\n"+months.getMonth().toString().toLowerCase();
        }

        Assert.assertEquals(actualMonths,expectedMonths,"Month are not matching, VERIFICATION FAILED!");
    }

 */

        Select monthDropdown=new Select(driver.findElement(By.xpath("//select[@id='month']")));
        List<WebElement> actualMonthOptions = monthDropdown.getOptions();

        List<String> expectedMonthOptions = Arrays.asList("January", "February", "March", "April", "May", "June", "July",
                "August","September","October", "November", "December");

        Assert.assertEquals(BrowserUtils.getElementsText(actualMonthOptions),expectedMonthOptions);




    }

    @AfterMethod
    public void tearDownMethod(){

        try {
            Thread.sleep(3000);
        }catch (InterruptedException e){
            System.out.println("InterruptedException Handled by \"try-catch method\"");
        }
        driver.close();
    }

}
