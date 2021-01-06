package com.atmsuki.thundercommand.spawn;

import com.atmsuki.thundercommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class Spawn implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String s, String[] strings) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("comando eseguibile solo in gioco");
            return true;
        }
        if(command.getName().equals("spawn")){
            if(sender.hasPermission(Objects.requireNonNull(Main.getInstance().getConfig().getString("perms" + ".spawn")))){
                double x = Main.getInstance().getConfig().getInt("spawn" + ".x");
                double y = Main.getInstance().getConfig().getInt("spawn" + ".y");
                double z = Main.getInstance().getConfig().getInt("spawn" + ".z");
                double yaw = Main.getInstance().getConfig().getInt("spawn" + ".yaw");
                double pitch = Main.getInstance().getConfig().getInt("spawn" + ".pitch");
                String world = Main.getInstance().getConfig().getString("spawn" + ".world");
                assert world != null;
                Location spawn = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);
                Objects.requireNonNull(((Player) sender).getPlayer()).teleport(spawn);
                ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 50,50);
                ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.BLOCK_STONE_BREAK, 50,50);
                Objects.requireNonNull(((Player) sender).getPlayer()).getWorld().strikeLightningEffect(spawn);
                String Title = ChatColor.translateAlternateColorCodes('&',"&9&lϟMineThunderϟ");
                ((Player) sender).sendTitle("", Title, 0 ,30, 3);
            } else {
                String deniedAccess = ChatColor.translateAlternateColorCodes('&',"&c!AccessoNegato!");
                ((Player) sender).sendTitle("", deniedAccess, 0 ,30, 3);
                ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.ENTITY_WOLF_GROWL , 50 ,50);
                }
            }
        return false;
    }
}
