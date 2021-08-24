package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class YoutuberCommand extends Command {

	public YoutuberCommand(String name, String description, String usageMessage, List<String> aliases) {
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
			bp.sendMessage("  §b§lYOUTUBER");
			bp.sendMessage("  ");
			bp.sendMessage("§fInscritos: §b100+");
			bp.sendMessage("§fViews: §b150+");
			bp.sendMessage("§fLikes: §b10+");
			bp.sendMessage("  ");
			bp.sendMessage("  §3§lYOUTUBER+");
			bp.sendMessage("  ");
			bp.sendMessage("§fInscritos: §3500+");
			bp.sendMessage("§fViews: §3250+");
			bp.sendMessage("§fLikes: §310+");
			bp.sendMessage("  ");
			return true;
		}
		return false;
	}
}
