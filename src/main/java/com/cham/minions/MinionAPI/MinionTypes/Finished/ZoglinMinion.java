package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Zoglin;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class ZoglinMinion extends Zoglin implements Minion {
    public ZoglinMinion(Location location) {
        super(EntityType.ZOGLIN,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.RED + ChatColor.BOLD.toString() + "Zoglin Minion");
        MinionUtil.setDamage(this, 30);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.ZOGLIN_MINION;
    }

    @Override
    public String minionName() {
        return "Zoglin Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/f05e06b1d1357a3574268a5189615983ceffc185993047da47ac947f3b7507f3",
                ChatColor.RED + ChatColor.BOLD.toString() + "Zoglin Minion",
                1, 30, 180, 6, this.unlocked());
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
        return 45;
    }

    @Override
    public float moveSpeed() {
        return 1.45F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 50;
    }
}
