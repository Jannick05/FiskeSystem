package dk.nydt.utils;

import dk.nydt.Fisk;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;

import java.util.Set;

public class FiskReload {
    private ArrayList<Prize> prizes = new ArrayList<>();
    private ItemStack key;
    public void reload() {

        // Generate Preview INV
        int size = 9;
        Set<String> prizes = Fisk.configYML.getConfigurationSection("Fangster").getKeys(false);
        if (prizes.size() > 9) size = 18;
        if (prizes.size() > 18) size = 27;
        if (prizes.size() > 27) size = 36;
        if (prizes.size() > 36) size = 45;
        if (prizes.size() > 45) size = 54;

        float totalPercentage = 0.00f;

        int n = 0;

        for(String winning : prizes){
            Prize prize = new Prize(winning);

            this.prizes.add(prize);
            totalPercentage += prize.getChance();
            n++;
        }

    }
    public ItemStack getKey(){
        return this.key;
    }

    public ArrayList<Prize> getPrizes(){
        return this.prizes;
    }
}
