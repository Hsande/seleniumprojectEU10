package com.cydeo.tests.day5_Testng_intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestNg_Selenium {
    WebDriver driver;// We put WebDriver here out of the other blocks, inside the class; bcs prevent any reach problems and errors
    @BeforeMethod
    public void setUpMethod(){
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @Test
    public void selenium_test() {

        driver.get("https://google.com");

        String expectedTitle = "Google";
        Assert.assertEquals(driver.getTitle(), expectedTitle, "title is not matching here");// message for fail time to comment


    }

}
