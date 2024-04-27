package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.hoglin.Hoglin;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class HoglinMinion extends Hoglin implements Minion {
    public HoglinMinion(Location location) {
        super(EntityType.HOGLIN, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.RED + ChatColor.BOLD.toString() + "Hoglin Minion");
        MinionUtil.setDamage(this, 18);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.HOGLIN_MINION;
    }

    @Override
    public String minionName() {
        return "Hoglin Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/db677670d09150bf10eafe9a36d8f6fec1e845529aca86c3c706bcee1ab06341",
                ChatColor.RED + ChatColor.BOLD.toString() + "Hoglin Minion",
                1, 18, 220, 3, this.unlocked());
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
        return 40;
    }

    @Override
    public float moveSpeed() {
        return 1.75F;
    }

    @Override
    public int coinIncrease() {
        return 2;
    }

    @Override
    public int rarity() {
        return 32;
    }
}
