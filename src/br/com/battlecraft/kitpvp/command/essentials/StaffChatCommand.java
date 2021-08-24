package br.com.battlecraft.kitpvp.command.essentials;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class StaffChatCommand extends Command {

	public StaffChatCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}
	
	public static final ArrayList<Player> staffchat = new ArrayList<>();
	
	public static final boolean onStaffChat(final Player bp) {
		return (staffchat.contains(bp) ? true : false);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.sc")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0) {
			if (!onStaffChat(bp)) {
				staffchat.add(bp);
				bp.sendMessage("§e§lSTAFFCHAT§f Voce §a§lentrou§f no staffchat.");
				return true;
			} else {
				staffchat.remove(bp);
				bp.sendMessage("§e§lSTAFFCHAT§f Voce §c§lsaiu§f do staffchat.");
				return true;
			}
		}
		return false;
	}
}
