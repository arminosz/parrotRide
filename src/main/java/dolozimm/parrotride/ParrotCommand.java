package dolozimm.parrotride;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.List;

public class ParrotCommand implements CommandExecutor, TabCompleter {
    private final JavaPlugin plugin;
    private final ParrotListener parrotListener;
    public ParrotCommand(JavaPlugin plugin) {
        this.plugin = plugin;
        this.parrotListener = new ParrotListener(plugin);
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            Parrot parrot = (Parrot) player.getWorld().spawnEntity(player.getLocation(), EntityType.PARROT);
            parrot.setTamed(true);
            parrot.setOwner(player);
            parrot.addPassenger(player);
            parrotListener.startControllingParrot(player, parrot);
            return true;
        } else {
            sender.sendMessage("PR| This command can't be used in the console!");
            return false;
        }
    }
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return null;
    }
}