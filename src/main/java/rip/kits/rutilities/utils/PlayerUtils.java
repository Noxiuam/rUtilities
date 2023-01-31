package rip.kits.rutilities.utils;

import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.potion.PotionEffect;

public class PlayerUtils {
    /**
     *
     * @param player
     */

    public static void resetInventory(Player player) {
        resetInventory(player, null);
    }

    /**
     *
     * @param player
     * @param gameMode
     */
    public static void resetInventory(Player player, GameMode gameMode) {
        resetInventory(player, gameMode, false);
    }

    /**
     *
     * @param player
     * @param gameMode
     * @param skipInvRest
     */
    public static void resetInventory(Player player, GameMode gameMode, boolean skipInvRest) {
        player.setHealth(player.getMaxHealth());
        player.setFallDistance(0F);
        player.setFoodLevel(20);
        player.setSaturation(10F);
        player.setLevel(0);
        player.setExp(0F);

        if (!skipInvRest) {
            player.getInventory().clear();
            player.getInventory().setArmorContents(null);
        }

        player.setFireTicks(0);

        removePotionEffects(player);

        if (gameMode != null && player.getGameMode() != gameMode) {
            player.setGameMode(gameMode);
        }

        player.setAllowFlight(false);
        player.setFlying(false);
    }

    /**
     *
     * @param player
     */
    public static void removePotionEffects(Player player) {
        for (PotionEffect potionEffect : player.getActivePotionEffects()) {
            player.removePotionEffect(potionEffect.getType());
        }
    }

    /**
     *
     * @param player
     * @return
     */
    public static boolean isNaked(Player player) {
        return player.getInventory().getHelmet() == null && player.getInventory().getChestplate() == null && player.getInventory().getLeggings() == null && player.getInventory().getBoots() == null;
    }

    /**
     *
     * @param player
     * @return
     */

    public static boolean isSwordInHand(Player player) {
        /*return player.getItemInHand().getType().equals(Material.DIAMOND_SWORD)
                || player.getItemInHand().getType().equals(Material.GOLD_SWORD)
                || player.getItemInHand().getType().equals(Material.IRON_SWORD)
                || player.getItemInHand().getType().equals(Material.STONE_SWORD)
                || player.getItemInHand().getType().equals(Material.WOOD_SWORD);*/
        return player.getItemInHand().getType().toString().contains("SWORD");
    }

    /**
     *
     * @param player
     * @return
     */
    public static boolean isArmorInHand(Player player) {
        return player.getItemInHand().getType().toString().contains("HELMET")
                || player.getItemInHand().getType().toString().contains("CHESTPLATE")
                || player.getItemInHand().getType().toString().contains("LEGGINGS")
                || player.getItemInHand().getType().toString().contains("BOOTS");
    }
}
