package br.com.battlecraft.kitpvp.scoreboard;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;

import br.com.battlecraft.kitpvp.BukkitMain;
import br.com.battlecraft.kitpvp.account.AccountAPI;
import br.com.battlecraft.kitpvp.api.KitAPI;
import br.com.battlecraft.kitpvp.api.WarpAPI;
import br.com.battlecraft.kitpvp.leagues.Leagues;
import br.com.battlecraft.kitpvp.topks.TopKillStreakAPI;
import br.com.battlecraft.kitpvp.utils.TimeConverter;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.Evento.EventoAPI;
import br.com.battlecraft.kitpvp.warps.OneVsOne.X1WarpListener;

public final class Score {

	public static final ArrayList<Player> hasScore = new ArrayList<Player>();

	public static final HashMap<Player, ScoreboardAPI> sscore = new HashMap<>();

	public static final void updateAllScoreboards() {
		Bukkit.getScheduler().scheduleSyncRepeatingTask(BukkitMain.getPlugin(), new Runnable() {
			@SuppressWarnings("deprecation")
			@Override
			public void run() {
				for (final Player all : Bukkit.getOnlinePlayers()) {
					updateScoreboardSpawn(all);
					updateScoreboardFps(all);
					updateScoreboard1v1(all);
					updateScoreboardChallenge(all);
					updateScoreboardCapiroto(all);
					updateScoreboardEvento(all);
				}
			}
		}, 0, 3L);
	}

	public static final String getPlayerFithing(final Player bp) {
		if (!X1WarpListener.playerfigh.containsKey(bp)) {
			return "§3Ninguém";
		} else if (X1WarpListener.playerfigh.containsKey(bp)) {
			return "§3" + X1WarpListener.playerfigh.get(bp);
		} else {
			return "§3Ninguém";
		}
	}

	///////////// UPDATES //////////////

