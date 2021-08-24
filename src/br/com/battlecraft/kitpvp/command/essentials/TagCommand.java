package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.nametags.BattleNametagAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class TagCommand extends Command {

	public TagCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (args.length == 0 && args.length < 1) {
			BattleNametagAPI.checkBattlePlayerTags(bp);
			return true;
		} else if (args.length == 1 && args.length < 2) {
			BattleNametagAPI.setTagFromCommand(bp, args[0]);
			return true;
		} else if (args.length > 1) {
			bp.sendMessage(
					"§3§lTAGS§f Utilize: /tag para ver suas §9§lTAGS§f ou /tag <nome da tag> para selecionar uma §9§lTAG§f.");
			return true;
		}
		return false;
	}
}