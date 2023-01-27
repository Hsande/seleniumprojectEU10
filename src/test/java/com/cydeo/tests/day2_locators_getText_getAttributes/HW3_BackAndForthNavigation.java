package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW3_BackAndForthNavigation {
    public static void main(String[] args) {
        //Back and forth navigation
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://google.com
       driver.get("https://google.com");
        //3- Click to Gmail from top right.
        WebElement gMail= driver.findElement(By.className("gb_j"));
       gMail.click();
        //4- Verify title contains:
       String actualTitle= driver.getTitle();
        //Expected: Gmail
        String expectedTitle= "Gmail";
        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED");
        }else{
            System.out.println("Title test FAILED");
        }
        //5- Go back to Google by using the .back();
        driver.navigate().back();
        //6- Verify title equals:
        actualTitle = driver.getTitle();
        //Expected: Google
    expectedTitle= "Google";

        if(actualTitle.contains(expectedTitle)){
            System.out.println("Title test PASSED2");
        }else{
            System.out.println("Title test FAILED2");
        }
    driver.close();
    }
}
