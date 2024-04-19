package com.cham.minions.MinionAPI;

import com.cham.minions.MinionAPI.MinionTypes.*;
import com.cham.minions.Minions;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.LivingEntity;
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
    ;

    public static List<LivingEntity> minionEntity = new ArrayList<>();
    private Class<? extends LivingEntity> minionClass;
    MinionEnum(Class<? extends LivingEntity> minionClass) {
        this.minionClass = minionClass;
    }
    public Class<? extends LivingEntity> getMinionClass() {
        return minionClass;
    }

    public static void spawnMinion(Location location, MinionEnum minion, Player player, Minion minionType) {
        try{
            ServerLevel level = ((CraftWorld)location.getWorld()).getHandle();
            LivingEntity le = minion.getMinionClass().getConstructor(Location.class).newInstance(location);
            level.addFreshEntity(le);
            le.getBukkitLivingEntity().setCollidable(false);
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
