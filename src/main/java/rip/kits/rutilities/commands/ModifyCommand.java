package rip.kits.rutilities.commands;

import net.frozenorb.qlib.command.Command;
import net.frozenorb.qlib.command.Param;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import rip.kits.rutilities.rUtilities;
import rip.kits.rutilities.utils.PlayerUtils;

import java.util.Arrays;

public class ModifyCommand {

    /**
     *
     * @param sender
     * @param effect
     * @param seconds
     * @param amplifier
     */
    @Command(names={"modify potion", "edit potion"}, permission = "op")
    public static void modifyPotion(Player sender, @Param(name="effect") String effect, @Param(name="seconds") int seconds, @Param(name = "amplifier") int amplifier) {
        PotionEffectType effectType = PotionEffectType.getByName(effect.toUpperCase());
        ItemStack hand = sender.getItemInHand();

        if (hand == null || hand.getType() != Material.POTION) {
            sender.sendMessage(ChatColor.RED + "Please hold a potion.");
            return;
        } else if (effectType == null) {
            sender.sendMessage(ChatColor.RED + "Could not parse " + effect);
            return;
        } else {
            PotionMeta meta = (PotionMeta) hand.getItemMeta();
            meta.addCustomEffect(new PotionEffect(effectType, seconds * 20, amplifier), true);
            hand.setItemMeta(meta);

            sender.sendMessage(ChatColor.RED + "Modified effect " + effectType.getName() + ": Level " + amplifier + " for " + seconds + " seconds.");
            sender.updateInventory();
        }
    }

    /**
     *
     * @param sender
     * @param enchant
     * @param amplifier
     */

    private static int enchantmentCount;

    @Command(names={"modify item", "edit item"}, permission = "op")
    public static void modifyItem(Player sender, @Param(name="enchant") String enchant, @Param(name = "amplifier") int amplifier) {
        Enchantment enchantment = Enchantment.getByName(enchant.toUpperCase());

        ItemStack hand = sender.getItemInHand();

        if (hand == null && PlayerUtils.isSwordInHand(sender) || hand == null) {
            sender.sendMessage(ChatColor.RED + "Please hold an item.");
            return;
        } else if (enchantment != null && amplifier > enchantment.getMaxLevel()) {
            sender.sendMessage(ChatColor.RED + "You cannot enchant this item to " + amplifier + "/" + enchantment.getMaxLevel());
            return;
        } else if (enchantment == null) {
            StringBuilder enchantmentsBuilder = new StringBuilder();
            for (Enchantment enchantmentList : rUtilities.getInstance().getEnchantments()) {
                if (enchantmentsBuilder.length() != 0 && enchantmentList.canEnchantItem(hand)) {
                    enchantmentsBuilder.append(',');
                    enchantmentsBuilder.append(' ');
                }

                if (enchantmentList.canEnchantItem(hand)) {
                    enchantmentsBuilder.append(enchantmentList.getName());
                    enchantmentCount++;
                }
            }

            if (enchantmentsBuilder.length() == 0) enchantmentsBuilder.append("None");

            sender.sendMessage(ChatColor.RED + "The enchant does not exist. try to use one of the following: (" + enchantmentCount + "): " + enchantmentsBuilder);
            enchantmentCount = 0;
            return;
        } else if (!(enchantment.canEnchantItem(hand))) {
            sender.sendMessage(ChatColor.RED + "You cannot add the enchant " + enchantment.getName() + " to " + hand.getType());
        } else {
            hand.addEnchantment(enchantment, amplifier);

            sender.sendMessage(ChatColor.RED + "Modified item " + enchantment.getName() + ": Level " + amplifier + ".");
            sender.updateInventory();
        }
    }
}
