package com.cham.minions.MinionAPI;

import com.cham.minions.MinionAPI.MinionTypes.Finished.*;
import com.cham.minions.MinionAPI.MinionTypes.ToDo.*;
import com.cham.minions.Minions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.piglin.Piglin;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.NamespacedKey;
import org.bukkit.craftbukkit.v1_20_R3.CraftWorld;
import org.bukkit.entity.Player;
import org.bukkit.metadata.FixedMetadataValue;
import org.bukkit.persistence.PersistentDataType;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public enum MinionEnum {

    CHICKEN_MINION(ChickenMinion.class),
    COW_MINION(CowMinion.class),
    PIG_MINION(PigMinion.class),
    SHEEP_MINION(SheepMinion.class),
    WOLF_MINION(WolfMinion.class),
    PRINCE_BLAZE_MINION(PrinceBlazeMinion.class),
    TURTLE_MINION(TurtleMinion.class),
    ZOMBIE_MINION(ZombieMinion.class),
    FOX_MINION(FoxMinion.class),
    SKELETON_HORSE_MINION(SkeletonHorseMinion.class),
    SLIME_MINION(SlimeMinion.class),
    SNIFFER_MINION(SnifferMinion.class),
    SKELETON_MINION(SkeletonMinion.class),
    RAVAGER_MINION(RavagerMinion.class),
    POLAR_BEAR_MINION(PolarBearMinion.class),
    PILLAGER_MINION(PillagerMinion.class),
    PANDA_MINION(PandaMinion.class),
    MOOSHROOM_MINION(MooshroomMinion.class),
    MAGMA_CUBE_MINION(MagmaSlimeMinion.class),
    PIGLIN_MINION(Piglin.class),
    PIGLIN_BRUTE_MINION(PiglinBruteMinion.class),
    IRON_GOLEM_MINION(IronGolemMinion.class),
    HORSE_MINION(HorseMinion.class),
    HOGLIN_MINION(HoglinMinion.class),
    GOAT_MINION(GoatMinion.class),
    FROG_MINION(FrogMinion.class),
    PARROT_MINION(ParrotMinion.class),
    EVOKER_MINION(EvokerMinion.class),
    ENDERMITE_MINION(EndermiteMinion.class),
    ENDERMAN_MINION(EndermanMinion.class),
    DROWNED_MINION(DrownedMinion.class),
    DONKEY_MINION(DonkeyMinion.class),
    CREEPER_MINION(CreeperMinion.class),
    CAVE_SPIDER_MINION(CaveSpiderMinion.class),
    SPIDER_MINION(SpiderMinion.class),
    STRIDER_MINION(StriderMinion.class),
    SNOW_GOLEM_MINION(SnowGolemMinion.class),
    VILLAGER_MINION(VillagerMinion.class),
    VINDICATOR_MINION(VindicatorMinion.class),
    WARDEN_MINION(WardenMinion.class),
    WITHER_MINION(WitherMinion.class),
    WITHER_SKELETON_MINION(WitherSkeletonMinion.class),
    ZOGLIN_MINION(ZoglinMinion.class),
    SILVER_FISH_MINION(SilverfishMinion.class),
    BLAZE_MINION(BlazeMinion.class)
    ;

    public static List<LivingEntity> minionEntity = new ArrayList<>();
    private Class<? extends LivingEntity> minionClass;
    MinionEnum(Class<? extends LivingEntity> minionClass) {
        this.minionClass = minionClass;
    }
    public Class<? extends LivingEntity> getMinionClass() {
        return minionClass;
    }

    public static void spawnMinion(Location location, MinionEnum minion, Player player, Minion minionType, int minionLevel) {
        try{
            ServerLevel level = ((CraftWorld)location.getWorld()).getHandle();
            LivingEntity le = minion.getMinionClass().getConstructor(Location.class).newInstance(location);
            level.addFreshEntity(le);
            le.getBukkitLivingEntity().setCustomName(minionType.minionEntity().getBukkitLivingEntity().getCustomName() + " " + ChatColor.GRAY + minionLevel);
            le.setSilent(true);
            le.setPos(location.getX(), location.getY(), location.getZ());
            le.getBukkitLivingEntity().getPersistentDataContainer().set(new NamespacedKey(Minions.getMinions(), player.getUniqueId().toString()), PersistentDataType.INTEGER, 1);
            le.getBukkitLivingEntity().setMetadata("MINION", new FixedMetadataValue(Minions.getMinions(), ""));
            le.setGlowingTag(true);
            Minions.getMinions().getRegister().getPlayerMinions().get(player.getUniqueId()).add(minionType);
            minionEntity.add(le);
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
