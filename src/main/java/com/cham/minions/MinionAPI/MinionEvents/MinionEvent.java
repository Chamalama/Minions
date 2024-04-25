package com.cham.minions.MinionAPI.MinionEvents;

import com.cham.minions.MinionAPI.Minion;
import org.bukkit.entity.LivingEntity;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class MinionEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;
    private Minion minion;
    private LivingEntity entityKilled;
    public MinionEvent(Minion minion, LivingEntity entityKilled) {
        this.minion = minion;
        this.entityKilled = entityKilled;
    }

    public MinionEvent(Minion minion) {
        this.minion = minion;
    }
    @Override
    public boolean isCancelled() {
        return isCancelled;
    }

    @Override
    public void setCancelled(boolean b) {
        this.isCancelled = b;
    }

    @Override
    public @NotNull HandlerList getHandlers() {
        return HANDLERS_LIST;
    }

    public static HandlerList getHandlerList() {
        return HANDLERS_LIST;
    }

    @Override
    public boolean callEvent() {
        return super.callEvent();
    }

    public Minion getMinion() {
        return minion;
    }

    public LivingEntity getEntityKilled() {
        return entityKilled;
    }
}
