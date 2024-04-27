package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Drowned;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class DrownedMinion extends Drowned implements Minion {
    public DrownedMinion(Location location) {
        super(EntityType.DROWNED, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.AQUA + ChatColor.BOLD.toString() + "Drowned Minion");
        MinionUtil.setDamage(this, 9);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.DROWNED_MINION;
    }

    @Override
    public String minionName() {
        return "Drowned Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/ae7c358bdbf410d71859e84387d38205f6d2438f06f7f1fd5a459e7ea122041b",
                ChatColor.AQUA + ChatColor.BOLD.toString() + "Drowned Minion",
                1, 9, 55, 2, this.unlocked());
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
        return 25;
    }

    @Override
    public float moveSpeed() {
        return 1.1F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 45;
    }
}
