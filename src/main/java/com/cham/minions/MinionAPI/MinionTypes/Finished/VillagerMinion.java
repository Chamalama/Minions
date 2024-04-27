package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.npc.Villager;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

import java.util.Random;

public class VillagerMinion extends Villager implements Minion {
    public VillagerMinion(Location location) {
        super(EntityType.VILLAGER,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Villager Minion");
        MinionUtil.setDamage(this, 15);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.VILLAGER_MINION;
    }

    @Override
    public String minionName() {
        return "Villager Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/17e30250cd5543516336f203b177c2268b72b6f6c5d0cfd802e6eab75e83ff0e",
                ChatColor.WHITE + ChatColor.BOLD.toString() + "Villager Minion",
                1, 15, 55, 4, this.unlocked());
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
        return 1.15F;
    }

    @Override
    public int coinIncrease() {
        return new Random().nextInt(25) + 15;
    }

    @Override
    public int rarity() {
        return 26;
    }
}
