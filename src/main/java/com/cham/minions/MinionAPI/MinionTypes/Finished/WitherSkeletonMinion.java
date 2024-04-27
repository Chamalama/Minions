package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.WitherSkeleton;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class WitherSkeletonMinion extends WitherSkeleton implements Minion {
    public WitherSkeletonMinion(Location location) {
        super(EntityType.WITHER_SKELETON,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Wither Skeleton Minion");
        MinionUtil.setDamage(this, 36);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.WITHER_SKELETON_MINION;
    }

    @Override
    public String minionName() {
        return "Wither Skeleton Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/535cd6cc48cdaedd836a04ceafa8ec930eea62f92297fdd673f4fcb21e5246c4",
                ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Wither Skeleton Minion",
                1, 36, 150, 6, this.unlocked());
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
        return 1.85F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 55;
    }
}
