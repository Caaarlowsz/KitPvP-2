package net.meziyani.kitpvp.kit.kits;

import net.meziyani.kitpvp.kit.Kit;
import net.meziyani.kitpvp.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;

/**
 * Created by yanim on 2017-07-17.
 */
public class Warrior extends Kit{

    protected static Material[] _armor = new Material[]{Material.DIAMOND_HELMET, Material.DIAMOND_CHESTPLATE, Material.DIAMOND_LEGGINGS, Material.DIAMOND_BOOTS};
    protected static ItemStack _sword = new ItemBuilder(Material.DIAMOND_SWORD, 1).toItemStack();
    protected static ItemStack _wand = new ItemBuilder(Material.SPIDER_EYE,1).toItemStack();

    public Warrior(String name, Material icon, int price) {
        super(name,
                new ItemBuilder(icon, 1)
                        .setName("&c"+name)
                        .setLore("§9Price: §f"+price+" pts")
                        .toItemStack(), 0, _armor, _sword, _wand
        );
    }

    @Override
    public void effect() {
        System.out.println("Kit effect activated");
    }
}