	// SPAWN //
	public static final void updateScoreboardSpawn(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SPAWN) {

			final ScoreboardAPI sb = sscore.get(bp);

			bp.getScoreboard().getObjective("score")
					.setDisplayName("§8§l>> §6§l" + BukkitTasks.TittleSpawn + " §8§l<<");

			sb.updateLine("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 12);
			sb.updateLine("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 11);
			sb.updateLine("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 10);
			sb.updateLine("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 9);
			sb.updateLine("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 8);
			sb.updateLine(TopKillStreakAPI.getWarpSpawnTopKsName(bp), TopKillStreakAPI.getWarpSpawnTopKsNumber(bp), 5);
			sb.updateLine("§7Kit: ", "§e" + KitAPI.getKit(bp), 3);
		}
	}

	// EVENTO //
	public static final void updateScoreboardEvento(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.EVENTO) {

			final ScoreboardAPI sb = sscore.get(bp);

			bp.getScoreboard().getObjective("score")
					.setDisplayName("§8§l>> §6§l" + BukkitTasks.TittleEvento + " §8§l<<");

			sb.updateLine("§7Tempo: ", "§b" + TimeConverter.ConvertTime(EventoAPI.eventtime), 8);
			sb.updateLine("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 6);
			sb.updateLine("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 5);
			sb.updateLine("§7Jogadores: ", "§e" + EventoAPI.Players.size() + "/" + EventoAPI.maxEventSlots, 3);
		}
	}

	// FPS //
	public static final void updateScoreboard1v1(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.FPS) {

			final ScoreboardAPI sb = sscore.get(bp);

			bp.getScoreboard().getObjective("score").setDisplayName("§8§l>> §6§l" + BukkitTasks.TittleFps + " §8§l<<");

			sb.updateLine("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 12);
			sb.updateLine("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 11);
			sb.updateLine("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 10);
			sb.updateLine("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 9);
			sb.updateLine("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 8);
			sb.updateLine(TopKillStreakAPI.getWarpFpsTopKsName(bp), TopKillStreakAPI.getWarpFpsTopKsNumber(bp), 5);
			sb.updateLine("§7Warp: ", "§3" + WarpAPI.getWarp(bp), 3);
		}
	}

	// 1v1 //
	public static final void updateScoreboardFps(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.ONEVSONE) {

			final ScoreboardAPI sb = sscore.get(bp);

			bp.getScoreboard().getObjective("score")
					.setDisplayName("§8§l>> §6§l" + BukkitTasks.TittleOneVsOne + " §8§l<<");

			sb.updateLine("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 10);
			sb.updateLine("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 9);
			sb.updateLine("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 8);
			sb.updateLine("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 7);
			sb.updateLine("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 6);
			sb.updateLine(getPlayerFithing(bp), "", 3);
		}
	}

	// CHALLENGE //
	public static final void updateScoreboardChallenge(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.LAVA_CHALLENGE) {

			final ScoreboardAPI sb = sscore.get(bp);

			bp.getScoreboard().getObjective("score")
					.setDisplayName("§8§l>> §6§l" + BukkitTasks.TittleChallenge + " §8§l<<");

			sb.updateLine("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 4);
			sb.updateLine("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 3);
		}
	}

	// CAPIROTO //
	@SuppressWarnings("deprecation")
	public static final void updateScoreboardCapiroto(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.CAPIROTO) {

			final ScoreboardAPI sb = sscore.get(bp);

			bp.getScoreboard().getObjective("score")
					.setDisplayName("§8§l>> §6§l" + BukkitTasks.TittleCapiroto + " §8§l<<");

			sb.updateLine("§7Capirotos: ",
					"§e" + X1WarpListener.itemsInInventory(bp.getInventory(), new Material[] { Material.GOLDEN_APPLE }),
					11);
			sb.updateLine("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 9);
			sb.updateLine("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 8);
			sb.updateLine("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 7);
			sb.updateLine("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 6);
			sb.updateLine("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 5);
			sb.updateLine("§7Online: ", "§b" + Bukkit.getOnlinePlayers().length, 3);
		}
	}

	///////// BUILDS/CREATES ///////////

	// SPAWN //
	public static final void createScoreSpawn(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SPAWN) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§8§l>> §6§l" + BukkitTasks.TittleSpawn + " §8§l<<");

			WarpAPI.setWarp(bp, "SPAWN");
			score.add("", "", 13);
			score.add("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 12);
			score.add("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 11);
			score.add("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 10);
			score.add("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 9);
			score.add("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 8);
			score.add("", "", 7);
			score.add("§7Top Kill", "§7Streak:", 6);
			score.add(TopKillStreakAPI.getWarpSpawnTopKsName(bp), TopKillStreakAPI.getWarpSpawnTopKsNumber(bp), 5);
			score.add("", "", 4);
			score.add("§7Kit: ", "§e" + KitAPI.getKit(bp), 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}

	// FPS //
	public static final void createScoreFps(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.FPS) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§8§l>> §6§l" + BukkitTasks.TittleFps + " §8§l<<");

			WarpAPI.setWarp(bp, "FPS");
			score.add("", "", 13);
			score.add("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 12);
			score.add("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 11);
			score.add("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 10);
			score.add("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 9);
			score.add("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 8);
			score.add("", "", 7);
			score.add("§7Top Kill", "§7Streak:", 6);
			score.add(TopKillStreakAPI.getWarpFpsTopKsName(bp), TopKillStreakAPI.getWarpFpsTopKsNumber(bp), 5);
			score.add("", "", 4);
			score.add("§7Warp: ", "§3" + WarpAPI.getWarp(bp), 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}

	// 1v1 //
	public static final void createScore1v1(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.ONEVSONE) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§8§l>> §6§l" + BukkitTasks.TittleOneVsOne + " §8§l<<");

			WarpAPI.setWarp(bp, "1v1");
			score.add("", "", 11);
			score.add("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 10);
			score.add("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 9);
			score.add("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 8);
			score.add("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 7);
			score.add("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 6);
			score.add("", "", 5);
			score.add("§7Batalhando", " §7Contra:", 4);
			score.add(getPlayerFithing(bp), "", 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}

	// CHALLENGE //
	public static final void createScoreChallenge(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.LAVA_CHALLENGE) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§8§l>> §6§l" + BukkitTasks.TittleChallenge + " §8§l<<");

			WarpAPI.setWarp(bp, "CHALLENGE");
			score.add("", "", 5);
			score.add("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 4);
			score.add("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}

	// EVENTO
	public static final void createScoreEvento(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.EVENTO) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§8§l>> §6§l" + BukkitTasks.TittleEvento + " §8§l<<");

			WarpAPI.setWarp(bp, "EVENTO");
			score.add("", "", 9);
			score.add("§7Tempo: ", "§b" + TimeConverter.ConvertTime(EventoAPI.eventtime), 8);
			score.add("", "", 7);
			score.add("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 6);
			score.add("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 5);
			score.add("", "", 4);
			score.add("§7Jogadores: ", "§e" + EventoAPI.Players.size() + "/" + EventoAPI.maxEventSlots, 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}

	// CAPIROTO //
	@SuppressWarnings("deprecation")
	public static final void createScoreCapiroto(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.CAPIROTO) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§8§l>> §6§l" + BukkitTasks.TittleCapiroto + " §8§l<<");

			WarpAPI.setWarp(bp, "CAPIROTO");
			score.add("", "", 12);
			score.add("§7Capirotos: ",
					"§e" + X1WarpListener.itemsInInventory(bp.getInventory(), new Material[] { Material.GOLDEN_APPLE }),
					11);
			score.add("", "", 10);
			score.add("§7Kills: ", "§b" + AccountAPI.getBattlePlayerKills(bp), 9);
			score.add("§7Deaths: ", "§b" + AccountAPI.getBattlePlayerDeaths(bp), 8);
			score.add("§7KillStreak: ", "§b" + AccountAPI.getBattlePlayerKillStreak(bp), 7);
			score.add("§7XP: ", "§b" + AccountAPI.getBattlePlayerXp(bp), 6);
			score.add("§7Liga: ", Leagues.getBattlePlayerLeagueInScore(bp), 5);
			score.add("", "", 4);
			score.add("§7Online: ", "§b" + Bukkit.getOnlinePlayers().length, 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}

	// SCREENSHARE //
	public static final void createScoreScreensharePlayer(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SS) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§6§lSCREENSHARE");

			WarpAPI.setWarp(bp, "SCREENSHARE");
			score.add("", "", 11);
			score.add("§bVocê foi puxa", "§bdo para SS", 10);
			score.add("", "", 9);
			score.add("§bSiga atentam", "§bente os", 8);
			score.add("§bpassos para", "§b que não haja", 7);
			score.add("§bproblemas com", "§b você!", 6);
			score.add("", "", 5);
			score.add("§bApós ser liber", "§bado,", 4);
			score.add("§bvolte á jogar", "§b!", 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}

	public static final void createScoreScreenshareStaffer(final Player bp) {
		if (hasScore.contains(bp) && WarpsAPI.battlePlayerWarp.get(bp) == WarpsAPI.Warps.SS) {
			final ScoreboardAPI score = new ScoreboardAPI(bp, "§6§lSCREENSHARE");

			score.add("", "", 11);
			score.add("§bVocê puxou u", "§bm player!", 10);
			score.add("", "", 9);
			score.add("§bRealize os pr", "§bocedimentos", 8);
			score.add("§be de modo alg", "§bum saia sem", 7);
			score.add("§bconcluir a sc", "§breenshare!", 6);
			score.add("", "", 5);
			score.add("§bApós ser liber", "§bado, vá no", 4);
			score.add("§bvolte á moder", "§bar!", 3);
			score.add("", "", 2);
			score.add("§6www.battlebits", "§6.com.br", 1);

			sscore.put(bp, score);
			bp.setScoreboard(score.getSoreboard());
		}
	}
}