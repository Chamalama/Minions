package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.EnderMan;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class EndermanMinion extends EnderMan implements Minion {
    public EndermanMinion(Location location) {
        super(EntityType.ENDERMAN, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Enderman Minion");
        MinionUtil.setDamage(this, 10);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.ENDERMAN_MINION;
    }

    @Override
    public String minionName() {
        return "Enderman Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/a3ce9245f4e5d04602ab35e3be0ed6063c2e907df3d3dd96f447dcf4c8409c81",
                ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Enderman Minion",
                1, 10, 75, 5, this.unlocked());
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
        return 2.2F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 42;
    }
}
