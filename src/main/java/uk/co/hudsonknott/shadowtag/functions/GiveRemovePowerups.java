package uk.co.hudsonknott.shadowtag.functions;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class GiveRemovePowerups {
    public static void GivePowerups(Player p) {
        // Jump boost (rabbit foot)
        ItemStack rabbitFoot = new ItemStack(Material.RABBIT_FOOT);
        ItemMeta rabbitFootMeta = rabbitFoot.getItemMeta();
        rabbitFootMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Jump Boost");
        rabbitFoot.setItemMeta(rabbitFootMeta);
        p.getInventory().addItem(rabbitFoot);
        // Speed boost (feather)
        ItemStack feather = new ItemStack(Material.FEATHER);
        ItemMeta featherMeta = feather.getItemMeta();
        featherMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Speed Boost");
        feather.setItemMeta(featherMeta);
        p.getInventory().addItem(feather);
        // Invisibility (gray dye)
        ItemStack grayDye = new ItemStack(Material.GRAY_DYE);
        ItemMeta grayDyeMeta = grayDye.getItemMeta();
        grayDyeMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Invisibility");
        grayDye.setItemMeta(grayDyeMeta);
        p.getInventory().addItem(grayDye);
        // Slow Player (trident)
        ItemStack trident = new ItemStack(Material.TRIDENT);
        ItemMeta tridentMeta = trident.getItemMeta();
        tridentMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Slow Down Player (throw me)");
        trident.setItemMeta(tridentMeta);
    }
    public static void RemovePowerups() {
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (p.getInventory().contains(new ItemStack(Material.RABBIT_FOOT))) {
                p.getInventory().removeItem(new ItemStack(Material.RABBIT_FOOT));
            }
            if (p.getInventory().contains(new ItemStack(Material.FEATHER))) {
                p.getInventory().removeItem(new ItemStack(Material.FEATHER));
            }
            if (p.getInventory().contains(new ItemStack(Material.GRAY_DYE))) {
                p.getInventory().removeItem(new ItemStack(Material.GRAY_DYE));
            }
            if (p.getInventory().contains(new ItemStack(Material.TRIDENT))) {
                p.getInventory().removeItem(new ItemStack(Material.TRIDENT));
            }
        }
    }
}
