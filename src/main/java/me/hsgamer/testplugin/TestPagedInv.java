package me.hsgamer.testplugin;

import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import plugily.projects.minigamesbox.inventory.common.item.ClickableItem;
import plugily.projects.minigamesbox.inventory.common.item.ItemMap;
import plugily.projects.minigamesbox.inventory.common.item.SimpleClickableItem;
import plugily.projects.minigamesbox.inventory.paged.PagedFastInv;

public class TestPagedInv extends PagedFastInv {
    public TestPagedInv() {
        super(27, "Test Paged Inventory");
        setup();
        refresh();
    }

    private void setup() {
        ItemMap map1 = createNewPage();
        map1.setItem(0, new CountUpClickableItem());
        map1.setItem(8, new CountUpClickableItem());

        ItemMap map2 = createNewPage();
        map2.setItem(0, new SimpleClickableItem(new ItemStack(Material.STONE), event -> event.getWhoClicked().sendMessage("Stone")));
        map2.setItem(1, new SimpleClickableItem(new ItemStack(Material.TNT), event -> event.getWhoClicked().sendMessage("TNT")));

        setLastLineSequence((slot, item) -> {
            if (slot == 0) {
                return new SimpleClickableItem(new ItemStack(Material.RED_STAINED_GLASS_PANE), event -> {
                    setCurrentPage(getCurrentPage() - 1);
                    refresh();
                });
            } else if (slot == 8) {
                return new SimpleClickableItem(new ItemStack(Material.GREEN_STAINED_GLASS_PANE), event -> {
                    setCurrentPage(getCurrentPage() + 1);
                    refresh();
                });
            } else {
                return ClickableItem.of(new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
            }
        });
    }
}
