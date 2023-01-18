package uk.co.hudsonknott.shadowtag.events;

import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;

public class OnDropItem implements Listener {
    public static void onDropItem(PlayerDropItemEvent e) {
        e.setCancelled(true);
    }
}
