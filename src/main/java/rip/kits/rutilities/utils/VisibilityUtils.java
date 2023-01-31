package rip.kits.rutilities.utils;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import rip.kits.rutilities.rUtilities;

public class VisibilityUtils {
    /**
     * Super Useless LOL!
     *
     * @param player
     * @return
     */
    public static void updateVisibilityFlicker(Player player) {
        for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
            player.hidePlayer(otherPlayer);
            otherPlayer.hidePlayer(player);
        }
        Bukkit.getScheduler().runTaskLater(rUtilities.getInstance(), () -> updateVisibility(player), 10L);
    }

    /**
     * Super Useless LOL!
     *
     * @param player
     * @return
     */
    public static void updateVisibility(Player player) {
        for (Player otherPlayer : Bukkit.getOnlinePlayers()) {
            otherPlayer.showPlayer(player);
            player.showPlayer(player);
        }
    }
}
