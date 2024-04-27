package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.horse.Donkey;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class DonkeyMinion extends Donkey implements Minion {
    public DonkeyMinion(Location location) {
        super(EntityType.DONKEY, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.WHITE + ChatColor.BOLD.toString() + "Donkey Minion");
        MinionUtil.setDamage(this, 5);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.DONKEY_MINION;
    }

    @Override
    public String minionName() {
        return "Donkey Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/b97499f52af515ef72c2163be07fe4e81f7a3fd7792717c66c8a5b65e646395e",
                ChatColor.WHITE + ChatColor.BOLD.toString() + "Donkey Minion",
                1, 5, 25, 1, this.unlocked());
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
        return 22;
    }

    @Override
    public float moveSpeed() {
        return 1.5F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 4;
    }
}
