package com.cydeo.tests.day4_findElements_checboxes_radio;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

public class T6_StaleElementReferenceException {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        //2- Go to: https://practice.cydeo.com/abtest
        driver.get("https://practice.cydeo.com/abtest");

        //3- Locate “CYDEO” link, verify it is displayed
        WebElement cydeolink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));
        System.out.println("cydeolink.isDisplayed() = " + cydeolink.isDisplayed());


        //4- Refresh the page.
        driver.navigate().refresh();

        //* We are refreshing the web element reference by re-assigning/re-locating the web element
        cydeolink = driver.findElement(By.xpath("//a[@href='https://cydeo.com/']"));
       //if we do not this, we have a "StaleElementReferenceException"; bcs of the connection lost of between driver and the web element


        //5- Verify it is displayed, again.
        System.out.println("cydeolink.isDisplayed() = " + cydeolink.isDisplayed());

        driver.quit();
    }
}
