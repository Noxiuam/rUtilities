package rip.kits.rutilities.utils.event;

import org.bukkit.Bukkit;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class BaseEvent extends Event {
    private static final HandlerList handlers;

    @Override
    public HandlerList getHandlers() {
        return handlers;
    }

    public void call() {
        Bukkit.getServer().getPluginManager().callEvent(this); // Easier Calling...
    }

    static {
        handlers = new HandlerList();
    }
}
