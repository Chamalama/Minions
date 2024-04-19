package com.cham.minions.MinionAPI;

import com.cham.minions.Minions;
import com.cham.minions.Util.MinionInventory;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

public class PlayerMinionData {

    private final File dataFolder;
    public PlayerMinionData(Minions minions) {
        this.dataFolder = minions.getDataFolder();
    }

    public void saveData(UUID uuid) {
        File file = new File(dataFolder, uuid.toString() + ".yml");
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        Player p = Bukkit.getPlayer(uuid);
        Inventory inventory = Minions.getPlayerMinionInventory().get(p);
        ConfigurationSection section = config.createSection("Items");
        for(int i = 0; i < inventory.getSize(); i++) {
            ItemStack is = inventory.getItem(i);
            if(is != null && is.getType() != Material.AIR) {
                section.set("Item_" + i, is);
            }
            if(inventory.getItem(i) == null) {
                section.set("Item_" + i, null);
            }
        }
        try{
            config.save(file);
        }catch (IOException e) {
            Bukkit.getLogger().info("[Minions] File error encountered");
        }
    }

    public void loadVault(UUID uuid) {
        File file = new File(dataFolder,uuid.toString() + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection section = configuration.getConfigurationSection("Items");
        Player p = Bukkit.getPlayer(uuid);
        assert p != null;
        Inventory inventory = new MinionInventory(p).getInventory();
        for(String keys : section.getKeys(false)) {
            if(keys.startsWith("Item_")) {
                int index = Integer.parseInt(keys.replace("Item_", ""));
                ItemStack is = section.getItemStack(keys);
                inventory.setItem(index, is);
            }
        }
        Minions.getPlayerMinionInventory().put(p, inventory);
    }


    public boolean sectionNotNull(UUID player) {
        File file = new File(dataFolder, player.toString() + ".yml");
        YamlConfiguration configuration = YamlConfiguration.loadConfiguration(file);
        ConfigurationSection section = configuration.getConfigurationSection("Items");
        return section != null;
    }

}
