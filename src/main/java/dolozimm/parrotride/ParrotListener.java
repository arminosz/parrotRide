package dolozimm.parrotride;

import org.bukkit.entity.Parrot;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class ParrotListener implements Listener {

    private final JavaPlugin plugin;

    public ParrotListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    public void startControllingParrot(Player player, Parrot parrot) {
        new BukkitRunnable() {
            @Override
            public void run() {
                if (parrot.isDead() || !parrot.getPassengers().contains(player)) {
                    this.cancel();
                    return;
                }
                parrot.setVelocity(player.getLocation().getDirection().multiply(0.5));
            }
        }.runTaskTimer(plugin, 0L, 1L);
    }
}
