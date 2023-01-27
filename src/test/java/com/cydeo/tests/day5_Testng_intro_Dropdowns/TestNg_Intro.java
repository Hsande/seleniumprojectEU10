package com.cydeo.tests.day5_Testng_intro_Dropdowns;

import org.testng.Assert;
import org.testng.annotations.*;

public class TestNg_Intro {
    //TestNg is a unit testing tool, and we use it for getting some reports from the test
//Assert class has methods for using some verifications with testNg
    @BeforeClass
    public void setUpClass(){
        System.out.println("---> Before class is running");
    }

    @AfterClass
    public void tearDownClass(){
        System.out.println("---> After class is running");
    }

    @BeforeMethod// This is for repeating method or every test method's running before
    public void setUpMethod() {
        System.out.println("-->Before method is running");
    }
    @AfterMethod//This is for repeating method or every test method's running after
    public void tearDownMethod() {
        System.out.println("-->After method is running");
    }


    @Test(priority = 2) // This is make runnable the code without main
    public void test1() {
        System.out.println("Test1 is running...");
// Assert equals: compare 2 of the same things
        String actual="apple";
        String expected="apple";
        Assert.assertEquals(actual,expected);

    }

    @Test(priority = 1) //priority is for which one is run first; by default it is running in alphabetical order
    public void test2() {
        System.out.println("Test2 is running...");

      // Assert true used for boolean type
        String actual="apple";
        String expected="apple";
    Assert.assertTrue(actual.equals(expected));
    }


}
