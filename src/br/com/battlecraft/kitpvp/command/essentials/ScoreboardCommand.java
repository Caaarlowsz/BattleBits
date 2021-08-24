package br.com.battlecraft.kitpvp.command.essentials;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.scoreboard.Score;
import br.com.battlecraft.kitpvp.screenshare.ScreenshareSystem;
import br.com.battlecraft.kitpvp.utils.BattleStrings;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;

public final class ScoreboardCommand extends Command {

	public ScoreboardCommand(String name, String description, String usageMessage, List<String> aliases) {
		super(name, description, usageMessage, aliases);
	}

	public static final Scoreboard noScoreboard() {
		ScoreboardManager manager = Bukkit.getScoreboardManager();
		Scoreboard board = manager.getNewScoreboard();
		return board;
	}

	public static final void loadScoreboard(final Player bp) {
		if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SPAWN) {
			Score.createScoreSpawn(bp);
		} else if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.FPS) {
			Score.createScoreFps(bp);
		} else if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.EVENTO) {
			Score.createScoreEvento(bp);
		} else if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.ONEVSONE) {
			Score.createScore1v1(bp);
		} else if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.LAVA_CHALLENGE) {
			Score.createScoreChallenge(bp);
		} else if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.CAPIROTO) {
			Score.createScoreCapiroto(bp);
		} else if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SS
				&& ScreenshareSystem.stafferSS.containsKey(bp)) {
			Score.createScoreScreenshareStaffer(bp);
		} else if (WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SS
				&& ScreenshareSystem.playerSS.containsKey(bp)) {
			Score.createScoreScreensharePlayer(bp);
		} else {
			loadScoreboard(bp);
		}
	}

	@Override
	public boolean execute(final CommandSender sender, final String label, final String[] args) {
		if (!BukkitMain.NotInGame(sender)) {
			sender.sendMessage(BattleStrings.getCommandOnlyInGameMessage());
			return true;
		}
		final Player bp = (Player) sender;
		if (args.length >= 0) {
			if (Score.hasScore.contains(bp)) {
				// remover //
				Score.hasScore.remove(bp);
				noScoreboard().clearSlot(DisplaySlot.SIDEBAR);
				bp.setScoreboard(noScoreboard());
				bp.sendMessage("§cVoce desativou sua scoreboard.");
				return true;
			} else {
				// adicionar //
				Score.hasScore.add(bp);
				loadScoreboard(bp);
				bp.sendMessage("§aVoce ativou sua scoreboard.");
				return true;
			}
		}
		return false;
	}
}
