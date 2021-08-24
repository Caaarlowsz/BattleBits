package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Item;

import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class ClearDropsCommand extends Command {

	public ClearDropsCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.cleardrops")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0) {
			for (final World world : Bukkit.getWorlds()) {
				for (final Item drops : world.getEntitiesByClass(Item.class)) {
					drops.remove();
				}
			}
			sender.sendMessage("§eVoce limpou os drops.");
			Bukkit.getServer().broadcastMessage("§e§lDROPS§f Os DROPS foram LIMPOS");
			return true;
		}
		return false;
	}
}
