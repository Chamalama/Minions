package com.cham.minions;

import com.cham.minions.Commands.MinionCMD;
import com.cham.minions.Listeners.MinionListener;
import com.cham.minions.Listeners.PlayerListener;
import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.MinionAPI.MinionRegister;
import com.cham.minions.MinionAPI.MinionTypes.Finished.*;
import com.cham.minions.MinionAPI.MinionTypes.Finished.FoxMinion;
import com.cham.minions.MinionAPI.MinionTypes.Finished.SkeletonHorseMinion;
import com.cham.minions.MinionAPI.MinionTypes.Finished.PolarBearMinion;
import com.cham.minions.MinionAPI.MinionTypes.Finished.PiglinBruteMinion;
import com.cham.minions.MinionAPI.MinionTypes.Finished.HoglinMinion;
import com.cham.minions.MinionAPI.PlayerMinionData;
import com.cham.minions.Util.MinionInventory;
import net.minecraft.world.entity.Entity;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
public final class Minions extends JavaPlugin {

    public static Minions minions;
    private PlayerMinionData data;
    private MinionRegister register;
    public static Map<Player, Inventory> playerMinionInventory = new HashMap<>();
    public static Map<String, Minion> minionMap = new HashMap<>();
    @Override
    public void onEnable() {
        minions = this;
        data = new PlayerMinionData(this);
        register = new MinionRegister(this);
        Location loc = new Location(Bukkit.getWorld("Dungeon"), 80000, 250, 80000);
        registerMinions(new ChickenMinion(loc), new CowMinion(loc), new PigMinion(loc), new SheepMinion(loc), new WolfMinion(loc), new ZombieMinion(loc), new FoxMinion(loc),
                new SkeletonHorseMinion(loc), new SkeletonMinion(loc), new SlimeMinion(loc), new SnifferMinion(loc), new RavagerMinion(loc), new PolarBearMinion(loc), new PillagerMinion(loc),
                new PandaMinion(loc), new MooshroomMinion(loc), new TurtleMinion(loc), new PiglinMinion(loc), new MagmaSlimeMinion(loc), new PiglinBruteMinion(loc), new IronGolemMinion(loc),
                new HoglinMinion(loc), new GoatMinion(loc), new FrogMinion(loc), new EvokerMinion(loc), new EndermiteMinion(loc), new EndermanMinion(loc), new DonkeyMinion(loc),
                new CreeperMinion(loc), new CaveSpiderMinion(loc), new SpiderMinion(loc), new StriderMinion(loc), new WardenMinion(loc), new VindicatorMinion(loc), new VillagerMinion(loc),
                new SnowGolemMinion(loc), new SilverfishMinion(loc), new WitchMinion(loc), new WitherMinion(loc), new WitherSkeletonMinion(loc), new HuskMinion(loc), new ZoglinMinion(loc),
                new WardenMinion(loc));
        registerListeners();
        registerCommands();
    }

    @Override
    public void onDisable() {
        minionMap.clear();
        MinionEnum.minionEntity.forEach(livingEntity -> livingEntity.remove(Entity.RemovalReason.DISCARDED));
    }

    private void registerCommands() {
        getCommand("minions").setExecutor(new MinionCMD());
    }
    private void registerListeners() {
        getServer().getPluginManager().registerEvents(new PlayerListener(), this);
        getServer().getPluginManager().registerEvents(new MinionListener(), this);
    }

    public static Minions getMinions() {
        return minions;
    }

    public PlayerMinionData getData() {
        return data;
    }

    public static void registerMinions(Minion m) {
        minionMap.put(m.minionName().toLowerCase(), m);
    }

    private void registerMinions(Minion... minions) {
        for(Minion m : minions) {
            minionMap.put(m.minionName().toLowerCase(), m);
        }
    }
    public static Minion getMinion(String name) {
        return minionMap.get(name.toLowerCase());
    }
    public static Minion getMinionFromEntity(LivingEntity le) {
        if (le != null) {
            if(le.getCustomName().contains(ChatColor.GRAY.toString())) {
                String displayName = ChatColor.stripColor(le.getCustomName());
                String formatted = displayName.substring(0, displayName.lastIndexOf(" "));
                return minionMap.get(formatted.toLowerCase());
            }else{
                return null;
            }
        }else{
            return null;
        }
    }

    public static boolean isMinionItem(ItemStack itemStack) {
        if(itemStack != null && itemStack.getItemMeta() != null) {
            String displayName = ChatColor.stripColor(itemStack.getItemMeta().getDisplayName());
            return minionMap.containsKey(displayName.toLowerCase());
        }
        return false;
    }

    public void populateMapDefault(Player player) {
        if (!playerMinionInventory.containsKey(player)) {
            playerMinionInventory.put(player, new MinionInventory(player).getInventory());
        }
    }
    public static Map<Player, Inventory> getPlayerMinionInventory() {
        return playerMinionInventory;
    }
    public MinionRegister getRegister() {
        return register;
    }
}
