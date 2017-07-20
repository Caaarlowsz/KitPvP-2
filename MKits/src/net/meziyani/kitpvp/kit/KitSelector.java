package net.meziyani.kitpvp.kit;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.players.MPlayer;
import net.meziyani.kitpvp.utils.ItemBuilder;
import org.bukkit.Bukkit;
import org.bukkit.enchantments.Enchantment;
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
    private int size = 36;
    private String name = "§aSelect Kit";

    public KitSelector(Core core){
        this.core = core;
        kits = new ArrayList<Kits>();
        initKits();
    }

    public void initKits(){
        for (Kits kit : Kits.values()) {
            kits.add(kit);
        }
    }

    public Inventory getInventory(MPlayer mpl){
        Inventory inv = Bukkit.createInventory(mpl.getPlayer(),  size, name);;
        for(Kits kit : kits){
            if(mpl.getKit().name().equalsIgnoreCase(kit.name())){
                System.out.println(mpl.getKit().name());
                ItemStack current = new ItemBuilder(kit.getKit().getIcon().getType(), kit.getKit().getIcon().getAmount()).setName(kit.getKit().getIcon().getItemMeta().getDisplayName()).toItemStack();
                inv.addItem(new ItemBuilder(current).addEnchant(Enchantment.DURABILITY,1).toItemStack());
                continue;
            } else {
                System.out.println(mpl.getKit().name());
                inv.addItem(kit.getKit().getIcon());
                continue;
            }



        }
        return inv;
    }

    @EventHandler
    public void onInvClic(InventoryClickEvent e){
        if (e.getSlot() < 0) return;
        if (!e.getInventory().getName().equalsIgnoreCase(name)) return;
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
