package net.meziyani.database;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Created by yanim on 2017-07-19.
 */
public class MDatabase extends JavaPlugin{

    @Override
    public void onEnable() {
        saveDefaultConfig();
        System.out.println("[MDatabase] Plugin enabled");

        super.onEnable();
    }

    @Override
    public void onDisable() {
        System.out.println("[MDatabase] Plugin disabled");
        super.onDisable();
    }

    public Database getDatabase(String name){
        return new Database(name, this);
    }



}
