package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class CcCommand extends Command {

	public CcCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String arg1, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.chat")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0) {
			for (int i = 1; i < 101; i++) {
				Bukkit.getServer().broadcastMessage(" ");
			}
			Bukkit.getServer().broadcastMessage("§4§lCHAT§f O CHAT do servidor foi §4§lLIMPO§f!");
			return true;
		}
		return false;
	}
}
