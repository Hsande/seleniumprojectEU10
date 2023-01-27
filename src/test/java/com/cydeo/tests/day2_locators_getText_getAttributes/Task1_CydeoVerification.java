package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task1_CydeoVerification {
    public static void main(String[] args) throws InterruptedException {
        //TC #1: Cydeo practice tool verifications
        //1. Open Chrome browser

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com
        driver.get("https://practice.cydeo.com");
Thread.sleep(3000);
        //3. Verify URL contains

        String expectedURL = "cydeo";
        String actualURL = driver.getCurrentUrl();

        //Expected: cydeo


        if (actualURL.contains(expectedURL)) {
            System.out.println("Verification URL contains cydeo completed. Test is PASSED");
        } else {
            System.out.println("Verification URL contains cydeo completed. Test is FAILED");
        }


        //4. Verify title:
        String actualTitle = driver.getTitle();
        String expectedTitle = "Practice";
        //Expected: Practice

        if (actualTitle.equals(expectedTitle)) {
            System.out.println("Verification completed. Test is PASSED");
        } else {
            System.out.println("Verification completed. Test is FAILED");
        }

driver.close();
    }
}
