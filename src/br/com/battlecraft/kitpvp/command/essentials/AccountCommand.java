package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.OfflinePlayer;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.account.AccountManager;
import br.com.battlecraft.kitpvp.battleplayer.BattlePlayerAPI;
import br.com.battlecraft.kitpvp.leagues.Leagues;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class AccountCommand extends Command {

	public AccountCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (args.length == 0) {
			bp.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			bp.sendMessage("§7NICK: §e" + bp.getName());
			bp.sendMessage("§7UUID: §e" + bp.getUniqueId().toString());
			bp.sendMessage("§7Kills: §b" + AccountAPI.getBattlePlayerKills(bp));
			bp.sendMessage("§7Deaths: §b" + AccountAPI.getBattlePlayerDeaths(bp));
			bp.sendMessage("§7KillStreak: §b" + AccountAPI.getBattlePlayerKillStreak(bp));
			bp.sendMessage("§7XP: §b" + AccountAPI.getBattlePlayerXp(bp));
			bp.sendMessage("§7Moedas: §b" + AccountAPI.getBattlePlayerMoney(bp));
			bp.sendMessage("§7DoubleXP: §b" + AccountAPI.getBattlePlayerDoubleXp(bp));
			bp.sendMessage("§7Liga: " + Leagues.getBattlePlayerLeagueInScore(bp));
			bp.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			return true;
		}
		if (args.length == 1) {
			final OfflinePlayer bpf = BattlePlayerAPI.BattlePlayerOffline(args[0]);
			if (!AccountManager.hasAccount(args[0])) {
				bp.sendMessage("§e§lACCOUNT§f Este nick nao possui §e§lregistro§f no servidor.");
				return true;
			}
			bp.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			bp.sendMessage("§7NICK: §e" + bpf.getName());
			bp.sendMessage("§7UUID: §e" + bpf.getUniqueId().toString());
			bp.sendMessage("§7Kills: §b" + AccountAPI.getBattlePlayerKills(bpf));
			bp.sendMessage("§7Deaths: §b" + AccountAPI.getBattlePlayerDeaths(bpf));
			bp.sendMessage("§7KillStreak: §b" + AccountAPI.getBattlePlayerKillStreak(bpf));
			bp.sendMessage("§7XP: §b" + AccountAPI.getBattlePlayerXp(bpf));
			bp.sendMessage("§7Moedas: §b" + AccountAPI.getBattlePlayerMoney(bpf));
			bp.sendMessage("§7DoubleXP: §b" + AccountAPI.getBattlePlayerDoubleXp(bpf));
			bp.sendMessage("§7Liga: " + Leagues.getBattlePlayerLeagueInScore(bpf));
			bp.sendMessage("§e-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			return true;
		}
		if (args.length > 1) {
			bp.sendMessage("§e§lACCOUNT§f Utilize: /account ou /account <player>");
			return true;
		}
		return false;
	}
}
