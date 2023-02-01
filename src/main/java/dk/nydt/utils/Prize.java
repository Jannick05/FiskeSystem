package dk.nydt.utils;

import com.sun.org.apache.xpath.internal.operations.Bool;
import dk.nydt.Main;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public class Prize {

    private float percentage;

    private String name;
    private String AddItem;
    private List<String> commands;
    private List<String> messages;

    private ItemStack previewItem;

    public Prize() {

    }

    public Prize(String path){
        this.name = Main.configYML.getString("Fangster." + path + ".Name");
        this.AddItem = Main.configYML.getString("Fangster." + path + ".Add-Item");
        Material itemType = Material.valueOf(Main.configYML.getString("Fangster." + path + ".Item-Type").toUpperCase());
        boolean isEnchanted = Main.configYML.getBoolean("Fangster." + path + ".Enchanted");
        this.percentage = (float) Main.configYML.getDouble("Fangster." + path + ".Chance");
        this.commands = Main.configYML.getStringList("Fangster." + path + ".Commands");
        this.messages = Main.configYML.getStringList("Fangster." + path + ".Messages");

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

    public String getAddItem(){
        return this.AddItem;
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
