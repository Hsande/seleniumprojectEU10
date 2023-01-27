package com.cydeo.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WebTableUtils {
    /*
• Arg1: WebDriver driver
• Arg2: String costumerName
This method will accept a costumerName and return the costumer order date as a String.
*/
    public static String returnOrderDate( String costumerName) {
        String locator= "//table[@id='ctl00_MainContent_orderGrid']//td[.='" + costumerName + "']//following-sibling:: td[3]";
        WebElement customerOrderDateCell = Driver.getDriver().findElement(By.xpath(locator));
        return customerOrderDateCell.getText();

    }


    /*
    Method #2 info:
    • Name: orderVerify ()
    • Return type: void
    • Arg1: WebDriver driver
    • Arg2: String costumerName
    • Arg3: String expectedOrderDate
    This method should accept above mentioned arguments and internally assert expectedOrderDate matching actualOrderDate.
         */
    public static void orderVerify( String costumerName, String expectedOrderDate) {
        String actualOrderDate = returnOrderDate( costumerName);
        Assert.assertEquals(actualOrderDate,expectedOrderDate);
    }
}
