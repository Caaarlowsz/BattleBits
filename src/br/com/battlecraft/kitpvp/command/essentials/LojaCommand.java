package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class LojaCommand extends Command {

	public LojaCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (args.length >= 0) {
			bp.sendMessage("  ");
			bp.sendMessage("  §6§lLOJA");
			bp.sendMessage("  ");
			bp.sendMessage("§6§lBattleCraft §7>> §fAcesse a loja: §6§lwww.battlebits.com.br");
			bp.sendMessage("  ");
			return true;
		}
		return false;
	}
}
