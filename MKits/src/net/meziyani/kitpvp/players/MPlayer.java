package net.meziyani.kitpvp.players;

import net.meziyani.kitpvp.Core;
import net.meziyani.kitpvp.gameplay.CustomInventory;
import net.meziyani.kitpvp.kit.Kits;
import net.meziyani.kitpvp.utils.LocationUtil;
import net.meziyani.kitpvp.utils.Title;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by yanim on 2017-07-17.
 */
public class MPlayer {

    private Kits kit = Kits.WARRIOR;
    private int points = 0;
    private Player p;
    private PlayerState ps;

    public MPlayer(Player p){
        this.p = p;
        this.ps = PlayerState.LOBBY;
    }

    public void openInventory(Inventory inv){
        p.openInventory(inv);
    }

    public void sendMessage(String message){
        p.sendMessage(message.replaceAll("&", "§"));
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Kits getKit(){
        return this.kit;
    }

    public void setKit(Kits k){
        this.kit = k;
        sendTitle(new Title("§a"+kit.name(), "Kit selected", 1,2,1));


    }

    public void sendTitle(Title title){
        title.send(p);
    }

    public Player getPlayer() {
        return p;
    }

    public int getPoints() {

        return points;
    }

    public void giveInventory(CustomInventory ci){
        p.getInventory().clear();
        HashMap<Integer, ItemStack> map = ci.getItems();
        for (HashMap.Entry<Integer, ItemStack> item : map.entrySet())
        {
            p.getInventory().setItem(item.getKey(), item.getValue());
            p.updateInventory();
        }
    }

    public PlayerState getState(){
        return ps;
    }

    public void setState(PlayerState ps){
        this.ps = ps;
    }

    public void giveKit(){
        p.getInventory().clear();
        p.getInventory().setArmorContents(kit.getKit().getArmor());
        p.getInventory().setItem(0, kit.getKit().getSword());
        p.getInventory().setItem(1, kit.getKit().getWand());
        for(int slot = 0; slot < p.getInventory().getSize(); slot++) {
            if(p.getInventory().getItem(slot) == null) {
                p.getInventory().setItem(slot, new ItemStack(Material.MUSHROOM_SOUP, 1));
            }
        }
        p.updateInventory();

    }

    public void goToSpawn(Core core){
        try{
            String spawn_s = core.getConfig().getString("spawn");
            Location spawn = LocationUtil.deserialise(spawn_s);
            p.teleport(spawn);
        } catch (NullPointerException ex){
            System.out.println("[KitPvP] Spawn not defined");
        }

    }

}
