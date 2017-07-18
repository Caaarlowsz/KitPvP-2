package net.meziyani.kitpvp.events.all;

import net.meziyani.kitpvp.Core;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

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
        e.setDeathMessage("");
    }

}
