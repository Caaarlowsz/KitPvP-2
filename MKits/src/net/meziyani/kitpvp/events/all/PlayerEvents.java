package net.meziyani.kitpvp.events.all;

import com.sk89q.worldguard.LocalPlayer;
import com.sk89q.worldguard.bukkit.WGBukkit;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import net.meziyani.kitpvp.players.PlayerState;
import net.meziyani.kitpvp.utils.Symbols;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

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
    public void onPlace(BlockPlaceEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(!(mpl.getState().canBuild)){e.setCancelled(true);}

    }

    @EventHandler
    public void onDrop(PlayerDropItemEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(!(mpl.getState().canDrop)){e.setCancelled(true);}

    }

    @EventHandler
    public void onDamage(EntityDamageEvent e){
        if(!(e.getEntity() instanceof Player)){return;}
        Player p = (Player) e.getEntity();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(!(mpl.getState().canBeDamaged)){e.setCancelled(true);}
        if (e.getCause() == EntityDamageEvent.DamageCause.FALL && p.hasPotionEffect(PotionEffectType.REGENERATION)) {
            e.setCancelled(true);
        }

    }

    @EventHandler
    public void onDeath(PlayerDeathEvent e){
        e.setDeathMessage("");
        Player p = e.getEntity();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);

        if(p.getKiller() != null && p.getKiller() instanceof Player){
            String message = "&9"+p.getName()+" &7has been killed by &9" +p.getKiller().getName()+" &7( &c"+ (p.getKiller().getHealth()/2)+" " + Symbols.HEART+" &7)";
            mpl.sendMessage(message);
            core.getPlayerManager().getMPlayer(p.getKiller()).sendMessage(message);
        }



    }

    @EventHandler
    public void onRegionEnter(PlayerMoveEvent e){
        Player p = e.getPlayer();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);
        try {
            if (mpl.getState() == PlayerState.LOBBY) {

                LocalPlayer lp = core.getWorldGuard().wrapPlayer(p);
                RegionManager rm = core.getWorldGuard().getRegionManager(p.getWorld());
                ApplicableRegionSet now = rm.getApplicableRegions(p.getLocation());
                ApplicableRegionSet before = rm.getApplicableRegions(e.getFrom());
                for (ProtectedRegion region : now) {
                    System.out.println(region.getId());
                    if (region.getId().equalsIgnoreCase(core.getConfig().getString("fightregion"))) {
                        mpl.setState(PlayerState.FIGHT);
                        p.playSound(p.getLocation(), Sound.LEVEL_UP, (float) 1, (float) 1);
                        p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 0));
                        mpl.giveKit();
                    }
                }
            }
        } catch (NullPointerException ex){
            p.kickPlayer("An error has occured please reconnect! Err Code: #001");
        }
    }



}
