package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class DanoCommand extends Command {

	public DanoCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}
	
	public static boolean onDamage = true;

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.dano")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0) {
			if (onDamage) {
				onDamage = false;
				sender.sendMessage("§4§lDANO§f Voce §c§ldesabilitou§f o dano global.");
				Bukkit.getServer().broadcastMessage("§4§lDANO§f O DANO global foi §c§ldesabilitado§f! §e(hit entre jogadores, lava, queda etc)");
				return true;
			} else {
				onDamage = true;
				sender.sendMessage("§4§lDANO§f Voce §a§lhabilitou§f o dano global.");
				Bukkit.getServer().broadcastMessage("§4§lDANO§f O DANO global foi §a§lhabilitado§f! §e(hit entre jogadores, lava, queda etc)");
				return true;
			}
		}
		return false;
	}
}
