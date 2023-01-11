package me.hsgamer.testplugin;

import com.google.common.reflect.TypeToken;
import me.hsgamer.hscore.bukkit.baseplugin.BasePlugin;
import me.hsgamer.hscore.bukkit.config.BukkitConfig;
import me.hsgamer.hscore.config.annotation.converter.SimpleConverter;
import me.hsgamer.hscore.config.annotation.converter.manager.DefaultConverterManager;
import me.hsgamer.hscore.config.proxy.ConfigGenerator;
import org.bukkit.event.Listener;

import java.util.LinkedHashMap;
import java.util.Map;

public final class TestPlugin extends BasePlugin implements Listener {
    @Override
    public void enable() {
        DefaultConverterManager.registerConverter(new TypeToken<Map<String, Integer>>() {}.getType(), new SimpleConverter(raw -> {
            System.out.println("Called for Map String Integer");
            Map<String, Integer> map = new LinkedHashMap<>();
            if (raw instanceof Map) {
                for (Map.Entry<?, ?> entry : ((Map<?, ?>) raw).entrySet()) {
                    map.put(entry.getKey().toString(), Integer.parseInt(entry.getValue().toString()));
                }
            }
            return map;
        }));

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
        System.out.println("Test Map: " + testConfig.getTestMap());
    }
}
