package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Vindicator;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class VindicatorMinion extends Vindicator implements Minion {
    public VindicatorMinion(Location location) {
        super(EntityType.VINDICATOR,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.YELLOW + ChatColor.BOLD.toString() + "Vindicator Minion");
        MinionUtil.setDamage(this, 18);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.VINDICATOR_MINION;
    }

    @Override
    public String minionName() {
        return "Vindicator Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/3c993a21824f5c2d56ff5a97ef435ca3c424a86b4e29570d9ea4a752df2f8e54",
                ChatColor.WHITE + ChatColor.BOLD.toString() + "Vindicator Minion",
                1, 18, 70, 4, this.unlocked());
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
        return 1.17F;
    }

    @Override
    public int coinIncrease() {
        return 20;
    }

    @Override
    public int rarity() {
        return 28;
    }
}
