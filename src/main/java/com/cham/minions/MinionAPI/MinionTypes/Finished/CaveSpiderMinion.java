package com.cham.minions.MinionAPI.MinionTypes.Finished;

import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.monster.CaveSpider;
import net.minecraft.world.level.Level;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class CaveSpiderMinion extends CaveSpider implements Minion {
    public CaveSpiderMinion(Location location) {
        super(EntityType.CAVE_SPIDER, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Cave Spider Minion");
        MinionUtil.setDamage(this, 8);
        Minion.super.tryAI(this);
    }

    //http://textures.minecraft.net/texture/46fe63ac5a6fffb9dbc53ff11e51dce214dd3a92e000d8b32791b66e4e31d86d
    @Override
    public LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.CAVE_SPIDER_MINION;
    }

    @Override
    public String minionName() {
        return "Cave Spider Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/46fe63ac5a6fffb9dbc53ff11e51dce214dd3a92e000d8b32791b66e4e31d86d",
                ChatColor.LIGHT_PURPLE + ChatColor.BOLD.toString() + "Cave Spider Minion",
                1, 8, 20, 3, this.unlocked());
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
        return 15;
    }

    @Override
    public float moveSpeed() {
        return 2.0F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 10;
    }
}
