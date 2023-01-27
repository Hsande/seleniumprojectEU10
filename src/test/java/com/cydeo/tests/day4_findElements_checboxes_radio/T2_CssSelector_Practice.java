package com.cydeo.tests.day4_findElements_checboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T2_CssSelector_Practice {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to https://practice.cydeo.com/forgot_password
        driver.get("https://practice.cydeo.com/forgot_password");

        //3. Locate all the WebElements on the page using XPATH and/or CSS
        //locator only (total of 6)

        //a. “Home” link
        WebElement homeLink = driver.findElement(By.cssSelector("a[class='nav-link']"));
        System.out.println("homeLink = " + homeLink.isDisplayed());

        //b. “Forgot password” header
        WebElement forgotPassword = driver.findElement(By.cssSelector("div[class='example']>h2"));
        System.out.println("forgotPassword = " + forgotPassword.isDisplayed());

        //c. “E-mail” text
        WebElement emailText = driver.findElement(By.cssSelector("label[for='email']"));
        System.out.println("emailText = " + emailText.isDisplayed());

        //d. E-mail input box
        WebElement emailInput = driver.findElement(By.cssSelector("input[name='email']"));
        System.out.println("emailInput = " + emailInput.isDisplayed());

        //e. “Retrieve password” button
        WebElement retrievePasswordButton = driver.findElement(By.cssSelector("button[type='submit']"));
        System.out.println("retrievePasswordButton = " + retrievePasswordButton.isDisplayed());

        //f. “Powered by Cydeo text
        WebElement poweredByCydeoText = driver.findElement(By.cssSelector("div[style='text-align: center;']"));
        System.out.println("poweredByCydeoText = " + poweredByCydeoText.isDisplayed());

        //System.out.println("poweredByCydeoText = " + poweredByCydeoText.getText());
        // System.out.println(poweredByCydeoText.getText().equals("Powered by Cydeo"));

        //4. Verify all web elements are displayed.
    }
}
