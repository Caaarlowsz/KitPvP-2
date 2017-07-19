package net.meziyani.kitpvp.kit;

import net.meziyani.kitpvp.kit.kits.Viper;
import net.meziyani.kitpvp.kit.kits.Warrior;
import org.bukkit.Material;

/**
 * Created by yanim on 2017-07-17.
 */
public enum Kits {
    VIPER(new Viper("Viper", Material.SPIDER_EYE, 0)),
    WARRIOR(new Warrior("Warrior",Material.IRON_CHESTPLATE, 0));

    private Kit kit;

    Kits(Kit kit){
        this.kit = kit;
    }

    public Kit getKit(){
        return kit;
    }

}
