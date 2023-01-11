package me.hsgamer.testplugin;

import me.hsgamer.hscore.config.annotation.ConfigPath;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Instant;

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

    @ConfigPath("test.string")
    default String getTestString() {
        return "TestString";
    }

    @ConfigPath("test.boolean")
    default boolean getTestBoolean() {
        return true;
    }

    @ConfigPath("test.double")
    default double getTestDouble() {
        return 10.0;
    }

    @ConfigPath("test.float")
    default float getTestFloat() {
        return 10.0f;
    }

    @ConfigPath("test.long")
    default long getTestLong() {
        return 10L;
    }

    @ConfigPath("test.short")
    default short getTestShort() {
        return 10;
    }

    @ConfigPath("test.byte")
    default byte getTestByte() {
        return 10;
    }

    @ConfigPath("test.char")
    default char getTestChar() {
        return 'a';
    }

    @ConfigPath("test.instant")
    default Instant getTestInstant() {
        return Instant.now();
    }

    @ConfigPath("test.url")
    default URL getTestURL() {
        try {
            return new URL("https://google.com");
        } catch (MalformedURLException e) {
            throw new IllegalStateException(e);
        }
    }

    @ConfigPath("test.bigdecimal")
    default BigDecimal getTestBigDecimal() {
        return BigDecimal.valueOf(10);
    }

    @ConfigPath("test.biginteger")
    default BigInteger getTestBigInteger() {
        return BigInteger.valueOf(10);
    }
}
