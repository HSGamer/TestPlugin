package me.hsgamer.testplugin;

import fr.mrmicky.fastinv.FastInvManager;
import me.hsgamer.hscore.bukkit.baseplugin.BasePlugin;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public final class TestPlugin extends BasePlugin {
    private final TestNormalInv testNormalInv = new TestNormalInv();
    private final TestPagedInv testPagedInv = new TestPagedInv();

    @Override
    public void enable() {
        FastInvManager.register(this);
        registerCommand(new Command("testnormalinv") {
            @Override
            public boolean execute(CommandSender sender, String commandLabel, String[] args) {
                if (sender instanceof Player) {
                    testNormalInv.open((Player) sender);
                    return true;
                }
                return false;
            }
        });
        registerCommand(new Command("testpagedinv") {
            @Override
            public boolean execute(CommandSender sender, String commandLabel, String[] args) {
                if (sender instanceof Player) {
                    testPagedInv.open((Player) sender);
                    return true;
                }
                return false;
            }
        });
    }
}
