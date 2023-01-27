package com.cydeo.tests.day6_iFrames_allerts_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_T2_T3_Alert_Practices {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        //1. Open browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to website: http://practice.cydeo.com/javascript_alerts
        driver.get("http://practice.cydeo.com/javascript_alerts");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {


        //3. Click to “Click for JS Alert” button
        driver.findElement(By.xpath("//button[.='Click for JS Alert']")).click();

        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();


        //5. Verify “You successfully clicked an alert” text is displayed.
        WebElement actualResult = driver.findElement(By.xpath("//p[@id='result']"));

        String exceptedText = "You successfully clicked an alert";
        String actualText = actualResult.getText();
        Assert.assertTrue(actualResult.isDisplayed(),"Result is not displayed");// if the result does not displayed; the message will be seen
        Assert.assertTrue(actualText.equals(exceptedText), "Result is not as expected");


    }

    @Test
    public void test2() {

        //3. Click to “Click for JS Confirm” button
        driver.findElement(By.xpath("//button[@onclick='jsConfirm()']")).click();
        //4. Click to OK button from the alert
        Alert alert = driver.switchTo().alert();
        alert.accept();
        //5. Verify “You clicked: Ok” text is displayed.

        String actualResultText = driver.findElement(By.xpath("//p[.='You clicked: Ok']")).getText();
        String expectedResultText = "You clicked: Ok";
        Assert.assertEquals(actualResultText, expectedResultText);
    }

    @Test
    public void test3() {

        //3. Click to “Click for JS Prompt” button
        driver.findElement(By.xpath("//button[.='Click for JS Prompt']")).click();
        //4. Send “hello” text to alert
        Alert alert = driver.switchTo().alert();
        alert.sendKeys("hello");

        //5. Click to OK button from the alert
        alert.accept();

        //6. Verify “You entered: hello” text is displayed.
        String actualResultText = driver.findElement(By.xpath("//p[.='You entered: hello']")).getText();
        String expectedResultText = "You entered: hello";
        Assert.assertEquals(actualResultText, expectedResultText);
    }


}
