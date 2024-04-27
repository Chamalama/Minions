package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class CreeperMinion extends Creeper implements Minion {
    public CreeperMinion(Location location) {
        super(EntityType.CREEPER, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.GREEN + ChatColor.BOLD.toString() + "Creeper Minion");
        MinionUtil.setDamage(this, 12);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.CREEPER_MINION;
    }

    @Override
    public String minionName() {
        return "Creeper Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/e06228c690ec8f3a2e682037672d2fc67ed555ab745043fbc7a95414be2208d3",
                ChatColor.GREEN + ChatColor.BOLD.toString() + "Creeper Minion",
                1, 12, 25, 2, this.unlocked());
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
        return 60;
    }

    @Override
    public float moveSpeed() {
        return 1.4F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 6;
    }
}
