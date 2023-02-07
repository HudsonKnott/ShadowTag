package uk.co.hudsonknott.shadowtag;

import org.bukkit.plugin.java.JavaPlugin;
import uk.co.hudsonknott.shadowtag.commands.STCommands;
import uk.co.hudsonknott.shadowtag.events.OnDamage;
import uk.co.hudsonknott.shadowtag.events.OnDropPickup;
import uk.co.hudsonknott.shadowtag.events.OnPunch;
import uk.co.hudsonknott.shadowtag.utilities.Tagger;

import java.io.IOException;
import java.util.Properties;


public final class ShadowTag extends JavaPlugin {

    public Tagger taggerClass;

    @Override
    public void onEnable() {
        // Get version
        Properties properties = new Properties();
        try {
            properties.load(ShadowTag.class.getResourceAsStream("/pom.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String version = properties.getProperty("version");

        taggerClass = new Tagger(this);

        // Register commands
        getCommand("shadowtag start").setExecutor(new STCommands());
        getCommand("shadowtag end").setExecutor(new STCommands());

        // Register events
        getServer().getPluginManager().registerEvents(new OnPunch(), this);
        getServer().getPluginManager().registerEvents(new OnDropPickup(), this);
        getServer().getPluginManager().registerEvents(new OnDamage(), this);

        // Startup message
        getLogger().info("ShadowTag v" + version + " is loaded. Please report any bugs in the GitHub issues tab (https://github.com/HudsonKnott/ShadowTag/issues). Happy playing!");
    }

    @Override
    public void onDisable() {
        // Shutdown message
        getLogger().info("ShadowTag unloading... goodbye!");
    }
}