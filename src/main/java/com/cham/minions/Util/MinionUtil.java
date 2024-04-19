package com.cham.minions.Util;

import com.cham.minions.Minions;
import com.destroystokyo.paper.profile.PlayerProfile;
import net.minecraft.network.chat.Component;
import net.minecraft.util.profiling.ProfilerFiller;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.GoalSelector;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.profile.PlayerTextures;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class MinionUtil {
    public static void setup(LivingEntity livingEntity, String name) {
        livingEntity.setCustomNameVisible(true);
        livingEntity.setCustomName(Component.nullToEmpty(name));
        livingEntity.getBukkitLivingEntity().setMetadata("MINION_TYPE", new FixedMetadataValue(Minions.getMinions(), ""));
        livingEntity.getAttributes().registerAttribute(Attributes.ATTACK_DAMAGE);
    }
    public static void setDamage(LivingEntity livingEntity, double dmg) {
        livingEntity.getBukkitLivingEntity().getAttribute(Attribute.GENERIC_ATTACK_DAMAGE).setBaseValue(dmg);
    }
    public static void setHealth(LivingEntity livingEntity, double hp) {
        livingEntity.getBukkitLivingEntity().getAttribute(Attribute.GENERIC_MAX_HEALTH).setBaseValue(hp);
    }
    public static void setArmor(LivingEntity livingEntity, double armor) {
        livingEntity.getBukkitLivingEntity().getAttribute(Attribute.GENERIC_ARMOR).setBaseValue(armor);
    }
    public static void setKnockbackResistance(LivingEntity livingEntity, double resist) {
        livingEntity.getBukkitLivingEntity().getAttribute(Attribute.GENERIC_KNOCKBACK_RESISTANCE).setBaseValue(resist);
    }
    public static void setSpeed(LivingEntity livingEntity, double speed) {
        livingEntity.getBukkitLivingEntity().getAttribute(Attribute.GENERIC_MOVEMENT_SPEED).setBaseValue(speed);
    }

    public static ItemStack buildMinionItem(String url, String name, int damage, int defense, int health, int rarity, boolean unlocked) {
        ItemStack is = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) is.getItemMeta();
        PlayerProfile playerProfile = Bukkit.createProfile(UUID.randomUUID());
        PlayerTextures textures = playerProfile.getTextures();
        try {
            textures.setSkin(URI.create(url).toURL());
        }catch (IOException e) {
            Bukkit.getLogger().info("[BossAPI] Skull builder issue.\n" + e.getMessage());
        }
        meta.setDisplayName(name);
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        lore.add(0, ChatColor.RED + "◼ Damage: " + damage);
        lore.add(1, ChatColor.YELLOW + "◼ Defense: " + defense);
        lore.add(2, ChatColor.GREEN + "◼ Health: " + health);
        lore.add(3, "");
        String s = unlocked ? ChatColor.GRAY + "◼ Unlocked: " + ChatColor.GREEN + "✔" : ChatColor.GRAY + "Unlocked: " + ChatColor.RED + "✘";
        lore.add(4, s);
        lore.add(5, "");
        lore.add(6, getColorForRarity(rarity));
        playerProfile.setTextures(textures);
        meta.setPlayerProfile(playerProfile);
        meta.setLore(lore);
        is.setItemMeta(meta);
        return is;
    }

    public static int getMinionDamage(ItemStack is) {
        if(is != null && is.getItemMeta() != null && is.getItemMeta().hasLore()) {
            List<String> lore = is.getItemMeta().getLore();
            String damageString = ChatColor.stripColor(lore.get(0).substring(lore.get(0).lastIndexOf(" ")).replace(" ", ""));
            return Integer.parseInt(damageString);
        }
        return 0;
    }
    public static int getMinionDefense(ItemStack is) {
        if(is != null && is.getItemMeta() != null && is.getItemMeta().hasLore()) {
            List<String> lore = is.getItemMeta().getLore();
            String damageString = ChatColor.stripColor(lore.get(1).substring(lore.get(1).lastIndexOf(" ")).replace(" ", ""));
            return Integer.parseInt(damageString);
        }
        return 0;
    }

    public static int getMinionHealth(ItemStack is) {
        if(is != null && is.getItemMeta() != null && is.getItemMeta().hasLore()) {
            List<String> lore = is.getItemMeta().getLore();
            String damageString = ChatColor.stripColor(lore.get(2).substring(lore.get(2).lastIndexOf(" ")).replace(" ", ""));
            return Integer.parseInt(damageString);
        }
        return 0;
    }

    public static boolean isMinionUnlocked(ItemStack is) {
        if(is != null && is.getItemMeta() != null && is.getItemMeta().hasLore()) {
            List<String> lore = is.getItemMeta().getLore();
            String boolString = lore.get(4);
            return boolString.contains(ChatColor.GREEN.toString());
        }
        return false;
    }
    public static String getColorForRarity(int rarity) {
        switch (rarity) {
            case 1:
                return ChatColor.WHITE + ChatColor.BOLD.toString() + "◼ RARITY: Common";
            case 2:
                return ChatColor.GREEN + ChatColor.BOLD.toString() + "◼ RARITY: Uncommon";
            case 3:
                return ChatColor.BLUE + ChatColor.BOLD.toString() + "◼ RARITY: Rare";
            case 4:
                return ChatColor.AQUA + ChatColor.BOLD.toString() + "◼ RARITY: Ultra Rare";
            case 5:
                return ChatColor.YELLOW + ChatColor.BOLD.toString() + "◼ RARITY: EXOTIC";
            case 6:
                return ChatColor.GOLD + ChatColor.BOLD.toString() + "◼ RARITY: LEGENDARY";
        }
        return "";
    }

    public static int getRarityFromLore(ItemStack is) {
        if(is != null && is.getItemMeta() != null) {
            List<String> lore = is.getItemMeta().getLore();
            String s = lore.get(lore.size()-1);
            if(s.contains(ChatColor.WHITE.toString())) {
                return 1;
            }
            if(s.contains(ChatColor.GREEN.toString())) {
                return 2;
            }
            if(s.contains(ChatColor.BLUE.toString())) {
                return 3;
            }
            if(s.contains(ChatColor.AQUA.toString())) {
                return 4;
            }
            if(s.contains(ChatColor.YELLOW.toString())) {
                return 5;
            }
            if(s.contains(ChatColor.GOLD.toString())) {
                return 6;
            }
        }
        return 0;
    }

    public static ItemStack buildUnlockItem(String url, String name, String unlock) {
        ItemStack is = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) is.getItemMeta();
        PlayerProfile playerProfile = Bukkit.createProfile(UUID.randomUUID());
        PlayerTextures textures = playerProfile.getTextures();
        try {
            textures.setSkin(URI.create(url).toURL());
        }catch (IOException e) {
            Bukkit.getLogger().info("[BossAPI] Skull builder issue.\n" + e.getMessage());
        }
        meta.setDisplayName(name);
        List<String> lore = meta.hasLore() ? meta.getLore() : new ArrayList<>();
        lore.add(0, unlock);
        lore.add(1, "");
        lore.add(2, ChatColor.YELLOW + "Right-Click this item in your hotbar");
        lore.add(3, ChatColor.YELLOW + "to unlock this minion");
        lore.add(4, "");
        lore.add(5, ChatColor.RED + ChatColor.BOLD.toString() + "IF THIS MINION IS ALREADY UNLOCKED");
        lore.add(6, ChatColor.RED + ChatColor.BOLD.toString() + "IT WILL BE UPGRADED");
        playerProfile.setTextures(textures);
        meta.setPlayerProfile(playerProfile);
        meta.setLore(lore);
        is.setItemMeta(meta);
        return is;
    }

    public static void unlockItem(ItemStack is) {
        if (is != null && is.getItemMeta() != null) {
            int damage = getMinionDamage(is);
            int defense = getMinionDefense(is);
            int health = getMinionHealth(is);
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            PlayerProfile profile = meta.getPlayerProfile();
            String displayName = meta.getDisplayName();
            URI url = null;
            try {
                 url = profile.getTextures().getSkin().toURI();
            }catch (URISyntaxException e) {
                Bukkit.getLogger().info("[Minions] Couldn't build new Minion Item!");
            }
            String textures = url.toString();
            int rarity = getRarityFromLore(is);
            is.setItemMeta(buildMinionItem(textures, displayName, damage, defense, health, rarity, true).clone().getItemMeta());
        }
    }
    public static void upgradeMinion(ItemStack is, int upgradeDMG, int upgradeDEF, int upgradeHP) {
        if (is != null && is.getItemMeta() != null) {
            int damage = getMinionDamage(is) + upgradeDMG;
            int defense = getMinionDefense(is) + upgradeDEF;
            int health = getMinionHealth(is) + upgradeHP;
            SkullMeta meta = (SkullMeta) is.getItemMeta();
            PlayerProfile profile = meta.getPlayerProfile();
            String displayName = meta.getDisplayName();
            URI url = null;
            try {
                url = profile.getTextures().getSkin().toURI();
            }catch (URISyntaxException e) {
                Bukkit.getLogger().info("[Minions] Couldn't build new Minion Item!");
            }
            String textures = url.toString();
            int rarity = getRarityFromLore(is);
            is.setItemMeta(buildMinionItem(textures, displayName, damage, defense, health, rarity, true).clone().getItemMeta());
        }
    }
}
