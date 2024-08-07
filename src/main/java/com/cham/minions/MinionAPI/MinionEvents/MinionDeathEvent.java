package com.cham.minions.MinionAPI.MinionEvents;

import com.cham.minions.MinionAPI.Minion;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;
import org.jetbrains.annotations.NotNull;

public class MinionDeathEvent extends Event implements Cancellable {
    private static final HandlerList HANDLERS_LIST = new HandlerList();
    private boolean isCancelled;
    private Minion minion;
    private Player owner;
    public MinionDeathEvent(Minion minion, Player owner) {
        this.minion = minion;
        this.owner = owner;
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

    public Player getOwner() {
        return owner;
    }


}
