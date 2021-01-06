package com.atmsuki.thundercommand.commands;

import com.atmsuki.thundercommand.Main;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Objects;

public class AnyDesk implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(!(sender instanceof Player)) {
            sender.sendMessage("comando eseguibile solo in gioco");
            return true;
        }
        if(sender.hasPermission(Objects.requireNonNull(Main.getInstance().getConfig().getString("perms" + ".anydesk")))){
            if(Main.getInstance().getConfig().getString("AnyDesk") == null){
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&',"&c&lAnydesk: &clink non inserito nel config.yml"));
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l&m-----------------------------------"));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cAnydesk: " + Main.getInstance().getConfig().getString("AnyDesk")));
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', "&c&l&m-----------------------------------"));
            }
            ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.UI_BUTTON_CLICK, 50,50);
        } else {
                String deniedAccess = ChatColor.translateAlternateColorCodes('&',"&c!AccessoNegato!");
                ((Player) sender).sendTitle("", deniedAccess, 0 ,30, 3);
                ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.ENTITY_WOLF_GROWL , 50 ,50);
            }
        return false;
    }
}