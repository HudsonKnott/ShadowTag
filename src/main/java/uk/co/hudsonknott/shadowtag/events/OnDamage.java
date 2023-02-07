package uk.co.hudsonknott.shadowtag.events;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

public class OnDamage implements Listener {
    @EventHandler
    public static void onDamage(EntityDamageEvent e) {e.setDamage(0);}
}
