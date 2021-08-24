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

public final class MoneyCommand extends Command {

	public MoneyCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String arg1, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (!bp.hasPermission("pvp.cmd.money")) {
			bp.sendMessage(BattleStrings.getNoPermissionToCommandMessage());
			return true;
		}
		if (args.length >= 0 && args.length < 3) {
			bp.sendMessage("§6§lMONEY§f Utilize: /money <add/remove> (player) [quantidade]");
			return true;
		}
		if (args.length == 3) {
			final Player m = BattlePlayerAPI.BattlePlayer(args[1]);
			if (m == null) {
				final OfflinePlayer moff = BattlePlayerAPI.BattlePlayerOffline(args[1]);
				if (!args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove")) {
					bp.sendMessage("§6§lMONEY§f Utilize: /money <add/remove> (player) [quantidade]");
					return true;
				} else if (args[0].equalsIgnoreCase("add")) {
					try {
						AccountAPI.addBattlePlayerMoney(moff, Integer.valueOf(args[2]));
						bp.sendMessage(
								"§6§lMONEY§f Você adicionou §6§l" + args[2] + " MOEDAS§f para a conta do player " + args[1]);
						return true;
					} catch (Exception e) {
						bp.sendMessage(
								"§6§lMONEY§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §6§lMOEDAS§f!");
						return true;
					}
				} else if (args[0].equalsIgnoreCase("remove")) {
					try {
						if (Integer.valueOf(args[2]) > AccountAPI.getBattlePlayerMoney(moff)) {
							bp.sendMessage(
									"§6§lMONEY§f Você não §c§lpode remover§f uma quantidade de §6§lMOEDAS§f maior que a do player!");
							return true;
						}
						AccountAPI.removeBattlePlayerMoney(moff, Integer.valueOf(args[2]));
						bp.sendMessage("§6§lMONEY§f Você removeu §6§l" + args[2] + " MOEDAS§f da conta do player " + args[1]);
						return true;
					} catch (Exception e) {
						bp.sendMessage(
								"§6§lMONEY§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §6§lMOEDAS§f!");
						return true;
					}
				}
			}
			if (!args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove")) {
				bp.sendMessage("§6§lMONEY§f Utilize: /money <add/remove> (player) [quantidade]");
				return true;
			} else if (args[0].equalsIgnoreCase("add")) {
				try {
					AccountAPI.addBattlePlayerMoney(m, Integer.valueOf(args[2]));
					m.sendMessage("§6§lMONEY§f Foram §a§ladicionadas§f na sua conta §6§l" + args[2] + " MOEDAS§f pelo " + bp.getName());
					bp.sendMessage("§6§lMONEY§f Você adicionou §6§l" + args[2] + " MOEDAS§f para a conta do player " + args[1]);
					return true;
				} catch (Exception e) {
					bp.sendMessage(
							"§6§lMONEY§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §6§lMOEDAS§f!");
					return true;
				}
			} else if (args[0].equalsIgnoreCase("remove")) {
				try {
					if (Integer.valueOf(args[2]) > AccountAPI.getBattlePlayerMoney(m)) {
						bp.sendMessage(
								"§6§lMONEY§f Você não §c§lpode remover§f uma quantidade de §6§lMOEDAS§f maior que a do player!");
						return true;
					}
					AccountAPI.removeBattlePlayerMoney(m, Integer.valueOf(args[2]));
					m.sendMessage("§6§lMONEY§f Foram §c§lremovidas§f da sua conta §6§l" + args[2] + " MOEDAS§f pelo " + bp.getName());
					bp.sendMessage("§6§lMONEY§f Você removeu §6§l" + args[2] + " MOEDAS§f da conta do player " + args[1]);
					return true;
				} catch (Exception e) {
					bp.sendMessage(
							"§6§lMONEY§f Utilize apenas §9§lNUMEROS§f para indicar a quantidade de §6§lMOEDAS§f!");
					return true;
				}
			}
		}
		if (args.length > 3) {
			bp.sendMessage("§6§lMONEY§f Utilize: /money <add/remove> (player) [quantidade]");
			return true;
		}
		return false;
	}
}
