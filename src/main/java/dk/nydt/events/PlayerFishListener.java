package dk.nydt.events;


import dk.nydt.utils.Prize;
import dk.nydt.utils.RandomPrize;
import org.bukkit.Bukkit;
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
//        System.out.println("generatedPrize.getPreviewItem() - " + generatedPrize.getPreviewItem());
//        System.out.println("prizeWon.getChance() - " + prizeWon.getChance());
//        System.out.println("prizeWon.getMessages() - " + prizeWon.getMessages());
//        System.out.println("prizeWon.getCommands() - " + prizeWon.getCommands());
//        System.out.println("prizeWon.getPreviewItem() - " + prizeWon.getPreviewItem());
//        System.out.println("player - " + player.getName());

        if (event.getState().equals(PlayerFishEvent.State.CAUGHT_FISH)) {
            Item stack = (Item) event.getCaught();
            prizeWon.runMessages(player);
            prizeWon.runCommands(player);

            stack.setItemStack(new ItemStack(prizeWon.getPreviewItem()));
        }
    }
}
