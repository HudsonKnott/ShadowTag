package uk.co.hudsonknott.shadowtag.utilities;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class Powerups implements Listener {

    private static final ItemStack RABBIT_FOOT = new ItemStack(Material.RABBIT_FOOT);
    private static final ItemStack FEATHER = new ItemStack(Material.FEATHER);
    private static final ItemStack GRAY_DYE = new ItemStack(Material.GRAY_DYE);
    private static final ItemStack TRIDENT = new ItemStack(Material.TRIDENT);

    @EventHandler
    public static void powerupUsed(PlayerInteractEvent e) {
        try {
            if (e.getPlayer().equals(Tagger.tagger)) {
                if (e.getItem().equals(RABBIT_FOOT)) {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Jump Boost activated!");
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.JUMP, 150, 10));
                    e.getPlayer().getInventory().removeItem(RABBIT_FOOT);
                }
                else if (e.getItem().equals(FEATHER)) {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Speed Boost activated!");
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.SPEED, 150, 2));
                    e.getPlayer().getInventory().removeItem(FEATHER);
                }
                else if (e.getItem().equals(GRAY_DYE)) {
                    e.getPlayer().sendMessage(ChatColor.GREEN + "Invisibility activated!");
                    e.getPlayer().addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY, 40, 1));
                    e.getPlayer().getInventory().removeItem(new ItemStack(Material.GRAY_DYE));
                }
            }
            else {
                // tagger can't use powerups
                e.getPlayer().sendMessage(ChatColor.RED + "You can't use that!");
                if (e.getPlayer().getInventory().contains(RABBIT_FOOT)) {
                    e.getPlayer().getInventory().removeItem(RABBIT_FOOT);
                }
                else if (e.getPlayer().getInventory().contains(FEATHER)) {
                    e.getPlayer().getInventory().removeItem(FEATHER);
                }
                else if (e.getPlayer().getInventory().contains(GRAY_DYE)) {
                    e.getPlayer().getInventory().removeItem(GRAY_DYE);
                }
                else if (e.getPlayer().getInventory().contains(TRIDENT)) {
                    e.getPlayer().getInventory().removeItem(TRIDENT);
                }
            }
        }
        catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }

    @EventHandler
    public static void tridentUsed(ProjectileHitEvent e) {
        if (e.getEntity().getType() == EntityType.TRIDENT) {
            if (e.getEntity().getShooter() instanceof Player) {
                if (e.getEntity() == Tagger.tagger) {
                    if (e.getHitEntity() instanceof Player) {
                        Player shooter = (Player) e.getEntity().getShooter();
                        Player hitPlayer = (Player) e.getHitEntity();

                        shooter.sendMessage(ChatColor.GREEN + "It's a hit!");
                        hitPlayer.sendMessage(ChatColor.RED + "You have been hit by the slowness trident! You have Slowness II for 5 seconds");
                        hitPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
                    }
                }
                else {
                    // tagger can't use powerups
                    ((Player) e.getEntity().getShooter()).sendMessage(ChatColor.RED + "You can't use that!");
                }
            }
        }
    }

    public static void givePowerups(Player p) {
        // Jump boost (rabbit foot)
        ItemStack rabbitFoot = RABBIT_FOOT;
        ItemMeta rabbitFootMeta = rabbitFoot.getItemMeta();
        rabbitFootMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Jump Boost");
        rabbitFoot.setItemMeta(rabbitFootMeta);
        p.getInventory().addItem(rabbitFoot);

        // Speed boost (feather)
        ItemStack feather = FEATHER;
        ItemMeta featherMeta = feather.getItemMeta();
        featherMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Speed Boost");
        feather.setItemMeta(featherMeta);
        p.getInventory().addItem(feather);

        // Invisibility (gray dye)
        ItemStack grayDye = GRAY_DYE;
        ItemMeta grayDyeMeta = grayDye.getItemMeta();
        grayDyeMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Invisibility");
        grayDye.setItemMeta(grayDyeMeta);
        p.getInventory().addItem(grayDye);

        // Slow Player (trident)
        ItemStack trident = TRIDENT;
        ItemMeta tridentMeta = trident.getItemMeta();
        tridentMeta.setDisplayName(ChatColor.LIGHT_PURPLE + "Slow Down Player (throw me)");
        trident.setItemMeta(tridentMeta);
    }

    public static void removePowerups(Player p) {
        if (p.getInventory().contains(RABBIT_FOOT)) {
            p.getInventory().removeItem(RABBIT_FOOT);
        }
        if (p.getInventory().contains(FEATHER)) {
            p.getInventory().removeItem(FEATHER);
        }
        if (p.getInventory().contains(GRAY_DYE)) {
            p.getInventory().removeItem(GRAY_DYE);
        }
        if (p.getInventory().contains(TRIDENT)) {
            p.getInventory().removeItem(TRIDENT);
        }
    }
}
