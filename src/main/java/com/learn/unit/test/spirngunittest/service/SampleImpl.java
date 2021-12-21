package com.learn.unit.test.spirngunittest.service;

import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class SampleImpl implements Sample {

    @Override
    public int calculateSum(int[] numbers) {
       return Arrays.stream(numbers).sum();
    }
}
