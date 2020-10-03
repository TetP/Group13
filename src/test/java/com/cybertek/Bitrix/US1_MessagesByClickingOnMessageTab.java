package com.cybertek.Bitrix;

import com.cybertek.Utilities.BrowserUtils;
import com.cybertek.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class US1_MessagesByClickingOnMessageTab {
    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://login2.nextbasecrm.com/");
        WebElement username = driver.findElement(By.xpath("//input[@type='text']"));
        username.sendKeys("helpdesk13@cybertekschool.com");

        WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
        password.sendKeys("UserUser");

        WebElement login = driver.findElement(By.xpath("//input[@type='submit']"));
        login.click();
        BrowserUtils.wait(1);

        WebElement sendMessage = driver.findElement(By.xpath("//span[.='Send message …']"));
        sendMessage.click();
        BrowserUtils.wait(1);
    }

    @Test
    public void click_on_upload_files_icon() {

        WebElement uploadFilesButton=driver.findElement(By.xpath("//span[@id='bx-b-uploadfile-blogPostForm']"));
        uploadFilesButton.click();
        BrowserUtils.wait(1);

        List<WebElement> actualUploadingFileOptions = driver.findElements(By.xpath("//table[@class='diskuf-selector-table wd-fa-add-file-light-table']"));

        String actualOption="";

        for (WebElement eachOption:actualUploadingFileOptions){
            actualOption+=eachOption.getText();
        }


        String expectedOptions="Upload files and images\n" +
                "Drag files here to upload\n" +
                "Select document from Bitrix24\n" +
                "Available libraries\n" +
                "Download from external drive\n" +
                "Office 365\n" +
                "Google Drive\n" +
                "Dropbox\n" +
                "Create using Google Docs\n" +
                "Document\n" +
                "Spreadsheet\n" +
                "Presentation";



        Assert.assertTrue(actualOption.equals(expectedOptions),"Failed");



        //upload files and pictures from local disks
        // download from an external drive
        // select documents from bixtrix24
        // create files to upload. 


        //Upload files and images
        //Download from external drive
        //Select document from Bitrix24
        //Create using Google Docs

    }


    @Test
    public void USAC2_AddUsersFromSelectingContact(){
        WebElement addMoreButton = driver.findElement(By.xpath("//span[.='All employees']"));
        addMoreButton.click();
        BrowserUtils.wait(1);

        List<WebElement> addingOptions=driver.findElements(By.xpath("//a[@href='#switchTab']"));

        String actualOptions="";

        for (WebElement each:addingOptions){
            actualOptions+=each.getText()+"\n";
        }


        String expectedOptions="Recent\n" +
                "Employees and departments\n" +
                "E-mail users"+"\n";

        Assert.assertEquals(actualOptions,expectedOptions,"Options doesn't match, VERIFICATION FAILED");

    }


}