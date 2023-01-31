package rip.kits.rutilities.utils;

import org.bukkit.ChatColor;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class CCUtil {

    /**
     * Translate the '&' character into the right character for the color code.
     *
     * @param message - The original string to be converted.
     * @return string - Translated with Color Codes
     */

    public static String s(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }

    public static List<String> sAll(List<String> messages) {
        List<String> buffered = new ArrayList<>();
        for (String message : messages) {
            buffered.add(s("&r" + message));
        }
        return buffered;
    }

    /**
     * Capitalizes the First Letter of any String.
     *
     * @param original - This is the original non-capitalised string.
     * @return result - Will return the String instead with the first letter capitalised.
     */
    public static String capitalizeFirstLetter(String original) {
        if (original == null || original.length() == 0) {
            return original;
        }
        return original.substring(0, 1).toUpperCase() + original.substring(1); // Makes the first capital and then adds the rest of the string without the first letter...
    }

    /**
     *
     * @param string
     * @return
     */

    public static ChatColor parseChatColor(String string) {
        switch (string) {
            case "&1": {
                return ChatColor.DARK_BLUE;
            }
            case "&2": {
                return ChatColor.DARK_GREEN;
            }
            case "&3": {
                return ChatColor.DARK_AQUA;
            }
            case "&4": {
                return ChatColor.DARK_RED;
            }
            case "&5": {
                return ChatColor.DARK_PURPLE;
            }
            case "&6": {
                return ChatColor.GOLD;
            }
            case "&7": {
                return ChatColor.GRAY;
            }
            case "&8": {
                return ChatColor.DARK_GRAY;
            }
            case "&9": {
                return ChatColor.BLUE;
            }
            case "&0": {
                return ChatColor.BLACK;
            }
            case "&a": {
                return ChatColor.GREEN;
            }
            case "&b": {
                return ChatColor.AQUA;
            }
            case "&c": {
                return ChatColor.RED;
            }
            case "&d": {
                return ChatColor.LIGHT_PURPLE;
            }
            case "&e": {
                return ChatColor.YELLOW;
            }
            case "&f": {
                return ChatColor.WHITE;
            }
            case "&o": {
                return ChatColor.ITALIC;
            }
            case "&k": {
                return ChatColor.MAGIC;
            }
            case "&l": {
                return ChatColor.BOLD;
            }
            case "&r": {
                return ChatColor.RESET;
            }
            case "&m": {
                return ChatColor.UNDERLINE;
            }
            case "&n": {
                return ChatColor.STRIKETHROUGH;
            }
            default: {
                return ChatColor.WHITE;
            }
        }
    }

    public static int stringToWoolColor(String r) {
        String fixed = r.replaceAll("§l", "").replaceAll("§r", "").replaceAll("§k", "").replaceAll("§n", "").replaceAll("§m", "").replaceAll("§o", "");
        switch (fixed) {
            case "§1":
                return 11;
            case "§2":
                return 13;

            case "§3":
                return 9;

            case "§4":
                return 14;

            case "§5":
                return 10;

            case "§6":
                return 1;

            case "§7":
                return 8;

            case "§8":
                return 7;

            case "§9":
                return 11;

            case "§0":
                return 15;

            case "§a":
                return 5;

            case "§b":

                return 3;
            case "§c":
                return 14;

            case "§d":
                return 6;

            case "§e":

                return 4;
            case "§f":
                return 0;

            default:
                return 0;
        }
    }

    public static String formatTPS(double tps, boolean shouldColor) {
        DecimalFormat format = new DecimalFormat("##.##");
        ChatColor color;

        if (tps >= 18.0D) {
            color = ChatColor.GREEN;
        } else {
            if (tps >= 15.0D) {
                color = ChatColor.YELLOW;
            } else {
                color = ChatColor.RED;
            }
        }
        return (shouldColor ? color : "") + format.format(tps);
    }
}
