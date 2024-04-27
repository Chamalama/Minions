package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.Fox;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class FoxMinion extends Fox implements Minion {
    public FoxMinion(Location location) {
        super(EntityType.FOX, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.GOLD + ChatColor.BOLD.toString() + "Fox Minion");
        MinionUtil.setDamage(this, 9);
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
        return MinionEnum.FOX_MINION;
    }

    @Override
    public String minionName() {
        return "Fox Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/88c235f714fa42034bc4c99c58c9efbe7a5ed9ce01d207b8ec5cf47bf246617a", ChatColor.GOLD + ChatColor.BOLD.toString() + "Fox Minion",
                1, 9, 35, 2, this.unlocked());
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
        return 20;
    }

    @Override
    public float moveSpeed() {
        return 2.2F;
    }

    @Override
    public int coinIncrease() {
        return 10;
    }

    @Override
    public int rarity() {
        return 11;
    }
}
