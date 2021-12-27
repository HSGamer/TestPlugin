package me.hsgamer.testplugin;

import org.bukkit.Material;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import plugily.projects.minigamesbox.inventory.common.RefreshableFastInv;
import plugily.projects.minigamesbox.inventory.common.item.ClickableItem;

public class CountUpClickableItem implements ClickableItem {
    private int count = 1;

    @Override
    public ItemStack getItem() {
        ItemStack item = new ItemStack(Material.TNT);
        item.setAmount(count);
        return item;
    }

    @Override
    public void onClick(InventoryClickEvent inventoryClickEvent) {
        count++;
        if (count > 64) {
            count = 1;
        }
        InventoryHolder holder = inventoryClickEvent.getInventory().getHolder();
        if (holder instanceof RefreshableFastInv) {
            ((RefreshableFastInv) holder).refresh();
        }
    }
}
