package dk.nydt.events;

import dk.nydt.utils.Prize;
import org.bukkit.event.Event;
import org.bukkit.entity.Player;
import org.bukkit.event.HandlerList;

public class PlayerFiskEvent extends Event {
    private static final HandlerList handlers = new HandlerList();


    private Player player;

    private Prize prize;
    private boolean isCancelled;

    public PlayerFiskEvent(Player player, Prize prize){
        this.player = player;
        this.prize = prize;
        this.isCancelled = false;
    }


    public Player getPlayer() {
        return player;
    }

    public Prize getPrize() {
        return prize;
    }

    public boolean isCancelled() {
        return this.isCancelled;
    }

    public void setCancelled(boolean isCancelled) {
        this.isCancelled = isCancelled;
    }
    public void setPrize(Prize prize) {
        this.prize = prize;
    }

    public HandlerList getHandlers() {
        return handlers;
    }
    public static HandlerList getHandlerList() {
        return handlers;
    }
}
