package me.hsgamer.testplugin;

import fr.mrmicky.fastinv.FastInv;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;

public final class TestPlugin extends BasePlugin implements Listener {
    private FastInv inv = new FastInv(18, "&7&lTestPlugin");

    @Override
    public void onEnable() {
        super.onEnable();
        inv.setItem(0, new ItemStack(Material.STONE));
        inv.setItem(1, new ItemStack(Material.STONE), event -> event.getWhoClicked().sendMessage("&a&lTestPlugin"));
        Bukkit.getPluginManager().registerEvents(this, this);
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Bukkit.getScheduler().runTask(this, () -> inv.open(event.getPlayer()));
    }
}
