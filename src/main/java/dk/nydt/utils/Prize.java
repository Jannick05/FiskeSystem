package dk.nydt.utils;

import dk.nydt.Fisk;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Prize {

    private float percentage;

    private String name;

    private List<String> commands;
    private List<String> messages;

    private ItemStack previewItem;

    public Prize() {

    }

    public Prize(String path){
        this.name = Fisk.configYML.getString("Fangster." + path + ".Name");
        Material itemType = Material.valueOf(Fisk.configYML.getString("Fangster." + path + ".Item-Type").toUpperCase());
        boolean isEnchanted = Fisk.configYML.getBoolean("Fangster." + path + ".Enchanted");
        this.percentage = (float) Fisk.configYML.getDouble("Fangster." + path + ".Chance");
        this.commands = Fisk.configYML.getStringList("Fangster." + path + ".Commands");
        this.messages = Fisk.configYML.getStringList("Fangster." + path + ".Messages");

        ItemStack previewItem = new ItemStack(itemType);
        if(isEnchanted) previewItem.addUnsafeEnchantment(Enchantment.LURE, 1);

        ItemMeta itemMeta = previewItem.getItemMeta();
        itemMeta.setDisplayName(Chat.colored(name));


        if(isEnchanted) itemMeta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        previewItem.setItemMeta(itemMeta);

        this.previewItem = previewItem;
    }

    public String getName(){
        return this.name;
    }
    public List<String> getCommands(){
        return this.commands;
    }
    public List<String> getMessages(){
        return this.messages;
    }
    public ItemStack getPreviewItem(){
        return this.previewItem;
    }
    public float getChance() {
        return this.percentage;
    }

    public void runCommands(Player player){
        for(String command : this.commands)
            Bukkit.dispatchCommand(Bukkit.getConsoleSender(), command.replaceAll("%player%", player.getName()));
    }
    public void runMessages(Player player){
        for(String message : this.messages)
            player.sendMessage(Chat.colored(message.replace("%Player%", player.getName())));

    }



}
