package com.cydeo.tests.day8_properties_config_reader;

import org.testng.annotations.Test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadingProperties {
    @Test
    public void reading_properties() throws IOException {
        //create properties object
        Properties properties= new Properties();

        //we need to open a file from java memory:FileInputStream
        FileInputStream file= new FileInputStream("configuration.properties");

        //Load the properties object using FileInputStream
        properties.load(file);

        //use "properties" object to read value
        System.out.println("properties.getProperty(\"browser\") = " + properties.getProperty("browser"));
        System.out.println("properties.getProperty(\"env\") = " + properties.getProperty("env"));
        System.out.println("properties.getProperty(\"username\") = " + properties.getProperty("username"));

    }
}
