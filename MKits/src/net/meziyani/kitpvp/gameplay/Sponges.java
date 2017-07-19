package net.meziyani.kitpvp.gameplay;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.util.Vector;


public class Sponges implements Listener {


    @EventHandler
    public void onSponge(PlayerMoveEvent e) {

        Player p = e.getPlayer();
        Location loc = new Location(p.getWorld(), p.getLocation().getX(), p.getLocation().getY() - 1, p.getLocation().getZ());

        if (loc.getBlock().getType() == Material.SPONGE) {

            Vector v = p.getVelocity();
            v.setY(3);
            p.setVelocity(v);
            p.addPotionEffect(new PotionEffect(PotionEffectType.REGENERATION, 120, 0));

        } else if ((p.getLocation().getBlock().getType() == Material.CARPET) && (p.getLocation().getBlock().getData() == 12)) {
            p.setVelocity(p.getLocation().getDirection().multiply(4));
            p.setVelocity(new Vector(p.getVelocity().getX(), 1.0D, p.getVelocity().getZ()));
            p.playEffect(p.getLocation(), Effect.SMOKE, 0);
        }

    }

}
