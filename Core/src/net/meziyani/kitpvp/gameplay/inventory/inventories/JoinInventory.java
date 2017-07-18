package net.meziyani.kitpvp.gameplay.inventory.inventories;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.gameplay.CustomInventory;
import net.meziyani.kitpvp.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;

/**
 * Created by yanim on 2017-07-18.
 */
public class JoinInventory extends CustomInventory{

    public JoinInventory(Core core){
        super(core);
    }

    @Override
    public void addItems() {
        items.put(0, new ItemBuilder(Material.EYE_OF_ENDER, 1).setName("&6Kit Selector").addUnsafeEnchantment(Enchantment.DURABILITY, 1).toItemStack());
        items.put(8, new ItemBuilder(Material.REDSTONE, 1).setName("&71v1").toItemStack());
    }


}
