package com.cydeo.tests.day5_Testng_intro_Dropdowns;

import com.cydeo.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class T3_RadioButton_Cont {
    public static void main(String[] args) {
        // In the button; not same as checkboxes, "name" attribute of each button is the same, so we can use these names to create a list.
        //In the button; we can seperate each button via "id" attribute.
        //In checkboxes; since, both "name" and "id" attributes are different from each other, we cannot use this method.


        //1. Open Chrome browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //2. Go to https://practice.cydeo.com/radio_buttons
        driver.get("https://practice.cydeo.com/radio_buttons");
        //3-Locate name=Sports buttons and store them in a list of WebElement
        List<WebElement> sportButtonsList = driver.findElements(By.name("sport"));// in button group, name attributes' are the same
        //4-Loop through the list of Web Element and select matching result "hockey"
        for (WebElement each : sportButtonsList) {
            String eachId = each.getAttribute("id"); // id attributes' are different from in each sport button and store them

            System.out.println("eachId = " + eachId); // we are checking each sports' id attributes

            if (eachId.equals("hockey")) {
                each.click();
                System.out.println("Hockey is selected = " + each.isSelected());
                break;
            }

        }

        clickAndVerifyRadioButton(driver, "color", "red");

        driver.close();
    }

    private static void clickAndVerifyRadioButton(WebDriver driver, String nameAttribute, String idValue) {
        List<WebElement> radioButtons = driver.findElements(By.name(nameAttribute));
        for (WebElement each : radioButtons) {
            String eachId = each.getAttribute("id"); // id attributes' are different from in each sport button and store them

            if (eachId.equals(idValue)) {
                each.click();
                System.out.println(idValue + " is selected = " + each.isSelected());
                break;
            }

        }

    }


}
