package com.cydeo.tests.day2_locators_getText_getAttributes;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HW2_ZeroBankHeader {
    public static void main(String[] args) {
        //Zero Bank header verification
        //1. Open Chrome browser
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        //2. Go to http://zero.webappsecurity.com/login.html
        driver.get("http://zero.webappsecurity.com/login.html");
        //3. Verify header text
        WebElement forHeaderText = driver.findElement(By.tagName("h3"));
        String actualHeader = forHeaderText.getText();
        //Expected: “Log in to ZeroBank”
        String expectedheader = "Log in to ZeroBank";
        if (expectedheader.equals(actualHeader)) {
            System.out.println("Header verification PASSED");
        } else {
            System.out.println("Header verification FAILED");
        }

    driver.close();
    }
}
