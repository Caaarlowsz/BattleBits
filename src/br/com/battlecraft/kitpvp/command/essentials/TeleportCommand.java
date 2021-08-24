package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class TeleportCommand extends Command {

	public TeleportCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.teleport")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			bp.sendMessage(
					"§6§lTELEPORT§f Utilize: §6/tp <player>, §e/tp <player1> <player2>§f ou §c/tp <player> (x) (y) (z)");
			return true;
		} else if (args.length == 1) {
			final Player toTeleport = BattlePlayerAPI.BattlePlayer(args[0]);
			if (toTeleport == null) {
				bp.sendMessage(BattleStrings.getBattlePlayerIsNotOnlineMessage());
				return true;
			}
			bp.teleport(toTeleport);
			bp.sendMessage("§6§lTELEPORTE§f Você foi §e§lTELEPORTADO§f para " + toTeleport.getName());
			return true;
		} else if (args.length == 2) {
			final Player player = BattlePlayerAPI.BattlePlayer(args[0]);
			final Player toTeleport = BattlePlayerAPI.BattlePlayer(args[1]);
			if (player == null) {
				bp.sendMessage("§4§lERRO§f O player " + args[0] + " não está §c§lonline§f.");
				return true;
			} else if (toTeleport == null) {
				bp.sendMessage("§4§lERRO§f O player " + args[1] + " não está §c§lonline§f.");
				return true;
			}
			player.teleport(toTeleport);
			bp.sendMessage("§6§lTELEPORTE§f Você §e§lTELEPORTOU§f o player " + args[0] + " para o player " + args[1]);
			return true;
		} else if (args.length > 2 && args.length < 4) {
			bp.sendMessage("§6§lTELEPORT§f Utilize: /tp <player>, /tp <player1> <player2> ou /tp <player> (x) (y) (z)");
			return true;
		} else if (args.length == 4) {
			final Player toTeleport = BattlePlayerAPI.BattlePlayer(args[0]);
			if (toTeleport == null) {
				bp.sendMessage(BattleStrings.getBattlePlayerIsNotOnlineMessage());
				return true;
			}
			try {
				toTeleport.teleport(new Location(bp.getWorld(), Integer.valueOf(args[1]), Integer.valueOf(args[2]),
						Integer.valueOf(args[3])));
				bp.sendMessage("§6§lTELEPORTE§f Você §e§lTELEPORTOU§f o player  " + args[0] + " para §e§l" + args[1]
						+ " §b§l" + args[2] + " §c§l" + args[3]);
				return true;
			} catch (Exception e) {
				bp.sendMessage("§6§lTELEPORTE§f Utilize §4§lapenas numeros§f para §c§lindicar coordenadas§f!");
				return true;
			}
		} else if (args.length > 4) {
			bp.sendMessage("§6§lTELEPORT§f Utilize: /tp <player>, /tp <player1> <player2> ou /tp <player> (x) (y) (z)");
			return true;
		}
		return false;
	}
}
