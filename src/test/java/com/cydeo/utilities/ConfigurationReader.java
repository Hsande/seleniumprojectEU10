package com.cydeo.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    /*
    We want to variable cannot be accesable outside of this class, bcs we are using it only in this class-and it about control-,so we did it private
    We are using static type for variable; since it is using the same value for everytime and we can assign a value at the beginning
    We are using static block, since it runs before everything.
    file.close() is dor taking the control from garbage collectar, while it is out of using, close the file.
     */

    //create properties object
    private static Properties properties = new Properties();

    static {
        try {
            //we need to open a file from java memory:FileInputStream
            FileInputStream file = new FileInputStream("configuration.properties");

            //Load the properties object using FileInputStream

            properties.load(file);

            //close the file
            file.close();

        } catch (IOException e) {
            System.out.println("File not found in the \"ConfiguratonReader Class\"");
            e.printStackTrace();
        }

    }


    public static String getProperty(String keyword){


        //use "properties" object to read value

        return properties.getProperty(keyword);

    }
}
