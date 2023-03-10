package com.cydeo.tests.day3_LocatorsContinue_CssSelector_XPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T4_GetText_GetAttribute_CssSelector {
    public static void main(String[] args) {
        //1- Open a chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/?forgot_password=yes
        driver.get("https://login1.nextbasecrm.com/?forgot_password=yes");
        //3- Verify “Reset password” button text is as expected:
        //Expected: Reset password
        WebElement resetButton = driver.findElement(By.cssSelector("button[value='Reset password']"));
        String actualResetText = resetButton.getText();
        String expectedResetText = "Reset password";
        if (actualResetText.equals(expectedResetText)) {
            System.out.println("passed");
        } else {
            System.out.println("failed");
        }
driver.close();
    }
}
