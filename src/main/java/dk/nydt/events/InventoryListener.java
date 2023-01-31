package dk.nydt.events;

import dk.nydt.Main;
import dk.nydt.utils.Chat;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

import java.util.Objects;

public class InventoryListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player p = (Player) event.getWhoClicked();
        if (event.getClickedInventory().getTitle().equals(Chat.colored(Main.configYML.getString("GUI.Guiname")))) {
            event.setCancelled(true);
        }
    }
}
