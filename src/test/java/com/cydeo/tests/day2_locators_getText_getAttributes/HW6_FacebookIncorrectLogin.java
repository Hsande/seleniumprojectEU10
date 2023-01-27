package com.cydeo.tests.day2_locators_getText_getAttributes;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW6_FacebookIncorrectLogin {
    public static void main(String[] args) throws InterruptedException {


        //Facebook incorrect login title verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to https://www.facebook.com
        driver.get("https://www.facebook.com");
        //3. Enter incorrect username
        WebElement usernameBox = driver.findElement(By.id("email"));
        usernameBox.sendKeys("incorrect");
        //4. Enter incorrect password

        WebElement passwordBox = driver.findElement(By.id("pass"));
        passwordBox.sendKeys("incorrect@gmail.com");

        WebElement loginButton = driver.findElement(By.name("login"));
        loginButton.click();
        //5. Verify title changed to:
        String actualTitle = driver.getTitle();
        //Expected: “Log into Facebook”
        String expectedTitle = "Log into Facebook";
        if (expectedTitle.equals(actualTitle)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }

        driver.quit();
    }
}