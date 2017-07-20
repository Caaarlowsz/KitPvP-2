package net.meziyani.automessages;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by yanim on 2017-07-18.
 */
public class AutoMessages extends JavaPlugin{

    public List<String> messages;
    public boolean enabled;
    public int delay;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        messages = new ArrayList<String>();
        messages = getConfig().getStringList("messages");
        enabled = getConfig().getBoolean("enabled");
        delay = getConfig().getInt("delay");
        new BukkitRunnable()
        {
            @Override
            public void run()
            {
                if(enabled){
                    Random r = new Random();
                    int Low = 0;
                    int High = messages.size();
                    int Result = r.nextInt(High-Low) + Low;
                    for(Player p : getServer().getOnlinePlayers()) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', messages.get(Result)));
                    }
                }

            }
        }.runTaskTimer(this, 100, 100*delay);
        Bukkit.getPluginCommand("automessages").setExecutor(new MessagesCommand(this));
        super.onEnable();
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }

}
