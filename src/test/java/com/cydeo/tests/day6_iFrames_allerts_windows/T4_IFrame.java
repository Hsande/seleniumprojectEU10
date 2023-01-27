package com.cydeo.tests.day6_iFrames_allerts_windows;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class T4_IFrame {
    public WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //3. Go to: https://practice.cydeo.com/iframe

        driver.get("https://practice.cydeo.com/iframe");

    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

   // @Ignore //if we use @Ignore, test is ignored
    @Test
    public void test() {


        //4. Assert: “Your content goes here.” Text is displayed.
        // driver.switchTo().frame(0);
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@frameborder='0']")));

        WebElement frameText = driver.findElement(By.xpath("//p[.='Your content goes here.']"));
        Assert.assertTrue(frameText.isDisplayed(), "Text is not displayed");

        String actualText = frameText.getText();
        String expectedText = "Your content goes here.";

        Assert.assertEquals(actualText, expectedText, "actual text and expected text do not match");
        //5. Assert: “An iFrame containing the TinyMCE WYSIWYG Editor”
        driver.switchTo().parentFrame();
        String expectedHeader = "An iFrame containing the TinyMCE WYSIWYG Editor";
        String actualHeader = driver.findElement(By.xpath("//h3[.='An iFrame containing the TinyMCE WYSIWYG Editor']")).getText();

        Assert.assertTrue(actualHeader.equals(expectedHeader), "actual header does not match with expected one");
    }
}
