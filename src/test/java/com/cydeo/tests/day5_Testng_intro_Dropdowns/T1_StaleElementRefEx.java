package com.cydeo.tests.day5_Testng_intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T1_StaleElementRefEx {
    public static void main(String[] args) throws InterruptedException {


        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        //2. Go to https://practice.cydeo.com/add_remove_elements/
        driver.get("https://practice.cydeo.com/add_remove_elements/");

        //3. Click to “Add Element” button
        WebElement addElementButton = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElementButton.click();

        Thread.sleep(3000);

        //4. Verify “Delete” button is displayed after clicking.
        WebElement deleteButton = driver.findElement(By.xpath("//button[.='Delete']"));
        System.out.println("deleteButton.isDisplayed() expected result true = " + deleteButton.isDisplayed());

        //5. Click to “Delete” button.
        deleteButton.click();

        Thread.sleep(3000);

        //6. Verify “Delete” button is NOT displayed after clicking.
        try {
            System.out.println("deleteButton.isDisplayed() expected result false = " + deleteButton.isDisplayed());

        } catch (StaleElementReferenceException e) {
            e.printStackTrace();
            System.out.println("--> StaleElementReferenceException is thrown");
            System.out.println("-->This means the element completely deleted from the page");
            System.out.println("deleteButton.isDisplayed() expected result false = false");
        }

        driver.quit();
    }
}