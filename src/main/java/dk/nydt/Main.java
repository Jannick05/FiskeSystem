package dk.nydt;

import dk.nydt.commands.Fisk;
import dk.nydt.events.InteractEvent;
import dk.nydt.events.InventoryListener;
import dk.nydt.events.PlayerFishListener;
import dk.nydt.events.TabCompleteListener;
import dk.nydt.utils.Config;
import dk.nydt.utils.FiskReload;
import org.bukkit.command.TabCompleter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Main extends JavaPlugin {
    private static PluginManager pluginManager;
    public static Main instance;
    public static Config config;
    public static FileConfiguration configYML;

    public static FiskReload rc;
    @Override
    public void onEnable() {
        pluginManager = getServer().getPluginManager();
        instance = this;

        getCommand("Fisk").setExecutor(new Fisk());
        getCommand("Fisk").setTabCompleter(new TabCompleteListener());
        //Config.yml
        if (!(new File(getDataFolder(), "config.yml")).exists())
            saveResource("config.yml", false);

        config = new Config(this, null, "config.yml");
        configYML = config.getConfig();

        //Register Events
        getServer().getPluginManager().registerEvents(new PlayerFishListener(), this);
        getServer().getPluginManager().registerEvents(new InventoryListener(), this);
        getServer().getPluginManager().registerEvents(new InteractEvent(this), this);
        rc = new FiskReload();
        rc.reload();

        //Register Prizes

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Main getInstance(){
        return instance;
    }

    public static void openPreview(Player player) {
        player.openInventory(Main.rc.getPreview());
    }

}
