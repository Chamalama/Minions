package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.piglin.PiglinBrute;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class PiglinBruteMinion extends PiglinBrute implements Minion {
    public PiglinBruteMinion(Location location) {
        super(EntityType.PIGLIN_BRUTE, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.RED + ChatColor.BOLD.toString() + "Piglin Brute Minion");
        MinionUtil.setDamage(this, 27);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.PIGLIN_BRUTE_MINION;
    }

    @Override
    public String minionName() {
        return "Piglin Brute Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/e7223d4f38875ce18668e55cfd8459e1dbed5de6ae9140d10e57b2f22268980d",
                ChatColor.RED + ChatColor.BOLD.toString() + "Piglin Brute Minion",
                1, 27, 235, 3, this.unlocked());
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
        return 50;
    }

    @Override
    public float moveSpeed() {
        return 1.1F;
    }

    @Override
    public int coinIncrease() {
        return 40;
    }

    @Override
    public int rarity() {
        return 28;
    }
}
