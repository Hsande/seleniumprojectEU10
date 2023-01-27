package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task2_LinkText_Practice {
    public static void main(String[] args) {
        //TC #2: Back and forth navigation
        WebDriverManager.chromedriver().setup();


        //1- Open a chrome browser
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //2- Go to: https://practice.cydeo.com
        driver.navigate().to("https://practice.cydeo.com");

        //3- Click to A/B Testing from top of the list.
        WebElement abTestLink = driver.findElement(By.linkText("A/B Testing"));
        abTestLink.click();
        //4- Verify title is:
        String actualTitle= driver.getTitle();
        //Expected: No A/B Test
        String expectedTitle="No A/B Test";
        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
        //5- Go back to home page by using the .back();
driver.navigate().back();
        //6- Verify title equals:
        actualTitle= driver.getTitle();
        //Expected: Practice
        expectedTitle="Practice";
        if (expectedTitle.equals(actualTitle)){
            System.out.println("PASSED");
        }else {
            System.out.println("FAILED");
        }
driver.close();

    }
}
