package com.cham.minions.MinionAPI.MinionTypes;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.Cow;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class CowMinion extends Cow implements Minion {
    public CowMinion(Location location) {
        super(EntityType.COW, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Cow Minion");
        MinionUtil.setDamage(this, MinionUtil.getMinionDamage(this.minionItem()));
        this.goalSelector.getAvailableGoals().clear();
        Minion.super.tryAI(this);
    }

    @Override
    public net.minecraft.world.entity.LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.COW_MINION;
    }

    @Override
    public String minionName() {
        return "Cow Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/387810fcf5f3a27dda4580bdc761867d14487fdecf0e138c5830d92be33b48a2", ChatColor.WHITE + ChatColor.BOLD.toString() + "Cow Minion",
                3, 3, 30, 1, this.unlocked());
    }

    @Override
    public boolean unlocked() {
        return false;
    }

    @Override
    public MoveControl moveControl() {
        return this.moveControl;
    }

    @Override
    public void onDamage(Player owner, Minion minion) {

    }

    @Override
    public void onDamageReceived(LivingEntity minion, EntityDamageEvent e) {

    }

    @Override
    public int attackTime() {
        return 40;
    }

    @Override
    public float moveSpeed() {
        return 1.5F;
    }

    @Override
    public int coinIncrease() {
        return 1;
    }

    @Override
    public int rarity() {
        return 3;
    }
}
