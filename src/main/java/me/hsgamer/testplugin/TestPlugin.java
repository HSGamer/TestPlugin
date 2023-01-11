package me.hsgamer.testplugin;

import me.hsgamer.hscore.bukkit.baseplugin.BasePlugin;
import me.hsgamer.hscore.bukkit.config.BukkitConfig;
import me.hsgamer.hscore.config.proxy.ConfigGenerator;
import org.bukkit.event.Listener;

public final class TestPlugin extends BasePlugin implements Listener {
    @Override
    public void enable() {
        TestConfig testConfig = ConfigGenerator
                .newInstance(TestConfig.class, new BukkitConfig(this, "test.yml"));
        TestObject testObject = testConfig.getTestObject();
        System.out.println("Name: " + testObject.getName());
        System.out.println("Age: " + testObject.getAge());
        testConfig.setTestObject(new TestObject("Tien", 123123));
        System.out.println("Set Value");
        testObject = testConfig.getTestObject();
        System.out.println("Name: " + testObject.getName());
        System.out.println("Age: " + testObject.getAge());
        testConfig.setTestObject(new TestObject("hsgamer", 18));
        System.out.println("Set Value");
        testObject = testConfig.getTestObject();
        System.out.println("Name: " + testObject.getName());
        System.out.println("Age: " + testObject.getAge());

        System.out.println("Test Int: " + testConfig.getTestInt());
        System.out.println("Test Integer: " + testConfig.getTestInteger());
        System.out.println("Test String: " + testConfig.getTestString());
        System.out.println("Test Boolean: " + testConfig.getTestBoolean());
        System.out.println("Test Double: " + testConfig.getTestDouble());
        System.out.println("Test Float: " + testConfig.getTestFloat());
        System.out.println("Test Long: " + testConfig.getTestLong());
        System.out.println("Test Short: " + testConfig.getTestShort());
        System.out.println("Test Byte: " + testConfig.getTestByte());
        System.out.println("Test Char: " + testConfig.getTestChar());
        System.out.println("Test BigInteger: " + testConfig.getTestBigInteger());
        System.out.println("Test BigDecimal: " + testConfig.getTestBigDecimal());
        System.out.println("Test URL: " + testConfig.getTestURL());
        System.out.println("Test Instant: " + testConfig.getTestInstant());
    }
}
