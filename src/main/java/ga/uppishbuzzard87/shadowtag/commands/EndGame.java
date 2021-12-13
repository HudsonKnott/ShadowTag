package ga.uppishbuzzard87.shadowtag.commands;

import ga.uppishbuzzard87.shadowtag.functions.GiveRemoveTagger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

public class EndGame implements CommandExecutor {
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("shadowend")) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "The game has ended!");
            GiveRemoveTagger.removeTagger();
        }
        return true;
    }
}
