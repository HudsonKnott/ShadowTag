package uk.co.hudsonknott.shadowtag;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;
import java.io.IOException;
import java.util.Properties;

public final class ShadowTag extends JavaPlugin {

    @Override
    public void onEnable() {
        Properties properties = new Properties();
        try {
            properties.load(ShadowTag.class.getResourceAsStream("/pom.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String version = properties.getProperty("version");
        System.out.println(ChatColor.GOLD + "ShadowTag " + ChatColor.GREEN +"v" + version + ChatColor.GOLD + " is loaded. This is an ALPHA build; please report any bugs in the GitHub issues tab" + ChatColor.GREEN + " (https://github.com/UppishBuzzard87/ShadowTag/issues). " + ChatColor.GOLD + "Happy playing!");
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.GOLD + "ShadowTag unloading... goodbye!");
    }
}
