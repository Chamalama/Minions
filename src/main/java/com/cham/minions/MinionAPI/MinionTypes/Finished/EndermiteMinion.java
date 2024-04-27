package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Endermite;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class EndermiteMinion extends Endermite implements Minion {
    public EndermiteMinion(Location location) {
        super(EntityType.ENDERMITE, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Endermite Minion");
        MinionUtil.setDamage(this, 2);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.ENDERMITE_MINION;
    }

    @Override
    public String minionName() {
        return "Endermite Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/d78919290be84ec651be99d9bd5cf224e343ff4cd9c9a1d2c133c08f021d4c00",
                ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Endermite Minion",
                1, 2, 5, 7, this.unlocked());
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
        return 5;
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
        return 40;
    }
}
