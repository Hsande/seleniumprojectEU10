package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW4_PracticeCydeo {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/inputs
        driver.get("https://practice.cydeo.com/inputs");
        //3- Click to “Home” link
        WebElement homeLink = driver.findElement(By.linkText("Home"));
        homeLink = driver.findElement(By.className("nav-link"));
        homeLink.click();
        //4- Verify title is as expected:
        //Expected: Practice
        String actualTitle= driver.getTitle();
        String expectedTitle="Practice";
if(expectedTitle.equals(actualTitle)){
    System.out.println("PASSED");
}else{
    System.out.println("FAILED");
}
driver.close();
        //PS: Locate “Home” link using “className” locator
    }
}
