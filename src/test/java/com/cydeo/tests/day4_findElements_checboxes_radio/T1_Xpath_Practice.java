package com.cydeo.tests.day4_findElements_checboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T1_Xpath_Practice {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)
        //a. “Home” link
        WebElement homeLink = driver.findElement(By.xpath("//a[@class='nav-link']"));
        System.out.println("homeLink = " + homeLink.isDisplayed());

        //b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.xpath("//div[@class= 'example']/h2"));
        System.out.println("forgotPassword = " + forgotPassword.isDisplayed());

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.xpath("//label[@for='email']"));
        System.out.println("emailText = " + emailText.isDisplayed());

        //d. E-mail input box
        WebElement inputBox = driver.findElement(By.xpath("//input[@pattern='[a-z0-9._%+-]+@[a-z0-9.-]+\\.[a-z]{2,3}$']"));
        System.out.println("inputBox = " + inputBox.isDisplayed());

        //e. “Retrieve password” button
        WebElement retrieveButton = driver.findElement(By.xpath("//button[@id='form_submit']"));
        System.out.println("retrieveButton = " + retrieveButton.isDisplayed());

        //f. “Powered by Cydeo text
        WebElement poweredByText = driver.findElement(By.xpath("//div[text()='Powered by ']"));
        WebElement cydeoText = driver.findElement(By.xpath("//a[.='CYDEO']"));
        System.out.println("poweredByText = " + poweredByText.isDisplayed());
        System.out.println("cydeoText = " + cydeoText.isDisplayed());

        //4. Verify all web elements are displayed.

    }
}
