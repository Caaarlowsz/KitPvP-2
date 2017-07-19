package net.meziyani.kitpvp.events.all;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import net.meziyani.kitpvp.players.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

/**
 * Created by yanim on 2017-07-18.
 */
public class DeathEvents implements Listener{

    private Core core;

    public DeathEvents(Core core) {
        this.core = core;
    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        Player p = e.getEntity();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

    }

    @EventHandler
    public void onReSpawn(PlayerRespawnEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(mpl.getState() != PlayerState.ADMIN){
            mpl.setState(PlayerState.LOBBY);
            mpl.goToSpawn(core);
            p.getInventory().clear();
            p.getActivePotionEffects().clear();
            mpl.giveInventory(core.ji);
        }
    }

}
