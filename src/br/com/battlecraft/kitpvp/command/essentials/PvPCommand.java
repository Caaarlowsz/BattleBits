package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class PvPCommand extends Command {

	public PvPCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static boolean onPvP = true;

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.pvp")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0) {
			if (onPvP) {
				onPvP = false;
				sender.sendMessage("§4§lPVP§f Voce §c§ldesabilitou§f o pvp global.");
				Bukkit.getServer()
						.broadcastMessage("§4§lPVP§f O PVP global foi §c§ldesabilitado§f! §e(hit entre jogadores)");
				return true;
			} else {
				onPvP = true;
				sender.sendMessage("§4§lPVP§f Voce §a§lhabilitou§f o pvp global.");
				Bukkit.getServer()
						.broadcastMessage("§4§lPVP§f O PVP global foi §a§lhabilitado§f! §e(hit entre jogadores)");
				return true;
			}
		}
		return false;
	}
}
