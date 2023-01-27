package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC4_FindElements {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://www.openxcell.com
        driver.get("https://www.openxcell.com");
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test1() {


        //3. Count the number of the links on the page and verify
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        System.out.println("allLinks.size() = " + allLinks.size());
        //Expected: 332
        int expectedAllLinksCount = 355;
        int actualAllLinksCount = allLinks.size();
        Assert.assertTrue(actualAllLinksCount == expectedAllLinksCount);
    }

    @Test
    public void test2() {

        //3. Print out all of the texts of the links on the page
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        int i = 1;
        for (WebElement each : allLinks) {
            if (!(each.getText().isEmpty())) {
                System.out.println((i++) + " - " + each.getText());


            }

        }
    }

    @Test
    public void test3() {
        //Count the number of links that does not have text and verify
        //Expected: 109
        List<WebElement> allLinks = driver.findElements(By.xpath("//a"));
        int actualCountNoText = 0;
        for (WebElement link : allLinks) {
            if (link.getText().isEmpty() || link.getText().isBlank()) {
                actualCountNoText++;
            }
        }
        int expectedCountNoTextLink = 259;

        Assert.assertEquals(actualCountNoText, expectedCountNoTextLink);
    }

}
