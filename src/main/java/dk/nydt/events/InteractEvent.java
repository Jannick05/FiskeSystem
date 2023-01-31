package dk.nydt.events;

import dk.nydt.Main;
import dk.nydt.utils.Chat;
import dk.nydt.utils.FiskReload;
import dk.nydt.utils.GUI;
import dk.nydt.utils.Prize;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
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

    //MIDLERTIDLIGT DEAKTIVERET, RIGHTCLICK UDLØSER BEGGE ACTIONS!
    //MIDLERTIDLIGT DEAKTIVERET, RIGHTCLICK UDLØSER BEGGE ACTIONS!
    //MIDLERTIDLIGT DEAKTIVERET, RIGHTCLICK UDLØSER BEGGE ACTIONS!
    //MIDLERTIDLIGT DEAKTIVERET, RIGHTCLICK UDLØSER BEGGE ACTIONS!
    //MIDLERTIDLIGT DEAKTIVERET, RIGHTCLICK UDLØSER BEGGE ACTIONS!
    //MIDLERTIDLIGT DEAKTIVERET, RIGHTCLICK UDLØSER BEGGE ACTIONS!
    //MIDLERTIDLIGT DEAKTIVERET, RIGHTCLICK UDLØSER BEGGE ACTIONS!

    /*@EventHandler
    public void onInteract(PlayerInteractEvent e) {
        Player p = e.getPlayer();

        try {
            Block targetBlock = e.getClickedBlock();

            if (targetBlock != null) {
                // Right click on a block with a fishing rod
                if (e.getAction() == Action.RIGHT_CLICK_BLOCK) {
                    return;
                }
            } else {
                // Right click on air with a fishing rod
                if (e.getAction() == Action.RIGHT_CLICK_AIR) {
                    return;
                }

                // Left click on air with a fishing rod
                if (e.getAction() == Action.LEFT_CLICK_AIR) {
                    if (!p.isSneaking()) return;
                    if((e.getAction() == Action.LEFT_CLICK_AIR) || e.getAction() == Action.LEFT_CLICK_BLOCK) {
                        p.openInventory(Main.rc.getPreview());
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }*/
}
