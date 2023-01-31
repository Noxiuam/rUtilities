package rip.kits.rutilities;

import com.google.common.collect.Lists;
import lombok.Getter;
import net.frozenorb.qlib.command.FrozenCommandHandler;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.plugin.java.JavaPlugin;
import rip.kits.rutilities.utils.CCUtil;

import java.util.List;

public class rUtilities extends JavaPlugin {
    @Getter private static rUtilities instance;
    @Getter private List<Enchantment> enchantments = Lists.newArrayList();

    @Override
    public void onEnable() {
        instance = this;

        saveDefaultConfig();
        FrozenCommandHandler.registerAll(this);

        /* Enchantment list */
        enchantments.add(Enchantment.LURE);
        enchantments.add(Enchantment.ARROW_DAMAGE);
        enchantments.add(Enchantment.ARROW_FIRE);
        enchantments.add(Enchantment.ARROW_INFINITE);
        enchantments.add(Enchantment.PROTECTION_FIRE);
        enchantments.add(Enchantment.PROTECTION_PROJECTILE);
        enchantments.add(Enchantment.ARROW_KNOCKBACK);
        enchantments.add(Enchantment.DAMAGE_ALL);
        enchantments.add(Enchantment.DAMAGE_ARTHROPODS);
        enchantments.add(Enchantment.DAMAGE_UNDEAD);
        enchantments.add(Enchantment.DIG_SPEED);
        enchantments.add(Enchantment.DURABILITY);
        enchantments.add(Enchantment.FIRE_ASPECT);
        enchantments.add(Enchantment.KNOCKBACK);
        enchantments.add(Enchantment.LOOT_BONUS_BLOCKS);
        enchantments.add(Enchantment.LOOT_BONUS_MOBS);
        enchantments.add(Enchantment.PROTECTION_ENVIRONMENTAL);
        enchantments.add(Enchantment.PROTECTION_EXPLOSIONS);
        enchantments.add(Enchantment.PROTECTION_FALL);
        enchantments.add(Enchantment.SILK_TOUCH);
        enchantments.add(Enchantment.THORNS);
    }

    public String getPrefix() {
        return CCUtil.s(getConfig().getString("config.prefix"));
    }
}
