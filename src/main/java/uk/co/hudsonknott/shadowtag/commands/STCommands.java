package uk.co.hudsonknott.shadowtag.commands;

import uk.co.hudsonknott.shadowtag.functions.GiveRemoveTagger;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class STCommands implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] args) {
        if (command.getName().equalsIgnoreCase("shadowtag")) {
            if (args.length == 0) {
                return false;
            }
            switch (args[0]) {
                case "set":
                    if (args.length == 2) {
                        Player tagger = Bukkit.getPlayer(args[1]);
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
                        // no player provided
                        return false;
                    }


                case "stop":
                    // end game
            }

        }
        return true;
    }
}
