package com.learn.unit.test.spirngunittest.controllers;

import com.learn.unit.test.spirngunittest.ControllerTests;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class IndexControllerTest implements ControllerTests {

    IndexController controller;

    @BeforeEach
    void setUp() {
        controller = new IndexController();
    }

    @DisplayName("test to verify the index view name")
    @Test
    void index() {
        assertEquals("index", controller.index(), "wrong view returned");
    }

    @DisplayName("test to verify the exception")
    @Test
    void oopsHandler() {
        // test the exception handler
      assertThrows(ValueNotFoudException.class,()->controller.oopsHandler());
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMac() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() {

    }
}