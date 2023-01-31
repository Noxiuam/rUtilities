package rip.kits.rutilities.commands;

import net.frozenorb.qlib.command.Command;
import net.frozenorb.qlib.command.Param;
import org.apache.commons.lang.StringEscapeUtils;
import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import rip.kits.rutilities.rUtilities;
import rip.kits.rutilities.utils.CCUtil;

public class PlayerCommand {
    /**
     *
     * @param sender
     */
    @Command(names={"rutil", "rutilities"}, permission = "")
    public static void rutil(Player sender) {
        sender.sendMessage(rUtilities.getInstance().getPrefix() + CCUtil.s(" &3Made by &3&l" + rUtilities.getInstance().getConfig().getString("config.author") + " &8(&c" + rUtilities.getInstance().getConfig().getString("config.authors") + "&8)"));
        sender.sendMessage(rUtilities.getInstance().getPrefix() + CCUtil.s(" &cVersion &8(&a" + rUtilities.getInstance().getConfig().getString("config.version") + "/" + rUtilities.getInstance().getConfig().getString("config.branch") + "&8)"));
    }

    /**
     *
     * @param sender
     * @param player
     */
    @Command(names={"op"}, permission = "op")
    public static void op(CommandSender sender, @Param(name = "Player") OfflinePlayer player) {
        if (player.isOp()) {
            sender.sendMessage(CCUtil.s("&c" + player.getName() + " is already operator."));
            return;
        }

        player.setOp(true);
        sender.sendMessage(CCUtil.s("&3&lKits &8" + StringEscapeUtils.unescapeJava("\u2758") + " &bYou have set the player " + player.getName() + " to an operator."));

        if (player.isOnline()) {
            player.getPlayer().sendMessage(CCUtil.s("&3&lKits &8" + StringEscapeUtils.unescapeJava("\u2758") + " &bYou have been set to be a operator."));
        }

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (players.isOp() && players != sender && players != player) { // not everyone is gonna get this message. only OP players that isnt the message sender and the player.
                players.sendMessage(CCUtil.s("&c" + sender.getName() + " has set " + player.getName() + " to be an operator."));
            }
        }
    }


    /**
     *
     * @param sender
     * @param player
     */
    @Command(names={"deop"}, permission = "op")
    public static void deop(CommandSender sender, @Param(name = "Player") OfflinePlayer player) {
        if (!(player.isOp())) {
            sender.sendMessage(CCUtil.s("&c" + player.getName() + " isn't a operator."));
            return;
        } else if (sender == player) {
            sender.sendMessage(CCUtil.s("&cYou cannot remove your own operator."));
            return;
        }

        player.setOp(false);
        sender.sendMessage(CCUtil.s("&3&lKits &8" + StringEscapeUtils.unescapeJava("\u2758") + " &bYou have set the player " + player.getName() + " to not be an operator."));

        if (player.isOnline()) { // Obviously the player needs to be on for us to send them a message...
            player.getPlayer().sendMessage(CCUtil.s("&3&lKits &8" +  StringEscapeUtils.unescapeJava("\u2758")  + " &bYour operator has been removed."));
        }

        for (Player players : Bukkit.getOnlinePlayers()) {
            if (players.isOp() && players != sender) {
                players.sendMessage(CCUtil.s("&c" + sender.getName() + " has removed " + player.getName() + "'s operator."));
            }
        }
    }
}
