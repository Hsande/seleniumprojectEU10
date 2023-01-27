package com.cydeo.tests.day3_LocatorsContinue_CssSelector_XPath;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class T1_NextBaseCrm_ErrorText {
    public static void main(String[] args) {


        //1- Open a chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Enter incorrect username: “incorrect”
       WebElement usernameBox = driver.findElement(By.name("USER_LOGIN"));
        //4- Enter incorrect password: “incorrect”
        usernameBox.sendKeys("incorrect");
        //5- Click to login button.
        WebElement logInButton = driver.findElement(By.className("login-btn"));
        logInButton.click();
        //6- Verify error message text is as expected:
        String actualErrorText= driver.findElement(By.className("errortext")).getText();
        //Expected: Incorrect login or password
    String expectedErrorText= "Incorrect login or password";
    if (actualErrorText.equals(expectedErrorText)){
        System.out.println("Error text verification PASSED!");
    }else {
        System.out.println("Error text verification FAILED!");
    }
    driver.quit();
    }
}