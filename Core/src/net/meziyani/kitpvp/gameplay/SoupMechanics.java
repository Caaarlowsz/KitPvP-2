package net.meziyani.kitpvp.gameplay;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

/**
 * Created by yanim on 2017-07-18.
 */
public class SoupMechanics implements Listener{

    private double health;
    private Core core;

    public SoupMechanics(Core core){
        this.core = core;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);
        if(p.getItemInHand().getType() == Material.MUSHROOM_SOUP){
            p.setHealth(p.getHealth()+health);
            p.getItemInHand().setType(Material.BOWL);
        }

    }

}
