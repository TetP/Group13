package com.cybertek.tests.day6_dropdown_review_javafaker;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class JavaFakerExamples {

    @Test
    public void fakerTest(){
        Faker faker = new Faker();

        String firstName=faker.name().firstName();
        System.out.println("First name: "+firstName);

        String lastName=faker.name().lastName();
        System.out.println("Last name: "+lastName);

        String fullName=faker.name().fullName();
        System.out.println("Full name: "+fullName);

        String address=faker.address().fullAddress();
        System.out.println("Address: "+address);

        String house=faker.gameOfThrones().house();
        System.out.println("House: "+house);

        String quote=faker.gameOfThrones().quote();
        System.out.println("Quote: "+quote);
    }


















}
