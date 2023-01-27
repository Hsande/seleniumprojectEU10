package com.cydeo.tests.day10_upload_actions_JSExecuter;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T2_UploadPractice {
    @Test
    public void uploadTest() {
        //1. Go to https://practice.cydeo.com/upload
        Driver.getDriver().get(ConfigurationReader.getProperty("upload.url"));
        //2. Find some small file from your computer, and get the path of it.
        WebElement filePath=Driver.getDriver().findElement(By.xpath("//input[@id='file-upload']"));
        filePath.sendKeys("C:\\Users\\LENOVO\\Desktop\\HTML\\Doctype HTML.png");

        //3. Upload the file.
        Driver.getDriver().findElement(By.xpath("//input[@id='file-submit']")).click();

        //4. Assert:
        //-File uploaded text is displayed on the page

        WebElement actualMessage= Driver.getDriver().findElement(By.xpath("//h3[.='File Uploaded!']"));

        Assert.assertTrue(actualMessage.isDisplayed());

    }
}
