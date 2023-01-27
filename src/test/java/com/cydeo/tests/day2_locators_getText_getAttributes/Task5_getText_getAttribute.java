package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Task5_getText_getAttribute {
    public static void main(String[] args) {
        //getText() and getAttribute() method practice
        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://practice.cydeo.com/registration_form
        driver.get("https://practice.cydeo.com/registration_form");
        //3- Verify header text is as expected:
        String actualHeader = driver.findElement(By.tagName("h2")).getText();
        //Expected: Registration form
        String expectedHeader = "Registration form";
        if (actualHeader.equals(expectedHeader)) {
            System.out.println("Header verification is Passed");
        } else {
            System.out.println("Header verification is Failed");
        }
        //4- Locate “First name” input box
        WebElement firstNameInput = driver.findElement(By.name("firstname"));
        //5- Verify placeholder attribute’s value is as expected:

        //Expected: first name
        String actualPlaceholderAttribute = firstNameInput.getAttribute("placeholder");
        String expectedPlaceholderAttribute = "first name";
        if (actualPlaceholderAttribute.equals(expectedPlaceholderAttribute)) {
            System.out.println("Placeholder text verification is Passed");
        } else {
            System.out.println("Placeholder text verification is Failed");
        }

    }
}
