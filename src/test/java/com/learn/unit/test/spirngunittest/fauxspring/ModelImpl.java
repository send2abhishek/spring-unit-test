package com.learn.unit.test.spirngunittest.fauxspring;

import java.util.HashMap;

public class ModelImpl implements Model {

    HashMap<String, Object> map = new HashMap<>();

    @Override
    public void addAttribute(String key, Object o) {
        map.put(key, o);
    }

    @Override
    public void addAttribute(Object o) {

    }
}
