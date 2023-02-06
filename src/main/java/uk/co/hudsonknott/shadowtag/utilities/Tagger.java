package uk.co.hudsonknott.shadowtag.utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import uk.co.hudsonknott.shadowtag.ShadowTag;

public final class Tagger {
    public static Player tagger;

    private static ShadowTag mainClass;

    private static final float defaultWalkSpeed = 0.2f;
    private static final float increasedWalkSpeed = 0.25f;

    // Dependency injection
    public Tagger(ShadowTag plugin) {
        mainClass = plugin;
    }

    public static void giveTagger(Player p) {
        tagger = p;
        Powerups.removePowerups(tagger);
        tagger.setWalkSpeed(0.0f);
        tagger.sendMessage("You are the tagger! You will be released in 30 seconds");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(mainClass, () -> p.setWalkSpeed(increasedWalkSpeed), 600);

    }

    public static void removeTagger() {
        tagger.setWalkSpeed(defaultWalkSpeed);
        Powerups.givePowerups(tagger);
        tagger = null;
    }
}
