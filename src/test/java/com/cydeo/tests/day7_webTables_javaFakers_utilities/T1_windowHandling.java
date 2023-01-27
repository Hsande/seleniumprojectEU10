package com.cydeo.tests.day7_webTables_javaFakers_utilities;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T1_windowHandling {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//1. Create new test and make set ups
//2. Go to : https://www.amazon.com
        driver.get("https://www.amazon.com");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test1() {

//3. Copy paste the lines from below into your class
        ((JavascriptExecutor) driver).executeScript("window.open('http://google.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://etsy.com','_blank');");
        ((JavascriptExecutor) driver).executeScript("window.open('http://facebook.com','_blank');");

//4. Create a logic to switch to the tab where Etsy.com is open
        BrowserUtils.switchWindowAndVerify(driver,"etsy","Etsy");
/*
        Set<String> allWindowsHandless = driver.getWindowHandles();

        for (String each : allWindowsHandless) {

            driver.switchTo().window(each);
            System.out.println("Current Url = " + driver.getCurrentUrl());
            if (driver.getCurrentUrl().contains("etsy")) {
                break;
            }

            // if (!(driver.getTitle().contains("Etsy"))) {
            //     driver.switchTo().window(each);
            // }

        }


//5. Assert: Title contains “Etsy”
        String actualTitle = driver.getTitle();
        String expectedContained = "Etsy";

        Assert.assertTrue(actualTitle.contains(expectedContained));

*/
    }
}
