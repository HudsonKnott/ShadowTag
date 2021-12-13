package ga.uppishbuzzard87.shadowtag.events;

import ga.uppishbuzzard87.shadowtag.functions.GiveRemoveTagger;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class OnDamage implements Listener {
    @EventHandler
    public static void onPunch(EntityDamageByEntityEvent event) {
        event.setDamage(0);
        Entity entity = event.getEntity();
        Entity damaged = event.getDamager();
        if (entity instanceof Player) {
            Player p = (Player) entity;
            if (damaged instanceof Player) {
                Player d = (Player) damaged;
                if (p.getWalkSpeed() == 0.25f) {
                    GiveRemoveTagger.removeTagger();
                    GiveRemoveTagger.giveTagger(d);
                }
            }
        }
    }
}
