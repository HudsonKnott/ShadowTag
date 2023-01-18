package uk.co.hudsonknott.shadowtag.functions;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityPickupItemEvent;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.entity.ProjectileLaunchEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.Map;

public class PowerupFunctions implements Listener {
    @EventHandler
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
    @EventHandler
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
    @EventHandler
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
            else {
                e.getPlayer().sendMessage(ChatColor.RED + "You can't use that!");
                e.getPlayer().getInventory().removeItem(new ItemStack(Material.GRAY_DYE));
            }
        }
        catch (NullPointerException exception) {
            exception.printStackTrace();
        }
    }
    @EventHandler
    public static void FreezeTrident(ProjectileHitEvent e) {
        if (e.getEntity().getType() == EntityType.TRIDENT) {
            if (e.getEntity().getShooter() instanceof Player) {
                if (((Player) e.getEntity().getShooter()).getFlySpeed() == 0.2f) {
                    if (e.getHitEntity() instanceof Player) {
                        Player shooter = (Player) e.getEntity().getShooter();
                        Player hitPlayer = (Player) e.getHitEntity();

                        shooter.sendMessage(ChatColor.GREEN + "It's a hit!");
                        hitPlayer.sendMessage(ChatColor.RED + "You have been hit by the slowness trident! You have Slowness II for 5 seconds");
                        hitPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 100, 2));
                    }
                }
                else {
                    ((Player) e.getEntity().getShooter()).sendMessage(ChatColor.RED + "You can't use that!");
                }
            }
        }
    }
    @EventHandler
    public static void PickUpTrident(EntityPickupItemEvent e) {
        if (e.getEntity() instanceof Player) {
            if (e.getItem().getItemStack().equals(new ItemStack(Material.TRIDENT))) {
                if (((Player) e.getEntity()).getFlySpeed() != 0.2f) {
                    Player p = (Player) e.getEntity();
                    p.getInventory().remove(new ItemStack(Material.TRIDENT));
                }
            }
        }
    }
}
