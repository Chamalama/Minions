package com.cham.minions.Util;

import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;

import java.util.HashSet;
import java.util.Set;

public abstract class RealtimeInventory {
    protected Inventory inventory;
    public static Set<Inventory> inventories = new HashSet<>();
    public RealtimeInventory(String name, int size) {
        this.inventory = Bukkit.createInventory(null, size, name);
        inventories.add(this.inventory);
    }
    public Inventory getInventory() {
        return inventory;
    }
    public static Set<Inventory> getInventories() {
        return inventories;
    }
}

