package net.meziyani.automessages;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by yanim on 2017-07-18.
 */
public class MessagesCommand implements CommandExecutor{

    private AutoMessages am;

    public MessagesCommand(AutoMessages am){
        this.am = am;
    }


    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] strings) {

        if(strings.length == 0){
            sendSenderMessage(commandSender, "You need arguments, example: reload, disable, enable");

        } else {
            if(strings[0].equalsIgnoreCase("reload")){

                am.reloadConfig();
                am.messages = am.getConfig().getStringList("messages");
                am.enabled = am.getConfig().getBoolean("enabled");
                sendSenderMessage(commandSender, "[AutoMessages] Reloaded successfully!");
            } else if(strings[0].equalsIgnoreCase("disable")){

                am.getConfig().set("enabled", false);
                am.saveConfig();
                am.reloadConfig();
                am.enabled = am.getConfig().getBoolean("enabled");
            } else if(strings[0].equalsIgnoreCase("enable")){

                am.getConfig().set("enabled", true);
                am.saveConfig();
                am.reloadConfig();
                am.enabled = am.getConfig().getBoolean("enabled");
            }
        }

        return false;
    }

    public void sendSenderMessage(CommandSender sender, String message){
        String nm = ChatColor.translateAlternateColorCodes('&', message);
        System.out.println(nm);
        if(sender instanceof Player){
            ((Player)sender).sendMessage(nm);
        }
    }

}
