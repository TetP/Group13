package com.Projects.Bitrix;

import com.Projects.Utilities.BrowserUtils;
import com.Projects.Utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class US2_TasksByClickingOnTaskTab {
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

        WebElement tasks = driver.findElement(By.xpath("//span[@id='feed-add-post-form-tab-tasks']"));
        tasks.click();
        BrowserUtils.wait(1);
    }


    @Test
    public void HighPriorityCheckbox(){
        WebElement highPriorityBox=driver.findElement(By.id("tasks-task-priority-cb"));
        highPriorityBox.click();


        Assert.assertTrue(highPriorityBox.isSelected(),"VERIFICATION FAILED");
    }


    @Test
    public void visualEditorDisplayed(){
        WebElement visualEditor=driver.findElement(By.xpath("//div[@id='bx-html-editor-tlbr-lifefeed_task_form']"));
        boolean visualEditorBeforeClick=visualEditor.isDisplayed(); //true

        BrowserUtils.wait(1);

        WebElement visualEditorButton=driver.findElement(By.xpath("//span[@id='lhe_button_editor_task-form-lifefeed_task_form']"));
        visualEditorButton.click();
        boolean visualEditorAfterClick=visualEditor.isDisplayed();  //false



        boolean result=false;
        if (visualEditorBeforeClick==true && visualEditorAfterClick==false){
            result=true;
        }

        Assert.assertTrue(result,"VERIFICATION FAILED");

    }






}
