package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class WhitelistCommand extends Command {

	public WhitelistCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.whitelist")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0 && args.length < 1) {
			sender.sendMessage("§c§lWHITELIST§f Escolha uma das opçoes: /whitelist <on/off/add/remove> (playerName)");
			return true;
		} else if (args.length == 1 && args.length < 2) {
			if (args[0].equalsIgnoreCase("on")) {
				if (Bukkit.getServer().hasWhitelist()) {
					sender.sendMessage("§c§lWHITELIST§f A §c§lwhitelist§f ja se encontra ativada!");
					return true;
				}
				Bukkit.getServer().setWhitelist(true);
				sender.sendMessage("§c§lWHITELIST§f A §c§lwhitelist§f foi ativada!");
				return true;
			} else if (args[0].equalsIgnoreCase("off")) {
				if (!Bukkit.getServer().hasWhitelist()) {
					sender.sendMessage("§c§lWHITELIST§f A §c§lwhitelist§f ja se encontra desativada!");
					return true;
				}
				Bukkit.getServer().setWhitelist(false);
				sender.sendMessage("§c§lWHITELIST§f A §c§lwhitelist§f foi desativada!");
				return true;
			} else if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("remove")) {
				sender.sendMessage("§c§lWHITELIST§f Formato incompleto: /whitelist " + args[0] + " <playerName>");
				return true;
			} else {
				sender.sendMessage("§c§lWHITELIST§f Formato incorreto: /whitelist <on/off/add/remove> (playerName)");
				return true;
			}
		} else if (args.length == 2 && args.length < 3) {
			final OfflinePlayer battleplayer = BattlePlayerAPI.BattlePlayerOffline(args[1]);
			if (!args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove")) {
				sender.sendMessage("§c§lWHITELIST§f Formato incorreto: /whitelist <add/remove> (playerName)");
				return true;
			} else if (args[1].length() > 16) {
				sender.sendMessage("§c§lWHITELIST§f O player name não pode §4§lultrapassar§f 16 carateres!");
				return true;
			} else if (args[0].equalsIgnoreCase("add")) {
				if (battleplayer.isWhitelisted()) {
					sender.sendMessage("§c§lWHITELIST§f O player " + args[1] + " ja esta na §c§lwhitelist§f!");
					return true;
				}
				battleplayer.setWhitelisted(true);
				sender.sendMessage("§c§lWHITELIST§f O player " + args[1] + " foi adicionado a §c§lwhitelist§f!");
				return true;
			} else if (args[0].equalsIgnoreCase("remove")) {
				if (!battleplayer.isWhitelisted()) {
					sender.sendMessage("§c§lWHITELIST§f O player " + args[1] + " nao esta na §c§lwhitelist§f!");
					return true;
				}
				battleplayer.setWhitelisted(false);
				sender.sendMessage("§c§lWHITELIST§f O player " + args[1] + " foi removido da §c§lwhitelist§f!");
				return true;
			}
		} else {
			sender.sendMessage("§c§lWHITELIST§f Escolha uma das opçoes: /whitelist <on/off/add/remove> (playerName)");
			return true;
		}
		return false;
	}
}
