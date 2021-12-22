package com.learn.unit.test.spirngunittest.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IndexControllerTest {

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
    void oupsHandler() {
        // thi assertion is used for test boolean condition
        assertTrue("notimplemented".equals(controller.oupsHandler()),()->"this is custom message which suggest that this is an error ");
    }
}