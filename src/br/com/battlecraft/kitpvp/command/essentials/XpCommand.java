package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class XpCommand extends Command {

	public XpCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}
	
	@Override
	public boolean execute(final CommandSender sender, final String arg1, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.xp")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0 && args.length < 3) {
			bp.sendMessage("§9§lXP§f Utilize: /xp <add/remove> (player) [quantidade]");
			return true;
		}
		if (args.length == 3) {
			final Player m = BattlePlayerAPI.BattlePlayer(args[1]);
			if (m == null) {
				final OfflinePlayer moff = BattlePlayerAPI.BattlePlayerOffline(args[1]);
				if (!args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove")) {
					bp.sendMessage("§9§lXP§f Utilize: /xp <add/remove> (player) [quantidade]");
					return true;
				} else if (args[0].equalsIgnoreCase("add")) {
					try {
						AccountAPI.addBattlePlayerXp(moff, Integer.valueOf(args[2]));
						bp.sendMessage(
								"§9§lXP§f Você adicionou §9§l" + args[2] + " XPs§f para a conta do player " + args[1]);
						return true;
					} catch (Exception e) {
						bp.sendMessage(
								"§9§lXP§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §9§lXPs§f!");
						return true;
					}
				} else if (args[0].equalsIgnoreCase("remove")) {
					try {
						if (Integer.valueOf(args[2]) > AccountAPI.getBattlePlayerXp(moff)) {
							bp.sendMessage(
									"§9§lXP§f Você não §c§lpode remover§f uma quantidade de §6§lXPs§f maior que a do player!");
							return true;
						}
						AccountAPI.removeBattlePlayerXp(moff, Integer.valueOf(args[2]));
						bp.sendMessage("§9§lXP§f Você removeu §9§l" + args[2] + " XPs§f da conta do player " + args[1]);
						return true;
					} catch (Exception e) {
						bp.sendMessage(
								"§9§lXP§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §9§lXPs§f!");
						return true;
					}
				}
			}
			if (!args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove")) {
				bp.sendMessage("§9§lXP§f Utilize: /xp <add/remove> (player) [quantidade]");
				return true;
			} else if (args[0].equalsIgnoreCase("add")) {
				try {
					AccountAPI.addBattlePlayerXp(m, Integer.valueOf(args[2]));
					m.sendMessage("§9§lXP§f Foram §a§ladicionadas§f na sua conta §9§l" + args[2] + " XPs§f pelo " + bp.getName());
					bp.sendMessage("§9§lXP§f Você adicionou §9§l" + args[2] + " XPs§f para a conta do player " + args[1]);
					return true;
				} catch (Exception e) {
					bp.sendMessage(
							"§9§lXP§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §9§lXPs§f!");
					return true;
				}
			} else if (args[0].equalsIgnoreCase("remove")) {
				try {
					if (Integer.valueOf(args[2]) > AccountAPI.getBattlePlayerXp(m)) {
						bp.sendMessage(
								"§9§lXP§f Você não §c§lpode remover§f uma quantidade de §9§lXPs§f maior que a do player!");
						return true;
					}
					AccountAPI.removeBattlePlayerXp(m, Integer.valueOf(args[2]));
					m.sendMessage("§9§lXP§f Foram §c§lremovidas§f da sua conta §9§l" + args[2] + " XPs§f pelo " + bp.getName());
					bp.sendMessage("§9§lXP§f Você removeu §9§l" + args[2] + " XPs§f da conta do player " + args[1]);
					return true;
				} catch (Exception e) {
					bp.sendMessage(
							"§9§lXP§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §9§lXPs§f!");
					return true;
				}
			}
		}
		if (args.length > 3) {
			bp.sendMessage("§9§lXP§f Utilize: /xp <add/remove> (player) [quantidade]");
			return true;
		}
		return false;
	}
}
