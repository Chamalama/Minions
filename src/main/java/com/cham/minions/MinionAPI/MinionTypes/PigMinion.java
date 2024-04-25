package com.cham.minions.MinionAPI.MinionTypes;

import com.cham.dungeons.Dungeons;
import com.cham.dungeons.Util.Config.PlayerData;
import com.cham.minions.MinionAPI.Minion;
import com.cham.minions.MinionAPI.MinionEnum;
import com.cham.minions.Util.MinionUtil;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.animal.Pig;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.inventory.ItemStack;

public class PigMinion extends Pig implements Minion {
    public PigMinion(Location location) {
        super(EntityType.PIG, ((CraftWorld)location.getWorld()).getHandle());
        MinionUtil.setup(this, ChatColor.RED + ChatColor.BOLD.toString() + "Pig Minion");
        MinionUtil.setDamage(this, MinionUtil.getMinionDamage(this.minionItem()));
        this.goalSelector.getAvailableGoals().clear();
        Minion.super.tryAI(this);
    }

    @Override
    public net.minecraft.world.entity.LivingEntity minionEntity() {
        return this;
    }

    @Override
    public MinionEnum spawnMinionType() {
        return MinionEnum.PIG_MINION;
    }

    @Override
    public String minionName() {
        return "Pig Minion";
    }

    @Override
    public ItemStack minionItem() {
        return MinionUtil.buildMinionItem("http://textures.minecraft.net/texture/4a37ec8fa9a7329723349c4889864e3eaa51b0c1877e54bd2bb3e0ae0d099fa6",
                ChatColor.RED + ChatColor.BOLD.toString() + "Pig Minion", 2, 2, 20, 1, this.unlocked());
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
        double random = Math.random();
        double chance = 0.01;
        if(random < chance) {
            PlayerData data = Dungeons.getDungeons().getPlayerConfig().loadPlayerData(owner.getUniqueId());
            data.setCoins(data.getCoins() + 10);
            owner.playSound(owner.getLocation(), Sound.ENTITY_PIG_AMBIENT, 1.0F, 1.0F);
            owner.sendMessage(ChatColor.RED + ChatColor.BOLD.toString() + "** PIGGY BANK ** " + ChatColor.GRAY + "(+10 Coins)");
            Dungeons.getDungeons().getPlayerConfig().savePlayerData(data);
        }
    }

    @Override
    public void onDamageReceived(LivingEntity minion, EntityDamageEvent e) {

    }

    @Override
    public int attackTime() {
        return 20;
    }

    @Override
    public float moveSpeed() {
        return 2.1F;
    }

    @Override
    public int coinIncrease() {
        return 0;
    }

    @Override
    public int rarity() {
        return 2;
    }
}
