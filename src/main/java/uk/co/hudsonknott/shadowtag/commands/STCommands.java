package uk.co.hudsonknott.shadowtag.commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import uk.co.hudsonknott.shadowtag.utilities.Tagger;
import uk.co.hudsonknott.shadowtag.utilities.Powerups;

public class STCommands implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("shadowtag")) {
            if (args.length >= 1) {
                if (args[0].equalsIgnoreCase("set")) {
                    if (args.length != 2) {
                        // incorrect number of args
                        return false;
                    }
                    if (Bukkit.getPlayer(args[1]) == null) {
                        // player not logged on
                        commandSender.sendMessage(ChatColor.RED + "Invalid player name. The player must be logged on to the server");
                        return true;
                    }

                    Tagger.giveTagger(Bukkit.getPlayer(args[1]));

                    for (Player p : Bukkit.getOnlinePlayers()) {
                        if (p != Tagger.tagger) {
                            p.sendMessage(ChatColor.GREEN + "You are a runner! The tagger is " + Tagger.tagger.getName() + " and they will be released in 30 seconds");
                            Powerups.givePowerups(p);
                        }
                    }
                }
                else if (args[0].equalsIgnoreCase("end")) {
                    Tagger.removeTagger();
                    for (Player p : Bukkit.getOnlinePlayers()) {
                        p.sendMessage(ChatColor.GREEN + "The game is over! " + Tagger.tagger.getName() + " was the final tagger");
                        Powerups.removePowerups(p);
                    }
                }
            }
            // not enough args
            return false;
        }
        return true;
    }
}
