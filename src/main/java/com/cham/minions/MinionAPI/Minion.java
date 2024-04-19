package com.cham.minions.MinionAPI;


import com.cham.dungeons.Dungeons;
import com.cham.dungeons.Listeners.PlayerListener;
import com.cham.dungeons.Scoreboard.PlayerScoreboard;
import com.cham.dungeons.Util.Config.PlayerData;
import com.cham.minions.Minions;
import net.minecraft.commands.arguments.EntityAnchorArgument;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.phys.Vec3;
import org.bukkit.Bukkit;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_20_R3.entity.CraftEntity;
import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityTargetEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;

import java.util.*;

public interface Minion {
    net.minecraft.world.entity.LivingEntity minionEntity();
    MinionEnum spawnMinionType();
    String minionName();
    ItemStack minionItem();
    MoveControl moveControl();
    boolean unlocked();
    void onDamage(LivingEntity minion, Player user, EntityDamageByEntityEvent e);
    void onDamageReceived(LivingEntity minion, EntityDamageEvent e);
    int attackTime();
    float moveSpeed();
    int coinIncrease();
    int rarity();
    default void tryAI(Minion minion) {
        net.minecraft.world.entity.LivingEntity le = minion.minionEntity();
        PersistentDataContainer pdc = le.getBukkitEntity().getPersistentDataContainer();
        Bukkit.getScheduler().runTaskTimer(Minions.getMinions(), () -> {
            PlayerData data = null;
            UUID id = null;
            for(NamespacedKey key : pdc.getKeys()) {
                id = UUID.fromString(key.getKey());
                break;
            }
            if(id != null) {
                Player owner = Bukkit.getPlayer(id);
                if (le.isAlive() && le.getBukkitLivingEntity().isValid()) {
                    int ticks = minion.minionEntity().getBukkitEntity().getTicksLived();
                    if (owner != null) {
                        data = Dungeons.getDungeons().getPlayerConfig().loadPlayerData(owner.getUniqueId());
                        if (owner.getWorld() != le.getBukkitLivingEntity().getWorld()) {
                            le.remove(net.minecraft.world.entity.Entity.RemovalReason.KILLED);
                        } else {
                            if (((Mob) le).getTarget() == null) {
                                if (owner.getLocation().distance(le.getBukkitLivingEntity().getLocation()) > 1.5) {
                                    moveControl().setWantedPosition(owner.getX(), owner.getY(), owner.getZ(), moveSpeed());
                                }
                                if (le.getBukkitLivingEntity().getLocation().distance(owner.getLocation()) > 10) {
                                    le.teleportTo(owner.getX(), owner.getY(), owner.getZ());
                                }
                            }
                        }
                        for (Entity entity : owner.getNearbyEntities(5, 5, 5)) {
                            if (!entity.hasMetadata("MINION") && !entity.hasMetadata("OWNER")) {
                                if (!entity.isDead() && entity.isValid()) {
                                    if (entity instanceof LivingEntity) {
                                        CraftEntity craftEntity = (CraftEntity) entity;
                                        net.minecraft.world.entity.LivingEntity nmsTarget = (net.minecraft.world.entity.LivingEntity) craftEntity.getHandle();
                                        ((Mob) le).setTarget(nmsTarget, EntityTargetEvent.TargetReason.CLOSEST_ENTITY, true);
                                        break;
                                    }
                                }
                            }
                        }
                    } else {
                        le.remove(net.minecraft.world.entity.Entity.RemovalReason.DISCARDED);
                    }
                    LivingEntity bukkitMinion = le.getBukkitLivingEntity();
                    if (((Mob) le).getTarget() != null) {
                        LivingEntity target = ((Mob) le).getTarget().getBukkitLivingEntity();
                        if (((Mob) le).getTarget().isDeadOrDying()) {
                            ((Mob) le).setTarget(null);
                        }
                        if (target.isValid() && !target.isDead()) {
                            le.lookAt(EntityAnchorArgument.Anchor.EYES, new Vec3(target.getX(), target.getY() + 1.5, target.getZ()));
                            if (bukkitMinion.getLocation().distance(target.getLocation()) > 2.5) {
                                moveControl().setWantedPosition(target.getX(), target.getY(), target.getZ(), moveSpeed());
                            }
                            if (ticks % attackTime() == 0) {
                                bukkitMinion.attack(target);
                                if (data != null) {
                                    data.setCoins(data.getCoins() + 1 + data.getCoinBooster() + coinIncrease());
                                    data.setXp(data.getXp() + 1 + data.getXpBooster());
                                    PlayerListener.tryLevelUp(data, owner);
                                    Dungeons.getDungeons().getPlayerConfig().savePlayerData(data);
                                    PlayerScoreboard.updateScoreboard(owner);
                                }
                            }
                        }
                    }
                }
            }
        }, 0L, 1L);
    }
}
