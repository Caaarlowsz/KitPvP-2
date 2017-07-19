package net.meziyani.kitpvp.players;

import net.meziyani.kitpvp.Core;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;

/**
 * Created by yanim on 2017-07-17.
 */
public class PlayerManager implements Listener {
    private ArrayList<MPlayer> players;
    private Core core;

    public PlayerManager(Core core){
        this.core = core;
        players = new ArrayList<MPlayer>();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e){
        System.out.println("MPlayer");
        Player p = e.getPlayer();
        MPlayer mp = new MPlayer(p);
        players.add(mp);
        System.out.println(players.size());
    }

    @EventHandler
    public void onLeave(PlayerQuitEvent e){
        Player p = e.getPlayer();
        try{
            players.remove(getMPlayerIndex(p));
        } catch(Exception ex){}

    }

    public MPlayer getMPlayer(Player p){
        for(MPlayer mpl : players){
            if(p == mpl.getPlayer()){
                return mpl;
            }
        }
        return null;
    }

    public int getMPlayerIndex(Player p){
        int i = 0;
        for(MPlayer mpl : players){
            if(p == mpl.getPlayer()){
                return i;
            }
            i++;
        }
        return -1;
    }

    public ArrayList getPlayersList(){
        return players;
    }


}
