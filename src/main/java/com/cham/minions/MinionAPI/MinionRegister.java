package com.cham.minions.MinionAPI;

import com.cham.minions.Minions;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class MinionRegister {
    private Minions minions;
    private Map<UUID, List<Minion>> playerMinions = new HashMap<>();
    public MinionRegister(Minions minions) {
        this.minions = minions;
    }
    public Map<UUID, List<Minion>> getPlayerMinions() {
        return playerMinions;
    }
}
