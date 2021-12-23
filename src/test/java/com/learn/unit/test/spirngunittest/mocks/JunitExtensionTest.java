package com.learn.unit.test.spirngunittest.mocks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

@ExtendWith(MockitoExtension.class)
public class JunitExtensionTest {


    @Mock
    Map<String, Object> mapMock;


    @Test
    void testMock() {

        mapMock.put("key", "mock value");
    }
}
