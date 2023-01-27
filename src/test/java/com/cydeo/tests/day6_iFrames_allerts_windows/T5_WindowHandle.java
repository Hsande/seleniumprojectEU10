package com.cydeo.tests.day6_iFrames_allerts_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T5_WindowHandle {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3. Go to: https://practice.cydeo.com/iframe

        driver.get("https://practice.cydeo.com/windows");

    }

    @AfterMethod
    public void tearDown() {
      //  driver.close(); //close currently open window
        driver.quit(); // close all the session; all tabs
    }

    @Test
    public void test() {
        //Storing main page's window handle for future re-usability; changing everytime
        String mainHandle = driver.getWindowHandle();// window's ID number

        //4. Assert: Title is “Windows”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Windows";
        System.out.println("actualTitle before click = " + actualTitle);// Windows

        Assert.assertTrue(actualTitle.equals(expectedTitle));
        //5. Click to: “Click Here” link
driver.findElement(By.xpath("//a[.='Click Here']")).click();
        actualTitle = driver.getTitle();
        System.out.println("actualTitle after click = " + actualTitle);// Windows: Selenium keeps looking into the same tab; so we need to change its focus to the new tab

        //6. Switch to new Window.
        for (String each : driver.getWindowHandles()) {
            driver.switchTo().window(each);
            System.out.println("Title while switching = " + driver.getTitle());

        }

        //7. Assert: Title is “New Window”
        String expecLasttedTitle="New Window";
        actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle,expecLasttedTitle);

        System.out.println("actualTitle after switch = " + actualTitle);
    }

}

