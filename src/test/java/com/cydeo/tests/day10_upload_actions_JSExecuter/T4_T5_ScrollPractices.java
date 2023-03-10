package com.cydeo.tests.day10_upload_actions_JSExecuter;

import com.cydeo.utilities.BrowserUtils;
import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class T4_T5_ScrollPractices {
    @Test
    public void ScrollTest1() {
//TC #4: Scroll practice
//1- Open a chrome browser
//2- Go to: https://practice.cydeo.com/
        Driver.getDriver().get("https://practice.cydeo.com/");

//3- Scroll down to “Powered by CYDEO”
        Actions actions = new Actions(Driver.getDriver());
        BrowserUtils.sleep(1);
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']")));

//4- Scroll using Actions class “moveTo(element)” method
        actions.moveToElement(Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']"))).perform();

    }

    @Test
    public void ScrollTest2() {

//1- Continue from where the Task 4 is left in the same test.
//2- Scroll back up to “Home” link using PageUP button
Actions actions= new Actions(Driver.getDriver());

        BrowserUtils.sleep(1);
        actions.sendKeys(Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']")),Keys.PAGE_UP).perform();
    }

}
