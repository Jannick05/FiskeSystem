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
    Main plugin;
    public InteractEvent(Main plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        try {

            if (e.getItem().getType() == Material.FISHING_ROD) {
                if (!p.isSneaking()) return;
                if(e.getAction() == Action.LEFT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_AIR) {
                    p.openInventory(Main.rc.getPreview());

                }

            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
