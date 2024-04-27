package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Skeleton;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class SkeletonMinion extends Skeleton implements Minion {
    public SkeletonMinion(Location location) {
        super(EntityType.SKELETON, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Skeleton Minion");
        MinionUtil.setDamage(this, 10);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.SKELETON_MINION;
    }

    @Override
    public String minionName() {
        return "Skeleton Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/707393439f016a2aca7c1a2c7f68b83ec2d3056581bc031eb7bd50cc5e1c70b4",
                ChatColor.WHITE + ChatColor.BOLD.toString() + "Skeleton Minion",
                1, 10, 65, 2, this.unlocked());
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
        return 1.35F;
    }

    @Override
    public int coinIncrease() {
        return 1;
    }

    @Override
    public int rarity() {
        return 18;
    }
}
