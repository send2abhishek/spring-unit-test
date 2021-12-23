package com.learn.unit.test.spirngunittest.practice;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.Standard.class)
public class CustomTest {

    @Test
    void testMethod() {
        System.out.println("test method called");
    }


   @Disabled
    void testDisabledMethod() {
        System.out.println("test method called2");
    }
}
