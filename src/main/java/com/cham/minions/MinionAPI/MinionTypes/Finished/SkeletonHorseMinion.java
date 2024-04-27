package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.horse.SkeletonHorse;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class SkeletonHorseMinion extends SkeletonHorse implements Minion {
    public SkeletonHorseMinion(Location location) {
        super(EntityType.SKELETON_HORSE, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Skeleton Horse Minion");
        MinionUtil.setDamage(this, 12);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.SKELETON_HORSE_MINION;
    }

    @Override
    public String minionName() {
        return "Skeleton Horse Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/d299d95bfb86e61ea08ea99bc3e0430d2fd45891ee7eec4a46c811e5185c1905", ChatColor.WHITE + ChatColor.BOLD.toString() + "Skeleton Horse Minion",
                1, 12, 105, 2, this.unlocked());
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
        return 15;
    }

    @Override
    public float moveSpeed() {
        return 2.5F;
    }

    @Override
    public int coinIncrease() {
        return 5;
    }

    @Override
    public int rarity() {
        return 12;
    }
}
