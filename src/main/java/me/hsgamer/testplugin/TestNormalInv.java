package me.hsgamer.testplugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import plugily.projects.minigamesbox.inventory.common.item.SimpleClickableItem;
import plugily.projects.minigamesbox.inventory.normal.NormalFastInv;

public class TestNormalInv extends NormalFastInv {
    public TestNormalInv() {
        super(27, "Test Normal Inventory");
        setup();
        refresh();
    }

    private void setup() {
        setItem(0, new SimpleClickableItem(new ItemStack(Material.STONE), event -> event.getWhoClicked().sendMessage("HELLO")));
        setItem(1, new CountUpClickableItem());
        setItem(2, new CountUpClickableItem());
        setItem(26, new SimpleClickableItem(new ItemStack(Material.BARRIER), event -> event.getWhoClicked().closeInventory()));
    }
}
