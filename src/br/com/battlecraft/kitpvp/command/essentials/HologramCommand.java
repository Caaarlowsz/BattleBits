package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.hologram.HalogramAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class HologramCommand extends Command {

	public HologramCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String arg1, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.hologram")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0) {
			HalogramAPI.spawnHologram(bp);
			bp.sendMessage("§a§lHOLOGRAM§f Você spawnou um §a§lholograma§f! Para remove-lo, reinicie o servidor.");
			return true;
		}
		return false;
	}
}
