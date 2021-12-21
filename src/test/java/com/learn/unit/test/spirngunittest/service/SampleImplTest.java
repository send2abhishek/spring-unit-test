package com.learn.unit.test.spirngunittest.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SampleImplTest {

    @Autowired
    SampleImpl sample;

    @Test
    void testSampleBasic() {

        int result=sample.calculateSum(new int[]{2,3,4,5});

        assertEquals(result,14);
    }
}