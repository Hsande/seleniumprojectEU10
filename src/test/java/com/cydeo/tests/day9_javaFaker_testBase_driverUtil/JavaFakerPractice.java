package com.cydeo.tests.day9_javaFaker_testBase_driverUtil;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerPractice {
    @Test
    public void test1(){
        Faker faker= new Faker();
       // Faker faker= new Faker(new Locale("tr"));// This part is used for getting locale results regarding to address name etc


        System.out.println("faker.name().firstName() = " + faker.name().firstName());
        System.out.println("faker.funnyName() = " + faker.funnyName().name());
        System.out.println("faker.address() = " + faker.address().fullAddress());

        //numerify() is for taking numbers that format that we want to
        System.out.println("faker.numerify(\"###-###-####\") = " + faker.numerify("###-###-####"));
        System.out.println("faker.numerify(\"0212-###-###\") = " + faker.numerify("0212-###-###"));

       //letterify() for random letters
        System.out.println("faker.letterify(\"???/???\") = " + faker.letterify("???/???"));

        //bothify() for random letters and digits
        System.out.println("faker.bothify(\"##? & ##???#\") = " + faker.bothify("##? & ##???#"));

      //  System.out.println("faker.finance().creditCard() = " + faker.finance().creditCard().replaceAll("-",""));
    }
}
