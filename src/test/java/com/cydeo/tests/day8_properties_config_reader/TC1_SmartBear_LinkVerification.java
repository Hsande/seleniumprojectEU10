package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class TC1_SmartBear_LinkVerification {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {

        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("http://secure.smartbearsoftware.com/samples/testcomplete12/WebOrders/login.aspx");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void smartBearLinkVerifyTest(){

        //3. Enter username: “Tester”
        WebElement usernameBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_username']"));
        usernameBox.sendKeys("Tester");
        //4. Enter password: “test”
        WebElement passwordBox= driver.findElement(By.xpath("//input[@id='ctl00_MainContent_password']"));
        passwordBox.sendKeys("test"+ Keys.ENTER);

        //5. Click to Login button
        //6. Print out count of all the links on landing page
        List<WebElement> allLinks= driver.findElements(By.xpath("//a"));
        System.out.println("allLinks.size() = " + allLinks.size());
        //7. Print out each link text on this page
        for (WebElement each : allLinks) {
            System.out.println("each.getText() = " + each.getText());
        }
    }
}
