package com.atmsuki.thundercommand.events;

import com.atmsuki.thundercommand.Main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Join implements Listener {


    @EventHandler
    public void join(PlayerJoinEvent e){
        Player p = e.getPlayer();
        double x = Main.getInstance().getConfig().getInt("spawn" + ".x");
        double y = Main.getInstance().getConfig().getInt("spawn" + ".y");
        double z = Main.getInstance().getConfig().getInt("spawn" + ".z");
        double yaw = Main.getInstance().getConfig().getInt("spawn" + ".yaw");
        double pitch = Main.getInstance().getConfig().getInt("spawn" + ".pitch");
        String world = Main.getInstance().getConfig().getString("spawn" + ".world");
        assert world != null;
        Location spawn = new Location(Bukkit.getWorld(world), x, y, z, (float) yaw, (float) pitch);
        p.teleport(spawn);
        p.playSound(p.getLocation(), Sound.ENTITY_LIGHTNING_BOLT_THUNDER, 50,50);
        p.playSound(p.getLocation(), Sound.BLOCK_STONE_BREAK, 50,50);
        p.getWorld().strikeLightningEffect(spawn);
        String Title = ChatColor.translateAlternateColorCodes('&',"&9&lϟMineThunderϟ");
        p.sendTitle("", Title, 0 ,30, 3);
    }
}
