package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class AplicarCommand extends Command {

	public AplicarCommand(String name, String description, String usageMessage, List<String> aliases) {
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
			bp.sendMessage("  §d§lAPLICAÇAO");
			bp.sendMessage("  ");
			bp.sendMessage("§fAplique-se para §d§lTRIAL§f em: §6§lwww.trial.com.br");
			bp.sendMessage("§fAplique-se para §5§lMOD§f em: §6§lwww.mod.com.br");
			bp.sendMessage("§fAplique-se para §5§lGCDETECTOR§f em: §6§lwww.gcdetector.com.br");
			bp.sendMessage("§fAplique-se para §2§lGCDETECTOR§f em: §6§lwww.gcdetector.com.br");
			bp.sendMessage("  ");
			return true;
		}
		return false;
	}
}
