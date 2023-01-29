package dk.nydt.events;

import dk.nydt.Main;
import dk.nydt.utils.Chat;
import dk.nydt.utils.FiskReload;
import dk.nydt.utils.GUI;
import dk.nydt.utils.Prize;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.Inventory;

import java.util.ArrayList;
import java.util.Set;

public class InteractEvent implements Listener {
    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();
        try {
            Bukkit.broadcastMessage("1");
            if (e.getItem().getType() == Material.FISHING_ROD) {
                Bukkit.broadcastMessage("2");
                if (p.isSneaking()) {
                    Bukkit.broadcastMessage("3");
                    if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.LEFT_CLICK_AIR) {
                        Bukkit.broadcastMessage("4");
                        //Material top = Material.valueOf(Main.configYML.getString("GUI.Top").toUpperCase());
                        //Material bottom = Material.valueOf(Main.configYML.getString("GUI.Bottom").toUpperCase());

                        Inventory inv = Bukkit.createInventory(null, 9 * 6, Chat.colored("&a&l"));

                        //for(int i = 0; i < 9; i++) {
                            //inv.setItem(i, GUI.createGuiItem(top, "&7"));
                        //}
                        //for(int i = 45; i < 54; i++) {
                            //inv.setItem(i, GUI.createGuiItem(bottom, "&7"));
                        //}

                        Integer slot = 9;
                        //Set<String> prizes = Main.configYML.getConfigurationSection("Fangster").getKeys(false);
                        FiskReload frInstance = new FiskReload();
                        ArrayList<Prize> prizes = frInstance.getPrizes();

                        for(Prize prize_item : prizes) {
                            Bukkit.broadcastMessage(String.valueOf(prize_item));
                            //inv.setItem(slot, GUI.createGuiItem(new Prize(prize_item).getPreviewItem(), slot));

                        }


                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
