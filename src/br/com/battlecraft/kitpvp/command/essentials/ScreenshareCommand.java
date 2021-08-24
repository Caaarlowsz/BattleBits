package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.screenshare.ScreenshareSystem;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class ScreenshareCommand extends Command {

	public ScreenshareCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.ss")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			bp.sendMessage("§c§lSCREENSHARE§f Utilize: /ss <player>");
			return true;
		}
		if (args.length == 1) {
			final Player ss = BattlePlayerAPI.BattlePlayer(args[0]);
			if (ss == null) {
				bp.sendMessage(BattleStrings.getBattlePlayerIsNotOnlineMessage());
				return true;
			}
			if (ss == bp) {
				bp.sendMessage("§c§lSCREENSHARE§f Voce nao pode se puxar para §c§lscreenshare§f!");
				return true;
			}
			ScreenshareSystem.runScreenshareSystem(bp, ss);
			return true;
		}
		if (args.length > 1) {
			bp.sendMessage("§c§lSCREENSHARE§f Utilize: /ss <player>");
			return true;
		}
		return false;
	}
}
