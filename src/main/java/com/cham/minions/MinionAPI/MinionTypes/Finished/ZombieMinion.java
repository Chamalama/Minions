package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Locale;

public class ZombieMinion extends Zombie implements Minion {
    public ZombieMinion(Location location) {
        super(EntityType.ZOMBIE, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Zombie Minion");
        MinionUtil.setDamage(this, 6);
        this.goalSelector.getAvailableGoals().clear();
        this.targetSelector.getAvailableGoals().clear();
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return null;
    }

    @Override
    public String minionName() {
        return "Zombie Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/a73f7d6d82c9820cd53acd88074117288691043370ee0b777f2fc27a551eadfc", ChatColor.DARK_GREEN + ChatColor.BOLD.toString() + "Zombie Minion",
                1, 6, 75, 2, this.unlocked());
    }

    @Override
    public MoveControl moveControl() {
        return this.moveControl;
    }

    @Override
    public boolean unlocked() {
        return false;
    }

    @Override
    public void onDamage(Player owner, Minion minion) {

    }

    @Override
    public void onDamageReceived(org.bukkit.entity.LivingEntity minion, EntityDamageEvent e) {

    }

    @Override
    public int attackTime() {
        return 17;
    }

    @Override
    public float moveSpeed() {
        return 1.25F;
    }

    @Override
    public int coinIncrease() {
        return 2;
    }

    @Override
    public int rarity() {
        return 9;
    }
}
