package uk.co.hudsonknott.shadowtag.commands;

import uk.co.hudsonknott.shadowtag.functions.GiveRemoveTagger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetTagger implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("shadowtagger")) {
            if (args.length == 1) {
                Player tagger = Bukkit.getPlayer(args[0]);
                if (tagger == null) {
                    sender.sendMessage(ChatColor.RED + "Invalid player name. The player must be logged onto the server.");
                    return true;
                }
                GiveRemoveTagger.giveTagger(tagger);
                for (Player p : Bukkit.getOnlinePlayers()) {
                    if (p != tagger) {
                        p.sendMessage(ChatColor.GREEN + "You are a runner! Stay away from " + tagger + "!");
                    }
                }
                return true;
            }
            else {
                return false;
            }
        }
        return true;
    }
}
