package com.cham.minions.MinionAPI.MinionTypes.ToDo;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Blaze;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PrinceBlazeMinion extends Blaze implements Minion {

    public PrinceBlazeMinion(Location location) {
        super(EntityType.BLAZE, ((CraftWorld)location.getWorld()).getHandle());
        this.getBukkitLivingEntity().setCustomName(ChatColor.RED + ChatColor.BOLD.toString() + "Prince Blaze Minion");
        MinionUtil.setDamage(this, 12);
        this.getBukkitLivingEntity().addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, PotionEffect.INFINITE_DURATION, 0, false, false));
        this.goalSelector.getAvailableGoals().clear();
        this.targetSelector.getAvailableGoals().clear();
        this.targetSelector.getRunningGoals().close();
        Minion.super.tryAI(this);
    }


    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.PRINCE_BLAZE_MINION;
    }

    @Override
    public String minionName() {
        return "Prince Blaze Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/edbcd8423e3eaec7bb1eb4204dfd5d6af5bbd877473ef12f405f8e3f3840161c",
                ChatColor.RED + ChatColor.BOLD.toString() + "Prince Blaze Minion", 1, 10, 500, 7, this.unlocked());
    }

    @Override
    public MoveControl moveControl() {
        return this.moveControl;
    }

    @Override
    public boolean unlocked() {
        return true;
    }

    @Override
    public void onDamage(Player owner, Minion minion) {

    }

    @Override
    public void onDamageReceived(org.bukkit.entity.LivingEntity minion, EntityDamageEvent e) {
        if(!(e instanceof EntityDamageByEntityEvent)) {
            if(e.getCause() == EntityDamageEvent.DamageCause.DROWNING) {
                e.setCancelled(true);
            }
        }
    }

    @Override
    public int attackTime() {
        return 10;
    }

    @Override
    public float moveSpeed() {
        return 2.5F;
    }

    @Override
    public int coinIncrease() {
        return 20;
    }

    @Override
    public int rarity() {
        return 10;
    }


}
