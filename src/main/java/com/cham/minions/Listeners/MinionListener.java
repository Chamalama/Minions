package com.cham.minions.Listeners;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.Minions;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;

@SuppressWarnings("deprecation")
public class MinionListener implements Listener {

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (!(event.getDamager() instanceof LivingEntity)) {
            return;
        }
        if(event.getDamager() instanceof Player) {
            if(event.getEntity().hasMetadata("MINION_TYPE")) {
                event.setCancelled(true);
            }
        }
        LivingEntity le = (LivingEntity) event.getDamager();
        if (le.getCustomName() != null) {
            Minion minion = Minions.getMinion(ChatColor.stripColor(le.getCustomName().toLowerCase()));
            if (minion != null) {
                minion.onDamage(le, null, event);
            }
        }
    }

    @EventHandler
    public void onReceiveDamage(EntityDamageEvent e) {
        if(e.getEntity() instanceof LivingEntity) {
            LivingEntity le = (LivingEntity) e.getEntity();
            if (le.getCustomName() != null) {
                Minion minion = Minions.getMinion(ChatColor.stripColor(le.getCustomName().toLowerCase()));
                if(minion != null) {
                    if(e.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                        e.setCancelled(true);
                    }
                    minion.onDamageReceived(le, e);
                }
            }
        }
    }

    @EventHandler
    public void onDeath(EntityDeathEvent event) {
        if(event.getEntity().hasMetadata("MINION_TYPE")) {
            event.setDroppedExp(0);
            event.getDrops().clear();
        }
    }
}