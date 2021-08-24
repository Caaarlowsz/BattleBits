package br.com.battlecraft.kitpvp.command.essentials;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class BuildCommand extends Command {
	
	public static final ArrayList<Player> hasBuild = new ArrayList<>();
	
	public static boolean hasBuild(final Player bp) {
		return hasBuild.contains(bp);
	}

	public BuildCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.build")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			bp.sendMessage("§e§lBUILD§f Utilize: /build <on/off> [player]");
			return true;
		}
		if (args.length == 1) {
			if (args[0].equalsIgnoreCase("on")) {
				if (hasBuild(bp)) {
					bp.sendMessage("§e§lBUILD§f Seu modo §e§lbuilder§f já está habilitado!");
					return true;
				}
				hasBuild.add(bp);
				bp.sendMessage("§e§lBUILD§f Você §a§lhabilitou§f seu modo §e§lbuilder§f.");
				return true;
			}
			else if (args[0].equalsIgnoreCase("off")) {
				if (!hasBuild(bp)) {
					bp.sendMessage("§e§lBUILD§f Seu modo §e§lbuilder§f já está desabilitado§f!");
					return true;
				}
				hasBuild.remove(bp);
				bp.sendMessage("§e§lBUILD§f Você §c§ldesabilitou§f seu modo §e§lbuilder§f!");
				return true;
			} else {
				bp.sendMessage("§e§lBUILD§f Utilize: /build <on> ou <off>");
				return true;
			}
		}
		if (args.length == 2) {
			final Player toBuild = BattlePlayerAPI.BattlePlayer(args[1]);
			if (toBuild == null) {
				bp.sendMessage(BattleStrings.getBattlePlayerIsNotOnlineMessage());
				return true;
			}
			else if (args[0].equalsIgnoreCase("on")) {
				if (hasBuild(toBuild)) {
					bp.sendMessage("§e§lBUILD§f O modo §e§lbuilder§f do " + args[1] + " já está habilitado!");
					return true;
				}
				hasBuild.add(toBuild);
				toBuild.sendMessage("§e§lBUILD§f Seu modo §e§lbuilder§f foi §a§lhabilitado§f pelo " + bp.getName());
				bp.sendMessage("§e§lBUID§f Você §a§lhabilitou§f o modo §e§lbuilder§f do " + args[1]);
				return true;
			}
			else if (args[0].equalsIgnoreCase("off")) {
				if (!hasBuild(toBuild)) {
					bp.sendMessage("§e§lBUILD§f O modo §e§lbuilder§f do " + args[1] + " já está desabilitado!");
					return true;
				}
				hasBuild.remove(toBuild);
				toBuild.sendMessage("§e§lBUILD§f Seu modo §e§lbuilder§f foi §c§ldesabilitado§f pelo " + bp.getName());
				bp.sendMessage("§e§lBUID§f Você §c§ldesabilitou§f o modo §e§lbuilder§f do " + args[1]);
				return true;
			} else {
				bp.sendMessage("§e§lBUILD§f Utilize: /build <on/off> [player]");
				return true;
			}
		}
		if (args.length > 2) {
			bp.sendMessage("§e§lBUILD§f Utilize: /build <on/off> [player]");
			return true;
		}
		return false;
	}
}
