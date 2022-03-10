package me.hsgamer.testplugin;

import me.hsgamer.hscore.config.annotation.converter.Converter;

import java.util.Map;

public class TestConverter implements Converter {
    @Override
    public Object convert(Object raw) {
        if (raw instanceof Map) {
            Map<String, Object> map = (Map<String, Object>) raw;
            String name = (String) map.get("name");
            int age = (int) map.get("age");
            return new TestObject(name, age);
        }
        return null;
    }

    @Override
    public Object convertToRaw(Object value) {
        if (value instanceof TestObject) {
            TestObject testObject = (TestObject) value;
            Map<String, Object> map = new java.util.HashMap<>();
            map.put("name", testObject.getName());
            map.put("age", testObject.getAge());
            return map;
        }
        return null;
    }
}
