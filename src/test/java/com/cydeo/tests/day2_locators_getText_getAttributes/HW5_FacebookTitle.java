package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW5_FacebookTitle {
    public static void main(String[] args) throws InterruptedException {
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        //3. Verify title:
        //Expected: “Facebook - Log In or Sign Up”
    String actualTitle= driver.getTitle();
    String expectedTitle="Facebook - Log In or Sign Up";
    if (actualTitle.equals(expectedTitle)){
        System.out.println("passed");
    }else {
        System.out.println("failed");
    }

    driver.close();
    }

    }

