package net.meziyani.kitpvp.events.all;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import net.meziyani.kitpvp.utils.Symbols;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;

/**
 * Created by yanim on 2017-07-17.
 */
public class PlayerEvents implements Listener{

    private Core core;

    public PlayerEvents(Core core){
        this.core = core;
    }

    @EventHandler
    public void onFood(FoodLevelChangeEvent e){
        if(!(e.getEntity() instanceof Player)){return;}
        Player p = (Player) e.getEntity();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(!(mpl.getState().canLoseFood)){e.setCancelled(true);}

    }

    @EventHandler
    public void onBreak(BlockBreakEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(!(mpl.getState().canBuild)){e.setCancelled(true);}

    }

    @EventHandler
    public void onBreak(BlockPlaceEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(!(mpl.getState().canBuild)){e.setCancelled(true);}

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)){return;}
        Player p = (Player) e.getEntity();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(!(mpl.getState().canBeDamaged)){e.setCancelled(true);}

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.setDeathMessage("");
        Player p = e.getEntity();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        String message = "&9"+p.getName()+" &7(&c "+(p.getHealth()/2)+ " " + Symbols.HEART+" &7)"+
                " has been killed by &9"
                +p.getKiller()+" &7( "+
                (p.getKiller().getHealth()/2)+" " +
                Symbols.HEART+" &7)";
        mpl.sendMessage(message);

    }


}
