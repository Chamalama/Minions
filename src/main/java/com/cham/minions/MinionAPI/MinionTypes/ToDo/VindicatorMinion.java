package com.cham.minions.MinionAPI.MinionTypes.ToDo;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.level.Level;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class VindicatorMinion extends Vindicator implements Minion {
    public VindicatorMinion(Location location) {
        super(EntityType.VINDICATOR,  ((CraftWorld)location.getWorld()).getHandle());
    }

    @Override
    public LivingEntity minionEntity() {
        return null;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return null;
    }

    @Override
    public String minionName() {
        return null;
    }

    @Override
    public ItemStack minionItem() {
        return null;
    }

    @Override
    public MoveControl moveControl() {
        return null;
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
        return 0;
    }

    @Override
    public float moveSpeed() {
        return 0;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 0;
    }
}
