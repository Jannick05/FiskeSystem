package dk.nydt.utils;

import net.md_5.bungee.api.ChatColor;

public class Chat {
    public static String colored(String s) {
        return ChatColor.translateAlternateColorCodes('&', s);
    }
    public static String plain(String s) {
        return s.replaceAll("§", "&");

    }

}
