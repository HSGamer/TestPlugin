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
    }
}
