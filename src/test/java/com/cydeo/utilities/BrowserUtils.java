package com.cydeo.utilities;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import java.util.Set;

/*
In this class only general utility methods; not for special purposes related to some pages
 */
public class BrowserUtils {

    /*
    This method accepts int(in seconds), execute Thread.sleep for given duration
     */
    public static void sleep(int seconds) {
        seconds *= 1000;
        try {
            Thread.sleep(seconds);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /*This method accepts 3 arguments;
    Arg1: WebDriver
    Arg2: to verify if the url contains given string
         - if condition matches, break loop
    Arg3: expected title to be compared to actual title    */
    public static void switchWindowAndVerify(WebDriver driver, String expectedInUrl, String expectedTitle){




        Set<String> allWindowHandles = driver.getWindowHandles();

        for (String each : allWindowHandles) {
             driver.switchTo().window(each).getCurrentUrl();
            if (driver.getCurrentUrl().contains(expectedInUrl)) {
                break;
            }
        }
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitle));
    }

    //This method accepts String as expected title; and Asserts if it is true

    public static void verifyTitle(WebDriver driver, String expectedTitle){
        Assert.assertEquals(driver.getTitle(),expectedTitle);
    }



}
