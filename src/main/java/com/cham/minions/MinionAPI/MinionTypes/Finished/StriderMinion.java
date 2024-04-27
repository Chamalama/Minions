package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Strider;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class StriderMinion extends Strider implements Minion {
    public StriderMinion(Location location) {
        super(EntityType.STRIDER,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.RED + ChatColor.BOLD.toString() + "Strider Minion");
        MinionUtil.setDamage(this, 20);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.STRIDER_MINION;
    }

    @Override
    public String minionName() {
        return "Strider Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/406b3ae64ff87afc9ac9e3967031fadbbcd661426060ae1ffc2a52a5417c95b9",
                ChatColor.RED + ChatColor.BOLD.toString() + "Strider Minion",
                1, 20, 100, 4, this.unlocked());
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
        return 2.65F;
    }

    @Override
    public int coinIncrease() {
        return 10;
    }

    @Override
    public int rarity() {
        return 18;
    }
}
