package com.atmsuki.thundercommand;

import com.atmsuki.thundercommand.commands.AnyDesk;
import com.atmsuki.thundercommand.commands.GameMode;
import com.atmsuki.thundercommand.commands.Site;
import com.atmsuki.thundercommand.events.Join;
import com.atmsuki.thundercommand.spawn.Spawn;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public final class Main extends JavaPlugin {

    private static Main instance;

    public static Main getInstance() {
        return instance;
    }

    @Override
    public void onEnable() {
        instance = this;
        saveDefaultConfig();
        Objects.requireNonNull(getCommand("spawn")).setExecutor(new Spawn());
        Objects.requireNonNull(getCommand("gamemode")).setExecutor(new GameMode());
        Objects.requireNonNull(getCommand("anydesk")).setExecutor(new AnyDesk());
        Objects.requireNonNull(getCommand("site")).setExecutor(new Site());
        getServer().getPluginManager().registerEvents(new Join(), this);
    }
}
