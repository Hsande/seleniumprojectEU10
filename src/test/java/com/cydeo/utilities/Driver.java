package com.cydeo.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {


    /*We are creating private constructor; in order to close the access of this class' object outside the class*/
    private Driver() {
    }

    /*
    We make WebDriver private, in order to close the access of this class outside the class
    We make it static, bcs we will use it in a static method
    */
    private static WebDriver driver;

    /*
    We create are-usable utility method which will return same driver instance when we call it
     */
    public static WebDriver getDriver() {
        if (driver == null) {
        /*
        We read our browser type our Configuration.properties.
        This way, can control which browser opened outside the code,Configuration.properties.
       */

            String browserType = ConfigurationReader.getProperty("browser");

        /*

        Depending on the browserType that will be return from the Configuration.properties file;
        switch statement will determine the case an open the matching browser
         */

            switch (browserType) {
                case "chrome":
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                    break;
            }
        }


        return driver;
    }
    /*
    This method will make sure our driver value is always null after using quit() method
     */

    public static void closeDriver(){
        if (driver!=null){
            driver.quit();
            driver=null;
        }
    }


}
