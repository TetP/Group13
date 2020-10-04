package com.cybertek.tests.day10_testbase_properties_driverUtil;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.SmartBearUtilities;
import com.cybertek.tests.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

public class SmartBearPractices_9_10_11 extends TestBase {

    /*
    TC #9: SmartBear delete order
    1. Open browser and login to SmartBear
    2. Delete “Mark Smith” from the list
    3. Assert it is deleted from the list
    */

    @Test
    public void p9_delete_order_task() throws IOException {
        Properties properties = new Properties();

        FileInputStream file = new FileInputStream("configuration.properties");

        properties.load(file);

        String url=properties.getProperty("smartBearUrl");

        driver.get(url);

        SmartBearUtilities.loginToSmartBear(driver);
        //Locate the checkbox for 'Mark Smith' and click to it
        BrowserUtils.wait(2);
        WebElement markSmithCheckbox=driver.findElement(By.xpath("//td[.='Mark Smith']/../td[1]"));
        markSmithCheckbox.click();
        BrowserUtils.wait(1);

        WebElement deleteButton=driver.findElement(By.xpath("//input[@type='submit']"));
        deleteButton.click();
        BrowserUtils.wait(1);

        List<WebElement> names=driver.findElements(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr/td[2]"));

        for (WebElement each:names){
            Assert.assertFalse(each.getText().equals("Mark Smith"));
        }

    }



}
