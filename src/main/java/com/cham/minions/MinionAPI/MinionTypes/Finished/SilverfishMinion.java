package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Silverfish;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class SilverfishMinion extends Silverfish implements Minion {
    public SilverfishMinion(Location location) {
        super(EntityType.SILVERFISH, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.GRAY + ChatColor.BOLD.toString() + "Silverfish Minion");
        MinionUtil.setDamage(this, 1);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.SILVER_FISH_MINION;
    }

    @Override
    public String minionName() {
        return "Silverfish Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/19f323a579ebfaef3e9963a4cf14b0261e504a515e0542cb3d5f6a0172b5e263",
                ChatColor.GRAY + ChatColor.BOLD.toString() + "Silverfish Minion",
                1, 1, 10, 4, this.unlocked());
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
        return 8;
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
        return 22;
    }
}
