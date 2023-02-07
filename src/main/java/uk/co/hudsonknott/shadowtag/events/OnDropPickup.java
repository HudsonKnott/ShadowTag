package uk.co.hudsonknott.shadowtag.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerAttemptPickupItemEvent;
import org.bukkit.event.player.PlayerDropItemEvent;

public class OnDropPickup implements Listener {
    @EventHandler
    public static void onDrop(PlayerDropItemEvent e) {e.setCancelled(true);}

    @EventHandler
    public static void onPickup(PlayerAttemptPickupItemEvent e) {e.setCancelled(true);}
}
