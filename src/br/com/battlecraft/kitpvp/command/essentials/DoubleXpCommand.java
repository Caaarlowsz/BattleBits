package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.deathevents.DoubleXp;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class DoubleXpCommand extends Command {

	public DoubleXpCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (args.length == 0) {
			bp.sendMessage("§3§lDOUBLEXP§f Utilize: /doublexp <usar>");
			bp.sendMessage("§3§lDOUBLEXP§f Seus doublexp's: §b§l" + AccountAPI.getBattlePlayerDoubleXp(bp));
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("usar") || args[0].equalsIgnoreCase("use")) {
				DoubleXp.addPlayerDoubleXp(bp);
				return true;
			} else {
				bp.sendMessage("§3§lDOUBLEXP§f Utilize: /doublexp <usar>");
				bp.sendMessage("§3§lDOUBLEXP§f Seus doublexp's: §b§l" + AccountAPI.getBattlePlayerDoubleXp(bp));
				return true;
			}
		}
		if (args[0].length() > 1) {
			bp.sendMessage("§3§lDOUBLEXP§f Utilize: /doublexp <usar>");
			bp.sendMessage("§3§lDOUBLEXP§f Seus doublexp's: §b§l" + AccountAPI.getBattlePlayerDoubleXp(bp));
			return true;
		}
		return false;
	}

}
