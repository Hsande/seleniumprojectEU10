package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TC5_GasMileageCalc {
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver(ConfigurationReader.getProperty("browser"));
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

       @AfterMethod
       public void tearDown(){
           driver.close();
       }

    @Test
    public void gasMileageCalcTest() {
        //1. Add a new class GasMileageCalculatorTest
        //2. Go to https://www.calculator.net
        driver.get("https://www.calculator.net");

        //3. Search for “gas mileage” using search box
        WebElement searchBox = driver.findElement(By.xpath("//input[@id='calcSearchTerm']"));
        searchBox.sendKeys("gas mileage" + Keys.ENTER);
        //4. Click on the “Gas Mileage Calculator” link
        WebElement gasMileageCalculatorLink = driver.findElement(By.xpath("//a[.='Gas Mileage Calculator']"));
        gasMileageCalculatorLink.click();
        //5. On Next page verify:
        //a. Title equals: “Gas Mileage Calculator”
        String actualTitle = driver.getTitle();
        String expectedTitle = "Gas Mileage Calculator";
        Assert.assertEquals(actualTitle, expectedTitle);

        //b. “Gas Mileage Calculator” label is displayed
        String actualGasMileageCalculatorLabel = driver.findElement(By.xpath("//h1[.='Gas Mileage Calculator']")).getText();
        String expectedGasMileageCalculatorLabel = "Gas Mileage Calculator";

        //6. Locate, clear and type “7925” into “Current odometer” field
        WebElement currentOdometerBox = driver.findElement(By.xpath("//input[@id='mucodreading']"));
        currentOdometerBox.clear();
        currentOdometerBox.sendKeys("7925");
        //7. Locate, clear and type “7550” into “Previous odometer” field
        WebElement previousodometerBox = driver.findElement(By.xpath("//input[@id='mupodreading']"));
        previousodometerBox.clear();
        previousodometerBox.sendKeys("7550");
        //8. Locate, clear and type “16” into “Gas added” field
        WebElement gasAddedrBox = driver.findElement(By.xpath("//input[@id='mugasputin']"));
        gasAddedrBox.clear();
        gasAddedrBox.sendKeys("16");

        //9. Locate, clear and type “3.55” into “Gas price” field
        WebElement gasPricerBox = driver.findElement(By.xpath("//input[@id='mugasprice']"));
        gasPricerBox.clear();
        gasPricerBox.sendKeys("3.55");


        //10. Click on Calculate button
        WebElement calculateButton = driver.findElement(By.xpath("(//input[@src='//d26tpo4cm8sb6k.cloudfront.net/img/svg/calculate.svg'])[2]"));
        calculateButton.click();
        //11. Verify mpg value is as expected:
        //Expected value: “23.44 mpg”
        String expectedValue = "(55.13 mpg)";
        String actualValue = driver.findElement(By.xpath("//span[@class ='bigtext']")).getText();

        Assert.assertEquals(actualValue,expectedValue);

    }
}
