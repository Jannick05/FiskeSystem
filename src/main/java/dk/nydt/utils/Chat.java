package dk.nydt.utils;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Chat {
    public static String colored(String s){
        return ChatColor.translateAlternateColorCodes('&', s);
    }

    public static String plain(String s) {
        return s.replaceAll("§", "&");

    }

    public static List<String> getColored(List<String> lores){
        List<String> coloredLores = new ArrayList<String>();
        for(String lore : lores){
            coloredLores.add(ChatColor.translateAlternateColorCodes('&', lore)); }
        return coloredLores;
    }

}
