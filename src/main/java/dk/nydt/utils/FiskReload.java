package dk.nydt.utils;

import dk.nydt.Main;
import org.bukkit.Bukkit;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

import java.util.Collections;
import java.util.List;
import java.util.Set;

public class FiskReload {
    private ArrayList<Prize> prizes = new ArrayList<>();
    private Inventory preview;
    public void reload() {

        // Generate Preview INV
        int size = 9;
        Set<String> prizes = Main.configYML.getConfigurationSection("Fangster").getKeys(false);
        if (prizes.size() > 9) size = 18;
        if (prizes.size() > 18) size = 27;
        if (prizes.size() > 27) size = 36;
        if (prizes.size() > 36) size = 45;
        if (prizes.size() > 45) size = 54;


        Inventory inventory = Bukkit.createInventory(null, size, Chat.colored(Main.configYML.getString("GUI.Guiname")));



        float totalPercentage = 0.00f;

        int n = 0;
        List<String> ITEM_LORE = Main.configYML.getStringList("GUI.Lorename");
        for(String winning : prizes){
            Prize prize = new Prize(winning);


            inventory.setItem(n, GUI.createItemStack(prize.getPreviewItem(), Chat.colored(prize.getName()), Chat.colored(String.valueOf( "&a" + prize.getChance() + " &fChance"))));

            this.prizes.add(prize);
            totalPercentage += prize.getChance();
            n++;
        }
        this.preview = inventory;

        if(totalPercentage > 100.00f){
            Main.getInstance().getLogger().warning("The total percentage for the FiskSystem is over 100%");
        }
        if(totalPercentage < 100.00f){
            Main.getInstance().getLogger().warning("The total percentage for the FiskSystem is under 100%");
        }



    }


    public ArrayList<Prize> getPrizes(){
        return this.prizes;
    }

    public Inventory getPreview(){
        return this.preview;
    }
}
