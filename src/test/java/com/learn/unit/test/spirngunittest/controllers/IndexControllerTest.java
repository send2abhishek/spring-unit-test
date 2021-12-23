package com.learn.unit.test.spirngunittest.controllers;

import com.learn.unit.test.spirngunittest.ControllerTests;
import com.learn.unit.test.spirngunittest.model.OwnerType;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;

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
        assertThrows(ValueNotFoudException.class, () -> controller.oopsHandler());
    }

    @EnabledOnOs(OS.MAC)
    @Test
    void testOnMac() {

    }

    @EnabledOnOs(OS.WINDOWS)
    @Test
    void testOnWindows() {

    }

    @RepeatedTest(value = 5, name = "{displayName} - repetition {currentRepetition} of {totalRepetitions}")
    @DisplayName("repeat test")
    void repeatedTest() {

    }

    // these params will resolve at runtime with concepts of test DI
    @RepeatedTest(5)
    @DisplayName("test with DI")
    void repeatedTestWithDI(TestInfo testInfo, RepetitionInfo info) {
        System.out.println("test ran " + testInfo.getDisplayName() + ": " + info.getCurrentRepetition());
    }

    @DisplayName("value source test")
    @ParameterizedTest(name = "displayName - [{index}] {argumentsWithNames}")
    @ValueSource(strings = {"spring","framework","guru"})
    void testParameterized(String val) {
        System.out.println("params is " + val);
    }

    @DisplayName("enum source test")
    @ParameterizedTest(name = "displayName - [{index}] {argumentsWithNames}")
    @EnumSource(OwnerType.class)
    void testParameterizedWithEnum(OwnerType type) {
        System.out.println("owner is " + type);
    }
}