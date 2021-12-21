package com.learn.unit.test.spirngunittest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    @Test
    void testPerson() {

        // given the person

        Person person = new Person(1l, "Abhishek", "Aryan");

        // group assertion

        assertAll("test property set", () -> assertEquals(person.getFirstName(), "Abhishek", "name is not Abhishek"),
                () -> assertEquals(person.getLastName(), "Aryan", "name is not Aryan")

        );
    }
}