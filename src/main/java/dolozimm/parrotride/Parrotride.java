package dolozimm.parrotride;

import dolozimm.parrotride.ParrotCommand;
import org.bukkit.plugin.java.JavaPlugin;

public class Parrotride extends JavaPlugin {

    @Override
    public void onEnable() {
        // Register the command
        this.getCommand("parrot").setExecutor(new ParrotCommand(this));
        getServer().getPluginManager().registerEvents(new ParrotListener(this), this);
        getLogger().info("PR| Plugin successfully loaded!");
    }

    @Override
    public void onDisable() {
        getLogger().info("PR| Plugin succesfully disabled!");
    }
}

