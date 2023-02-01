package dk.nydt.events;


import dk.nydt.Main;
import dk.nydt.utils.Prize;
import dk.nydt.utils.RandomPrize;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerFishEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class PlayerFishListener implements Listener {

    @EventHandler
    public void onPlayerFish(PlayerFishEvent event) {

        Player player = event.getPlayer();
        // Custom Event
        Prize generatedPrize = new RandomPrize().getPrize();
        PlayerFiskEvent playerFiskEvent = new PlayerFiskEvent(player, generatedPrize);
        Bukkit.getServer().getPluginManager().callEvent(playerFiskEvent);
        Prize prizeWon = playerFiskEvent.getPrize();

        if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
            Item stack = (Item) event.getCaught();
            prizeWon.runMessages(player);
            prizeWon.runCommands(player);
            String addItem = prizeWon.getAddItem();
            ItemStack prizeItem = prizeWon.getPreviewItem();
            ItemMeta meta = prizeItem.getItemMeta();
            meta.setLore(null);
            prizeItem.setItemMeta(meta);
            if (addItem.equals("false")){
                stack.setItemStack(prizeItem);
            } else if (addItem.equals("true")) {
                event.getCaught().remove();
                player.getInventory().addItem(prizeItem);
            }

        }
    }
}
