package com.cydeo.tests.day10_upload_actions_JSExecuter;

import com.cydeo.tests.base.TestBase;
import com.cydeo.utilities.ConfigurationReader;
import com.cydeo.utilities.Driver;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;

public class T1_RegistrationForm extends TestBase {

    @Test
    public void registrationFormTest() {
        //Open browser
        //2. Go to website: https://practice.cydeo.com/registration_form
        Driver.getDriver().get(ConfigurationReader.getProperty("registration.form.url"));
        //3. Enter first name
        WebElement nameBox = Driver.getDriver().findElement(By.xpath("//input[@name='firstname']"));

        Faker faker = new Faker();
        String firstName = faker.name().firstName();

        nameBox.sendKeys(firstName);
        //4. Enter last name
        WebElement lastNameBox = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='lastname']"));

        String lastName = faker.name().lastName();
        lastNameBox.sendKeys(lastName);

        //5. Enter username
        WebElement userNameBox = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='username']"));
String userName= faker.name().username().replace(".","");
        userNameBox.sendKeys(userName);
        //6. Enter email address
        WebElement emailBox = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='email']"));

        emailBox.sendKeys(userName + "@" + faker.letterify("??????") + ".com");
        //emailBox.sendKeys(ConfigurationReader.getProperty("email"));
        //7. Enter password
        WebElement passwordBox = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='password']"));
passwordBox.sendKeys(faker.bothify("###??###?"));

       // passwordBox.sendKeys(ConfigurationReader.getProperty("password"));

        //8. Enter phone number
        WebElement phoneBox = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='phone']"));
        String phoneNumber = faker.numerify("###-###-####");
        phoneBox.sendKeys(phoneNumber);

        //9. Select a gender from radio buttons
        WebElement genderMaleRadioButton = Driver.getDriver().findElement(By.xpath("//input[@value='male']"));
        genderMaleRadioButton.click();


        //10. Enter date of birth
        WebElement birthdayBox = Driver.getDriver().findElement(By.xpath("//input[@data-bv-field='birthday']"));
        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
        String birthday = sdf.format(faker.date().birthday());
        birthdayBox.sendKeys(birthday);

        //11. Select Department/Office
        WebElement departmentBox = Driver.getDriver().findElement(By.xpath("//select[@name='department']"));

        Select forDepartment = new Select(departmentBox);

        forDepartment.selectByIndex(faker.number().numberBetween(1,9));

        //12. Select Job Title
        WebElement jobTitleBox = Driver.getDriver().findElement(By.xpath("//select[@name='job_title']"));
        Select forJob = new Select(jobTitleBox);
        forJob.selectByIndex(faker.number().numberBetween(1,4));

        //13. Select programming language from checkboxes
        WebElement programmingLanguageCPlusBox = Driver.getDriver().findElement(By.xpath("//input[@value='cplusplus']"));
        programmingLanguageCPlusBox.click();

        WebElement programmingLanguageJavaBox = Driver.getDriver().findElement(By.xpath("//input[@value='java']"));
        programmingLanguageJavaBox.click();

        //14. Click to sign up button
        Driver.getDriver().findElement(By.xpath("//button[@id='wooden_spoon']")).click();

        //15. Verify success message “You’ve successfully completed registration.” is displayed.
        String actualMessage = Driver.getDriver().findElement(By.xpath("//div[@role='alert']//p")).getText();
        String expectedMessage = "You've successfully completed registration!";

        Assert.assertEquals(expectedMessage,actualMessage);

    }

}
