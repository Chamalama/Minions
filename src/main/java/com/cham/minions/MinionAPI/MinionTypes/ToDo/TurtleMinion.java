package com.cham.minions.MinionAPI.MinionTypes.ToDo;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class TurtleMinion extends Turtle implements Minion {
    public TurtleMinion(Location location) {
        super(EntityType.TURTLE, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.GREEN + ChatColor.BOLD.toString() + "Turtle Minion");
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
        return MinionEnum.TURTLE_MINION;
    }

    @Override
    public String minionName() {
        return "Turtle Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/c029cfe00d55105a7e9e1b6c13f684083d60e45f5131a1a49f3f0f175afcccc6",
                ChatColor.GREEN + ChatColor.BOLD.toString() + "Turtle Minion", 1, 2, 250, 3, this.unlocked());
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
        e.setDamage(e.getDamage() / 2);
    }

    @Override
    public int attackTime() {
        return 50;
    }

    @Override
    public float moveSpeed() {
        return 0.5F;
    }

    @Override
    public int coinIncrease() {
        return 50;
    }

    @Override
    public int rarity() {
        return 9;
    }
}
