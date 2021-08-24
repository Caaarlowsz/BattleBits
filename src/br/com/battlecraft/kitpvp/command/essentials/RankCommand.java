package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.leagues.Leagues;
import br.com.battlecraft.kitpvp.utils.BattleStrings;

public final class RankCommand extends Command {

	public RankCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player battleplayer = (Player) sender;
		if (args.length == 0 || args.length > 0) {
			battleplayer.sendMessage(" ");
			battleplayer.sendMessage(
					"§6§lLIGA§f A nossa rede possui um sistema de liga único que garante aos players uma competição e mais destaque no servidor.");
			battleplayer.sendMessage(
					"§fAo matar alguém, ganhar uma partida ou fazer ações específicas em cada Modo de Jogo você recebe uma quantidade de XP por nossa rede para upar de nível.");
			battleplayer.sendMessage("§3" + "☯" + " CHALLENGER");
			battleplayer.sendMessage("§4" + "✪" + " LEGENDARY");
			battleplayer.sendMessage("§c" + "✫" + " MASTER");
			battleplayer.sendMessage("§5" + "✹" + " ELITE");
			battleplayer.sendMessage("§b" + "✦" + " DIAMOND");
			battleplayer.sendMessage("§6" + "✷" + " GOLD");
			battleplayer.sendMessage("§7" + "✶" + " SILVER");
			battleplayer.sendMessage("§1" + "☷" + " EXPERT");
			battleplayer.sendMessage("§e" + "☲" + " ADVANCED");
			battleplayer.sendMessage("§a" + "☰" + " PRIMARY");
			battleplayer.sendMessage("§f" + "-" + " UNRANKED");
			battleplayer.sendMessage("§fSua liga atual é: " + Leagues.getBattlePlayerLeagueInCommand(battleplayer));
			battleplayer.sendMessage("§fSeu XP atual é: §4§l" + AccountAPI.getBattlePlayerXp(battleplayer) + "§f XPs");
			battleplayer.sendMessage("§fPróxima liga: " + Leagues.getBattlePlayerNextLeague(battleplayer));
			battleplayer.sendMessage("§fXP necessário para a próxima liga: §4§l"
					+ Leagues.getBattlePlayerLeagueXpLeft(battleplayer) + "§f XPs");
			return true;
		}
		return false;
	}

}