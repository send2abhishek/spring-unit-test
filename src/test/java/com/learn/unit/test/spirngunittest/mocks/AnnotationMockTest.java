package com.learn.unit.test.spirngunittest.mocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Map;

public class AnnotationMockTest {
    @Mock
    Map<String, Object> mapMock;

    // this is second way of creating the mock
    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
    }




    @Test
    void testMock() {

        mapMock.put("key", "mock value");
    }
}
