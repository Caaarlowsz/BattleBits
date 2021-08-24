package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class KickCommand extends Command {

	public KickCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String arg1, final String[] args) {
		if (!sender.hasPermission("pvp.cmd.kick")) {
			sender.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length == 0) {
			sender.sendMessage("§c§lKICK§f Utilize: /kick <player> [motivo]");
			return true;
		}
		if (args.length >= 1) {
			final Player kicked = BattlePlayerAPI.BattlePlayer(args[0]);
			if (kicked == null) {
				sender.sendMessage(BattleStrings.getBattlePlayerIsNotOnlineMessage());
				return true;
			}
			String motive = "";
			for (int i = 1; i < args.length; i++) {
				motive = motive + args[i] + " ";
			}
			if (motive == "") {
				motive = "não colocado";
			}
			kicked.kickPlayer("§fVocê foi §c§lKICKADO§f do servidor! \n \n " + "§c§lAutor:§f " + sender.getName() + "\n"
					+ "§c§lMotivo:§f " + motive + " \n \n §fAtenciosamente");
			Bukkit.getServer().broadcastMessage("§f" + kicked.getName() + " foi §c§lKICKADO§f do servidor pelo motivo:§c " + motive);
			sender.sendMessage("§c§lKICK§f Você §a§lkickou§f o player " + args[0]);
			return true;
		}
		return false;
	}
}
