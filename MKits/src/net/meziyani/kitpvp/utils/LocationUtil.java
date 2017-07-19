package net.meziyani.kitpvp.utils;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.World;

public class LocationUtil {

    public static String serialise(Location loc){
        String serialised = null;
        String world = loc.getWorld().getName();
        double x = loc.getX();
        double y = loc.getY();
        double z = loc.getZ();
        float pitch = loc.getPitch();
        float yaw = loc.getYaw();

        serialised = world+":"+x+":"+y+":"+z+":"+pitch+":"+yaw;

        return serialised;
    }

    public static Location deserialise(String serialised){
        Location loc = null;
        String[] parts = serialised.split(":");
        World world = Bukkit.getWorld(parts[0]);
        double x = Double.parseDouble(parts[1]);
        double y = Double.parseDouble(parts[2]);
        double z = Double.parseDouble(parts[3]);
        float pitch = Float.parseFloat(parts[4]);
        float yaw = Float.parseFloat(parts[5]);
        loc = new Location(world, x, y, z, yaw, pitch);

        return loc;
    }
}

 