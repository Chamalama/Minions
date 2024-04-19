package com.cham.minions.Util;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.Minions;
import org.bukkit.entity.Player;

import java.util.*;

public class MinionInventory extends RealtimeInventory{
    public MinionInventory(Player player) {
        super(player.getName() + "'s Minions", 54);
        addMinionsToInventory();
    }

    private void addMinionsToInventory() {
        List<Minion> sorted = new ArrayList<>(Minions.minionMap.values());
        sorted.sort(Comparator.comparingInt(Minion::rarity));
        for(Minion minion : sorted) {
            if(!this.inventory.contains(minion.minionItem())) {
                this.inventory.addItem(minion.minionItem());
            }
        }
    }
}
