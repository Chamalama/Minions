package com.cham.minions.Commands;

import com.cham.minions.Minions;
import com.cham.minions.Util.MinionInventory;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class MinionCMD implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {

        Player p = (Player) commandSender;
        p.openInventory(Minions.getPlayerMinionInventory().get(p));

        return true;
    }
}
