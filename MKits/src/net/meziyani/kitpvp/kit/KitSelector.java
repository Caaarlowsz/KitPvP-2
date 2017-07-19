package net.meziyani.kitpvp.kit;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.event.inventory.InventoryClickEvent;

import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

/**
 * Created by yanim on 2017-07-17.
 */
public class KitSelector implements Listener {
    private ArrayList<Kits> kits;
    private Core core;
    private Inventory inv;

    public KitSelector(Core core){
        this.core = core;
        kits = new ArrayList<Kits>();
        initKits();
    }

    public void initKits(){
        for (Kits kit : Kits.values()) {
            kits.add(kit);
        }
        createInventory();
    }

    public void createInventory(){
        inv = Bukkit.createInventory(null, 36, "§aSelect Kit");
        for(Kits kit : kits){
            inv.addItem(kit.getKit().getIcon());
        }
    }

    public Inventory getInventory(){
        return inv;
    }

    @EventHandler
    public void onInvClic(InventoryClickEvent e){
        if (e.getSlot() < 0) return;
        if (!e.getInventory().getName().equalsIgnoreCase(inv.getName())) return;
        if (e.getCurrentItem().getItemMeta() == null) return;

        Player p = (Player) e.getWhoClicked();
        MPlayer mpl = core.getPlayerManager().getMPlayer(p);
        e.setCancelled(true);
        String str = e.getCurrentItem().getItemMeta().getDisplayName();
        for(Kits kit : kits){
            if(str.contains(kit.getKit().name)){
                mpl.setKit(kit);
                p.closeInventory();
                break;
            }
        }



    }

}
