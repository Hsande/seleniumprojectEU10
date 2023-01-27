package com.cydeo.tests.day5_Testng_intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T5_T6_T7_T8_Select_Dropdown_Verify {

    public WebDriver driver;

    @BeforeTest
    public void setUpTest() {
        //1. Open Chrome browser
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to http://practice.cybertekschool.com/dropdown
        driver.get("http://practice.cybertekschool.com/dropdown");
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test5() {
        Select stateDropdown = new Select(driver.findElement(By.id("state")));

        //3. Select Illinois
        stateDropdown.selectByVisibleText("Illinois");

        //4. Select Virginia
        stateDropdown.selectByValue("VA");

        //5. Select California
        stateDropdown.selectByIndex(5);

        //6. Verify final selected option is California.
        String expectedOption = "California";
        String actualOption = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals(actualOption, expectedOption);

        //Use all Select options. (visible text, value, index)

    }

    @Test
    public void test6() { //NoSuchElementException
        //Select “December 1st, 1923” and verify it is selected.
        Select yearDropdown = new Select(driver.findElement(By.id("year")));
        Select monthDropdown = new Select(driver.findElement(By.id("month")));
        Select dayDropdown = new Select(driver.findElement(By.id("day")));


        //Select year using : visible text

        yearDropdown.selectByVisibleText("1924");// There is no option for 1923

        //Select month using : value attribute
        monthDropdown.selectByValue("11");
        //Select day using : index number
        dayDropdown.selectByIndex(0);

        String expectedYear = "1924";
        String expectedDay = "1";
        String expectedMonth = "December";
        String actualYear = yearDropdown.getFirstSelectedOption().getText();
        String actualDay = dayDropdown.getFirstSelectedOption().getText();
        String actualMonth = monthDropdown.getFirstSelectedOption().getText();

        Assert.assertEquals(actualYear, expectedYear);

        Assert.assertEquals(actualMonth, expectedMonth);
        Assert.assertEquals(actualDay, expectedDay);

    }

    @Test
    public void test7() {
        //3. Click to non-select dropdown
        WebElement dropdownLink = driver.findElement(By.xpath("//a[@href='#']"));
        dropdownLink.click();
        //4. Select Facebook from dropdown
        driver.findElement(By.xpath("//a[.='Facebook']")).click();
        //5. Verify title is “Facebook - Log In or Sign Up”

        String expectedTitle = "Facebook - Giriş Yap veya Kaydol";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(expectedTitle, actualTitle);
    }

    @Test
    public void test8() {
        //3. Select all the options from multiple select dropdown.

        driver.get("http://practice.cybertekschool.com/dropdown");
        Select proggramminglanguagesDropdown = new Select(driver.findElement(By.xpath("//select[@name='Languages']")));
        List<WebElement> allOptions = proggramminglanguagesDropdown.getOptions();

        System.out.println("proggramminglanguagesDropdown.isMultiple() = " + proggramminglanguagesDropdown.isMultiple());
        for (int i = 0; i < allOptions.size(); i++) {

            proggramminglanguagesDropdown.selectByIndex(i);
        }
        //4. Print out all selected values.
        for (WebElement option : allOptions) {

            System.out.println("option = " + option.getAttribute("value"));
        }
        //5. Deselect all values.
        proggramminglanguagesDropdown.deselectAll();
    }

}
