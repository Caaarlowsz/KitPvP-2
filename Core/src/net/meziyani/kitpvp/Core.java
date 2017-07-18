package net.meziyani.kitpvp;
import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import net.meziyani.kitpvp.commands.MainCmd;
import net.meziyani.kitpvp.events.EventManager;
import net.meziyani.kitpvp.gameplay.inventory.inventories.JoinInventory;
import net.meziyani.kitpvp.kit.KitSelector;
import net.meziyani.kitpvp.players.PlayerManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by yanim on 2017-07-17.
 */
public class Core extends JavaPlugin{

    public PlayerManager plm;
    public KitSelector ks;
    public EventManager em;
    public JoinInventory ji;



    @java.lang.Override
    public void onEnable() {
        //Instantiate objects
        ks = new KitSelector(this);
        em = new EventManager(this);
        plm = new PlayerManager(this);
        ji = new JoinInventory(this);

        saveDefaultConfig();

        //Register command executor and events
        em.registerEvents();
        Bukkit.getPluginCommand("kitpvp").setExecutor(new MainCmd(this));
        Bukkit.getPluginCommand("points").setExecutor(new MainCmd(this));
        Bukkit.getPluginCommand("spawn").setExecutor(new MainCmd(this));
        Bukkit.getPluginCommand("setspawn").setExecutor(new MainCmd(this));

        System.out.println("[KitPvP] Plugin activated");
        super.onEnable();
    }

    @java.lang.Override
    public void onDisable() {
        System.out.println("[KitPvP] Plugin deactivated");
        super.onDisable();
    }

    public PlayerManager getPlayerManager(){
        return this.plm;
    }

    public WorldGuardPlugin getWorldGuard() {
        Plugin plugin = getServer().getPluginManager().getPlugin("WorldGuard");

        // WorldGuard may not be loaded
        if (plugin == null || !(plugin instanceof WorldGuardPlugin)) {
            System.out.println(ChatColor.RED+"[ALERT!] WorldGuard dependency missing to the kitpvp plugin. Disabling it...");
            getServer().getPluginManager().disablePlugin(this);
        }

        return (WorldGuardPlugin) plugin;
    }

}
