package dk.nydt;

import dk.nydt.events.PlayerFishListener;
import dk.nydt.utils.Config;
import dk.nydt.utils.FiskReload;
import dk.nydt.utils.Prize;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Fisk extends JavaPlugin {
    private static PluginManager pluginManager;
    public static Fisk instance;
    public static Config config;
    public static FileConfiguration configYML;

    public static FiskReload rc;
    @Override
    public void onEnable() {
        pluginManager = getServer().getPluginManager();
        instance = this;

        //Config.yml
        if (!(new File(getDataFolder(), "config.yml")).exists())
            saveResource("config.yml", false);

        config = new Config(this, null, "config.yml");
        configYML = config.getConfig();

        //Register Events
        getServer().getPluginManager().registerEvents(new PlayerFishListener(), this);

        rc = new FiskReload();
        rc.reload();

        //Register Prizes

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static Fisk getInstance(){
        return instance;
    }

}
