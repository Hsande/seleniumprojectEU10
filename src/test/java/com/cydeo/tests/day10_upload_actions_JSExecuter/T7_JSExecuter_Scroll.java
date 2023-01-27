package com.cydeo.tests.day10_upload_actions_JSExecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class T7_JSExecuter_Scroll {

    @Test
    public void scrollTest(){
        //TC #7: Scroll using JavascriptExecutor
        //1- Open a chrome browser
        //2- Go to: https://practice.cydeo.com/large
        Driver.getDriver().get("https://practice.cydeo.com/large");
        //3- Scroll down to “Cydeo” link
        JavascriptExecutor js= (JavascriptExecutor) Driver.getDriver();
        js.executeScript("arguments[0].scrollIntoView(true)",Driver.getDriver().findElement(By.xpath("//div[@style='text-align: center;']")));
        //4- Scroll up to “Home” link
        js.executeScript("arguments[0].scrollIntoView(true)",Driver.getDriver().findElement(By.xpath("//a[@class='nav-link']")));

        //5- Use below provided JS method only
        //JavaScript method to use : arguments[0].scrollIntoView(true)
        //Note: You need to locate the links as web elements and pass them as arguments into executeScript() method
    }
}
