package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class SpiderMinion extends Spider implements Minion {
    public SpiderMinion(Location location) {
        super(EntityType.SPIDER,  ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Spider Minion");
        MinionUtil.setDamage(this, 9);
        Minion.super.tryAI(this);
    }

    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.SPIDER_MINION;
    }

    @Override
    public String minionName() {
        return "Spider Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/fbbef941250fecfa342e875760883d412f64792b791ef902b90d8612f12c09c2",
                ChatColor.DARK_PURPLE + ChatColor.BOLD.toString() + "Spider Minion",
                1, 9, 22, 3, this.unlocked());
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
        return 14;
    }

    @Override
    public float moveSpeed() {
        return 2.2F;
    }

    @Override
    public int coinIncrease() {
        return 1;
    }

    @Override
    public int rarity() {
        return 12;
    }
}
