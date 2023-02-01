package dk.nydt.commands;

import dk.nydt.Main;
import dk.nydt.utils.Chat;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Fisk implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Player p = (Player) sender;
        String _command = (label == null) ? String.valueOf(command) : label;
        if(args.length == 0) {
            if (!p.hasPermission("Fisk.admin")) {
                sendNoobDefaultCommand(sender, _command);
            } else {
                sendAdminDefaultCommand(sender, _command);
            }
            return true;
        } else if (args[0].equalsIgnoreCase("fangster")) {
            p.openInventory(Main.rc.getPreview());
            return true;
        } else if (!p.hasPermission("fisk.admin")) {
            sender.sendMessage(Chat.colored("&cIngen adgang"));
            return true;
        } else if (args[0].equalsIgnoreCase("reload")) {
            boolean reloadSuccess;
            try {
                Main.config.reloadConfig();
                Main.configYML = Main.config.getConfig();
                Main.rc.reload();
                reloadSuccess = true;
            } catch(Exception e){
                e.printStackTrace();
                reloadSuccess = false;
            }
            if(reloadSuccess) {
                sender.sendMessage(Chat.colored("&aReload successfully completed"));
            } else {
                sender.sendMessage(Chat.colored("&cAn error occurred. Please check the console."));
            }
            return true;
        } else {
            return false;
        }
    }
    private void sendAdminDefaultCommand(CommandSender sender, String command){
        String sb = "";
        sb = sb + "\n ";
        sb = sb + "&7/" + command + " reload &8&fReloader &econfig.yml\n ";
        sb = sb + "&7/" + command + " fangster &8&fÅbner GUI med &eFangster\n ";
        sender.sendMessage(Chat.colored(sb));
    }
    private void sendNoobDefaultCommand(CommandSender sender, String command){
        String sb = "";
        sb = sb + "\n ";
        sb = sb + "&7/" + command + " fangster &8&fÅbner GUI med &eFangster\n ";
        sender.sendMessage(Chat.colored(sb));
    }
}
