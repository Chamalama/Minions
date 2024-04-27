package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.goat.Goat;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class GoatMinion extends Goat implements Minion {
    public GoatMinion(Location location) {
        super(EntityType.GOAT, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Goat Minion");
        MinionUtil.setDamage(this, 8);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.GOAT_MINION;
    }

    @Override
    public String minionName() {
        return "Goat Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/c3a1324d78537f1d6050a7fc43b7910672eeeedcd6344e8f1ceec145b1bf1d92",
                ChatColor.WHITE + ChatColor.BOLD.toString() + "Goat Minion",
                1, 8, 35, 2, this.unlocked());
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
        return 1.5F;
    }

    @Override
    public int coinIncrease() {
        return 1;
    }

    @Override
    public int rarity() {
        return 33;
    }
}
