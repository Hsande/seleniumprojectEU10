package com.cydeo.tests.day3_LocatorsContinue_CssSelector_XPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T5_getText_getAttribute_Xpath {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");

        //3- Enter incorrect username into login box:
        WebElement loginBox = driver.findElement(By.xpath("//input[@class='login-inp']"));
        loginBox.sendKeys("incorrect");

        //4- Click to `Reset password` button
        WebElement resetButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        resetButton.click();
        //5- Verify “error” label is as expected
        //Expected: Login or E-mail not found

        String expectedErrorLabel = "Login or E-mail not found";
        String actualErrorLabel = driver.findElement(By.xpath("//div[@class='errortext']")).getText();

        // System.out.println("actualErrorLabel = " + actualErrorLabel);

        if (actualErrorLabel.equals(expectedErrorLabel)) {
            System.out.println("Error label verification test PASSED!");
        } else {
            System.out.println("Error label verification test FAILED!");
        }
    driver.quit();

    }
}
