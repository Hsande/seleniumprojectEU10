package com.cydeo.tests.day3_LocatorsContinue_CssSelector_XPath;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class T2_NextBaseCrm_getText_getAttribute {
    public static void main(String[] args) {
        //1- Open a chrome browser
        //WebDriverManager.chromedriver().setup();
        //WebDriver driver = new ChromeDriver();
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //2- Go to: https://login1.nextbasecrm.com/
        driver.get("https://login1.nextbasecrm.com/");
        //3- Verify “remember me” label text is as expected:
        //Expected: Remember me on this computer
        String actualRememberMeLabel = driver.findElement(By.tagName("label")).getText();
        String expectedRememberMeLabel = "Remember me on this computer";

        if (actualRememberMeLabel.equals(expectedRememberMeLabel)) {
            System.out.println("Remember me label verification Passed");
        } else {
            System.out.println("Remember me label verification Failed");
        }


        //4- Verify “forgot password” link text is as expected:
        //Expected: Forgot your password?

        String actualForgotPasswordText = driver.findElement(By.className("login-link-forgot-pass")).getText();
        String expectedForgotPasswordText = "FORGOT YOUR PASSWORD?";

        //  System.out.println(actualForgotPasswordText);

        if (actualForgotPasswordText.equals(expectedForgotPasswordText)) {
            System.out.println("Forgot password text verification passed");
        } else {
            System.out.println("Forgot password text verification failed");
        }

        //5- Verify “forgot password” href attribute’s value contains expected:
        //Expected: forgot_password=yes
        String actualForgotPasswordHref = driver.findElement(By.className("login-link-forgot-pass")).getAttribute("href");
        String expectedForgotPasswordInHref = "forgot_password=yes";

        // System.out.println(actualForgotPasswordHref);

        if (actualForgotPasswordHref.contains(expectedForgotPasswordInHref)) {
            System.out.println("Forgot passsword in Href verification Passed");
        } else {
            System.out.println("Forgot passsword in Href verification Failed");
        }


    }
}
