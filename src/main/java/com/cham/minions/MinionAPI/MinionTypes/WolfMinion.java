package com.cham.minions.MinionAPI.MinionTypes;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.Wolf;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class WolfMinion extends Wolf implements Minion {
    public WolfMinion(Location location) {
        super(EntityType.WOLF, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Wolf Minion");
        MinionUtil.setDamage(this, 5);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.WOLF_MINION;
    }

    @Override
    public String minionName() {
        return "Wolf Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/8c601673c09974e84fd6c06c6e63075b2c265e1df8f073e5f5c450bb13c638bc", ChatColor.WHITE + ChatColor.BOLD.toString() + "Wolf Minion",
                6, 1, 70, 2, this.unlocked());
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
        return 10;
    }

    @Override
    public float moveSpeed() {
        return 2.5F;
    }

    @Override
    public int coinIncrease() {
        return 1;
    }

    @Override
    public int rarity() {
        return 5;
    }
}
