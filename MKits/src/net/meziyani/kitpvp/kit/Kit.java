package net.meziyani.kitpvp.kit;

import net.meziyani.kitpvp.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

import org.bukkit.inventory.Inventory;

import java.util.ArrayList;

/**
 * Created by yanim on 2017-07-17.
 */
public abstract class Kit implements Listener {

    protected Inventory stuff;
    protected ItemStack icon;
    protected int price;
    protected String name;
    protected Material[] armor;
    protected ItemStack sword;
    protected ItemStack wand;

    public Kit(String name, ItemStack icon, int price, Material[] armor, ItemStack sword, ItemStack wand){
        this.name = name;
        this.price = price;
        this.icon = icon;
        this.armor = armor;
        this.wand = wand;
        this.sword = sword;
    }

    public abstract void effect();

    public ItemStack[] getArmor(){
        ItemStack[] armorContents = new ItemStack[4];
        int i = 0;
        while(i < 4){
            armorContents[i] = new ItemStack(armor[i], 1);
            i++;
        }
        return armorContents;
    }

    public ItemStack getSword(){
        return this.sword;
    }

    public ItemStack getWand(){
        return this.wand;
    }

    public ItemStack getIcon(){
        return this.icon;
    }



}
