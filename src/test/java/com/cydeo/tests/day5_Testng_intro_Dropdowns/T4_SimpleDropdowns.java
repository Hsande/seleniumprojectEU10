package com.cydeo.tests.day5_Testng_intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_SimpleDropdowns {
    WebDriver driver;

    @BeforeClass
    public void setUpClass(){
     driver = WebDriverFactory.getDriver("chrome");
    }


    @BeforeMethod
    public void setUpMethod() {
        //1. Open Chrome browser

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/dropdown
        driver.get("https://practice.cydeo.com/dropdown");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void simpleDropdownTest() {

        //3. Verify “Simple dropdown” default selected value is correct
        //Expected: “Please select an option”

        Select simpleDropdown = new Select(driver.findElement(By.xpath("//select[@id='dropdown']")));// we are creating an object from Select class(from selenium) in order to use all methods of this class for the found WebElement

        WebElement currentlySelectedOption = simpleDropdown.getFirstSelectedOption();
        String actualSelectedOptionText = currentlySelectedOption.getText();
        String expectedSelectedOptionText = "Please select an option";

        Assert.assertEquals(actualSelectedOptionText, expectedSelectedOptionText);

        //4. Verify “State selection” default selected value is correct
        //Expected: “Select a State”

        Select stateDropdown = new Select(driver.findElement(By.xpath("//select[@id='state']")));

        WebElement currentlyStateselection = stateDropdown.getFirstSelectedOption();
        String actualStateSelection = currentlyStateselection.getText();
        String expectedStateSelection = "Select a State";

        Assert.assertEquals(actualStateSelection, expectedStateSelection);
    }
}
