package com.cydeo.tests.base;

import com.cydeo.utilities.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public abstract class TestBase {


    @BeforeMethod
    public void setUp() {
/*
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 */
        Driver.getDriver();

    }

    @AfterMethod
    public void tearDown() {
        Driver.getDriver().quit();
    }
}
