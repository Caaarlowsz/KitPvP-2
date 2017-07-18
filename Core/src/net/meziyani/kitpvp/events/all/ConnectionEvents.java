package net.meziyani.kitpvp.events.all;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.gameplay.inventory.inventories.JoinInventory;
import net.meziyani.kitpvp.players.MPlayer;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

/**
 * Created by yanim on 2017-07-18.
 */
public class ConnectionEvents implements Listener{

    private Core core;

    public ConnectionEvents(Core core){
        this.core = core;
    }

    @EventHandler(priority = EventPriority.HIGH)
    public void onJoin(PlayerJoinEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);
        System.out.println(mpl);
        mpl.giveInventory(core.ji);
        mpl.goToSpawn(core);
        mpl.getPlayer().setGameMode(GameMode.SURVIVAL);
        e.setJoinMessage("");
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        e.setQuitMessage("");
    }

}
