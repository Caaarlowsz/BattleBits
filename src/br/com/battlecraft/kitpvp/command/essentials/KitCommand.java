package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.api.KitAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnKitsMenu;

public final class KitCommand extends Command {

	public KitCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (FlyCommand.hasFly.contains(bp)) {
			bp.sendMessage("§3§lKITS§f Saia do modo §e§lvoo§f para selecionar um kit.");
			return true;
		}
		if (args.length >= 0) {
			if (KitAPI.getKit(bp) != "Nenhum") {
				bp.sendMessage("§3§lKITS§f Voce so pode selecionar um kit, sem ter um kit!");
				return true;
			}
			if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SPAWN) {
				SpawnKitsMenu.oPenKitsMenu(bp);
				return true;
			} else {
				bp.sendMessage("§3§lKITS§f Voce so pode selecionar um kit no spawn.");
				return true;
			}
		}
		return false;
	}
}
