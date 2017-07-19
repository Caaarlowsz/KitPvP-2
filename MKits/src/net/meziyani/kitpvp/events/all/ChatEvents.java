package net.meziyani.kitpvp.events.all;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by yanim on 2017-07-17.
 */
public class ChatEvents implements Listener{

    private Core core;

    public ChatEvents(Core core){
        this.core = core;
    }

    @EventHandler
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);
        e.setMessage(ChatColor.translateAlternateColorCodes('&', e.getMessage()));
        e.setFormat("§e[Dev] §f"+p.getName() + " >> "  + "%2$s");
    }

}
