package ga.uppishbuzzard87.shadowtag;

import ga.uppishbuzzard87.shadowtag.commands.EndGame;
import ga.uppishbuzzard87.shadowtag.commands.SetTagger;
import ga.uppishbuzzard87.shadowtag.events.OnDamage;
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
        getCommand("shadowtagger").setExecutor(new SetTagger());
        getCommand("shadowend").setExecutor(new EndGame());
        getServer().getPluginManager().registerEvents(new OnDamage(), this);
        String version = properties.getProperty("version");
        String artifactId = properties.getProperty("artifactId");
        String groupId = properties.getProperty("groupId");
        System.out.println(ChatColor.GOLD + "ShadowTag " + ChatColor.GREEN +"v" + version + ChatColor.GOLD + " is loaded. Happy playing!");
    }

    @Override
    public void onDisable() {
        System.out.println(ChatColor.GOLD + "ShadowTag unloading... goodbye!");
    }
}
