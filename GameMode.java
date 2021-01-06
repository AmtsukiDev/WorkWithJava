public class GameMode implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("comando eseguibile solo in gioco");
            return true;
        }
        String survivalPerm = Main.getInstance().getConfig().getString("GameMode" + ".0");
        String creativePerm = Main.getInstance().getConfig().getString("GameMode" + ".1");
        String adventurePerm = Main.getInstance().getConfig().getString("GameMode" + ".2");
        String spectatorPerm = Main.getInstance().getConfig().getString("GameMode" + ".3");
        if (command.getName().equals("gamemode")) {
            if (args.length >= 1) {
                assert survivalPerm != null;
                if (sender.hasPermission(survivalPerm)) {
                    if (args[0].equals("0")) {
                        ((Player) sender).setGameMode(org.bukkit.GameMode.SURVIVAL);
                        String survival = ChatColor.translateAlternateColorCodes('&', "&a&lGameMode 0");
                        ((Player) sender).sendTitle("", survival, 0 ,30 ,3);
                        ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 50, 50);
                    }
                }
                assert creativePerm != null;
                if (sender.hasPermission(creativePerm)) {
                    if (args[0].equals("1")) {
                        ((Player) sender).setGameMode(org.bukkit.GameMode.CREATIVE);
                        String creative = ChatColor.translateAlternateColorCodes('&', "&a&lGameMode 1");
                        ((Player) sender).sendTitle("", creative, 0 ,30 ,3);
                        ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 50, 50);
                    }
                }
                assert adventurePerm != null;
                if (sender.hasPermission(adventurePerm)) {
                    if (args[0].equals("2")) {
                        ((Player) sender).setGameMode(org.bukkit.GameMode.ADVENTURE);
                        String adventure = ChatColor.translateAlternateColorCodes('&', "&a&lGameMode 2");
                        ((Player) sender).sendTitle("", adventure, 0 ,30 ,3);
                        ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 50, 50);
                    }
                }
                assert spectatorPerm != null;
                if (sender.hasPermission(spectatorPerm)) {
                    if (args[0].equals("3")) {
                        ((Player) sender).setGameMode(org.bukkit.GameMode.SPECTATOR);
                        String spectator = ChatColor.translateAlternateColorCodes('&', "&a&lGameMode 3");
                        ((Player) sender).sendTitle("", spectator, 0 ,30 ,3);
                        ((Player) sender).playSound(Objects.requireNonNull(((Player) sender).getPlayer()).getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 50, 50);
                    }
                }
            }
        } 
        return false;
    }
}