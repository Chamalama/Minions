package com.cham.minions.Listeners;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.MinionAPI.MinionRegister;
import com.cham.minions.MinionAPI.MinionTypes.PrinceBlazeMinion;
import com.cham.minions.MinionAPI.PlayerMinionData;
import com.cham.minions.Minions;
import com.cham.minions.Util.MinionInventory;
import com.cham.minions.Util.MinionUtil;
import com.cham.minions.Util.RealtimeInventory;
import net.minecraft.world.entity.Entity;
import org.bukkit.*;
import org.bukkit.entity.Blaze;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.*;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.*;

@SuppressWarnings("deprecation")
public class PlayerListener implements Listener {

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        Player p = event.getPlayer();
        Minions.getMinions().populateMapDefault(p);
        if(Minions.getMinions().getData().sectionNotNull(p.getUniqueId())) {
            Minions.getMinions().getData().loadVault(p.getUniqueId());
        }
        p.setMetadata("OWNER", new FixedMetadataValue(Minions.getMinions(), ""));
        Minions.getMinions().getData().saveData(p.getUniqueId());
    }
    @EventHandler(
            priority = EventPriority.LOWEST
    )
    public void onQuit(PlayerQuitEvent event) {
        Player p = event.getPlayer();
        List<Minion> minions = Minions.getMinions().getRegister().getPlayerMinions().get(p.getUniqueId());
        if(minions != null && !minions.isEmpty()) {
            for (Minion m : minions) {
                m.minionEntity().setRemoved(Entity.RemovalReason.DISCARDED);
            }
            minions.clear();
        }
        Minions.getMinions().getData().saveData(p.getUniqueId());
    }
    @EventHandler
    public void onMinionInv(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        MinionRegister minionRegister = Minions.getMinions().getRegister();
        if(RealtimeInventory.getInventories().contains(event.getInventory())) {
            if (event.getView().getTitle().contains(" Minions")) {
                ItemStack is = event.getCurrentItem();
                if (is != null) {
                    minionRegister.getPlayerMinions().computeIfAbsent(p.getUniqueId(), k -> new ArrayList<>());
                    if (MinionUtil.isMinionUnlocked(is)) {
                        if (event.getClick() == ClickType.LEFT) {
                            if (minionRegister.getPlayerMinions().get(p.getUniqueId()).size() < 4) {
                                Minion toSummon = Minions.getMinion(ChatColor.stripColor(is.getItemMeta().getDisplayName()).toLowerCase());
                                MinionUtil.setDamage(toSummon.minionEntity(), MinionUtil.getMinionDamage(is));
                                MinionUtil.setHealth(toSummon.minionEntity(), MinionUtil.getMinionHealth(is));
                                int level = MinionUtil.getMinionLevel(is);
                                MinionEnum.spawnMinion(p.getLocation(), toSummon.spawnMinionType(), p, toSummon, level);
                            } else {
                                p.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "[!] " + ChatColor.RED + "No more minion slots!");
                            }
                        }
                    } else {
                        p.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "[!] " + ChatColor.RED + "Minion not unlocked!");
                    }
                }
                event.setResult(Event.Result.DENY);
            }
        }
    }
    @EventHandler
    public void onPlayerRedeem(PlayerInteractEvent event) {
        Player p = event.getPlayer();
        PlayerMinionData playerMinionData = Minions.getMinions().getData();
        Inventory minionInventory = Minions.getPlayerMinionInventory().get(p);
        ItemStack is = p.getInventory().getItemInMainHand();
        if (is.getType() != Material.AIR) {
            for (ItemStack contents : minionInventory.getContents()) {
                if (contents != null && Minions.isMinionItem(is)) {
                    Minion minion = Minions.getMinion(ChatColor.stripColor(is.getItemMeta().getDisplayName()));
                    if (event.getHand() == EquipmentSlot.HAND && event.getAction() == Action.RIGHT_CLICK_AIR) {
                        Minion toCompare = Minions.getMinion(ChatColor.stripColor(contents.getItemMeta().getDisplayName()));
                        if (minion == toCompare) {
                            if (!MinionUtil.isMinionUnlocked(contents)) {
                                MinionUtil.unlockItem(contents);
                                if (is.getAmount() > 1) {
                                    is.setAmount(is.getAmount() - 1);
                                } else {
                                    p.getInventory().remove(is);
                                }
                                p.playSound(p.getLocation(), Sound.UI_TOAST_CHALLENGE_COMPLETE, 1.0F, 1.0F);
                                p.sendTitle(ChatColor.YELLOW + ChatColor.BOLD.toString() + "UNLOCKED NEW MINION", ChatColor.YELLOW + ChatColor.BOLD.toString() + minion.minionName(), 20, 20, 20);
                            } else {
                                if (MinionUtil.getMinionLevel(is) < 50) {
                                    MinionUtil.upgradeMinion(contents, 1, 1, 1);
                                    if (is.getAmount() > 1) {
                                        is.setAmount(is.getAmount() - 1);
                                    } else {
                                        p.getInventory().remove(is);
                                    }
                                    p.playSound(p.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1.0F, 1.0F);
                                    p.sendTitle(ChatColor.AQUA + ChatColor.BOLD.toString() + "UPGRADED MINION", ChatColor.AQUA + ChatColor.BOLD.toString() + minion.minionName(), 20, 20, 20);
                                }else{
                                    p.sendMessage(ChatColor.RED + "(!) This minion is max level!");
                                }
                            }
                            playerMinionData.saveData(p.getUniqueId());
                            break;
                        }
                    }
                }
            }
        }
    }

    @EventHandler
    public void onMinionInteract(PlayerInteractEntityEvent event) {
        Player p = event.getPlayer();
        MinionRegister register = Minions.getMinions().getRegister();
        List<Minion> playerMinions = register.getPlayerMinions().get(p.getUniqueId());
        if (event.getRightClicked() instanceof LivingEntity) {
            LivingEntity entity = (LivingEntity) event.getRightClicked();
            if (event.getHand() == EquipmentSlot.HAND) {
                if (playerMinions != null) {
                    Minion minion = Minions.getMinionFromEntity(entity);
                    PersistentDataContainer pdc = entity.getPersistentDataContainer();
                    if(playerMinions.contains(minion)) {
                        if(pdc.has(new NamespacedKey(Minions.getMinions(), p.getUniqueId().toString()))) {
                            entity.remove();
                            playerMinions.remove(minion);
                        }
                    }
                }
            }
        }
    }
    @EventHandler(priority = EventPriority.MONITOR)
    public void onWorldChange(PlayerChangedWorldEvent event) {
        Player p = event.getPlayer();
        MinionRegister register = Minions.getMinions().getRegister();
        List<Minion> minionsList = register.getPlayerMinions().get(p.getUniqueId());
        minionsList.clear();
    }
}
