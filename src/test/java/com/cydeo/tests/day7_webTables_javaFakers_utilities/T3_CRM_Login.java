package com.cydeo.tests.day7_webTables_javaFakers_utilities;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T3_CRM_Login {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//1. Create new test and make set ups
//2. Go to : http://login1.nextbasecrm.com/
        driver.get("http://login1.nextbasecrm.com/");

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void crm_logIn_test() {


        //3. Enter valid username
        WebElement loginBox= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginBox.sendKeys("helpdesk1@cybertekschool.com");
        //4. Enter valid password
        WebElement passwordBox= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys("UserUser");
        //5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        //6. Verify title is as expected:
        //Expected: Portal/ My tasks
        BrowserUtils.verifyTitle(driver,"My tasks");
    }

    }
