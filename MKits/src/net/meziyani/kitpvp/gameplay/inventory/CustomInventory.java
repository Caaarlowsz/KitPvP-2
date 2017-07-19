package net.meziyani.kitpvp.gameplay;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanim on 2017-07-18.
 */
public abstract class CustomInventory implements Listener{

    public Core core;
    protected HashMap<Integer, ItemStack> items = new HashMap<Integer, ItemStack>();


    public CustomInventory(Core core){
        this.core = core;
        addItems();
    }

    public abstract void addItems();

    public HashMap<Integer, ItemStack> getItems(){
        return items;
    }



}
