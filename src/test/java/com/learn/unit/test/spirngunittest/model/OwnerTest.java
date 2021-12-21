package com.learn.unit.test.spirngunittest.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OwnerTest {


    @Test
    void dependentAssertions() {
        Owner owner = new Owner(2l, "Abhishek", "Aryan");
        owner.setCity("bangalore");
        owner.setTelephone("34300340449");

        assertAll("properties tests",
                () -> assertAll("Person Properties",
                        () -> assertEquals("Abhishek", owner.getFirstName()),
                        () -> assertEquals("Aryan", owner.getLastName())
                ),

                () -> assertAll("Owner Properties",
                        () -> assertEquals("bangalore", owner.getCity()),
                        () -> assertEquals("34300340449", owner.getTelephone())));
    }
}