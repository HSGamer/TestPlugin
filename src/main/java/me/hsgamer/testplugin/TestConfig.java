package me.hsgamer.testplugin;

import me.hsgamer.hscore.config.annotation.ConfigPath;

public interface TestConfig {
    @ConfigPath(value = "test.object", converter = TestConverter.class)
    default TestObject getTestObject() {
        return new TestObject("TestObject", 10);
    }

    void setTestObject(TestObject testObject);

    @ConfigPath("test.int")
    default int getTestInt() {
        return 10;
    }

    @ConfigPath("test.int2")
    default Integer getTestInteger() {
        return 10;
    }
}
