package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC3_SmartBearOrderVerify {
    WebDriver driver;

    @BeforeMethod
    public void setUp(){
        driver= WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

    @Test
    public void smartBearOrderVerifyTest(){
        //1. Open browser and login to Smartbear software
        SmartBearUtils.loginToSmartBear(driver);
        //2. Click on View all orders
        WebElement orderlink = driver.findElement(By.xpath("//a[.='View all orders']"));

        //3. Verify Susan McLaren has order on date “01/05/2010”
    WebElement orderDateCell= driver.findElement(By.xpath("//table[@cellpadding='0']//td[.='Susan McLaren']//following-sibling::td[3]"));
    String expectedOrderDate="01/05/2010";
    String actualOrderDate=orderDateCell.getText();

        Assert.assertEquals(actualOrderDate,expectedOrderDate);
    }
}
