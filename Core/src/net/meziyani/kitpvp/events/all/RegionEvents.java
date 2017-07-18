package net.meziyani.kitpvp.events.all;

import com.mewin.WGRegionEvents.events.RegionEnterEvent;
import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import net.meziyani.kitpvp.players.PlayerState;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

/**
 * Created by yanim on 2017-07-18.
 */
public class RegionEvents implements Listener{

    private Core core;

    public RegionEvents(Core core) {
        this.core = core;
    }

    @EventHandler(priority = EventPriority.NORMAL)
    public void onRegionEnter(RegionEnterEvent e){
        //if(e.getRegion().getId().equalsIgnoreCase(core.getConfig().getString("fightregion"))) {return;}
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);
        mpl.setState(PlayerState.FIGHT);
        mpl.giveKit();
    }

}
