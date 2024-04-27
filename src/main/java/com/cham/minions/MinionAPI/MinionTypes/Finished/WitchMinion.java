package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Witch;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class WitchMinion extends Witch implements Minion {
    public WitchMinion(Location location) {
        super(EntityType.WITCH, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Witch Minion");
        MinionUtil.setDamage(this, 25);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.WITCH_MINION;
    }

    @Override
    public String minionName() {
        return "Witch Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/40650af8586b1867ed3923888496bed503aaf53643bedf531300fce710224391",
                ChatColor.DARK_RED + ChatColor.BOLD.toString() + "Warden Minion",
                1, 25, 125, 5, this.unlocked());
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
        return 35;
    }

    @Override
    public float moveSpeed() {
        return 1.25F;
    }

    @Override
    public int coinIncrease() {
        return 15;
    }

    @Override
    public int rarity() {
        return 45;
    }
}
