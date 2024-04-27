package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Slime;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class SlimeMinion extends Slime implements Minion {
    public SlimeMinion(Location location) {
        super(EntityType.SLIME,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.GREEN + ChatColor.BOLD.toString() + "Slime Minion");
        MinionUtil.setDamage(this, 7);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.SLIME_MINION;
    }

    @Override
    public String minionName() {
        return "Slime Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/c69864311f8852bde8a489a237a819b1363c603a2b85fb243ee4f1aba2551adf",
                ChatColor.GREEN + ChatColor.BOLD.toString() + "Slime Minion",
                1, 7, 120, 2, this.unlocked());
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
        return 40;
    }

    @Override
    public float moveSpeed() {
        return 1.1F;
    }

    @Override
    public int coinIncrease() {
        return 1;
    }

    @Override
    public int rarity() {
        return 12;
    }
}
