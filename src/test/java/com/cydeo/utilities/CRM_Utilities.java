package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
These methods for special for one page - crm
 */
public class CRM_Utilities {
   /*
   This method will login crm with helpdesk1@cybertekschool.com user when it is called
    */
    public static void crm_login(WebDriver driver){
        //3. Enter valid username
        WebElement loginBox= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginBox.sendKeys("helpdesk1@cybertekschool.com");
        //4. Enter valid password
        WebElement passwordBox= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys("UserUser");
        //5. Click to `Log In` button
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

    }

    /*
    This method will login crm with 3 arguments(driver, username,password)
     */
    public static void crm_login(WebDriver driver, String username, String password){
        //3. Enter valid username
        WebElement loginBox= driver.findElement(By.xpath("//input[@name='USER_LOGIN']"));
        loginBox.sendKeys(username);
        //4. Enter valid password
        WebElement passwordBox= driver.findElement(By.xpath("//input[@name='USER_PASSWORD']"));
        passwordBox.sendKeys(password);
        //5. Click to `Log In` button
        WebElement loginButton = driver.findElement(By.xpath("//input[@value='Log In']"));
        loginButton.click();

    }
}
