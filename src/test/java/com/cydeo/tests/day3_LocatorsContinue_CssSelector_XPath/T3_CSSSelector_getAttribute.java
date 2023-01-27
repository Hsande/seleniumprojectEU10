package com.cydeo.tests.day3_LocatorsContinue_CssSelector_XPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T3_CSSSelector_getAttribute {
    public static void main(String[] args) {
        //1- Open a chrome browser

        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “Log in” button text is as expected:
        WebElement logIn= driver.findElement(By.cssSelector("input[type='submit']"));
        //Expected: Log In
String expectedLogInText="Log In";
String actualLogInText= logIn.getAttribute("value");// not getText; bcs, getting the Log In from attribute value on the page html. Not inside the opening and closing tags
        System.out.println("actualLogInText = " + actualLogInText);
if (expectedLogInText.equals(actualLogInText)){
    System.out.println("PASSED");
}else {
    System.out.println("PASSED");
}
driver.close();

    }


}
