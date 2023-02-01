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
            if (addItem.equals("false")){
                stack.setItemStack(new ItemStack(prizeWon.getPreviewItem()));
            } else if (addItem.equals("true")) {
                event.getCaught().remove();
                player.getInventory().addItem(new ItemStack(prizeWon.getPreviewItem()));
            }

        }
    }
}
