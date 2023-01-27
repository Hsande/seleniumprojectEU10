package com.cydeo.tests.day8_properties_config_reader;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.Driver;
import com.cydeo.utilities.WebTableUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T1_webTablePractice extends TestBase {



    @Test
    public void test1() {
        //1. Go to: https://practice.cydeo.com/web-tables
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");
        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        WebElement bobName = Driver.getDriver().findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[7]//td[.='333222111222']//preceding-sibling::td[9]"));

        String expectedName="Bob Martin";
        String actualName= bobName.getText();
        Assert.assertEquals(actualName,expectedName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
        WebElement bobOrderDate= Driver.getDriver().findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[7]//td[.='333222111222']//preceding-sibling::td[6]"));

        String expectedDate="12/31/2021";
        String actualdate= bobOrderDate.getText();

        Assert.assertEquals(actualdate,expectedDate);
    }

    @Test
    public void testC1() {

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
        Driver.getDriver().get("https://practice.cydeo.com/web-tables");

        WebElement bobName = Driver.getDriver().findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//td[.='Bob Martin']"));

        String expectedName="Bob Martin";
        String actualName= bobName.getText();
        Assert.assertEquals(actualName,expectedName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
       String actualDate =WebTableUtils.returnOrderDate("Bob Martin");

       String expectedDate="12/31/2021";


        Assert.assertEquals(actualDate,expectedDate);
    }

   @Test
    public void testCC1() {

        //2. Verify Bob’s name is listed as expected.
        //Expected: “Bob Martin”
       Driver.getDriver().get("https://practice.cydeo.com/web-tables");

        WebElement bobName = Driver.getDriver().findElement(By.xpath("//table[@id='ctl00_MainContent_orderGrid']//tr[7]//td[.='333222111222']//preceding-sibling::td[9]"));

        String expectedName="Bob Martin";
        String actualName= bobName.getText();
        Assert.assertEquals(actualName,expectedName);

        //3. Verify Bob Martin’s order date is as expected
        //Expected: 12/31/2021
   WebTableUtils.orderVerify("Bob Martin","12/31/2021");
    }

}
