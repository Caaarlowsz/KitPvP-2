package net.meziyani.kitpvp.ranks;

import org.bukkit.ChatColor;

/**
 * Created by yanim on 2017-07-18.
 */
public enum MRanks {

    DEV("[Dev]", "[D]", ChatColor.YELLOW), PLAYER("", "", ChatColor.GRAY), ADMIN("[Admin]", "[A]", ChatColor.RED);


    MRanks(String prefixChat, String prefixTab, ChatColor color) {
    }
}
