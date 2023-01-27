package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T4_GoogleSearch_ConfigUtil {
/*
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        // We did browser verification dynamic.
        //String browserType= ConfigurationReader.getProperty("browser");
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get(ConfigurationReader.getProperty("url"));
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
*/
    @Test
    public void t4() {
        Driver.getDriver().get("https://www.google.com");
        //3- Write “apple” in search box
        WebElement googleSearchBox= Driver.getDriver().findElement(By.xpath("//input[@name='q']"));
        googleSearchBox.sendKeys(ConfigurationReader.getProperty("searchValue")+ Keys.ENTER);
        //4- Verify title:
        //Expected: apple - Google Search
        //Use `configuration.properties` for the following:

        String expectedInsideTitle= ConfigurationReader.getProperty("searchValue") + " - Google'da Ara";
        String actualTitle= Driver.getDriver().getTitle();
        Assert.assertTrue(actualTitle.equals(expectedInsideTitle));
    }

}

