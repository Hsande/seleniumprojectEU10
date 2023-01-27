package com.cydeo.tests.day10_upload_actions_JSExecuter;

import com.cydeo.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class T3_HoverTest {
    @Test
    public void hoverTest() {
        //TC #3: Hover Test
        //1. Go to https://practice.cydeo.com/hovers
        Driver.getDriver().get("https://practice.cydeo.com/hovers");
        //2. Hover over to first image
        Actions actions = new Actions(Driver.getDriver());
        WebElement firstImage = Driver.getDriver().findElement(By.xpath("//img[@src='/img/avatar-blank.jpg']"));
        actions.moveToElement(firstImage).perform();

        //3. Assert:
        //a. “name: user1” is displayed
        WebElement User1Text = Driver.getDriver().findElement(By.xpath("//img[@src='/img/avatar-blank.jpg']//following-sibling::div[1]//h5"));
        Assert.assertTrue(User1Text.isDisplayed());
        //b. “view profile” is displayed
        WebElement profileText = Driver.getDriver().findElement(By.xpath("//img[@src='/img/avatar-blank.jpg']//following-sibling::div[1]//a"));
        Assert.assertTrue(profileText.isDisplayed());
        //4. Hover over to second image
        //5. Assert:
        //a. “name: user2” is displayed
        //b. “view profile” is displayed
        WebElement image2 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]"));
        actions.moveToElement(image2).perform();

        WebElement User2Text = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]//following-sibling::div[1]//h5"));
        Assert.assertTrue(User2Text.isDisplayed());

        WebElement profile2Text = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[2]//following-sibling::div[1]//a"));
        Assert.assertTrue(profile2Text.isDisplayed());


        //6. Hover over to third image
        //7. Confirm:
        //a. “name: user3” is displayed
        //b. “view profile” is displayed

        WebElement image3 = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]"));
        actions.moveToElement(image3).perform();

        WebElement User3Text = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]//following-sibling::div[1]//h5"));
        Assert.assertTrue(User3Text.isDisplayed());

        WebElement profile3Text = Driver.getDriver().findElement(By.xpath("(//img[@src='/img/avatar-blank.jpg'])[3]//following-sibling::div[1]//a"));
        Assert.assertTrue(profile3Text.isDisplayed());


    }
}
