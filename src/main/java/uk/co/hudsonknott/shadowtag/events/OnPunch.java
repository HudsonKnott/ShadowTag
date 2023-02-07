package uk.co.hudsonknott.shadowtag.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import uk.co.hudsonknott.shadowtag.utilities.Tagger;

public class OnPunch implements Listener {
    @EventHandler
    public static void onPunch(EntityDamageByEntityEvent e) {
        e.setDamage(0);
        if (e.getEntity() instanceof Player) {
            Player p = (Player) e.getEntity();
            if (e.getDamager() instanceof Player) {
                Player d = (Player) e.getDamager();
                if (d == Tagger.tagger) {
                    Tagger.removeTagger();
                    Tagger.giveTagger(p);
                }
            }

        }
    }
}
