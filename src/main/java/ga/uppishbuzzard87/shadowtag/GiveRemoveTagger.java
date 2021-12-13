package ga.uppishbuzzard87.shadowtag;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GiveRemoveTagger {
    public static void giveTagger(Player p) {
        ShadowTag inst = new ShadowTag();
        p.setFlySpeed(0.2f);
        p.setWalkSpeed(0f);
        p.sendMessage(ChatColor.RED + "You are the tagger! You will be freed in 30 seconds");
        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(inst, () -> p.setWalkSpeed(0.25f), 600);
        p.sendMessage(ChatColor.GREEN + "You have been released!");
        GiveRemovePowerups.GivePowerups(p);
    }
    public static void removeTagger() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getWalkSpeed() == 0.25f || p.getFlySpeed() == 0.2f) {
                p.setWalkSpeed(0.2f);
                p.setFlySpeed(0.1f);
                p.sendMessage(ChatColor.GREEN + "You are no longer the tagger!");
            }
        }
        GiveRemovePowerups.RemovePowerups();
    }
}
