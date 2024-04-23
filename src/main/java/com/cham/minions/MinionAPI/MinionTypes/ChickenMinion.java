package com.cham.minions.MinionAPI.MinionTypes;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import com.mojang.math.Transformation;
import net.minecraft.world.entity.Display;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.Chicken;
import net.minecraft.world.phys.AABB;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class ChickenMinion extends Chicken implements Minion {

    public ChickenMinion(Location location) {
        super(EntityType.CHICKEN, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Chicken Minion");
        MinionUtil.setDamage(this, 1);
        this.goalSelector.getAvailableGoals().clear();
        Minion.super.tryAI(this);
    }

    @Override
    public net.minecraft.world.entity.LivingEntity minionEntity() {
        return this;
    }
    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.CHICKEN_MINION;
    }
    @Override
    public String minionName() {
        return "Chicken Minion";
    }
    @Override
    public boolean unlocked() {
        return true;
    }
    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/f79932b5aa62c5acde2b0da7ccb2bae9208a7f3714340b60edb2616cc61d21ca",
                ChatColor.WHITE + ChatColor.BOLD.toString() + "Chicken Minion", 1, 1, 10, 1, this.unlocked());
    }

    @Override
    public MoveControl moveControl() {
        return this.moveControl;
    }

    @Override
    public void onDamage(LivingEntity minion, Player user, EntityDamageByEntityEvent e) {

    }

    @Override
    public void onDamageReceived(LivingEntity minion, EntityDamageEvent e) {

    }

    @Override
    public int attackTime() {
        return new Random().nextInt(15) + 10;
    }

    @Override
    public float moveSpeed() {
        return 3.0F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 1;
    }
}
