package com.cydeo.tests.day4_findElements_checboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T3_XpathLocator_Practice {
    public static void main(String[] args) {
        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        //2. Go to http://practice.cydeo.com/multiple_buttons
        driver.get("http://practice.cydeo.com/multiple_buttons");

        //3. Click on Button 1
        driver.findElement(By.xpath("//button[@onclick='button1()']")).click();

        //4. Verify text displayed is as expected:
        //Expected: “Clicked on button one!”
        String actualButtonOneText = driver.findElement(By.xpath("//p[@id='result']")).getText();
        String expectedButtonOneText = "Clicked on button one!";
        if (actualButtonOneText.equals(expectedButtonOneText)) {
            System.out.println("PASSED");
        } else {
            System.out.println("FAILED");

        }
        driver.close();

    }
}
