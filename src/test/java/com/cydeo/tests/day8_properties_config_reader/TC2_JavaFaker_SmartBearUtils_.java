package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.SmartBearUtils;
import com.cydeo.utilities.WebDriverFactory;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class TC2_JavaFaker_SmartBearUtils_ {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void smartBearOrderVerifyTest() {
        SmartBearUtils.loginToSmartBear(driver);
        //6. Click on Order
        WebElement orderlink = driver.findElement(By.xpath("//a[.='Order']"));
        orderlink.click();
        //7. Select familyAlbum from product, set quantity to 2
        WebElement productDropdown = driver.findElement(By.xpath("//select[@id='ctl00_MainContent_fmwOrder_ddlProduct']"));
        Select select = new Select(productDropdown);
        select.selectByVisibleText("FamilyAlbum");

        WebElement quantityInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtQuantity']"));
        quantityInput.sendKeys("2");
        //8. Click to “Calculate” button
        WebElement calculateButton = driver.findElement(By.xpath("//input[@value='Calculate']"));
        calculateButton.click();

        //9. Fill address Info with JavaFaker
        Faker faker = new Faker();

        String name = faker.name().fullName();
        String street = faker.address().streetAddress();
        String city = faker.address().city();
        String state = faker.address().city();
        String zip = faker.address().zipCode();

        //• Generate: name, street, city, state, zip code
        WebElement nameInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_txtName']"));
        nameInput.sendKeys(name);

        WebElement streetInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox2']"));
        streetInput.sendKeys(street);


        WebElement cityInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox3']"));
        cityInput.sendKeys(city);

        WebElement stateInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox4']"));
        stateInput.sendKeys(state);

        WebElement zipInput = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox5']"));
        zipInput.sendKeys(zip);

        //10. Click on “visa” radio button
        WebElement visaButton = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_cardList_0']"));
        visaButton.click();

        //11. Generate card number using JavaFaker
        String cardNumber = faker.number().digits(16);
        WebElement creditCardNumberBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox6']"));
        creditCardNumberBox.sendKeys(cardNumber);


        //Expire date:

        Date expireDate = faker.date().future(365, TimeUnit.DAYS);
        SimpleDateFormat monthYearFormat = new SimpleDateFormat("MM/yy");
        String expireDateInMonthYearFormat = monthYearFormat.format(expireDate);
        WebElement expireDateBox = driver.findElement(By.xpath("//input[@id='ctl00_MainContent_fmwOrder_TextBox1']"));
        expireDateBox.sendKeys(expireDateInMonthYearFormat);

        //12. Click on “Process”
        WebElement processButton = driver.findElement(By.xpath("//a[.='Process']"));
        processButton.click();


        //13. Verify success message “New order has been successfully added.”
        String expectedMessage = "New order has been successfully added.";
        String actualMessage = driver.findElement(By.tagName("strong")).getText();

        Assert.assertEquals(actualMessage, expectedMessage);


    }
}
