package br.com.battlecraft.kitpvp.warps.Challenge;

import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Sign;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerInteractEvent;

import br.com.battlecraft.kitpvp.api.WarpAPI;
import br.com.battlecraft.kitpvp.coords.LocationsConstructor;
import br.com.battlecraft.kitpvp.deathevents.Status;
import br.com.battlecraft.kitpvp.scoreboard.Score;
import br.com.battlecraft.kitpvp.warps.WarpsAPI;
import br.com.battlecraft.kitpvp.warps.Fps.FpsWarpListener;
import br.com.battlecraft.kitpvp.warps.Spawn.SpawnWarpListener;

public final class ChallengeWarpListener implements Listener {

	@SuppressWarnings("deprecation")
	public static final void loadWarpChallengeMethods(final Player bp) {
		if (FpsWarpListener.onFpsSpawnProtection.contains(bp)) {
			FpsWarpListener.onFpsSpawnProtection.remove(bp);
		}
		if (SpawnWarpListener.onWarpSpawnProtection.contains(bp)) {
			SpawnWarpListener.onWarpSpawnProtection.remove(bp);
		}
		bp.setGameMode(GameMode.SURVIVAL);
		bp.setHealth(20);
		WarpsAPI.battlePlayerWarp.put(bp, WarpsAPI.Warps.LAVA_CHALLENGE);
		Score.createScoreChallenge(bp);
		ChallengeItens.onInventoryChallenge(bp);
		bp.playSound(bp.getLocation(), Sound.ANVIL_LAND, 2.0F, 1.0F);
	}

	@EventHandler
	public final void onSignChangeEvent(final SignChangeEvent e) {
		if (e.getLine(0).equalsIgnoreCase("facil") || e.getLine(0).equalsIgnoreCase("easy")
				|| e.getLine(0).equalsIgnoreCase("ez")) {
			e.setLine(0, "§a§lFACIL");
			e.setLine(1, " ");
			e.setLine(2, "§9§lComplete");
			e.setLine(3, "§7(Clique)");
		}
		if (e.getLine(0).equalsIgnoreCase("medio") || e.getLine(0).equalsIgnoreCase("media")) {
			e.setLine(0, "§e§lMEDIO");
			e.setLine(1, " ");
			e.setLine(2, "§9§lComplete");
			e.setLine(3, "§7(Clique)");
		}
		if (e.getLine(0).equalsIgnoreCase("dificil") || e.getLine(0).equalsIgnoreCase("hard")) {
			e.setLine(0, "§c§lDIFICIL");
			e.setLine(1, " ");
			e.setLine(2, "§9§lComplete");
			e.setLine(3, "§7(Clique)");
		}
		if (e.getLine(0).equalsIgnoreCase("extreme") || e.getLine(0).equalsIgnoreCase("extremo")
				|| e.getLine(0).equalsIgnoreCase("extrema")) {
			e.setLine(0, "§4§lEXTREME");
			e.setLine(1, " ");
			e.setLine(2, "§9§lComplete");
			e.setLine(3, "§7(Clique)");
		}
	}

	@EventHandler
	public final void onPlayerInteractEvent(final PlayerInteractEvent e) {
		final Player p = e.getPlayer();
		if ((e.getAction() == Action.RIGHT_CLICK_BLOCK))
			if (e.getClickedBlock() != null)
				if (e.getClickedBlock().getType() == Material.WALL_SIGN
						|| (e.getClickedBlock().getType() == Material.SIGN_POST)) {
					Sign s = (Sign) e.getClickedBlock().getState();
					String[] lines = s.getLines();
					if ((lines.length > 0) && (lines[0].equals("§a§lFACIL")) && (lines.length > 1)
							&& (lines[1].equals(" ")) && (lines.length > 2) && (lines[2].equals("§9§lComplete"))
							&& (lines.length > 3)
							&& (lines[3].equals("§7(Clique)") && WarpAPI.getWarp(p) == "CHALLENGE")) {

						p.sendMessage("§c§lLava Challenge §8§l>>§f Você completou o nível §a§lFACIL§f!");
						loadWarpChallengeMethods(p);
						Status.addMoneyToBattlePlayer(p, 60);
						Status.addXpToBattlePlayer(p, 1);
						LocationsConstructor.teleportToBattleWarpLocation(p, "LavaChallenge");

					}
					if ((lines.length > 0) && (lines[0].equals("§e§lMEDIO")) && (lines.length > 1)
							&& (lines[1].equals(" ")) && (lines.length > 2) && (lines[2].equals("§9§lComplete"))
							&& (lines.length > 3)
							&& (lines[3].equals("§7(Clique)") && WarpAPI.getWarp(p) == "CHALLENGE")) {

						p.sendMessage("§c§lLava Challenge §8§l>>§f Você completou o nível §e§lMEDIO§f!");
						loadWarpChallengeMethods(p);
						Status.addMoneyToBattlePlayer(p, 100);
						Status.addXpToBattlePlayer(p, 2);
						LocationsConstructor.teleportToBattleWarpLocation(p, "LavaChallenge");

					}
					if ((lines.length > 0) && (lines[0].equals("§c§lDIFICIL")) && (lines.length > 1)
							&& (lines[1].equals(" ")) && (lines.length > 2) && (lines[2].equals("§9§lComplete"))
							&& (lines.length > 3)
							&& (lines[3].equals("§7(Clique)") && WarpAPI.getWarp(p) == "CHALLENGE")) {

						p.sendMessage("§c§lLava Challenge §8§l>>§f Você completou o nível §c§lDIFICIL");
						loadWarpChallengeMethods(p);
						Status.addMoneyToBattlePlayer(p, 150);
						Status.addXpToBattlePlayer(p, 3);
						LocationsConstructor.teleportToBattleWarpLocation(p, "LavaChallenge");

					}
					if ((lines.length > 0) && (lines[0].equals("§4§lEXTREME")) && (lines.length > 1)
							&& (lines[1].equals(" ")) && (lines.length > 2) && (lines[2].equals("§9§lComplete"))
							&& (lines.length > 3)
							&& (lines[3].equals("§7(Clique)") && WarpAPI.getWarp(p) == "CHALLENGE")) {

						Bukkit.getServer().broadcastMessage("§c§lLava Challenge §8§l>>§7 " + p.getName()
								+ " completou o nivel extreme do Lava Challenge");
						p.sendMessage("§c§lLava Challenge §8§l>>§f Você completou o nível §4§lEXTREME§f!");
						loadWarpChallengeMethods(p);
						Status.addMoneyToBattlePlayer(p, 200);
						Status.addXpToBattlePlayer(p, 4);
						LocationsConstructor.teleportToBattleWarpLocation(p, "LavaChallenge");

					}
				}
	}
}
