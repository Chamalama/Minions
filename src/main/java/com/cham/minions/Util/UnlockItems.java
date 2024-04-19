package com.cham.minions.Util;

import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;

public class UnlockItems {

    public static ItemStack pigUnlock() {
        return MinionUtil.buildUnlockItem("http://textures.minecraft.net/texture/4a37ec8fa9a7329723349c4889864e3eaa51b0c1877e54bd2bb3e0ae0d099fa6",
                ChatColor.RED + ChatColor.BOLD.toString() + "Pig Minion", ChatColor.RED + "Unlocks the Pig Minion");
    }

    public static ItemStack cowUnlock() {
        return MinionUtil.buildUnlockItem("http://textures.minecraft.net/texture/387810fcf5f3a27dda4580bdc761867d14487fdecf0e138c5830d92be33b48a2",
                ChatColor.WHITE + ChatColor.BOLD.toString() + "Cow Minion", ChatColor.WHITE + "Unlocks the Cow Minion");
    }

}
