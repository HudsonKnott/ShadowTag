package ga.uppishbuzzard87.shadowtag.functions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class PowerupFunctions implements Listener {
    public static void SuperJump(PlayerInteractEvent e) {
        ItemStack item = e.getItem();
        e.setCancelled(true);
        try {
            if (e.getPlayer().getFlySpeed() == 0.2f) {
                if (item.equals(new ItemStack(Material.RABBIT_FOOT))) {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Jump Boost activated!");
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 150, 10));
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.RABBIT_FOOT));
                }
            }
            else {
                e.getPlayer().sendMessage(ChatColor.RED + "You can't use that!");
                e.getPlayer().getInventory().removeItem(new ItemStack(Material.RABBIT_FOOT));
            }
        }
        catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
    public static void ExtraSpeed(PlayerInteractEvent e) {
        ItemStack item = e.getItem();
        e.setCancelled(true);
        try {
            if (e.getPlayer().getFlySpeed() == 0.2f) {
                if (item.equals(new ItemStack(Material.FEATHER))) {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Speed Boost activated!");
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 150, 2));
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.FEATHER));
                }
            }
            else {
                e.getPlayer().sendMessage(ChatColor.RED + "You can't use that!");
                e.getPlayer().getInventory().removeItem(new ItemStack(Material.FEATHER));
            }
        }
        catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
    public static void Invisibility(PlayerInteractEvent e) {
        ItemStack item = e.getItem();
        e.setCancelled(true);
        try {
            if (e.getPlayer().getFlySpeed() == 0.2f) {
                if (item.equals(new ItemStack(Material.GRAY_DYE))) {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Invisibility activated!");
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 40, 1));
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.GRAY_DYE));
                }
            }
        }
        catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
}
