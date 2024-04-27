package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Evoker;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class EvokerMinion extends Evoker implements Minion {
    public EvokerMinion(Location location) {
        super(EntityType.EVOKER, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setDamage(this, 15);
        MinionUtil.setup(this, ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Evoker Minion");
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.EVOKER_MINION;
    }

    @Override
    public String minionName() {
        return "Evoker Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/d578f9f9870fe763ac68763e1822466844eb81bafddb34974eef656dc806f52f",
                ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Evoker Minion",
                1, 15, 30, 6, this.unlocked());
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
        return 1.0F;
    }

    @Override
    public int coinIncrease() {
        return 1;
    }

    @Override
    public int rarity() {
        return 37;
    }
}
