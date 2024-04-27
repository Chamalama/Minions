package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Pillager;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class PillagerMinion extends Pillager implements Minion {
    public PillagerMinion(Location location) {
        super(EntityType.PILLAGER,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.GRAY + ChatColor.BOLD.toString() + "Pillager Minion");
        MinionUtil.setDamage(this, 12);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.PILLAGER_MINION;
    }

    @Override
    public String minionName() {
        return "Pillager Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/63550f89aea88665804c2fd1b6682930c23233184fdc060991305718ed660597",
                ChatColor.GRAY + ChatColor.BOLD.toString() + "Pillager Minion",
                1, 12, 175, 3, this.unlocked());
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
        return 1.4F;
    }

    @Override
    public int coinIncrease() {
        return 25;
    }

    @Override
    public int rarity() {
        return 22;
    }
}
