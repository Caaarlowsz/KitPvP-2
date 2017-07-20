package net.meziyani.kitpvp.commands;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import net.meziyani.kitpvp.players.PlayerManager;
import net.meziyani.kitpvp.utils.LocationUtil;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 * Created by yanim on 2017-07-17.
 */
public class MainCmd implements CommandExecutor{
    private Core core;
    public MainCmd(Core core){
        this.core = core;
    }


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(sender instanceof Player){
            Player p = (Player)sender;
            MPlayer mpl = core.getPlayerManager().getMPlayer(p);
            if(cmd == Bukkit.getPluginCommand("kitpvp")){
                if(args.length == 0){
                    mpl.openInventory(core.ks.getInventory(mpl));
                } else {
                    String arg1 = args[0];


                }
            } else if(cmd == Bukkit.getPluginCommand("points")){
                if(args.length == 0){
                    mpl.sendMessage("Points: &a"+mpl.getPoints());
                } else {
                    String arg1 = args[0];
                    if(Bukkit.getPlayer(arg1) != null){
                        MPlayer np = new MPlayer(Bukkit.getPlayer(arg1));
                        mpl.sendMessage("Points ("+np.getPlayer().getName()+") : &a"+mpl.getPoints());
                    } else {
                        mpl.sendMessage("&cNope, not a player...");
                    }
                }
            } else if(cmd == Bukkit.getPluginCommand("setspawn")){
                Location spawn = p.getLocation();
                String spawn_s = LocationUtil.serialise(spawn);
                core.getConfig().set("spawn", spawn_s);
                core.saveConfig();
                mpl.sendMessage("&aSpawn set at your location!");
            } else if(cmd == Bukkit.getPluginCommand("spawn")){
                mpl.goToSpawn(core);
            }





        } else {
            System.out.println("Va niquer tes morts, la calotte de tes morts, DJO!");
        }
        return false;
    }
}
