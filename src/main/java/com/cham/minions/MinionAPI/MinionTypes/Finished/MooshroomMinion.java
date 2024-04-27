package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.MushroomCow;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class MooshroomMinion extends MushroomCow implements Minion {
    public MooshroomMinion(Location location) {
        super(EntityType.MOOSHROOM, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.RED + ChatColor.BOLD.toString() + "Mooshroom Minion");
        MinionUtil.setDamage(this, 1);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.MOOSHROOM_MINION;
    }

    @Override
    public String minionName() {
        return "Mooshroom Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/27cc34e09c048025c2347a4546549625d433bd599ba769c19eef93e84fac86b6",
                ChatColor.RED + ChatColor.BOLD.toString() + "Mooshroom Minion",
                1, 1, 1, 7, this.unlocked());
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
        return 100;
    }

    @Override
    public float moveSpeed() {
        return 0.5F;
    }

    @Override
    public int coinIncrease() {
        return 200;
    }

    @Override
    public int rarity() {
        return 24;
    }
}
