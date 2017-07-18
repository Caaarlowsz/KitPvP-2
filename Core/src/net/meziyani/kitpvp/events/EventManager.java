package net.meziyani.kitpvp.events;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.events.all.*;
import net.meziyani.kitpvp.gameplay.SoupMechanics;
import net.meziyani.kitpvp.gameplay.Sponges;
import org.bukkit.plugin.PluginManager;

/**
 * Created by yanim on 2017-07-17.
 */
public class EventManager {

    private Core core;
    private PluginManager pm;

    public EventManager(Core core){
        this.core = core;
        this.pm = core.getServer().getPluginManager();
    }

    public void registerEvents(){
        //Register Player Manager Events
        pm.registerEvents(core.plm, core);
        //Register Kit Selector Events
        pm.registerEvents(core.ks, core);
        //Register join inventory
        pm.registerEvents(core.ji, core);

        //Other Events Registration
        pm.registerEvents(new RegionEvents(core), core);
        pm.registerEvents(new ChatEvents(core), core);
        pm.registerEvents(new DeathEvents(core), core);
        pm.registerEvents(new ConnectionEvents(core), core);
        pm.registerEvents(new PlayerEvents(core), core);
        pm.registerEvents(new Sponges(), core);
        pm.registerEvents(new SoupMechanics(core), core);

    }

}
