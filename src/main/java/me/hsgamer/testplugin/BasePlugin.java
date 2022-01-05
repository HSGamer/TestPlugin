package me.hsgamer.testplugin;

import fr.mrmicky.fastinv.FastInvManager;
import org.bukkit.plugin.java.JavaPlugin;

public class BasePlugin extends JavaPlugin {
    @Override
    public void onEnable() {
        FastInvManager.register(this);
    }
}
