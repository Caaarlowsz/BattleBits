package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class ChatCommand extends Command {

	public ChatCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static boolean chatMode = true;

	@Override
	public boolean execute(final CommandSender sender, final String arg1, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.chat")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage("§4§lCHAT§f Utilize: /chat <on/off/clear>");
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("on")) {
				if (chatMode) {
					sender.sendMessage("§4§lCHAT§f O chat ja está §e§lhabilitado§f!");
					return true;
				}
				chatMode = true;
				Bukkit.getServer().broadcastMessage("§4§lCHAT§f O chat foi §a§lhabilitado§f!");
				sender.sendMessage("§4§lCHAT§f Você §a§lhabilitou§f o chat.");
				return true;
			} else if (args[0].equalsIgnoreCase("off")) {
				if (!chatMode) {
					sender.sendMessage("§4§lCHAT§f O chat ja está §e§ldesabilitado§f!");
					return true;
				}
				chatMode = false;
				Bukkit.getServer().broadcastMessage("§4§lCHAT§f O chat foi §c§ldesabilitado§f!");
				sender.sendMessage("§4§lCHAT§f Você §c§ldesabilitou§f o chat.");
				return true;
			} else if (args[0].equalsIgnoreCase("clear") || args[0].equalsIgnoreCase("limpar")) {
				for (int i = 1; i < 101; i++) {
					Bukkit.getServer().broadcastMessage(" ");
				}
				Bukkit.getServer().broadcastMessage("§4§lCHAT§f O CHAT do servidor foi §4§lLIMPO§f!");
				return true;
			} else {
				sender.sendMessage("§4§lCHAT§f Utilize: /chat <on/off/clear>");
				return true;
			}
		}
		if (args.length > 1) {
			sender.sendMessage("§4§lCHAT§f Utilize: /chat <on/off/clear>");
			return true;
		}
		return false;
	}
}
